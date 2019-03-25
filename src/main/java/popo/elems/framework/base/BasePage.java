package popo.elems.framework.base;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.reflections.Reflections;
import popo.elems.framework.Constants;
import popo.elems.framework.base.elements.G2Element;
import popo.elems.framework.base.elements.annotation.ISetup;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@NoArgsConstructor
@RequiredArgsConstructor
public class BasePage<L extends BasePage> extends BaseEntity {

    @NonNull public L landingPage;
    private static final List<String> SUB_TYPES_ELEMENTS = new Reflections(Constants.ELEMENTS_SOURCE).getSubTypesOf(G2Element.class)
            .parallelStream().map(Class::getName).collect(Collectors.toList());

    public void initElements() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            String className = field.getType().getName();
            try {
                if (SUB_TYPES_ELEMENTS.contains(className)) {
                    ((ISetup) field.get(this)).setUpElements(field);
                }
            } catch (IllegalAccessException e) {
                log.fatal(ExceptionUtils.getStackTrace(e));
            }
        }
    }
}