# Submission 1
Kriteria dalam pembuatan submission 1
- [x] Menampilkan data pada halaman aplikasi dengan minimal jumlah **10 item**
- [x] Menggunakan **RecyclerView**
- [x] Menggunakan **Parcelable** sebagai interface dari obyek data yang akan dikirimkan antar Activity
- [x] List Item untuk **RecycleView** disusun menggunakan **ConstraintLayout**
- [x] Aplikasi tidak *force closed*

Berikut Tampilan Aplikasi : 
<p>
<img src="https://user-images.githubusercontent.com/72274358/197258265-70ae2b18-c238-4579-b460-f850bade7c60.jpg" height="500rm">

<img src="https://user-images.githubusercontent.com/72274358/197259329-5059c53b-9550-4c37-9f1d-eb683dd713dc.jpg" height="500rm">
<p>
kekurangan dalam aplikasi tersebut adalah sebagai berikut : 

pada bagian Detail.kt

```
companion object {
    const val EXTRA_USER = "extra_user"
...
}
```

Penulisan companion object sebaiknya diletakkan di paling bawah dari sebuah class sesuai dengan konvensi penulisan kode Kotlin di tautan [ini](https://kotlinlang.org/docs/coding-conventions.html#class-layout).

pada bagian item_user.xml

```
<androidx.constraintlayout.widget.ConstraintLayout
  android:layout_width="match_parent"
  android:layout_height="wrap_content"
  android:padding="8dp">

  <ImageView
    ...
```

Pada sebuah **ImageView**, jangan lupa untuk tambahkan attribut android:contentDescription. Ini mendefinisikan konten dengan teks yang menjelaskan secara singkat konten tampilan. Properti ini digunakan terutama untuk aksesibilitas. Karena beberapa tampilan tidak memiliki representasi tekstual, atribut ini dapat digunakan untuk menyediakannya.

pada bagian User.kt

```
package com.example.aplikasigithubuser
```

Penulisan package seharusnya disesuaikan dengan lokasi file
