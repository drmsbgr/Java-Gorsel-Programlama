
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MidtermExam {

    static Connection con = null;

    public static void main(String[] args) {
        Connect(); // soru 3;
        Question1();
        Question2();
        Question3_4();
    }

    private static void Connect() {
        try {
            var url = "jdbc:mysql://localhost:3306/schooldb";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "1234");

            //tablo oluştur
            var query = "CREATE TABLE teachers("
                    + "teacher_id INT PRIMARY KEY,"
                    + "teacher_name VARCHAR(200),"
                    + "teacher_degree VARCHAR(100),"
                    + "teacher_age INT);";
            var st = con.createStatement();
            st.execute(query);

        } catch (Exception e) {
            System.out.println("Bağlantı hatası: " + e.getMessage());
        }
    }

    private static JFrame CreateDefaultFrame() {
        var frame = new JFrame();
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        var contentPane = frame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    //Bir metin girdisi al ve bir buton ile tetikleyerek bir labelda tersten yazılmış halini yazdır.
    private static void Question1() {
        var frame = CreateDefaultFrame();
        frame.setTitle("Soru 1");

        var title = new JLabel("Metin:");
        var textField = new JTextField(30);
        var resultLabel = new JLabel("Sonuç: ");
        var reverseBtn = new JButton("Ters Çevir");

        reverseBtn.addActionListener(e -> {
            var text = textField.getText().toCharArray();
            var len = text.length;
            var rev = "";
            for (int i = 0; i < len; i++) {
                rev += text[len - i - 1];
            }
            resultLabel.setText("Sonuç: " + rev);
        }
        );

        var contentPane = frame.getContentPane();
        contentPane.add(title);
        contentPane.add(textField);
        contentPane.add(resultLabel);
        contentPane.add(reverseBtn);

        frame.setVisible(true);
    }

    //kişi bilgilerini al ve bir buton ile tetikleyerek bir labelda göster.
    private static void Question2() {
        var frame = CreateDefaultFrame();
        frame.setTitle("Soru 2");

        var nameLabel = new JLabel("Ad Soyad");
        var nameField = new JTextField(30);
        var isOnlineCheckBox = new JCheckBox("Çevrimiçi mi?");
        var genderLabel = new JLabel("Cinsiyet");
        var btnGroup = new ButtonGroup();
        var maleRB = new JRadioButton("Erkek");
        var femaleRB = new JRadioButton("Kadın");
        btnGroup.add(maleRB);
        btnGroup.add(femaleRB);

        var langs = new String[]{"Java", "C#", "Python"};
        var langsLabel = new JLabel("Diller");
        var langComboBox = new JComboBox<String>(langs);
        var resultLabel = new JLabel("Kişi bilgisi bekleniyor...");
        var printBtn = new JButton("Yazdır");

        printBtn.addActionListener(e -> {
            var res = nameField.getText()
                    + ", " + (isOnlineCheckBox.isSelected() ? "Çevrimiçi" : "Çevrimdışı")
                    + ", " + (maleRB.isSelected() ? "Erkek" : femaleRB.isSelected() ? "Kadın" : "Bilinmiyor")
                    + ", Seçilen dil: " + langs[langComboBox.getSelectedIndex()];
            resultLabel.setText(res);
        });

        var contentPane = frame.getContentPane();
        contentPane.add(nameLabel);
        contentPane.add(nameField);
        contentPane.add(isOnlineCheckBox);
        contentPane.add(genderLabel);
        contentPane.add(maleRB);
        contentPane.add(femaleRB);
        contentPane.add(langsLabel);
        contentPane.add(langComboBox);
        contentPane.add(printBtn);
        contentPane.add(resultLabel);

        frame.setVisible(true);
    }

    //CRUD panelini tasarla, tablo yapısını mysql ile oluştur.
    private static JFrame Question3_4() {
        var frame = CreateDefaultFrame();
        frame.setTitle("Soru 3-4");

        var idTitle = new JLabel("Öğretmen ID");
        var nameTitle = new JLabel("Öğretmen Ad Soyad");
        var degreeTitle = new JLabel("Öğretmen Ünvan");
        var ageTitle = new JLabel("Öğretmen Yaş");

        var idField = new JTextField(20);
        var nameField = new JTextField(30);
        var degreeField = new JTextField(20);
        var ageField = new JTextField(2);
        var addBtn = new JButton("Ekle");
        var delBtn = new JButton("Sil");
        var updBtn = new JButton("Güncelle");

        //SORU 4 -> Panelde update butonunu işlevsel yap
        updBtn.addActionListener(e -> {
            try {
                String name = nameField.getText();
                String degree = degreeField.getText();
                int age = Integer.parseInt(ageField.getText());
                int id = Integer.parseInt(idField.getText());

                var st = con.createStatement();
                String query = "UPDATE teachers SET teacher_name='" + name
                        + "', teacher_degree='" + degree
                        + "', teacher_age=" + age
                        + " WHERE teacher_id=" + id;

                st.execute(query);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        var findBtn = new JButton("Bul");

        var contentPane = frame.getContentPane();

        contentPane.add(idTitle);
        contentPane.add(idField);
        contentPane.add(nameTitle);
        contentPane.add(nameField);
        contentPane.add(degreeTitle);
        contentPane.add(degreeField);
        contentPane.add(ageTitle);
        contentPane.add(ageField);

        var panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(addBtn);
        panel.add(delBtn);
        panel.add(updBtn);
        panel.add(findBtn);
        contentPane.add(panel);

        frame.setVisible(true);
        return frame;
    }
}
