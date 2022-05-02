package com.github.pageobject;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class IssuePageWithSteps {

    @Step("Открытие главной страницы")
    public void openGithub(){
        Selenide.open("https://github.com/");}


    @Step("Ввод названия проекта в поисковую строку")
    public void search(String project){
        $(".header-search-input").setValue(project).pressEnter();
    }

    @Step("Переход по ссылке на страницу проекта")
    public void goToProject(String project){
        $(By.linkText(project)).click();
    }

    @Step("Открытие раздела с issue кликом по меню")
    public void openIssues(){
        $("#issues-tab").click();
    }

    @Step("Получение заголовка issue")
    public String getIssueName(String number){
        String name = $("#issue_"+number+"_link").getText();
        return name;
    }

    @Step("Проверка соответствия заголовка")
    public void assertIssueName(String name){
        Assertions.assertEquals("с днем археолога!", name);
    }
}
