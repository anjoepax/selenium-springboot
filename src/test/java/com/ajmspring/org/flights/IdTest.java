package com.ajmspring.org.flights;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = {"app.locale=id", "browser=edge"})
public class IdTest extends FlightTest{
}
