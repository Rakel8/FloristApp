# FloristApp: Katalog & Pemesanan Tanaman 🪴

**FloristApp** adalah sebuah aplikasi Android sederhana yang dibangun menggunakan **Kotlin**. Aplikasi ini berfungsi sebagai platform purwarupa untuk melihat katalog tanaman hias dan mensimulasikan alur pemesanan dan pengiriman.

Aplikasi ini mendemonstrasikan navigasi dasar menggunakan sistem `Activity` tradisional, manajemen data dari *resource* XML, dan implementasi daftar yang responsif menggunakan `RecyclerView`.

---

## 🖼️ Tampilan Aplikasi (Alur Pengguna)

Berikut adalah alur utama dari aplikasi **FloristApp** yang telah kita kembangkan:

1.  **Welcome & Splash**: Pengguna disambut oleh **`MainActivity`** (layar *splash* dengan tombol "Start now"). [Tampilan Splash](./assets/splash.jpg)
2.  **Auth Selection**: Pengguna diarahkan ke **`RegisterActivity`** untuk memilih antara Login atau Register. [Pilihan Auth](./assets/auth.jpg)
3.  **Formulir Login/Register**: Pengguna masuk ke **`LoginActivity`** [Tampilan Login](./assets/login.jpg) atau **`RegisterFormActivity`** [Tampilan Register](./assets/register.jpg) untuk memasukkan *dummy* kredensial. (Validasi: *Field* tidak boleh kosong).
4.  **Home (Katalog Tanaman)**: Setelah autentikasi berhasil, pengguna masuk ke **`HomeActivity`**. Halaman ini menampilkan daftar tanaman hias menggunakan **`RecyclerView`** yang dapat di-scroll. [Tampilan Home](./assets/home.jpg)
5.  **Pemesanan Item**: Mengetuk item tanaman akan menampilkan *Toast* konfirmasi dan langsung memindahkan pengguna ke halaman Order.
6.  **Keranjang (Order)**: **`OrderActivity`** menampilkan daftar pesanan statis dan tombol "Kirim". [Tampilan Order](./assets/order.jpg)
7.  **Checkout & Pengiriman**: Menekan "Kirim" mengarahkan pengguna ke **`AddressFormActivity`** (Form Alamat Pengiriman). [Tampilan Alamat](./assets/address.jpg)
8.  **Konfirmasi & Selesai**: Setelah form alamat diisi, pesanan dikonfirmasi di **`ConfirmationActivity`** (layar "Terima kasih"). Menekan "Mengerti" akan kembali ke Home Screen. [Tampilan Terima Kasih](./assets/thanks.jpg)

---

## ✨ Fitur Utama

* **Autentikasi Dasar**: Alur dasar untuk simulasi Login dan Register.
* **Katalog Dinamis (dari Resource)**: Menampilkan daftar 10 tanaman hias menggunakan **`RecyclerView`** dengan tampilan bergaya *CardView*.
* **Data Terpusat**: Data tanaman (judul, deskripsi, dan gambar) dikelola secara terpusat di `app/src/main/res/values/strings.xml`.
* **Alur Pemesanan Lengkap**: Simulasi alur dari pemilihan item, Order, pengisian Alamat, hingga Konfirmasi.
* **Navigasi Konsisten**: Menggunakan `BottomNavigationView` di Home dan Order untuk navigasi antar halaman utama.
* **Dukungan Dark Mode**: Tampilan aplikasi disesuaikan untuk Tema Terang dan Tema Malam (Dark Mode).

---

## 🚀 Teknologi yang Digunakan

* **Bahasa**: [Kotlin](https://kotlinlang.org/)
* **UI**:
    * Material Components
    * **RecyclerView** (untuk daftar dinamis)
    * **CardView** (untuk efek *depth* pada item list)
    * ConstraintLayout
* **Library Pihak Ketiga**:
    * **Glide** (untuk pemuatan gambar secara efisien)
* **Arsitektur**: Menggunakan sistem `Activity` tradisional untuk navigasi antar layar.

---

## ⚙️ Cara Menjalankan Proyek

1.  **Clone** repositori ini:
    ```bash
    git clone [https://github.com/Rakel8/FloristApp.git](https://github.com/Rakel8/FloristApp.git) 
    ```
2.  **Buka** proyek menggunakan Android Studio.
3.  Tunggu hingga proses **Gradle Sync** selesai.
4.  **Jalankan** aplikasi pada emulator atau perangkat Android fisik.
