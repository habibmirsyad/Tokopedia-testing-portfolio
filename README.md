# Tokopedia-testing-portfolio
Simple testing untuk tokopedia

untuk mencoba test case yang memerlukan Remote Debugging di Chrome sebelum menjalankan skrip automasi ini agar koneksi ke port 9222 berhasil

jika lokasi chrome adalah default bisa menggunakan :

 ```bash
 C:\Program Files\Google\Chrome\Application\chrome.exe" --remote-debugging-port=9222 --user-data-dir="C:\ChromeDebug"
```

setelah melakukan login pada browser yang terbuka lakukan login ke tokopedia dan biarkan browser tetap terbuka sambil menjalankan test case yang memerlukan login seperti TC-10, 11, dsb


---
> **Note:**
> TC-01 sampai TC-07 tidak dibuat karena tokopedia membatasi akses untuk register dan login