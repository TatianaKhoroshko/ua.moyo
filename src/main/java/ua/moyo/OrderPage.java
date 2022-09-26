package ua.moyo;

import static com.codeborne.selenide.Selenide.$;

public class OrderPage {

        public OrderPage customerName(String nameOfClient) {
            $("[name='firstname']").val(nameOfClient).pressEnter();
            return this;
        }

        public OrderPage customerPhone(String phoneNumber){
            $("[name='phone']").val(phoneNumber).pressEnter();
            return this;
        }

        public OrderPage customerEmail(String email){
            $("[name='email']").val(email).pressEnter();
            return this;
        }

        public OrderPage clickSecondStepButton(){
            $("#contactsFormBtn").click();
            return this;
        }

        public OrderPage clickOnConfirmStep2Btn(){
            $("#confirmStep2Btn").click();
            return this;
        }
}
