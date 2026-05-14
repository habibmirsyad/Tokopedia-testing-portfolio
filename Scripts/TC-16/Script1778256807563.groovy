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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions

ChromeOptions options = new ChromeOptions()

options.setExperimentalOption('debuggerAddress', 'localhost:9222')

ChromeDriver driver = new ChromeDriver(options)

DriverFactory.changeWebDriver(driver)

WebUI.navigateToUrl('https://www.tokopedia.com/cart?t_id=1778682681837&t_st=21&t_pp=&t_efo=search_pure_goods_card&t_ef=goods_search&t_sm=rec_homepage_outer_flow&t_spt=search_result')

WebUI.click(findTestObject('Page_Keranjang  Tokopedia  Tokopedia/laptop lenovo'))

WebUI.setText(findTestObject('Page_Promo ISKU Paket Kombo Mesin Bor Listr_5ccc3b/input_jumlah'), '9999')

WebUI.click(findTestObject('Page_Promo ISKU Paket Kombo Mesin Bor Listr_5ccc3b/span_Keranjang'))

WebUI.click(findTestObject('Page_Promo ISKU Paket Kombo Mesin Bor Listr_5ccc3b/span_Keranjang'))

WebUI.verifyElementPresent(findTestObject('Page_Jual Laptop Lenovo Thinkpad T490/div_Stok barang ini sisa 8 dan kamu sudah punya'), 
    0)

WebUI.closeBrowser()

