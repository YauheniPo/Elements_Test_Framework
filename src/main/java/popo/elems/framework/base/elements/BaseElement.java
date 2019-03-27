package popo.elems.framework.base.elements;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import popo.elems.framework.base.BaseEntity;

@Log4j2
public class BaseElement extends BaseEntity {

    @Getter @Setter
    private SelenideElement selenideElement;
}
