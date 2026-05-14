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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.tokopedia.com/search?st=&q=laptop&srp_component_id=02.01.00.00&srp_page_id=&srp_page_title=&navsource=')

WebUI.click(findTestObject('Page_Jual laptop  Tokopedia/a_Lihat selengkapnya'))

// 1. Ambil semua elemen lokasi menggunakan class yang ada di file Anda
// Pastikan Object Repository 'Lokasi_Item' menggunakan CSS: span.css-iaqlny
List<WebElement> elements = WebUI.findWebElements(findTestObject('Filter Lokasi/div_LokasiDKI JakartaJabodetabekBandungMedanSura'), 10)

// String harus dipotong lagi karena sistem mengambilnya menjadi 1 string panjang seperti 'Lokasi[ENTER]DKI Jakarta[ENTER]Jabodetabek[ENTER]Bandung[ENTER]Medan[ENTER]Surabaya[ENTER]A[ENTER]Kab. Aceh Barat[ENTER]Kab. Aceh Barat Daya[ENTER]Kab. Aceh Besar[ENTER]Kab. Aceh Jaya[ENTER]Kab. Aceh Selatan[ENTER]Kab. Aceh Singkil[ENTER]Kab. Aceh Tamiang[ENTER]Kab. Aceh Tengah[ENTER]... dst

// Ambil String panjang dari elemen pertama
String teksPanjang = elements.get(0).getText()

// Pecah string berdasarkan [Enter]
List<String> semuaLokasi = teksPanjang.split('\n').collect({ 
        it.trim()
    }).findAll({ 
        it != ''
    })

// Buat Set untuk verifikasi unik
Set<String> lokasiUnik = new HashSet(semuaLokasi)

// Verifikasi Akhir
if (semuaLokasi.size() != lokasiUnik.size()) {
    List<String> itemDuplikat = semuaLokasi.findAll({ def item ->
            semuaLokasi.count(item) > 1
        }).unique()

    println('>>> DATA DUPLIKAT DITEMUKAN: ' + itemDuplikat)

    if (itemDuplikat.size() > 0) {
        KeywordUtil.markFailed('Gagal! Ditemukan duplikat pada lokasi: ' + itemDuplikat)
    }
} else {
    println('>>> INFO: Semua lokasi sudah unik.')
}

WebUI.closeBrowser()

