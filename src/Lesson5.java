
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Lesson5 {

    public static void main(String[] args) {
        var jf = new JFrame();
        jf.setSize(500, 600);
        jf.setLocation(100, 200);
        jf.getContentPane().setLayout(new FlowLayout());

        var checkboxYes = new JCheckBox("Evet");
        var checkboxNo = new JCheckBox("Hayır");

        var radioBtn = new JRadioButton("Erkek");

        jf.getContentPane().add(radioBtn);
        jf.getContentPane().add(checkboxYes);
        jf.getContentPane().add(checkboxNo);

        var btn = new JButton("Seç");
        jf.getContentPane().add(btn);

        String[] tags = {"C", "C#", "Java", "PHP"};

        var combobox = new JComboBox<String>(tags);

        var s = new JScrollBar(JScrollBar.VERTICAL);
        jf.getContentPane().add(s);
        jf.getContentPane().add(combobox);
        var label = new JLabel("Seçim bekleniyor...");
        jf.getContentPane().add(label);

        btn.addActionListener(e -> {
            if (checkboxYes.isSelected()) {
                System.out.println("Evet Seçildi");
            } else if (checkboxNo.isSelected()) {
                System.out.println("Hayır Seçildi");
            } else {
                System.out.println("Hiçbiri Seçilmedi");
            }

            var index = combobox.getSelectedIndex();
            label.setText(index + " -> " + tags[index]);
        });

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
