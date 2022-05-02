package com.github;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.pageobject.IssuePage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class AllureListenerAndLambdaTests {

    IssuePage issuePage;
    String name;

    private static final String PROJECT = "eroshenkoam/allure-example";
    private static final String ISSUE = "65";

        @Test
        @Severity(SeverityLevel.TRIVIAL)
        @DisplayName("Проверка заголовка "+ISSUE+" записи (лямбда)")
        public void issueNameLambdaTest(){
            SelenideLogger.addListener("allure", new AllureSelenide());
            step("Открытие главной страницы", () -> {
                issuePage = Selenide.open(IssuePage.GIT, IssuePage.class);
            });
            step("Ввод названия проекта в поисковую строку", () -> {
                issuePage.search(PROJECT);
            });
            step("Переход по ссылке результата поиска на страницу проекта", () -> {
                issuePage.goToProject(PROJECT);
            });
            step("Открытие раздела с issue кликом по меню", () -> {
                issuePage.openIssues();
            });
            step("Получение заголовка issue", () -> {
                name = issuePage.getIssueName(ISSUE);
            });
            step("Проверка соответствия заголовка", () -> {
                Assertions.assertEquals("с днем археолога!", name);
            });
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Проверка заголовка "+ISSUE+" записи")
    public void issueNameTest(){

        IssuePage issuePage = Selenide.open(IssuePage.GIT, IssuePage.class);
        issuePage.search(PROJECT);
        issuePage.goToProject(PROJECT);
        issuePage.openIssues();
        String name = issuePage.getIssueName(ISSUE);

        Assertions.assertEquals("с днем археолога!", name);
    }
}
