
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Lesson3 {

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(500, 600);

        jf.setLocation(100, 200);

        jf.getContentPane().setLayout(new FlowLayout());

        JButton btn1 = new JButton("Gönder");

        jf.getContentPane().add(btn1);

        btn1.setBackground(Color.yellow);
        btn1.setForeground(Color.RED);

        Color yenirenk = new Color(8, 10, 138);

        jf.getContentPane().setBackground(yenirenk);

        Color eskibutonrengi = btn1.getBackground();

        JLabel lbl1 = new JLabel();
        lbl1.setSize(200, 200);
        Image img1 = new ImageIcon(Lesson3.class.getResource("/image/image.jpg")).getImage();
        lbl1.setIcon(new ImageIcon(img1));

        jf.getContentPane().add(lbl1);

        btn1.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn1.setBackground(eskibutonrengi);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn1.setBackground(Color.darkGray);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
            }
        });

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
