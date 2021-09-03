package com.ajmspring.org.test;

import com.ajmspring.org.annotations.LazyAutowired;
import com.ajmspring.org.page.google.GooglePage;
import com.ajmspring.org.service.ScreenshotService;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class Google1Test extends SpringBaseTestNgTest {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotService screenshotUtil;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchComponent().search("environment ");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.screenshotUtil.takeScreenshot();
        this.googlePage.quitDriver();
    }
}

