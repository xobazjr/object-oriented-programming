import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class lab_9_5 extends JFrame {
    private JPanel p1 = new JPanel();
    private JTextField display = new JTextField();
    private StringBuilder input = new StringBuilder();
    private double result = 0;
    private String operator = "";

    lab_9_5() {
        setLayout(new BorderLayout());

        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        add(display, BorderLayout.NORTH);

        p1.setLayout(new GridLayout(5, 4));
        JButton[] jbtButton = new JButton[20];

        String[] buttonLabels = {
            "√", "pow(x,2)", "+-", "C",
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", ".", "=", "="
        };

        for (int i = 0; i < 20; i++) {
            jbtButton[i] = new JButton(buttonLabels[i]);
            jbtButton[i].addActionListener(new ButtonListener());
            p1.add(jbtButton[i]);
        }

        add(p1, BorderLayout.CENTER);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            
            switch (command) {
                case "C":
                    input.setLength(0);
                    result = 0;
                    operator = "";
                    display.setText("");
                    break;
                case "=":
                    calculate(Double.parseDouble(input.toString()));
                    display.setText(String.valueOf(result));
                    input.setLength(0);
                    break;
                case "+":
                case "-":
                case "*":
                    if (!input.toString().isEmpty()) {
                        calculate(Double.parseDouble(input.toString()));
                        operator = command;
                        input.setLength(0);
                    }
                    break;
                case "√":
                    if (!input.toString().isEmpty()) {
                        result = Math.sqrt(Double.parseDouble(input.toString()));
                        display.setText(String.valueOf(result));
                        input.setLength(0);
                    }
                    break;
                case "pow(x,2)":
                    if (!input.toString().isEmpty()) {
                        result = Math.pow(Double.parseDouble(input.toString()), 2);
                        display.setText(String.valueOf(result));
                        input.setLength(0);
                    }
                    break;
                case "+-":
                    if (!input.toString().isEmpty()) {
                        input.insert(0, "-");
                        display.setText(input.toString());
                    }
                    break;
                default:
                    input.append(command);
                    display.setText(input.toString());
                    break;
            }
        }

        private void calculate(double num) {
            switch (operator) {
                case "+":
                    result += num;
                    break;
                case "-":
                    result -= num;
                    break;
                case "*":
                    result *= num;
                    break;
                case "=":
                    if (num != 0) {
                        result /= num;
                    } else {
                        display.setText("Error");
                        input.setLength(0);
                        return;
                    }
                    break;
                default:
                    result = num;
                    break;
            }
            display.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        JFrame frame = new lab_9_5();
        frame.setTitle("Calculator");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
