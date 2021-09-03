package com.ajmspring.org.test;

import com.ajmspring.org.page.google.GooglePage;
import com.ajmspring.org.util.ScreenShotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class Google1Test extends SpringBaseTestNgTest {

    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenShotUtil screenshotUtil;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchComponent().search("environment ");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.screenshotUtil.takeScreenshot("google-screenshot.png");
    }
}

