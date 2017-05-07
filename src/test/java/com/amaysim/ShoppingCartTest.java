package com.amaysim;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by aiam on 5/6/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources")
public class ShoppingCartTest {
}
