package com.petclinic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class Owners {


    private By owners = By.cssSelector("ul>li:nth-child(2)>a");
    private By findAll = By.cssSelector("a[href=\"/petclinic/owners\"]");
    private By addOwner = By.cssSelector(" ul > li:nth-child(2) > a > span:nth-child(2)");
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By address = By.id("address");
    private By city = By.id("city");
    private By telephone = By.id("telephone");
    private By addOwnerBtn = By.cssSelector("button[type=\"submit\"]");


    @BeforeMethod
    public void openSite(){
        Configuration.baseUrl = "http://46.101.230.213:8000";
        open(Configuration.baseUrl);
    }

    @Test
    public void addOwner() {
        $(owners).click();
        $(addOwner).click();
        $(firstName).setValue("Dayneris");
        $(lastName).setValue("Targarien");
        $(address).setValue("Dragon");
        $(city).setValue("Westeros");
        $(telephone).setValue("1234");
        sleep(2000);
        $(addOwnerBtn).click();
        $(owners).shouldBe(Condition.visible);
    }

}
