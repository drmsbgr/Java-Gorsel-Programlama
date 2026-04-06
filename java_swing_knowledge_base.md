# Java Swing UI Programlama: Sınav Hazırlık Bilgi Bankası (Knowledge Base)

Bu doküman, Java Swing ile geliştirilen kullanıcı arayüzü (UI) uygulamalarının temellerini, derste işlenen örneklere ve projelere dayanarak özetlemektedir. Yapay zekanın veya öğrencilerin sınav öncesi hızlı bir şekilde tekrar yapabilmesi amacıyla hazırlanmıştır. 

---

## 1. Temel Pencere (Frame) ve Düzen Yönetimi (Layout)

Projelerde her uygulamanın temelini `JFrame` sınıfı oluşturmaktadır.

*   `JFrame frame = new JFrame();` - Yeni bir pencere nesnesi oluşturur.
*   `frame.setSize(genişlik, yükseklik);` - Pencerenin boyutunu (piksel olarak) belirler.
*   `frame.setTitle("Başlık");` - Pencere üst çubuğunda görünecek başlığı belirler.
*   `frame.setLocation(x, y);` - Pencerenin ekrandaki koordinatını ayarlar; `setLocationRelativeTo(null)` pencereyi ekranın tam ortasında açar.
*   `frame.setResizable(false);` - Pencere boyutlandırılmasını (kullanıcının kenarlardan çekerek büyütmesini) engeller.
*   `frame.setVisible(true);` - **En kritik komutlardan biri**. Yazılmazsa pencere arka planda çalışır fakat ekranda görünmez. Genellikle en sona yazılır.
*   `frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);` - Sağ üstteki çarpı (X) butonuna basıldığında arka plandaki işlemin (uygulamanın) tamamen sonlanmasını sağlar. Eksikliğinde uygulama kapanmış gibi görünür ama RAM'de çalışmaya devam eder.

### Düzen Yönetimi (Layout)
*   Uygulamalarda temel olarak `FlowLayout` kullanılmıştır.
*   `frame.getContentPane().setLayout(new FlowLayout());`
*   `FlowLayout`: Bileşenleri (buton, yazı alanı vs.) pencereye sırayla (yan yana, sığmazsa alt satıra geçecek şekilde) yerleştirir.

---

## 2. Temel Arayüz Bileşenleri (Components)

Bileşenler `JFrame`'in **ContentPane**'ine `add()` metodu ile eklenmelidir (`jf.getContentPane().add(bilesen)` veya doğrudan `jf.add(bilesen)`).

*   **`JLabel` (Etiket):** Ekrana sadece okunabilir metin veya görsel eklemek için kullanılır. Kullanıcı buraya yazı yazamaz.
    *   _Örnek:_ `var lbl = new JLabel("Lütfen isminizi giriniz");`
*   **`JTextField` (Metin Alanı):** Kullanıcıdan tek satırlık veri veya metin girişi almak için kullanılır.
    *   _Örnek:_ `var txt = new JTextField(20);` (20 karakter genişliğinde alan)
*   **`JPasswordField` (Şifre Alanı):** Metin alanına benzer ancak girilen karakterleri gizler.
    *   _Özelleştirme:_ `passwordField.setEchoChar('*');` ile gizleme karakteri '*' yapılabilir.
    *   _Not:_ Değerini alırken `new String(passwordField.getPassword());` tercih edilmektedir (güvenlik nedeniyle).
