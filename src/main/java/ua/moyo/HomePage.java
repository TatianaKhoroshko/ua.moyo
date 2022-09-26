package ua.moyo;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    public void searchFor(String searchProduct) {
        $(".js-header-search-input").val(searchProduct).pressEnter();
    }
}
