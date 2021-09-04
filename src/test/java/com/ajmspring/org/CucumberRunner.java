package com.ajmspring.org;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        strict = true,
        features = "classpath:features",
        glue = "com.ajmspring.org.bdd",
        tags = {"@regression"},
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",
                "html:screenshots"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
