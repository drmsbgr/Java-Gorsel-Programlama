
import java.awt.FlowLayout;
import javax.swing.*;

public class Lesson4 {

    public static void main(String[] args) {

        // girilen metnin kelime ve karakter sayısı hesaplama
        JFrame jf = new JFrame();
        jf.setSize(500, 600);
        jf.setLocation(100, 200);
        jf.getContentPane().setLayout(new FlowLayout());

        JButton btn1 = new JButton("Gönder");

        jf.getContentPane().add(btn1);

        JTextArea ar1 = new JTextArea(); // bu compenent çoklu satırda yazmak için kullanılır.
        ar1.setText("buraya yaz");

        JLabel lblKelime = new JLabel();
        JLabel lblmetin = new JLabel();

        // JPasswordField pass = new JPasswordField(20); // şifre için kullanılan component
        jf.getContentPane().add(ar1);
        jf.getContentPane().add(lblKelime);
        jf.getContentPane().add(lblmetin);
        // jf.getContentPane().add(pass);

        btn1.addActionListener(e -> {
            String text = ar1.getText().trim();
            String[] words = text.split("\\s+");

            var letterNum = 0;
            var wordNum = text.isEmpty() ? 0 : words.length;

            for (String word : words) {
                letterNum += word.length();
            }

            lblmetin.setText("Karakter Sayısı: " + letterNum);
            lblKelime.setText("Kelime Sayısı: " + wordNum);
        });

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
