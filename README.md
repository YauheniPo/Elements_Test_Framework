# Test_Framework_Elements

mvn clean package

mvn clean -DskipTests=true package
mvn clean install -DskipTests=true -Dhttp.keepAlive=false -Dmaven.wagon.http.pool=false

java -jar target\elements_test_framework-1.0-shaded.jar --xml testng.xml

java -jar target\elements_test_framework-1.0-shaded.jar --cl TestWatchCoMainPage --pr=name=JAR

java -jar target\elements_test_framework-1.0-shaded.jar --xml target\testngQueue.xml

@CommandLine.Option(names = {"--xml"}, description = "TestNG xml")
@CommandLine.Option(names = {"--cl"}, description = "TestNG Classes")
@CommandLine.Option(names = {"--gr"}, description = "TestNG Groups")
@CommandLine.Option(names = {"--pack"}, description = "TestNG Packages")
@CommandLine.Option(names = {"--pr"}, description = "TestNG Parameters")