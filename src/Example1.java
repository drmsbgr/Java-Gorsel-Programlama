
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Example1 {

    public static void main(String[] args) {
        var frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(new FlowLayout());

        var contentPane = frame.getContentPane();

        var usernameTitle = new JLabel("Kullanıcı adı");
        var usernameField = new JTextField(20);
        var passwordTitle = new JLabel("Şifre");
        var passwordField = new JPasswordField(12);
        var loginButton = new JButton("Giriş yap");

        passwordField.setEchoChar('*');

        loginButton.addActionListener(e -> {
            var username = usernameField.getText();
            var password = new String(passwordField.getPassword());
            if (username.equals("admin") && password.equals("1234")) {
                JOptionPane.showMessageDialog(contentPane, "Başarılı bir şekilde giriş yaptınız.");
            } else {
                JOptionPane.showMessageDialog(contentPane, "Kullanıcı adı veya şifreniz yanlış!");
            }
        });

        contentPane.add(usernameTitle);
        contentPane.add(usernameField);
        contentPane.add(passwordTitle);
        contentPane.add(passwordField);
        contentPane.add(loginButton);

        frame.setContentPane(contentPane);
        frame.setVisible(true);
    }
}
