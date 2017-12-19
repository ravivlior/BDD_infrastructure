package com.BDD1;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/googleTest.feature"},format = {"pretty", "json:out/"})

public class cukesRunner {}
