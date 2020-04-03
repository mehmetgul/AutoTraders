package com.autotraders.Pages;

import com.autotraders.utils.MyDriver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class BasePage {

    //When we use @FindBy annotation in this page.
	public BasePage() {

		PageFactory.initElements(MyDriver.get(), this);
	}

	//To use for certain wait time we use this method.
	public void waitforelements() throws InterruptedException {
		Thread.sleep(3000);
	}

    /**
     * Web site was not allowing the automation browser
     * And I saw that browser was doing it with cookies and
     * I cleaned the cookies every page navigation to make sure
     * my automation works.
     */
	public static void clearCookiees() {

		Set<Cookie> a = MyDriver.get().manage().getCookies();
		System.out.println(a);
		//Delete all the cookies
		MyDriver.get().manage().deleteAllCookies();

	}

	public void scrollDown(WebElement link)  {


		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) MyDriver.get();
		/**
		 *  this script must scroll, until link element is visible
		 *  once link element visible, it will stop scrolling
		 *  arguments[0] = means first webelement after comma (link)
		 *  arguments it's an array of webelements after comma
		 *  arguments[0] = link web element, it can be any web element
		 */
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("arguments[0].scrollIntoView(true)", link);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
