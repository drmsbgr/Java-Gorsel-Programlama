
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Lesson2 {

    public static void main(String[] args) {
        var vizeNot = GetScoreByInput("Vize");
        var ödevNot = GetScoreByInput("Ödev");
        var finalNot = GetScoreByInput("Final");

        var notOrt = vizeNot * 0.3 + ödevNot * 0.2 + finalNot * 0.5;
        var durum = notOrt > 50 ? "Geçti" : "Kaldı";

        String sonuc = String.format("Ortalama: %.2f, Durum: %s", notOrt, durum);

        // Boş kalmaması için bir Label ekleyelim
        JFrame jf = new JFrame();
        jf.setTitle("Not Sonucu");
        jf.setSize(300, 200); // Boyut vermeyi unutma kanka
        jf.setLocationRelativeTo(null);
        jf.getContentPane().setLayout(new FlowLayout());

        // Sonucu içeren etiketi oluştur ve ekle
        JLabel lblSonuc = new JLabel(sonuc);
        jf.add(lblSonuc);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true); // Artık içinde yazı olan bir pencere açılır
    }

    public static double GetScoreByInput(String title) {
        String scoreString = JOptionPane.showInputDialog("Lütfen " + title + " notunu giriniz");
        var score = Double.parseDouble(scoreString.trim());
        while (score < 0 || score > 100) {
            scoreString = JOptionPane.showInputDialog(null, "Geçerli bir " + title + " notu giriniz", title,
                    JOptionPane.WARNING_MESSAGE);
            score = Double.parseDouble(scoreString.trim());
        }

        return score;
    }
}
