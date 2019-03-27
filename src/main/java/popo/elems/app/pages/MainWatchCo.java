package popo.elems.app.pages;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import popo.elems.framework.base.BasePage;

@Log4j2
@NoArgsConstructor
public class MainWatchCo<L extends BasePage> extends BasePage {

    public final MenuBar menuBar = new MenuBar();

    public MainWatchCo(L landingPage) {
        super(landingPage);
    }
}
