package com.ajmspring.org.page.window;

import com.ajmspring.org.annotations.Window;
import com.ajmspring.org.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Window("Page A")
public class PageA extends BasePage {

    @FindBy(id = "area")
    private WebElement textArea;

    public void addToArea(final String msg) {
        this.textArea.sendKeys(msg);
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> this.textArea.isEnabled() && this.textArea.isDisplayed());
    }
}
