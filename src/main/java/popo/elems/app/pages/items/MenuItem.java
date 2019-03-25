package popo.elems.app.pages.items;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor()
@Getter
public enum MenuItem {

    TOP_WATCH_BRANDS_MAIN_MENU_ITEM("Top Watch Brands"),
    ALL("ALL"),

    LUMINOX("Luminox");

    private String item;
}
