package strongroom;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import clickUp.createTask;
import objects.AdjustmentimprestPage;
import objects.DestroyPatientPage;
import objects.DestroyimprestPage;
import objects.LoginPage;
import objects.NotificationPage;
import objects.OutgoingPatientPage;
import objects.OutgoingimprestPage;
import objects.SecondPage;
import objects.SignPage;
import objects.Stocktakepage;
import objects.Stocktakepages;
import objects.TransferInPatientPage;
import objects.TransferInimprestPage;
import objects.TransferoutPatientPage;
import objects.TransferoutimprestPage;

public class Agedcare extends createTask {
	private WebDriver driver;
	private WebDriverWait wait;
	private LoginPage loginPage;
	private SecondPage secondPage;
	private NotificationPage notificationPage;
	private Stocktakepage stocktakepage;
	private TransferInimprestPage transferInPage;
	private TransferoutimprestPage transferoutimprestPage;
	private TransferInPatientPage transferInPatientPage;
	private TransferoutPatientPage transferoutPatientPage;
	private DestroyimprestPage destroyimprestPage;
	private DestroyPatientPage destroyPatientPage;
	private OutgoingimprestPage outgoingimprestPage;
	private OutgoingPatientPage outgoingPatientPage;
	private AdjustmentimprestPage adjustmentimprestPage;
	private SignPage signPage;
	private Stocktakepages stocktakepages;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		loginPage = new LoginPage(driver, wait);
		secondPage = new SecondPage(driver, wait);
		notificationPage = new NotificationPage(driver, wait);
		stocktakepage = new Stocktakepage(driver, wait);
		transferInPage = new TransferInimprestPage(driver, wait);
		transferoutimprestPage = new TransferoutimprestPage(driver, wait);
		transferInPatientPage = new TransferInPatientPage(driver, wait);
		transferoutPatientPage = new TransferoutPatientPage(driver, wait);
		destroyimprestPage = new DestroyimprestPage(driver, wait);
		destroyPatientPage = new DestroyPatientPage(driver, wait);
		outgoingimprestPage = new OutgoingimprestPage(driver, wait);
		outgoingPatientPage = new OutgoingPatientPage(driver, wait);
		adjustmentimprestPage = new AdjustmentimprestPage(driver, wait);
		signPage = new SignPage(driver, wait);
		stocktakepages = new Stocktakepages(driver, wait);

	}

	@Test(priority = 0)
	public void Login() {
		// Test Scenario
		loginPage.openLoginPage("https://staging.strongroom.ai/login");
		LoginPage.login();
		loginPage.clickLoginButton();

		secondPage.selectLocationFromDropdown();
		secondPage.clickSecondPageButton();
		notificationPage.clickNotificationIcon();

	}

	@Test(priority = 1, enabled = false)
	public void Adjustmentimprest() throws InterruptedException {

		adjustmentimprestPage.Adjustment();
		adjustmentimprestPage.writenote();
		adjustmentimprestPage.imprest();

		// Thread.sleep(3000);
		// signPage.performSignature("valeshan.naidoo@strongroom.ai", "1111");
		// Thread.sleep(6000);
	}

	@Test(priority = 1, invocationCount = 1, enabled = false)
	public void OutgoingPatient() throws InterruptedException {

		outgoingPatientPage.Outgoing();
		outgoingPatientPage.writenote();
		outgoingPatientPage.Resident();

		Thread.sleep(3000);
		signPage.performSignature("valeshan.naidoo@strongroom.ai", "1111");
		Thread.sleep(6000);
	}

	@Test(priority = 1, invocationCount = 15, enabled = false)
	public void Outgoingimprest() throws InterruptedException {

		outgoingimprestPage.Outgoing();
		outgoingimprestPage.writenote();
		outgoingimprestPage.imprest();

		Thread.sleep(3000);
		signPage.performSignature("valeshan.naidoo@strongroom.ai", "1111");
		Thread.sleep(6000);
	}

	@Test(priority = 1, invocationCount = 15, enabled = false)
	public void DestroyPatient() throws InterruptedException {

		destroyPatientPage.Destroy();
		destroyPatientPage.writenote();
		destroyPatientPage.MethodOFDestruction();
		destroyPatientPage.CourierNameandNotes();
		destroyPatientPage.Resident();
		Thread.sleep(3000);
		signPage.performSignature("valeshan.naidoo@strongroom.ai", "1111");
		Thread.sleep(6000);
	}

	@Test(priority = 1, invocationCount = 3, enabled = false)
	public void Destroyimprest() throws InterruptedException {

		destroyimprestPage.Destroy();
		destroyimprestPage.writenote();
		destroyimprestPage.MethodOFDestruction();
		destroyimprestPage.CourierNameandNotes();
		destroyimprestPage.imprest();
		Thread.sleep(3000);
		signPage.performSignature("valeshan.naidoo@strongroom.ai", "1111");
		Thread.sleep(6000);
	}

	@Test(priority = 1, invocationCount = 15, enabled = false)
	public void TransferoutPatient() throws InterruptedException {

		transferoutPatientPage.transferout();
		transferoutPatientPage.enterLocation();
		transferoutPatientPage.writenote();
		transferoutPatientPage.Resident();
		Thread.sleep(3000);
		signPage.performSignature("valeshan.naidoo@strongroom.ai", "1111");
		Thread.sleep(6000);
	}

	@Test(priority = 1, invocationCount = 1, enabled = false)
	public void TransferoutImprest() throws InterruptedException {

		transferoutimprestPage.transferout();
		transferoutimprestPage.enterLocation();
		transferoutimprestPage.writenote();
		transferoutimprestPage.imprest();
		Thread.sleep(3000);
		signPage.performSignature("valeshan.naidoo@strongroom.ai", "1111");
		Thread.sleep(6000);
	}

	@Test(priority = 2, invocationCount = 15, enabled = false)
	public void TransferinPatient() throws InterruptedException {

		transferInPatientPage.transferIn();
		transferInPatientPage.enterLocation();
		transferInPatientPage.writenote();
		transferInPatientPage.Resident();
		Thread.sleep(3000);
		signPage.performSignature("valeshan.naidoo@strongroom.ai", "1111");
		Thread.sleep(6000);
	}

	@Test(priority = 1, enabled = false)

	public void stocktakeOpen() throws InterruptedException {
		stocktakepage.clickStock();
		stocktakepage.clickStockTake();

		// Loop through the test execution
		for (int i = 0; i < 15; i++) {
			stocktakepage.enterMedication(i);
			Thread.sleep(3000);
			stocktakepage.Displayinstock();
			stocktakepage.searching();
			stocktakepage.Displayimprest();
			Thread.sleep(3000);

			int actualValue = stocktakepage.getExpectedValue();
			System.out.println("(Stock): " + actualValue);
		}
	}

	@Test(priority = 2, invocationCount = 15, enabled = false)
	public void TransferinImprest() throws InterruptedException {

		transferInPage.transferIn();
		transferInPage.enterLocation();
		transferInPage.writenote();
		transferInPage.imprest();
		Thread.sleep(3000);
		signPage.performSignature("valeshan.naidoo@strongroom.ai", "1111");
		Thread.sleep(6000);
	}

	@Test(priority = 3, enabled = false)

	public void stocktakeclose() throws InterruptedException {
		stocktakepages.clickStock();
		stocktakepages.clickStockTake();

		// Loop through the test execution
		for (int i = 0; i < 15; i++) {
			stocktakepages.enterMedication(i);
			Thread.sleep(3000);
			stocktakepages.Displayinstock();
			stocktakepages.searching();
			stocktakepages.Displayimprest();
			Thread.sleep(3000);

			int actualValue = stocktakepages.getExpectedValue();
			System.out.println("(Stock): " + actualValue);
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		// driver.close();

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws java.io.IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			// Test case failed, extract method name and console error
			String methodName = result.getMethod().getMethodName();
			String consoleError = extractConsoleError(result);
			String status = "fail";
			// Create ClickUp task with method name as task name and console error in
			// description
			createClickUpTask(methodName, consoleError, status);
		} else {
			String methodName = result.getMethod().getMethodName();
			String consoleError = extractConsoleError(result);
			String status = "pass";
			// Create ClickUp task with method name as task name and console error in
			// description
			createClickUpTask(methodName, consoleError, status);
		}

	}

	private String extractConsoleError(ITestResult result) {
		String consoleOutput = "";
		Throwable throwable = result.getThrowable();
		if (throwable != null) {
			consoleOutput = throwable.getMessage();
		}
		return consoleOutput;
	}
}