package ua.moyo;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest extends BaseTest{


    @BeforeEach
    void openPage() {
        open("/");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    void searchProductByTitleAndAddToCard() {
        var productName = "Sencor SHF2001GR";
        var productId = "152548";
        var nameOfClient = "Иван";
        
        Faker faker = new Faker();
        var phoneNumber = faker.phoneNumber().phoneNumber();
        var email = faker.internet().emailAddress();
        SearchPage searchPageResult = new SearchPage();

        new HomePage().searchFor(productName);
        searchPageResult.getSearchResultTitle();

        searchPageResult.getProductCard(productId).shouldHave(text(productName));
        searchPageResult.buyProductBtn(productId).click();

        $(".cart-item__title").shouldHave(text(productName));
        $(".footer-cta").click();

        $$(".cart-items-list-item").shouldHave(size(1));
        $(".product-link").shouldHave(text(productName));

        OrderPage fillOrder = new OrderPage();
        fillOrder
                .customerName(nameOfClient)
                .customerPhone(phoneNumber)
                .customerEmail(email);
        fillOrder.clickSecondStepButton();
        fillOrder.clickOnConfirmStep2Btn();
        $("#confirmOrderBtn").isEnabled();
        sleep(5000);
    }

    @Test
    void searchProductByTitleTest(){
        var productName = "Увлажнитель воздуха Sencor SHF2001GR";

        new HomePage().searchFor(productName);
        var searchResultPage = new SearchPage();

        var getActualResultTitle = searchResultPage.getSearchResultTitle();
        Assertions.assertEquals(productName,getActualResultTitle);

        var actualFirstProductTitle = searchResultPage.getFirstProductInfoTitle();
        Assertions.assertEquals(productName,actualFirstProductTitle);

    }
}