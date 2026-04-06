
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Lesson1 {

    public static void main(String[] args) {

        JFrame jf = new JFrame();
        jf.setSize(500, 600);
        jf.setTitle("ilk ders");
        jf.setLocation(100, 200); // x ve y koordinatıdır. 0,0 girersek sol üste yazar
        jf.getContentPane().setLayout(new FlowLayout());  // Content nesenleri tutmamıza yara bunu yazmak zorundayız

        JTextField txt1 = new JTextField(20);  // 20 karakter yazabildiğimiz bir text alanı.
        JButton btn1 = new JButton("Gönder");
        JLabel lbl1 = new JLabel();
        lbl1.setText("Lütfen isminizi giriniz");

        // Content alanına nesneleri aşağıdaki gibi eklemek zorundayız
        jf.getContentPane().add(lbl1);
        jf.getContentPane().add(btn1);
        jf.getContentPane().add(txt1);

        // butona aksiyon eklemek için zorunlu alan.
        btn1.addActionListener((ActionEvent e) -> {
            lbl1.setText("Merhaba " + txt1.getText() + " ilk derse hoşgeldin");
        });

        JButton btn2 = new JButton("Tıkla");
        btn2.addActionListener(e -> {
            // option pane kullanıcıdan veri girişi almak veya mesaj vermek için kullanılır
            JOptionPane.showMessageDialog(null, "Merhaba bu yeni bir pencere");
        });
        jf.getContentPane().add(btn2);

        JButton btn3 = new JButton("İsim al");
        btn3.addActionListener(e -> {
            String isim = JOptionPane.showInputDialog("Lütfen isminizi giriniz");
            JOptionPane.showMessageDialog(null, isim);
        });

        jf.getContentPane().add(btn3);

        jf.setResizable(false);

        jf.setVisible(true);   // bunu yazmazsak frame görünmez.
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // bunu yazmazsak uygulama çalıştığında çarpıya bassak bile uygulama arka planda çalışır.
    }
}