*   **`JTextArea` (Çok Satırlı Metin Alanı):** Çok satırlı girdiler (örneğin paragraf veya yorum) için kullanılır.
*   **`JButton` (Buton):** Tıklanabilir eylem düğmeleridir.
*   **`JCheckBox` (Onay Kutusu):** Çoklu seçim yapılabilen veya "Evet/Hayır" tarzı onay mekanizmaları içindir. Durumu `checkbox.isSelected()` ile kontrol edilir (true/false döner).
*   **`JRadioButton` (Radyo Butonu):** Genellikle bir grup içinden sadece tek bir seçim yapılacağı (Örn: Cinsiyet seçimi) durumlarda kullanılır.
*   **`JComboBox` (Açılır Liste):** Seçeneklerin bir açılır menü içerisinde sunulmasını sağlar. Listeye elemanlar dizi (Array) olarak verilebilir.
    *   _Seçilenin Sırasını Alma:_ `combobox.getSelectedIndex()` (0'dan başlar).

---

## 3. Kullanıcı ile İletişim: JOptionPane Sınıfı

`JOptionPane` sınıfı, programın ayrı küçük pencerelerde (dialog/pop-up) mesaj göstermesine veya anında veri istemesine yarar.

*   **Mesaj Gösterme (Dialog):**
    `JOptionPane.showMessageDialog(null, "Başarılı bir şekilde giriş yaptınız.");`
*   **Veri - Girdi Alma (Input):**
    `String isim = JOptionPane.showInputDialog("Lütfen isminizi giriniz");`
*   _Not:_ Sayısal işlemler yapılacaksa `JOptionPane`'den gelen veri daima metindir (`String`). Bu veri muhakkak `Double.parseDouble(gelenVeri)` veya `Integer.parseInt()` gibi metodlar kullanılarak dönüştürülmelidir (Lesson 2).

---

## 4. Olaylar ve Aksiyon Dinleyicileri (Listeners)

Etkileşim oluşturmak için bileşenlere "Olay Dinleyici" (Listener) eklenir.

### ActionListener (Tıklama Olayları)
Butona tıklandığında (veya combobox değiştiğinde) yapılacak işlemleri belirler. Genellikle modern Java'da **Lambda Expression (`e -> { ... }`)** kullanılarak yazılır.
```java
loginButton.addActionListener(e -> {
    // Butona tıklandığında çalışacak kodlar
    String username = usernameField.getText();
});
```

### MouseListener (Fare Olayları)
Mouse hover (üzerine gelme), tıklama, çekme, ayrılma gibi durumları yönetir. `Lesson3` örneğinde buton hover efekti bu sayede yapılmıştır:
*   `mouseEntered(MouseEvent e)`: Fare imleci bileşenin (butonun) üzerine geldiğinde tetiklenir.
*   `mouseExited(MouseEvent e)`: Fare imleci bileşenin üzerinden ayrıldığında tetiklenir. Üzerine gelindiğinde koyu gri yapılan buton, ayrılınca eski rengine döndürülür.

---

## 5. Renk ve Görünüm İşlemleri (Color & Image)

*   **Renk Değiştirme:** `btn1.setBackground(Color.yellow);` (Arka plan) ve `btn1.setForeground(Color.RED);` (Yazı rengi)
*   **Özel Renk (RGB):** `new Color(8, 10, 138);` şeklinde RGB formatında 0-255 arası değer verilerek oluşturulur.
*   **Görsel (Image) Ekleme:** Label içerisine görsel eklenebilir. Projeden alınan görsel `Lesson3.class.getResource("/image/image.jpg")` şeklinde belleğe alınıp `lbl1.setIcon(new ImageIcon(img))` metoduyla pencereye yerleştirilir.

---

## 6. Sık Karşılaşılan Mantık-Algoritma Örnekleri (Algoritma Sınav Soruları İçin)

Proje dosyalarında arayüz ile birlikte arka planda işleyen temel Java algoritmalarına da yer verilmiştir:

*   **Metin Karşılaştırma:** Girilen string nesneleri if ile kontrol edilirken `==` yerine `equals()` metodu kullanılır. `username.equals("admin")` gibi.
*   **Kelime ve Karakter Sayımı (Lesson 4):**
    ```java
    String text = ar1.getText().trim(); // Baştaki ve sondaki gereksiz boşlukları kırpar.
    String[] words = text.split("\\s+"); // Metni birden fazla alt alta ve yan yana boşlukları umursamadan kelimelerine ayırıp dizi yapar.
    // kelime sayısı = words.length
    // karakter sayısı = döngü ile her kelimenin .length() değeri toplanır.
    ```
*   **Döngülü Not Girişi ve Koşullu Oparötör (Lesson 2):**
    *   `var durum = notOrt > 50 ? "Geçti" : "Kaldı";` -> Ternary (Tek satırlık if/else).
    *   Kullanıcı geçersiz (0'dan küçük veya 100'den büyük) not girdiğinde `while` döngüsü ile tekrar veri isteme prensibi kullanılmıştır.
*   **String Formatlama:**
    `String.format("Ortalama: %.2f", notOrt)` metodu double bir sayıyı noktadan sonra istenilen basamak kadar (.2f = 2 basamak) formatlı bir şekilde metne döker.
