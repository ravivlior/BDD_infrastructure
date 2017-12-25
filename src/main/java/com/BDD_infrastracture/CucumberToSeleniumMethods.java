package com.BDD_infrastracture;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;


public class CucumberToSeleniumMethods {

    static String objectRepository;
    static WebDriver driver = new ChromeDriver();

    @Given("^Object repository for all GUI items is \"(.*)\"$")
    public void defineObjectRepository (String objectRepositoryName){
        objectRepository = objectRepositoryName;
    }

    @Given("^navigate to \"(.*)\" on browser$")
    public void navigate_to_URL_on_browser(String pathUrl) throws Throwable {
        driver.get(pathUrl);
        driver.manage().window().maximize();
    }

    @When("^type into \"(.*)\" the \"(.*)\"$")
    public void typeInputTextIntoField(String fieldNameParam, String inputText) throws Throwable {
        String fieldName = commonMethods.parseItemFromObjectRepository(objectRepository,fieldNameParam);
        driver.findElement(By.xpath(fieldName)).sendKeys(inputText);
    }

    @When("^press on button \"(.*)\"$")
    public void pressOnButton(String buttonNameParam) throws Throwable {
        String buttonName = commonMethods.parseItemFromObjectRepository(objectRepository,buttonNameParam);
        driver.findElement(By.xpath(buttonName)).click();
    }

    @When("^select item \"(.*)\" from dropdown list \"(.*)\"$")
    public void selectButton(int index,String dropdownListNameParam) throws Throwable {
        String dropdownName = commonMethods.parseItemFromObjectRepository(objectRepository,dropdownListNameParam);
        Select dropdown = new Select(driver.findElement(By.xpath(dropdownName)));
        dropdown.selectByIndex(index);
    }

    @When("^press on RETURN when in field \"(.*)\"$")
    public void press_on_RETURN(String fieldNameParam) throws Throwable {
        driver.findElement(By.xpath(fieldNameParam)).sendKeys(Keys.RETURN);
    }

    @Then("wait for \"(.*)\" is displaying on screen with timeout of \"(.*)\"$")
    public void waitUntillItemDisplay (String expectedItemParam, int timeOut) throws Throwable
    {
        String buttonName = commonMethods.parseItemFromObjectRepository(objectRepository,expectedItemParam);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonName)));
    }

    @Then ("^close the browser$")
    public void closeBrowser () throws Throwable
    {
        driver.close();
    }

    @Then("^the \"(.*)\" from the list is \"(.*)\"$")
    public void the_n_result_in_the_List_equals_to_expected_output(int resultNumber, String resultValue) throws Throwable {
        String bodyText = driver.findElement(By.xpath("(//*[@class='r'])["+resultNumber+"]")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(resultValue));
    }

    @Then("list of results \"(.*)\" not containing the item \"(.*)\"$")
    public void checkThatItemNotInList(String listNameParam, String itemNameParam) throws Throwable {
        String listText = driver.findElement(By.xpath(listNameParam)).getText();
        Assert.assertTrue("Text not found!", listText.contains(itemNameParam));
    }

}