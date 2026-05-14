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
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

ChromeOptions options = new ChromeOptions()

options.setExperimentalOption('debuggerAddress', 'localhost:9222')

ChromeDriver driver = new ChromeDriver(options)

DriverFactory.changeWebDriver(driver)

WebUI.switchToWindowTitle('Keranjang | Tokopedia | Tokopedia')

WebUI.click(findTestObject('Page_Keranjang  Tokopedia  Tokopedia/img_product (2)'))

WebUI.click(findTestObject('Page_Promo ISKU mesin bor listrik 21v cordl_f6c80e/h2_ISKU Tools Official Store'))

WebUI.click(findTestObject('Page_ISKU Tools Official Store Official Sto_74d0ff/img_product-image'))

WebUI.click(findTestObject('Page_Promo ISKU Paket Kombo Mesin Bor Listr_5ccc3b/span_Keranjang'))

WebUI.click(findTestObject('Page_Promo ISKU Paket Kombo Mesin Bor Listr_5ccc3b/span_Lihat Keranjang'))

WebUI.verifyElementPresent(findTestObject('Page_Keranjang  Tokopedia  Tokopedia/div_ISKU Tools Official Store', [('CSS Selector') : '#__skipper > div.Z5pv5a_NKshg9J2UQIDv > div > div > div.css-mvo6o9 > div.css-1srtlns > div:nth-child(3) > div:nth-child(1)']), 
    0)

WebUI.closeBrowser()

