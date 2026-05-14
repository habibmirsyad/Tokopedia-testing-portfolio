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
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

ChromeOptions options = new ChromeOptions()

options.setExperimentalOption('debuggerAddress', 'localhost:9222')

ChromeDriver driver = new ChromeDriver(options)

DriverFactory.changeWebDriver(driver)

WebUI.navigateToUrl('https://www.tokopedia.com/vegas-computer/macbook-air-13-2020-retina-quad-core-i7-i5-i3-16-512gb-8-512-ssd-8-128-100-original-i3-8-128-ssd-1733387358427710973-1735106387337774589?extParam=ivf%3Dfalse%26keyword%3Dlaptop%26search_id%3D202605131839166855456E2FE46A10BJ5X%26src%3Dsearch&t_id=1778682681837&t_st=20&t_pp=search_result&t_efo=search_pure_goods_card&t_ef=goods_search&t_sm=rec_homepage_outer_flow&t_spt=search_result')

WebUI.setText(findTestObject('Page_Promo Homedoki Kursi Kantor HidrolikKu_e30b5b/input_jumlah'), '9.9999')

WebUI.verifyElementPresent(findTestObject('Page_Jual Macbook Air 13/maks pembelian'), 0)

WebUI.closeBrowser()

