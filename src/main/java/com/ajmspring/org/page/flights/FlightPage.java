package com.ajmspring.org.page.flights;

import com.ajmspring.org.annotations.Page;
import com.ajmspring.org.annotations.TakeScreenshot;
import com.ajmspring.org.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

@Page
public class FlightPage extends BasePage {

    @FindBy(css = "[jsname='iSelEd']")
    private List<WebElement> flightWidgetLabels;

    public void goTo(final String url) {
        this.driver.manage().window().maximize();
        this.driver.get(url);
    }

    @TakeScreenshot
    public List<String> getLabels() {
        return this.flightWidgetLabels
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public void closeFlightPage() {
        this.driver.quit();
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> !this.flightWidgetLabels.isEmpty());
    }
}

