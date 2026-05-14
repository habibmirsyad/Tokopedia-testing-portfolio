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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

ChromeOptions options = new ChromeOptions()

options.setExperimentalOption('debuggerAddress', 'localhost:9222')

ChromeDriver driver = new ChromeDriver(options)

DriverFactory.changeWebDriver(driver)

WebUI.navigateToUrl('https://www.tokopedia.com/search?st=&q=laptop&srp_component_id=02.01.00.00&srp_page_id=&srp_page_title=&navsource=')

WebUI.click(findTestObject('Page_Jual laptop  Tokopedia/span_css-4iffx4-unf-checkbox_area e3y1k2n1'))

WebUI.setText(findTestObject('Page_Jual laptop  Tokopedia/input_Harga Minimum'), '2.000.000')

WebUI.sendKeys(findTestObject('Page_Jual laptop  Tokopedia/input_Harga Minimum'), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Page_Jual laptop  Tokopedia/input_Harga Maksimum'), '2.000.000')

WebUI.sendKeys(findTestObject('Page_Jual laptop  Tokopedia/input_Harga Maksimum'), Keys.chord(Keys.ENTER))

WebUI.waitForElementVisible(findTestObject('Page_Jual laptop  Tokopedia/semua barang page 1'), 10)

WebUI.delay(3)

List<WebElement> listHargaElement = WebUI.findWebElements(findTestObject('Page_Jual laptop  Tokopedia/semua barang page 1'), 
    10)

// Ambil String panjang dari elemen pertama karena yang terambil panjang dan dianggap 1 dipisahkan dengan [Enter]
String teksPanjang = listHargaElement.get(0).getText()

// Memotong string panjang
List<String> semuaHarga = teksPanjang.split('\n').collect({ 
        it.trim()
    }).findAll({ 
        it != ''
    })

println('Jumlah produk ditemukan: ' + semuaHarga.size())

int batasHarga = 2000000

// Iterasi setiap elemen untuk mengecek harga
for (String element : semuaHarga) {
    if (element.contains('Rp')) {
        String rawHarga = element

        // Clean up string agar hanya ada angka
        String cleanHarga = rawHarga.replaceAll('[^0-9]', '')

        if (!(cleanHarga.isEmpty())) {
            long hargaAngka = Long.parseLong(cleanHarga)

            if (hargaAngka != batasHarga) {
                KeywordUtil.markFailedAndStop('Gagal, ada yang memiliki harga ' + rawHarga + ' harusnya hanya ada ' + batasHarga)
            } else {
                println('PAS 2 JUTA: ' + rawHarga)
            }
        }
    }
}

WebUI.closeBrowser()

