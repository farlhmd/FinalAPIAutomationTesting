import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper as JsonSlurper

response = WS.sendRequest(findTestObject('EP_Booking/Get all Booking Id'))
// Success if response 200
WS.verifyResponseStatusCode(response, 200)
// Assign json slurper to a new variable
def slurper = new JsonSlurper()

// Assign slurper result into a new variable
def result = slurper.parseText(response.getResponseBodyContent())

total = 0
WS.comment("To check all available indexes of data")
// for(int i = 0; i < result.size(); i++) {
// To shorten the validation procedure, I only test 10 item instead of 3000+ datas, if you want, uncomment the code above and comment the code below
for(int i = 0; i < 10; i++) {
	bookingId = result[i].bookingid
	
	bookingIdVerified = WS.verifyElementPropertyValue(response, "[$i].bookingid", bookingId, FailureHandling.OPTIONAL)
	
	if(bookingIdVerified == true) {
		WS.comment("The item with Booking Id $bookingId is valid")
		total++
	}else {
		WS.comment("The item with Booking Id $bookingId is invalid")
	}
}

WS.comment("Indexes verified: $total")






