package com.ajmspring.org.test;

import com.ajmspring.org.page.google.GooglePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends SpringBaseTestNgTest {

    @Autowired
    private GooglePage googlePage;

    @Test
    public void googleTest() {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());

        this.googlePage.getSearchComponent().search("Spring Boot");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
    }
}

