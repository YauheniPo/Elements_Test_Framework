package popo.elems.app.pages;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import popo.elems.framework.base.BasePage;

@Log4j2
@NoArgsConstructor
public class MainWatchCo extends BasePage {

    public MenuBar<MainWatchCo> getMenuBar() {
        return new MenuBar<>(new MainWatchCo());
    }
}
