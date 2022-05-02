package com.github;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.pageobject.IssuePageWithSteps;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotationStepsTests {

    String name;
    private static final String PROJECT = "eroshenkoam/allure-example";
    private static final String ISSUE = "65";

    @Test
    @DisplayName("Проверка заголовка "+ISSUE+" записи")
    public void issueNameTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        IssuePageWithSteps steps = new IssuePageWithSteps();

        steps.openGithub();
        steps.search(PROJECT);
        steps.goToProject(PROJECT);
        steps.openIssues();
        name = steps.getIssueName(ISSUE);
        steps.assertIssueName(name);
    }
}
