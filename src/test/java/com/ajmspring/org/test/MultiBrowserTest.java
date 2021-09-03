package com.ajmspring.org.test;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;

public class MultiBrowserTest extends SpringBaseTestNgTest {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void browserTest() {
        this.ctx.getBean("chromeDriver", WebDriver.class).get("https://www.google.com");
        this.ctx.getBean("edgeDriver", WebDriver.class).get("https://www.yahoo.com");
    }
}
