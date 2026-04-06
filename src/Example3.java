
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Example3 {

    public static void main(String[] args) {
        var frame = new JFrame();
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        var contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());

        var btn = new JButton("Tıkla");
        btn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(255, 255, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(new Color(192, 192, 192));
            }

        });

        contentPane.add(btn);

        frame.setContentPane(contentPane);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
