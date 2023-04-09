import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Calculator extends JFrame {
    private JLabel labelMain;
    private JTextField txtM1;
    private JButton buttonCalc;
    private JLabel labelM1;
    private JLabel labelM2;
    private JPanel panelMain;
    private JTextField txtTA;
    private JTextField txtRS;
    private JLabel labelTA;
    private JLabel labelRS;
    private JTextField txtM2;

    public Calculator() {
        buttonCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double m1 = Double.parseDouble(txtM1.getText());
                double m2 = Double.parseDouble(txtM2.getText());
                double ta = Double.parseDouble(txtTA.getText());
                double sum=0;

                if (m1<=0 && m2<=0 && ta<=0) {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                    txtRS.setText("0");
                    txtM1.setText("0");
                    txtM2.setText("0");
                    txtTA.setText("0");

                } else if (m1>=1 && m1 <= 25 && m2>=1 && m2 <= 40 && ta>=1 && ta <= 35) {
                    sum = m1+m2+ta;
                    txtRS.setText(String.valueOf(sum));
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid input!");
                    txtRS.setText("0");
                    txtM1.setText("0");
                    txtM2.setText("0");
                    txtTA.setText("0");

                }
            }
        });

        txtM1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!(Character.isDigit(c) || c==KeyEvent.VK_DELETE)) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
        txtM2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!(Character.isDigit(c) || c==KeyEvent.VK_DELETE)) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
        txtTA.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!(Character.isDigit(c) || c==KeyEvent.VK_DELETE)) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
    }

    public static void main (String[] args) {
    Calculator n = new Calculator();
    n.setContentPane(n.panelMain);
    n.setTitle("GUI Practice");
    n.setSize(450,350);
    n.setLocationRelativeTo(null);
    n.setVisible(true);
    n.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
