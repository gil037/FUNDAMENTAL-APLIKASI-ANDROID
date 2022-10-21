## Submission 3
Kriteria dalam pembuatan submission 3
- [x] Aplikasi bisa **menambah** user ke daftar favorite.
- [x] Aplikasi bisa **menghapus** user dari daftar favorite.
- [x] Halaman yang **menampilkan** daftar user favorite.
- [x] Terdapat **pengaturan** untuk mengganti tema.
- [x] Mempertahankan semua fitur aplikasi dan komponen yang digunakan pada **Submission 2**.
- [x] Aplikasi tidak *force closed*

Berikut Tampilan Aplikasi : 
<p>
<img src="https://user-images.githubusercontent.com/72274358/197268697-297b6312-ecb7-44e6-b2f1-c2606fd81b30.jpg" height="400rm">
<img src="https://user-images.githubusercontent.com/72274358/197268708-6216a1fe-0431-40d0-81bd-461b4aba64e4.jpg" height="400rm">
<img src="https://user-images.githubusercontent.com/72274358/197268711-f00e406d-e411-418f-a91a-495737d44430.jpg" height="400rm">
<img src="https://user-images.githubusercontent.com/72274358/197268713-022404a4-e502-4879-8911-ebd45edd6fcf.jpg" height="400rm">
<p>
kekurangan dalam aplikasi tersebut adalah sebagai berikut : 

pada bagian ApiConfig.kt

```
object ApiConfig {
  fun getApiService(): ApiService {
    val loggingInterceptor = if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    } else {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
    }
  ...
}
```

kamu dapat menghindari penulisan headers authorization berlulangkali pada setiap endpoint dengan menambahkan interceptor pada bagian OkHttpClient seperti berikut ini
```
.addInterceptor { chain ->
    val original = chain.request()
    val request = original.newBuilder()
        .addHeader("Authorization", "token ${TOKEN_GITHUB}")
        .method(original.method, original.body)
        .build()
    chain.proceed(request)
}
```

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

fungsi untuk medapatkan follower dan following dapat digabungkan dengan menggunakan custom @path sebagai contoh seperti berikut ini silahkan di sesuaikan kembali dengan code yang kamu gunakan
```
@GET("users/{login}/{tipe}")
@Headers("Authorization: token ...")
    fun getExample(
        @Path("username") username: String
              @Path("tipe") tipe: String
    ): Call<List<GithubUser>>
```
  
cara menggunakan kamu tinggal memasukkan tipe (mau itu follower atau following) yang mau kamu gunakan ```getExample(username= "...", tipe="follower")```

pada bagian FollowersFollowingAdapter.kt

```
class FollowersFollowingViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
  private val binding = ItemUserBinding.bind(itemView)
  fun bind(user: User) {
      binding.apply {
          Glide.with(itemView.context)
              .load(user.avatar)
```

Untuk menghindari penulisan kode yang berulang, kamu bisa memanfaatkan **Kotlin Extensions**. Sebagai contoh : ```fun ImageView.loadImage(url: String?) { Glide.with(this.context) .load(url) .apply(RequestOptions().override(500, 500)) .centerCrop() .into(this) }```

Cara menggunakannya seperti ini ```ImageView.loadImage("url")```
             

pada bagian SettingPreferences.kt

```
class SettingPreferences(private val dataStore: DataStore<Preferences>) {
  ...
```
             
Variable konstan ini sebaiknya dimasukkan ke dalam scope **companion object**.
