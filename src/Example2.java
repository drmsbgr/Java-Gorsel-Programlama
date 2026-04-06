
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Example2 {

    public static void main(String[] args) {
        var frame = new JFrame();

        frame.setSize(400, 300);
        var contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());

        var midtermTitle = new JLabel("Vize Notu");
        var midtermInput = new JTextField(3);
        var finalTitle = new JLabel("Final Notu");
        var finalInput = new JTextField(3);

        var resultLabel = new JLabel("Sonuç : ?");
        var calculateButton = new JButton("Hesapla");

        calculateButton.addActionListener(e -> {
            var midterm = Double.parseDouble(midtermInput.getText());
            var finalGrade = Double.parseDouble(finalInput.getText());
            if (midterm >= 0 && midterm <= 100 && finalGrade >= 0 && finalGrade <= 100) {
                var resultGrade = midterm * 0.4 + finalGrade * 0.6;
                resultLabel.setText("Sonuç : " + resultGrade);
            } else {
                JOptionPane.showMessageDialog(null, "Geçerli notlar giriniz!");
            }
        });

        contentPane.add(midtermTitle);
        contentPane.add(midtermInput);
        contentPane.add(finalTitle);
        contentPane.add(finalInput);
        contentPane.add(resultLabel);
        contentPane.add(calculateButton);

        frame.setContentPane(contentPane);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
