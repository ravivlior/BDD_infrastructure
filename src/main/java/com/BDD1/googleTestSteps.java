package com.BDD1;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class googleTestSteps {
    String searchText;

    private WebDriver driver = new ChromeDriver();
    @Given("^navigate to \"(.*)\" on browser$")
    public void navigate_to_URL_on_browser(String pathUrl) throws Throwable {
        driver.get(pathUrl);
        driver.manage().window().maximize();

    }

    @When("^type into \"(.*)\" the \"(.*)\"$")
    public void type_inputText_into_field(String fieldName, String inputText) throws Throwable {
        driver.findElement(By.id(fieldName)).sendKeys(inputText);
        searchText=inputText;
    }

    @When("^press on \"(.*)\"$")
    public void press_on_button(String buttonID) throws Throwable {
        WebElement webElement = driver.findElement(By.id(buttonID));
        webElement.sendKeys(Keys.ENTER);
    }

    @Then("^the \"(.*)\" from the list is \"(.*)\"$")
    public void the_n_result_in_the_List_equals_to_expected_output(int resultNumber, String resultValue) throws Throwable {
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(resultValue));
    }

    @Then ("^close the browser$")
    public void closeBrowser () throws Throwable
    {
        driver.close();
    }

//    @Then("^read file named\"(.*)\"$")
//    public String readFile (String fileName) throws Throwable
//    {
//        BufferedReader br=null;
//        FileReader fr=null;
//
//
//        String textFromFile="";
//
//        try {
//            fr=new FileReader(fileName);
//            br=new BufferedReader(fr);
//
//
//            String currentLine="";
//            while ((currentLine=br.readLine())!=null)
//            {
//                textFromFile +=" "+ currentLine;
//            }
//
//        }catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        finally {
//            System.out.println(textFromFile);
//            return textFromFile;
//        }
//    }


}