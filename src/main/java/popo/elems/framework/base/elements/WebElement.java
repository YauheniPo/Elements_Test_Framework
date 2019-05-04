package popo.elems.framework.base.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import popo.elems.framework.base.BaseEntity;
import popo.elems.framework.base.BasePage;
import popo.elems.framework.base.elements.annotation.IElement;
import popo.elems.framework.base.elements.annotation.ISetup;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Log4j2
@RequiredArgsConstructor
public class WebElement<L extends BasePage> extends BaseEntity implements ISetup {

    @Getter @NonNull
    protected L landingPage;
    protected String xPath = "";
    protected String xPathPart = "";

    private String getXPath(String xPath) {
        return String.format(xPath, this.xPathPart);
    }

    private String getXPath() {
        return getXPath(this.xPath);
    }

    public WebElement<L> setXPathPart(String xPathPart) {
        this.xPathPart = xPathPart;
        return this;
    }

    public SelenideElement fetchElement() {
        return $(byXpath(getXPath())).shouldBe(Condition.exist);
    }

    @Step
    public L clickElement(String xPath) {
        $(byXpath(getXPath(xPath))).shouldBe(Condition.enabled).click();
        return this.landingPage;
    }

    public L clickElement() {
        return clickElement(this.xPath);
    }

    @Step
    public WebElement<L> hover() {
        $(byXpath(getXPath())).shouldBe(Condition.exist).hover();
        return this;
    }

    public boolean isElementExists(String xPath) {
        return $(byXpath(getXPath(xPath))).exists();
    }

    @Step
    public boolean isElementExists() {
        return isElementExists(this.xPath);
    }

    @Step
    public String getText() {
        return getText(this.xPath);
    }

    public String getText(String xPath) {
        return $(byXpath(getXPath(xPath))).getText();
    }

    public SelenideElement findElement(String xPath) {
        return $(byXpath(getXPath(xPath)));
    }

    public ElementsCollection findElements(String xPath) {
        return $$(byXpath(getXPath(xPath)));
    }

    @Override
    public void setUpElements(Field f) {
        Annotation[] annotations = f.getAnnotations();
        for (Annotation annotation : annotations) {
            String annotationName = annotation.annotationType().getName();
            if ("popo.elems.framework.base.elements.annotation.IElement".equals(annotationName)) {
                this.xPath = f.getAnnotation(IElement.class).xPath();
            }
        }
    }
}
