## Submission 2
Kriteria dalam pembuatan submission 2
- [x] Mempertahankan fitur pada Submission 1
- [x] **Pencarian User** menggunakan data dari API berjalan dengan baik.
- [x] Menggunakan **TabLayout** sebagai navigasi antara **halaman List Follower** dan **List Following**.
- [x] Terdapat **indikator loading** saat aplikasi memuat data di semua halaman.
- [x] Aplikasi tidak *force closed*

Berikut Tampilan Aplikasi : 
<p>
<img src="https://user-images.githubusercontent.com/72274358/197264466-f86602bc-c693-4d03-873a-a5366d611597.jpg" height="400rm">
<img src="https://user-images.githubusercontent.com/72274358/197264477-55f448f4-a5a2-4b4f-914a-2beeb1f9b14b.jpg" height="400rm">
<img src="https://user-images.githubusercontent.com/72274358/197264481-1478ca4e-83b0-4311-bc78-fbf4be4c851f.jpg" height="400rm">
<p>
kekurangan dalam aplikasi tersebut adalah sebagai berikut : 

pada bagian activity_settings.xml

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
  xmlns:app="http://schemas.android.com/apk/res-auto"
  xmlns:tools="http://schemas.android.com/tools"
  android:layout_width="match_parent"
  android:layout_height="match_parent"
  tools:context=".ui.SettingsActivity"
  android:paddingHorizontal="16dp">

  <ImageView
    ...
```

Pada sebuah **ImageView**, jangan lupa untuk tambahkan attribut android:contentDescription. Ini mendefinisikan konten dengan teks yang menjelaskan secara singkat konten tampilan. Properti ini digunakan terutama untuk aksesibilitas. Karena beberapa tampilan tidak memiliki representasi tekstual, atribut ini dapat digunakan untuk menyediakannya.

pada bagian ApiService.kt

```
interface ApiService {
  @GET("search/users")
  @Headers("Authorization: token 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")
  ...
```
             
Untuk alasan keamaan kredensial, hindari menyematkan sebuah TOKEN API ke dalam sebuah kelas, sebaiknya dipindahkan ke dalam berkas build.gradle seperti berikut:
```
android {
    defaultConfig {
     buildConfigField("String", "KEY", '”b650046bf640e7bf7054093854b8d02a"')
    }
}
```
             
Untuk mengaksesnya kamu bisa menggunakan properti ```val mySuperScretKey = BuildConfig.KEY```

pada bagian DetailUserActivity.kt

```
override fun onCreate(savedInstanceState: Bundle?) {
  ...
             
  supportActionBar!!.title = "Detail Github User"
             
  ...
             
}
```

Hindari penggunaan double bang operator (!!) saat pengecekan null, karena akan memaksa suatu variable menjadi non-null. Dan jika ternyata variable tersebut bernilai null, maka bisa menyebabkan NPE. Periksa kembali semua kode kamu dan jangan biarkan satupun operator tersebut tersisa.
             

pada bagian SnackBarUtil.kt

```
import android.content.Context
...
import com.google.android.material.snackbar.Snackbar
```
             
Kode yang tidak pernah digunakan baik itu Class, method, ataupun variable jika tidak digunakan sebaiknya dihapus. Kamu bisa memanfaatkan Analyze - Code Cleanup untuk melakukannya dengan cepat.
             
pada bagian build.gradle
             
```
implementation 'androidx.room:room-runtime:2.4.2'
kapt 'androidx.room:room-compiler:2.4.2'
```
             
Library ini sudah tersedia versi terbarunya 2.4.3. Silakan diupdate beserta library lainnya ya agar kode yang dituliskan mengikuti best practice dari library yang digunakan.
