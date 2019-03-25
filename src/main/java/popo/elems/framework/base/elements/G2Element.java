package popo.elems.framework.base.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import popo.elems.framework.base.BasePage;
import popo.elems.framework.base.elements.annotation.Element;
import popo.elems.framework.base.elements.annotation.ISetup;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Log4j2
@RequiredArgsConstructor
@NoArgsConstructor
public class G2Element<L extends BasePage> extends BaseElement implements ISetup {

    @NonNull
    protected L landingPage;
    protected String xPath;
    protected String xPathPart;

    public G2Element<L> setXPathPart(String xPathPart) {
        this.xPathPart = xPathPart;
        return this;
    }

    protected L clickElement(String xPath) {
        $(byXpath(xPath)).shouldBe(Condition.enabled).click();
        return this.landingPage;
    }

    protected L clickElement() {
        return clickElement(this.xPath);
    }

    protected boolean isElementExists(String xPath) {
        return $(byXpath(xPath)).exists();
    }

    public boolean isElementExists() {
        return isElementExists(String.format(this.xPath, this.xPathPart));
    }

    protected String getText() {
        return getText(this.xPath);
    }

    protected String getText(String xPath) {
        return $(byXpath(xPath)).getText();
    }

    protected SelenideElement findElement(String xPath) {
        return $(byXpath(xPath));
    }

    protected ElementsCollection findElements(String xPath) {
        return $$(byXpath(xPath));
    }

    @Override
    public void setUpElements(Field f) {
        Annotation[] annotations = f.getAnnotations();
        for (Annotation annotation : annotations) {
            String annotationName = annotation.annotationType().getName();
            if ("popo.elems.framework.base.elements.annotation.Element".equals(annotationName)) {
                this.xPath = f.getAnnotation(Element.class).хPath();
            }
        }
    }
}
