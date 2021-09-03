package com.ajmspring.org.page.google;

import com.ajmspring.org.annotations.PageFragment;
import com.ajmspring.org.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

@PageFragment
public class SearchResult extends BasePage {

    @FindBy(xpath = "//cite")
    private List<WebElement> results;

    public int getCount() {
        return this.results.size();
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> !this.results.isEmpty());
    }
}
