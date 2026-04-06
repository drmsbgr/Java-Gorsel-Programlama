
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Example4 {

    public static void main(String[] args) {
        var frame = new JFrame();
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());

        var cities = new String[]{
            "İstanbul",
            "Trabzon", "Samsun", "Ankara", "İzmir"};

        var genderTitle = new JLabel("Cinsiyet");
        var btnGroup = new ButtonGroup();
        var maleRadioButton = new JRadioButton("Erkek");
        var femaleRadioButton = new JRadioButton("Kadın");

        btnGroup.add(maleRadioButton);
        btnGroup.add(femaleRadioButton);

        var citiesTitle = new JLabel("Şehirler");
        var citiesCombobox = new JComboBox<String>(cities);
        var selectButton = new JButton("Seç");

        selectButton.addActionListener(e -> {
            var msg = "Seçilen: " + cities[citiesCombobox.getSelectedIndex()];
            JOptionPane.showMessageDialog(null, msg);
        });

        contentPane.add(genderTitle);
        contentPane.add(maleRadioButton);
        contentPane.add(femaleRadioButton);
        contentPane.add(citiesTitle);
        contentPane.add(citiesCombobox);
        contentPane.add(selectButton);

        frame.setContentPane(contentPane);
        frame.setVisible(true);
    }
}
