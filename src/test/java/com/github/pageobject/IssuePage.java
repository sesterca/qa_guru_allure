package com.github.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class IssuePage {

    public static final String GIT = "https://github.com/";

    SelenideElement searchInput = $(".header-search-input");
    SelenideElement menuIssues = $("#issues-tab");

    public void search(String project){
        searchInput.setValue(project).pressEnter();
    }
    public void goToProject(String project){
        $(By.linkText(project)).click();
    }
    public void openIssues(){
        menuIssues.click();
    }
    public String getIssueName(String number){
        String name = $("#issue_"+number+"_link").getText();
        return name;
        }
}
