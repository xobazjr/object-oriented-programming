import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class lab_9_4 extends JFrame {
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    
    JLabel us = new JLabel("US Dollars");
    JLabel cd = new JLabel("Canadian Dollars");
    JTextField ust = new JTextField(10);
    JTextField jtfMonitor = new JTextField(10);
    JButton bt = new JButton("Convert");

    lab_9_4() {
        p1.setLayout(new BorderLayout());
        p2.setLayout(new BorderLayout());
        ust.setHorizontalAlignment(JTextField.RIGHT);
        jtfMonitor.setEditable(false);
        jtfMonitor.setHorizontalAlignment(JTextField.RIGHT);
        
        p1.setLayout(new GridLayout(2, 2));
        p1.add(us);
        //p1.add(ust);
        p1.add(cd);
        //p1.add(jtfMonitor);
        
        p2.setLayout(new GridLayout(2, 2));
        p2.add(ust);
        p2.add(jtfMonitor);
        
        p3.setLayout(new GridLayout(2, 2));
        p3.add(bt);
        
        bt.addActionListener(new Listener());
        
        setLayout(new BorderLayout());
        add(p1, BorderLayout.WEST);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
    }
    
    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double usDollars = Double.parseDouble(ust.getText());
                double canadianDollars = usDollars * 1.5;
                jtfMonitor.setText(String.format("%.2f", canadianDollars)); 
            } catch (NumberFormatException ex) {
                jtfMonitor.setText("Invalid input"); 
            }
        }
    }

    public static void main(String[] args) {
        lab_9_4 frame = new lab_9_4();
        frame.setTitle("Currency Converter");
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}