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

    public Calculator(JFrame parent) {
        setContentPane(panelMain);
        setTitle("GUI Practice");
        setSize(350, 250);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MilestoneCalc();
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

        setVisible(true);
    }

        private void MilestoneCalc() {
            if (txtM1.getText().isEmpty() || txtM2.getText().isEmpty() || txtTA.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter all fields",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                try {
                    double m1 = Double.parseDouble(txtM1.getText());
                    double m2 = Double.parseDouble(txtM2.getText());
                    double ta = Double.parseDouble(txtTA.getText());
                    double sum = 0;
                    
                    if (m1<=0 && m2<=0 && ta<=0) {
                        JOptionPane.showMessageDialog(this,
                                "Invalid input!",
                                "Error", JOptionPane.ERROR_MESSAGE);    
                    } else if (m1>=1 && m1 <= 25 && m2>=1 && m2 <= 40 && ta>=1 && ta <= 35) {
                        sum = m1+m2+ta;
                        txtRS.setText(String.valueOf(sum));
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Invalid input!",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this,
                            "Invalid input!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    public static void main (String[] args) {
    Calculator n = new Calculator(null);

    }

}
