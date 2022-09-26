package ua.moyo;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {

    private By productListItem = By.cssSelector(".product-item");
    public String getSearchResultTitle() {
        return $(".search_title_search-string").getText();
    }

    public int getSearchResultListSize(){
        return $$(productListItem).size();
    }

    public String getFirstProductInfoTitle(){
        return $(productListItem).$(".product-item_name").getText();
    }

    private static SelenideElement findProductById(String productId) {
        return $(by("data-id", productId));
    }
    public SelenideElement getProductCard(String productId){
       return findProductById(productId).$(".product-item_content .product-item_name");
    }

    public SelenideElement buyProductBtn(String productId){
        return findProductById(productId).$(".buy-btn");
    }
}
