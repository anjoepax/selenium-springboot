package com.ajmspring.org.visa;

import com.ajmspring.org.entity.User;
import com.ajmspring.org.page.visa.VisaRegistrationPage;
import com.ajmspring.org.repository.UserRepository;
import com.ajmspring.org.test.SpringBaseTestNgTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.sql.Date;


public class UserVisaTest extends SpringBaseTestNgTest {

    private static final Logger logger = LoggerFactory.getLogger(UserVisaTest.class);

    @Autowired
    private VisaRegistrationPage registrationPage;

    @Autowired
    private UserRepository repository;

    @Test(enabled = false)
    public void visaTest() {
        this.repository.findById(85)
                .ifPresent(u -> System.out.println(u.getFirstName()));
    }

    @Test(dataProvider = "getData")
    public void visaTest2(User u) {
        this.registrationPage.goTo();
        this.registrationPage.setNames(u.getFirstName(), u.getLastName());
        this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
        this.registrationPage.setBirthDate(u.getDob().toLocalDate());
        this.registrationPage.setContactDetails(u.getEmail(), u.getPhone());
        this.registrationPage.setComments(u.getComments());
        this.registrationPage.submit();

        logger.info("Request confirmation # INFO" + this.registrationPage.getConfirmationNumber());
        logger.warn("Request confirmation # WARN" + this.registrationPage.getConfirmationNumber());
    }

    @DataProvider
    public Object[] getData(ITestContext context) {
        return this.repository.findByDobBetween(
                Date.valueOf(context.getCurrentXmlTest().getParameter("dobFrom")),
                Date.valueOf(context.getCurrentXmlTest().getParameter("dobTo"))
        )//findByFirstNameStartingWith("Mi")
                .stream()
                .limit(1)
                .toArray();
    }
}

//application.properties
//spring.datasource.url=jdbc:postgresql://10.11.12.13:5432/appdb
//spring.datasource.username=vinsguru
//spring.datasource.password=admin

