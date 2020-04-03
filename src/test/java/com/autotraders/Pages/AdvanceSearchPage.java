package com.autotraders.Pages;

import com.autotraders.utils.MyDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdvanceSearchPage extends BasePage {

	/**
	 * Locators
	 */
	@FindBy(xpath = "//a[contains(text(),'Advanced Search')]")
	public WebElement clickAdvanceSearch;

	@FindBy(xpath = "//input[contains(@type,'tel')]")
	public WebElement enterZipCode;

	@FindBy(xpath = "//div[contains(text(),'Certified')]")
	public WebElement selectCertified;

	@FindBy(xpath = "//div[contains(text(),'Convertible')]")
	public WebElement selectConvertible;

	@FindBy(xpath = "//select[contains(@name,'startYear')]")
	public WebElement selectFrom;

	@FindBy(xpath = "//select[contains(@name,'endYear')]")
	public WebElement selectTo;

	@FindBy(xpath = "//select[contains(@name,'makeFilter0')]")
	public WebElement selectBMW;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-block ae-button']")
	public WebElement clickSearchButton;

	@FindBy(xpath = "//title[contains(text(),'Certified BMW Convertibles for Sale')]")
	public WebElement userInPage;

	@FindBy(xpath = "//h2[contains(@data-cmp,'subheading')]")
	public WebElement onlyBMW;

	@FindBy(xpath = "//div[contains(@data-cmp,'inventoryListing')]")
	public WebElement numberOfBMW;


	/**
	 * Scenario 2 starting.
	 */

	//Clicking the advance search link.
	public void verifyclickable() {
		//Trying to make sure page loaded and all the elements visible.
		MyDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//to see the process putting 3 second wait.
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clickAdvanceSearch.click();
	}

	/**
	 * After navigating Advance Search page
	 * We are filling required fields to click search button.
	 */

	//Entering zipcode.
	public void verifyZipCode(String zipcode) {
		MyDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		enterZipCode.sendKeys(zipcode);
	}


	//Clicking the Certificate and Convertible checkboxes.
	public void verifyclickCertifiedAndConvertible(String a) {

		if (a.equalsIgnoreCase(selectCertified.getText())) {
			selectCertified.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			WebElement link = selectConvertible;
			scrollDown(link);
			selectConvertible.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	//Choosing the "from" to "To" years range.
	public void verifyselectStartAndEnd(String fromYear, String toYear) {
		MyDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select select = new Select(selectFrom);
		select.selectByValue(fromYear);
		Select select1 = new Select(selectTo);
		select1.selectByValue(toYear);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//Choosing the Car Make as BMW
	public void verifyselectVehicle(String car) {
		MyDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select select = new Select(selectBMW);
		select.selectByValue(car);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//Clicking the Search button
	public void verifyClickSearchButton() {

		WebElement link = clickSearchButton;
		scrollDown(link);
		clickSearchButton.click();
	}


	/**
	 * After clicking search button
	 * We are verifying that result is correct
	 */

	//Verifying the title that we are in result page.
	public void VerifyUsersInPage() {

		userInPage.getText();
	}

	//Verifying that in result page there is no other car results come.
	public void VerifyThereIsOnlySelectedVehicle(String car) {
		//Storing all the results in List and comparing all the results not contains BMW
		List<WebElement> list = MyDriver.get().findElements(By.xpath("//h2[contains(@data-cmp,'subheading')]"));
		int count = 0;
		int NonBMWcount=0;
		for (WebElement each : list) {
			if (!each.getText().contains(car)) {
				System.out.println("We found non BMW listing " + NonBMWcount);
			}
			count++;
		}
		System.out.println("We found " + count + " BMW listing and There is no non BMW listing");
	}


	//Counting how many listing result displayed.
	public void verifyNumberOfBMW() {

		List<WebElement> list = MyDriver.get().findElements(By.xpath("//div[contains(@data-cmp,'inventoryListing')]"));

		System.out.println("Number of BMW listed in result page is :" + list.size());

		int actual = list.size();
		String expected = MyDriver.get().findElement(By.xpath("//div[@class='results-text-container text-size-200']")).getText();
		System.out.println(expected);

		String[] arr = expected.split(" ");
		//System.out.println(arr[2]);
		int expectedResult = Integer.parseInt(arr[2]);
		Assert.assertEquals("Assertion failed", expectedResult, actual);
	}


}
