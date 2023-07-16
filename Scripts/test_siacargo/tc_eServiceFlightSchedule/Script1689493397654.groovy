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
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebElement as Keys

WebUI.openBrowser('https://www.siacargo.com/')

WebUI.maximizeWindow()

WebUI.mouseOver(findTestObject('or_test_siacargo/btn_E-Services'))

WebUI.click(findTestObject('or_test_siacargo/btn_Flight Schedule'))

WebUI.setText(findTestObject('or_test_siacargo/input_origin'), origin)

WebUI.setText(findTestObject('or_test_siacargo/input_destination'), destination)

WebUI.click(findTestObject('or_test_siacargo/input_departureDate'))

def tempDate = dept_date.split(' ')

WebUI.click(findTestObject('or_test_siacargo/btn_show_years'))
List<WebElement> elYears = WebUI.findWebElements(findTestObject('or_test_siacargo/list_years'), 10)
for (WebElement elYear : elYears) {
    if (elYear.getText() == (tempDate[2])) {
        elYear.click()
//		setMonth()
        break
    }
}

WebUI.click(findTestObject('or_test_siacargo/btn_show_months'))
List<WebElement> elMonths = WebUI.findWebElements(findTestObject('or_test_siacargo/list_months'), 10)
for (WebElement elMonth : elMonths) {
    if (elMonth.getText() == (tempDate[1])) {
        elMonth.click()
        break
    }
}

List<WebElement> elDays = WebUI.findWebElements(findTestObject('or_test_siacargo/list_days'), 10)
for (WebElement elDay : elDays) {
    if ((elDay.getText() == (tempDate[0])) && !(elDay.getAttribute('class').contains('react-datepicker__day--outside-month'))) {
        elDay.click()
        break
    }
}

WebUI.click(findTestObject('or_test_siacargo/btn_SEARCH'))

WebUI.verifyTextPresent(expect_flight_number, false)

WebUI.click(findTestObject('or_test_siacargo/span_ResetNewSearch'))

WebUI.setText(findTestObject('or_test_siacargo/input_origin'), origin)

WebUI.setText(findTestObject('or_test_siacargo/input_destination'), destination)

WebUI.click(findTestObject('or_test_siacargo/btn_SEARCH'))

WebUI.verifyTextPresent("Please fill in missing field(s) to proceed.", false)

WebUI.closeBrowser()