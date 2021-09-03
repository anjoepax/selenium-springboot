package com.ajmspring.org.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Lazy
@Component
public class ScreenShotUtil {

    @Autowired
    private TakesScreenshot driver;


    @Value("${screenshot.path}")
    private Path path;

    @PostConstruct
    private void init() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Sleeping....");
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void takeScreenshot(final String imageName) throws IOException {
        File srcFile = this.driver.getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(srcFile,this.path.resolve(imageName).toFile());
    }
}
