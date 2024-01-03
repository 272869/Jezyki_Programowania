import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimatorApp extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    final AnimatorApp frame = new AnimatorApp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public AnimatorApp(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        AnimPanel kanwa = new AnimPanel();
        contentPane.add(kanwa);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                kanwa.initialize();
            }
        });

        JButton btnAdd1 = new JButton("Dodaj samochód"); //Dodanie samochodów
        btnAdd1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kanwa.addSam();
            }
        });
        btnAdd1.setBounds(10, 310, 130, 23);
        contentPane.add(btnAdd1);

        JButton btnAdd2 = new JButton("Dodaj pieszego"); //Dodanie piesi
        btnAdd2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kanwa.addPiesi();
            }
        });
        btnAdd2.setBounds(150, 310, 130, 23);
        contentPane.add(btnAdd2);
        JButton btnAnimate = new JButton("Start"); //Pokazywanje
        btnAnimate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kanwa.animate();
            }
        });
        btnAnimate.setBounds(300, 310, 80, 23);
        contentPane.add(btnAnimate);

        setSize(600,400);
        setBackground(Color.WHITE);
        setVisible(true);
    }
}