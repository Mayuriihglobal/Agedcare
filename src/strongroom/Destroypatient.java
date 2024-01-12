package strongroom;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objects.DestroyPatientPage;
import objects.SignPage;
import test.Util.TestUtil;

public class Destroypatient {
	
	private DestroyPatientPage destroyPatientPage;
	private SignPage signPage;
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData =TestUtil.getDatafordestorypatient();
		return testData.iterator();
	}
	
	@Test(priority = 1, invocationCount = 15, enabled = false, dataProvider= "getTestData")
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
}
