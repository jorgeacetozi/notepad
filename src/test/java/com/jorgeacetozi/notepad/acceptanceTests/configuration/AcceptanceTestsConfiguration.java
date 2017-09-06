package com.jorgeacetozi.notepad.acceptanceTests.configuration;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AcceptanceTestsConfiguration {
	private final static String NOTEPAD_URL = System.getProperty("acceptance.notepad.url", "http://localhost:8080");
	private final static String SELENIUM_URL = System.getProperty("selenium.url", "http://localhost:4444/wd/hub");
	private final static String SELENIUM_BROWSER = System.getProperty("selenium.browser", "chrome");

	@Bean(destroyMethod = "quit")
	public WebDriver webDriver() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities(SELENIUM_BROWSER, "", Platform.ANY);
		WebDriverException ex = null;
		for (int i = 0; i < 10; i++) {
			try {
				return new RemoteWebDriver(new URL(SELENIUM_URL), capabilities);
			} catch (WebDriverException e) {
				ex = e;
				System.out.println(String.format("Error connecting to %s: %s. Retrying", SELENIUM_URL, e));
				Thread.sleep(1000);
			}
		}
		throw ex;
	}

	@Bean
	public URI baseUri() throws URISyntaxException {
		return new URI(NOTEPAD_URL);
	}
}
