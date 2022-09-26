package ua.moyo;


import com.codeborne.selenide.Configuration;

public abstract class BaseTest {

     static {
         Configuration.baseUrl = "https://www.moyo.ua/";
         Configuration.pageLoadStrategy = "none";
         Configuration.timeout = 4000;
     }
}

