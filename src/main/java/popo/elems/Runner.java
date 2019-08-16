package popo.elems;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.ThreadContext;
import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.xml.*;
import picocli.CommandLine;
import popo.elems.framework.helpers.listener.TestListener;
import popo.elems.framework.util.Options;

import java.io.InputStream;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static popo.elems.framework.Constants.LOGGER_THREAD_CONTEXT;

@Log4j2
public class Runner {

    private static final String TESTS_SOURCE = "popo.elems.app.test";

    public static void main(String[] args) {
        ThreadContext.put(LOGGER_THREAD_CONTEXT, "");

        Options options = CommandLine.populateCommand(new Options(), args);

        List<XmlSuite> suites = new ArrayList<>();
        TestNG testNG = new TestNG();

        try {
            if (Objects.requireNonNull(options).testngXml != null) {
                for (String xml : options.testngXml) {
                    Optional<XmlSuite> parser;
                    try (InputStream xmlRunnerReader = Objects.requireNonNull(Runner.class.getClassLoader().getResource(xml)).openStream()) {
                        parser = (new Parser(xmlRunnerReader)).parse().stream().findFirst();
                        parser.ifPresent(suites::add);
                    } catch (Exception ex) {
                        log.info("Error for TestNG xml files", ex);
                        try {
                            parser = (new Parser(Paths.get(xml).toString()).parse()).stream().findFirst();
                            parser.ifPresent(suites::add);
                        } catch (Exception e) {
                            log.error("Error for TestNG xml files", e);
                        }
                    }
                }
            }

            XmlSuite suite = new XmlSuite();
            suite.setParallel(XmlSuite.ParallelMode.METHODS);
            XmlTest myTest = new XmlTest(suite);

            setTestngXmlParameters(options, suite);

            List<XmlClass> classes = new ArrayList<> ();
            setTestngXmlClasses(options, classes);

            setTestngXmlGroupsPackages(options, myTest);
            if (args.length == 0) {
                setTestngXmlPackages(options, myTest);
            }

            myTest.setXmlClasses(classes); //testNG.setTestClasses(new Class[] { TestWatchCoMainPage.class });

            suites.add(suite);

            ITestNGListener iTestNGListener = new TestListener();
            testNG.addListener(iTestNGListener);

            testNG.setXmlSuites(suites);
            testNG.run();
        } catch (Throwable throwable) {
            log.fatal(ExceptionUtils.getStackTrace(throwable));
        }
    }

    private static void setTestngXmlClasses(Options options, List<XmlClass> classes) {
        if (options.testClasses != null) {
            for (String cl : options.testClasses) {
                classes.add(new XmlClass(String.format("%s.%s", TESTS_SOURCE, cl)));
            }
        }
    }

    private static void setTestngXmlGroupsPackages(Options options, XmlTest myTest) {
        if (options.testGroups != null) {
            for (String gr : options.testGroups) {
                myTest.addIncludedGroup(gr);
            }
            setTestngXmlPackages(options, myTest);
        }
    }

    private static void setTestngXmlPackages(Options options, XmlTest myTest) {
        List<XmlPackage> xmlPackages = new ArrayList<>();
        XmlPackage xmlPackage = new XmlPackage();
        if (options.testPackages != null) {
            xmlPackage.setName(options.testPackages.toString());
            xmlPackage.setInclude(options.testPackages.stream().map(
                    (pack) -> String.format("%s.*", pack)).collect(Collectors.toList()));
        } else {
            xmlPackage.setName(String.format("%s.*", TESTS_SOURCE));
            xmlPackage.setInclude(Collections.singletonList(TESTS_SOURCE));
        }
        xmlPackages.add(xmlPackage);
        myTest.setPackages(xmlPackages);
    }

    private static void setTestngXmlParameters(Options options, XmlSuite suite) {
        if (options.parameters != null) {
            suite.setParameters(options.parameters);
        }
    }
}
