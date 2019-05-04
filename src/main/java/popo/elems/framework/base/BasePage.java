package popo.elems.framework.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.reflections.Reflections;
import popo.elems.framework.Constants;
import popo.elems.framework.base.elements.WebElement;
import popo.elems.framework.base.elements.annotation.ISetup;
import popo.elems.framework.util.ResourcePropertiesManager;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@NoArgsConstructor
@RequiredArgsConstructor
public class BasePage<L extends BasePage> extends BaseEntity {

    @Getter
    @NonNull private L landingPage;
    private static ResourcePropertiesManager testConfig = new ResourcePropertiesManager("testConfig.properties");
    private static final String APP_ELEMENTS_SOURCE = testConfig.getProperty("app.elements", "");
    private static final List<String> SUB_TYPES_ELEMENTS_FRAMEWORK = new Reflections(Constants.ELEMENTS_SOURCE).getSubTypesOf(WebElement.class)
            .parallelStream().map(Class::getName).collect(Collectors.toList());

    static {
        if (!APP_ELEMENTS_SOURCE.isEmpty()) {
            SUB_TYPES_ELEMENTS_FRAMEWORK.addAll(new Reflections(APP_ELEMENTS_SOURCE).getSubTypesOf(WebElement.class)
                    .parallelStream().map(Class::getName).collect(Collectors.toList()));
        }
    }

    public void initElements() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            String className = field.getType().getName();
            try {
                if (SUB_TYPES_ELEMENTS_FRAMEWORK.contains(className)) {
                    ((ISetup) field.get(this)).setUpElements(field);
                }
            } catch (IllegalAccessException e) {
                log.fatal(ExceptionUtils.getStackTrace(e));
            }
        }
    }
}