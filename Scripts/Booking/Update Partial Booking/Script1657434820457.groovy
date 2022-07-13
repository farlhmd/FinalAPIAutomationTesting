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

// To implement DDT
GlobalVariable.id = id

GlobalVariable.firstName = firstName

GlobalVariable.lastName = lastName

// Unchanged variables
//GlobalVariable.totalPrice = totalPrice
//
//GlobalVariable.depositPaid = depositPaid
//
//GlobalVariable.bookingCheckIn = bookingCheckIn
//
//GlobalVariable.bookingCheckOut = bookingCheckOut
//
//GlobalVariable.additionalNeeds = additionalNeeds

response = WS.sendRequest(findTestObject('EP_Booking/Patch Partial Booking'))

// Success if response 200
WS.verifyResponseStatusCode(response, 200)

// Assign json slurper to a new variable
def slurper = new JsonSlurper()

// Assign slurper result into a new variable
def result = slurper.parseText(response.getResponseBodyContent())

WS.comment('To check all available indexes of data')


//id = result.bookingid

// The results from Json Slurper
//firstName = result.booking.firstname
//
//lastName = result.booking.lastname
//
//totalPrice = result.booking.totalprice
//
//depositPaid = result.booking.depositpaid
//
//bookingCheckIn = result.booking.bookingdates.checkin
//
//bookingCheckOut = result.booking.bookingdates.checkout
//
//additionalNeeds = result.additionalneeds
firstNameVerified = WS.verifyElementPropertyValue(response, 'firstname', firstName, FailureHandling.OPTIONAL)

lastNameVerified = WS.verifyElementPropertyValue(response, 'lastname', lastName, FailureHandling.OPTIONAL)

// Unused Variables
//totalPriceVerified = WS.verifyElementPropertyValue(response, 'totalprice', totalPrice, FailureHandling.OPTIONAL)
//
//depositPaidVerified = WS.verifyElementPropertyValue(response, 'depositpaid', depositPaid, FailureHandling.OPTIONAL)
//
//bookingCheckInVerified = WS.verifyElementPropertyValue(response, 'bookingdates.checkin', bookingCheckIn, FailureHandling.OPTIONAL)
//
//bookingCheckOutVerified = WS.verifyElementPropertyValue(response, 'bookingdates.checkout', bookingCheckOut, FailureHandling.OPTIONAL)
//
//additionalNeedsVerified = WS.verifyElementPropertyValue(response, 'additionalneeds', additionalNeeds, FailureHandling.OPTIONAL)

if (firstNameVerified == true) {
    WS.comment("The item with First Name $firstName is valid")

    if (lastNameVerified == true) {
        WS.comment("The item with Last Name $lastName is valid")

		// Unused Variables
//        if (totalPriceVerified == true) {
//            WS.comment("The item with Total Price $totalPrice is valid")
//
//            if (depositPaidVerified == true) {
//                WS.comment("The item with Deposit Paid $depositPaid is valid")
//            } else {
//                WS.comment("The item with Deposit Paid $depositPaid is invalid")
//            }
//        } else {
//            WS.comment("The item with Total Price $totalPrice is invalid")
//        }
    } else {
        WS.comment("The item with Last Name $lastName is invalid")
    }
} else {
    WS.comment("The item with First Name $firstName is invalid")
}

