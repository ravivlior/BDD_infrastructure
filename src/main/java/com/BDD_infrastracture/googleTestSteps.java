package com.BDD_infrastracture;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class googleTestSteps {

    private String searchText;

    private WebDriver driver = new ChromeDriver();

    @Given("^navigate to \"(.*)\" on browser$")
    public void navigate_to_URL_on_browser(String pathUrl) throws Throwable {
        driver.get(pathUrl);
        driver.manage().window().maximize();

    }

    @When("^type into \"(.*)\" the \"(.*)\"$")
    public void type_inputText_into_field(String fieldNameParam, String inputText) throws Throwable {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/main/ObjectRepository/GoogleObjectRepository.json"));
        JSONObject jsonObject = (JSONObject) obj;
        String fieldName = (String) jsonObject.get(fieldNameParam);
        driver.findElement(By.xpath(fieldName)).sendKeys(inputText);
        searchText=inputText;
    }

    @When("^press on \"(.*)\"$")
    public void press_on_button(String buttonID) throws Throwable {
        WebElement webElement = driver.findElement(By.id(buttonID));
        webElement.sendKeys(Keys.ENTER);
    }

    @Then("^the \"(.*)\" from the list is \"(.*)\"$")
    public void the_n_result_in_the_List_equals_to_expected_output(int resultNumber, String resultValue) throws Throwable {
        String bodyText = driver.findElement(By.xpath("(//*[@class='r'])["+resultNumber+"]")).getText();
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