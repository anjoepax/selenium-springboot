package com.ajmspring.org.page.google;

import com.ajmspring.org.page.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SearchComponent extends BasePage {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private List<WebElement> searchBtns;

    public void search(final String searchTerm) {
        this.searchBox.sendKeys(searchTerm);
        this.searchBox.sendKeys(Keys.TAB);
        this.searchBtns
                .stream()
                .filter(e -> e.isDisplayed() && e.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> this.searchBox.isDisplayed());
    }
}

