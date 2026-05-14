import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

ChromeOptions options = new ChromeOptions()

options.setExperimentalOption('debuggerAddress', 'localhost:9222')

ChromeDriver driver = new ChromeDriver(options)

DriverFactory.changeWebDriver(driver)

WebUI.navigateToUrl('https://www.tokopedia.com/sellered/esp32-s3-n8r8-n16r8-esp32-s3-devkit-type-c-esp32-s3-wroom-psram-s3-1731057903104066565?t_id=1778704263819&t_st=6&t_pp=cart&t_efo=cart&t_ef=homepage&t_sm=rec_homepage_outer_flow&t_spt=cart')

a = WebUI.getText(findTestObject('Page_Jual Murah Promo DELL ALIENWARE X14 R1/Teks A'))

WebUI.click(findTestObject('Page_Promo BOTOL MINUMTUMBLER AESTHETIC STA_3d2ca7/span_Keranjang'))

WebUI.click(findTestObject('Page_Promo ISKU mesin bor listrik 21v cordl_f6c80e/span_Lihat Keranjang'))

b = WebUI.getText(findTestObject('Page_Keranjang  Tokopedia  Tokopedia/teks B'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyEqual(a, b)

WebUI.closeBrowser()

