# Java Swing & GUI Development Knowledge Base

Bu belge, projedeki Java derslerinden (Lesson 1-5 ve Example 1) derlenen, sınava hazırlık için AI modellerine (veya size) yardımcı olacak temel bilgileri içerir.

---

## 1. Temel Pencere Yapısı (JFrame)
Her Swing uygulaması bir `JFrame` ile başlar.

*   **Oluşturma:** `JFrame jf = new JFrame();`
*   **Boyut ve Başlık:** `jf.setSize(500, 600);`, `jf.setTitle("Başlık");`
*   **Konum:** `jf.setLocation(x, y);` veya `jf.setLocationRelativeTo(null);` (merkeze alır).
*   **Kapatma Davranışı:** `jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);` (Uygulamanın arka planda çalışmaya devam etmesini engeller).
*   **Görünürlük:** `jf.setVisible(true);` (En son yazılmalıdır).
*   **Düzen (Layout):** `jf.getContentPane().setLayout(new FlowLayout());` (Nesneleri sırayla dizen en basit düzen).
*   **İçerik Paneli:** Nesneler `jf.getContentPane().add(component);` ile eklenir.

---

## 2. Temel Görsel Bileşenler (Components)

| Bileşen | Açıklama | Öne Çıkan Metotlar |
| :--- | :--- | :--- |
| **JLabel** | Bilgi metni veya resim gösterir. | `setText(str)`, `setIcon(icon)` |
| **JButton** | Tıklanabilir buton. | `addActionListener(e -> { ... })` |
| **JTextField** | Tek satırlık yazı alanı. | `getText()`, `setText(str)` |
| **JTextArea** | Çok satırlık yazı alanı. | `getText()`, `trim()`, `split()` |
| **JPasswordField** | Şifre giriş alanı (yazıları gizler). | `getPassword()` (char döner), `setEchoChar('*')` |
| **JCheckBox** | Çoklu seçim kutusu. | `isSelected()` |
| **JRadioButton** | Tekli seçim butonu. | `isSelected()` |
| **JComboBox** | Açılır liste (Dropdown). | `getSelectedIndex()`, `getSelectedItem()` |
| **JScrollBar** | Kaydırma çubuğu. | `new JScrollBar(JScrollBar.VERTICAL)` |

---

## 3. Kullanıcı Etkileşimi & Olaylar (Events)

### Action Listener (Buton Tıklama)
```java
btn.addActionListener(e -> {
    // Butona tıklandığında yapılacaklar
    String veri = textfield.getText();
    System.out.println("Giriş: " + veri);
});
```

### Mouse Listener (Fare Hareketleri)
Hover (üzerine gelme) efektleri için kullanılır:
```java
btn.addMouseListener(new MouseListener() {
    public void mouseEntered(MouseEvent e) { btn.setBackground(Color.GRAY); }
    public void mouseExited(MouseEvent e) { btn.setBackground(originalColor); }
    // mousePressed, mouseReleased ve mouseClicked'ı override etmek zorunludur.
});
```

### JOptionPane (Hazır Diyalog Pencereleri)
*   **Mesaj Verme:** `JOptionPane.showMessageDialog(null, "Mesaj");`
*   **Veri Alma:** `String sonuc = JOptionPane.showInputDialog("Lütfen giriniz");`

---

## 4. Renkler ve Resimler

### Renkler (Color)
*   Hazır Renkler: `btn.setBackground(Color.RED);`, `btn.setForeground(Color.YELLOW);`
*   Özel Renk (RGB): `Color custom = new Color(8, 10, 138);`

### Resimler (Image & Icon)
```java
Image img = new ImageIcon(Lesson3.class.getResource("/image/image.jpg")).getImage();
label.setIcon(new ImageIcon(img));
```

---

## 5. Veri İşleme ve Mantıksal Yapılar

### String Metotları
*   `trim()`: Baştaki ve sondaki boşlukları siler.
*   `split("\\s+")`: Metni boşluklara göre parçalara ayırır (Kelime sayısını bulmak için ideal).
*   `String.format("%.2f", value)`: Sayıyı virgülden sonra 2 basamağa yuvarlar.
*   `equals("string")`: Metin karşılaştırma (Şifre/Kullanıcı kontrolü için).

### Dönüşümler (Parsing)
*   `Double.parseDouble(str)`: String metni ondalıklı sayıya çevirir.
*   `Integer.parseInt(str)`: String metni tam sayıya çevirir.

### Kontrol Döngüleri (Validation)
Geçerli bir değer alana kadar kullanıcıyı zorlamak için `while` ve `JOptionPane` beraber kullanılır:
```java
double score = Double.parseDouble(JOptionPane.showInputDialog("Not:"));
while (score < 0 || score > 100) {
    score = Double.parseDouble(JOptionPane.showInputDialog("Lütfen 0-100 arası giriniz!"));
}
```

---

## 6. Önemli İpuçları (Sınavlık)
*   `JPasswordField`'dan veri alırken `getText()` yerine `getPassword()` kullanılır ve bu `char[]` döner. String'e çevirmek için `new String(passField.getPassword())` yapılabilir.
*   `JFrame` oluşturulduktan sonra `setVisible(true)` demezsen pencere açılmaz.
*   `FlowLayout` kullanırken bileşenler pencereye sığmazsa aşağı kayar.
*   Resim yolu belirtirken `Class.getResource()` kullanımı, projenin farklı ortamlarda da (JAR hali gibi) çalışmasını sağlar.
