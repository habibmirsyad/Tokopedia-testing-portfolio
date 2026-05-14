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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.tokopedia.com/search?st=&q=laptop&srp_component_id=02.01.00.00&srp_page_id=&srp_page_title=&navsource=')

WebUI.setText(findTestObject('Page_Jual laptop  Tokopedia/input_Harga Minimum'), '9.000.000')

WebUI.sendKeys(findTestObject('Page_Jual laptop  Tokopedia/input_Harga Minimum'), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Page_Jual laptop  Tokopedia/input_Harga Maksimum'), '8.000.000')

WebUI.sendKeys(findTestObject('Page_Jual laptop  Tokopedia/input_Harga Maksimum'), Keys.chord(Keys.ENTER))

WebUI.verifyElementPresent(findTestObject('Page_Jual celengan berangkas  Tokopedia/p_Harga maksimum harus lebih besar dari harga minimum'), 
    0)

WebUI.closeBrowser()

