
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lab_9_7 extends JFrame {
    private JTextField txtId, txtMoney, txtBath, txtRate, txtFirstName, txtLastName, txtAge;
    private JComboBox<String> cbDayOpen, cbMonthOpen, cbYearOpen;
    private JComboBox<String> cbDayBirth, cbMonthBirth, cbYearBirth;
    private JButton btnSave, btnShow;

    public lab_9_7() {
        setTitle("Show Detail of Account Money");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);

        JLabel titleLabel = new JLabel("ACCOUNT MONEY", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(titleLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(10, 2, 5, 5));
        mainPanel.add(inputPanel);

        inputPanel.add(new JLabel("ID: "));
        txtId = new JTextField();
        inputPanel.add(txtId);

        inputPanel.add(new JLabel("MONEY: "));
        txtMoney = new JTextField();
        inputPanel.add(txtMoney);

        inputPanel.add(new JLabel("BATH: "));
        txtBath = new JTextField();
        inputPanel.add(txtBath);

        inputPanel.add(new JLabel("ANNUAL INTEREST RATE: "));
        txtRate = new JTextField();
        inputPanel.add(txtRate);

        inputPanel.add(new JLabel("DAY OPEN ACCOUNT: "));
        cbDayOpen = new JComboBox<>(generateDays());
        cbMonthOpen = new JComboBox<>(generateMonths());
        cbYearOpen = new JComboBox<>(generateYears());
        JPanel openDatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        openDatePanel.add(cbDayOpen);
        openDatePanel.add(cbMonthOpen);
        openDatePanel.add(cbYearOpen);
        inputPanel.add(openDatePanel);

        inputPanel.add(new JLabel("FIRST NAME: "));
        txtFirstName = new JTextField();
        inputPanel.add(txtFirstName);

        inputPanel.add(new JLabel("LAST NAME: "));
        txtLastName = new JTextField();
        inputPanel.add(txtLastName);

        inputPanel.add(new JLabel("BIRTH DAY: "));
        cbDayBirth = new JComboBox<>(generateDays());
        cbMonthBirth = new JComboBox<>(generateMonths());
        cbYearBirth = new JComboBox<>(generateYears());
        JPanel birthDatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        birthDatePanel.add(cbDayBirth);
        birthDatePanel.add(cbMonthBirth);
        birthDatePanel.add(cbYearBirth);
        inputPanel.add(birthDatePanel);

        inputPanel.add(new JLabel("AGE: "));
        txtAge = new JTextField();
        inputPanel.add(txtAge);

        btnSave = new JButton("SAVE");
        btnShow = new JButton("SHOW");
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnSave);
        buttonPanel.add(btnShow);
        mainPanel.add(buttonPanel);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });

        btnShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showData();
            }
        });
    }

    private String[] generateDays() {
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = String.valueOf(i);
        }
        return days;
    }

    private String[] generateMonths() {
        return new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    }

    private String[] generateYears() {
        String[] years = new String[101];
        int currentYear = java.time.Year.now().getValue();
        for (int i = 0; i < 101; i++) {
            years[i] = String.valueOf(currentYear - i);
        }
        return years;
    }

    private void saveData() {
        JOptionPane.showMessageDialog(this, "Data Saved Successfully!");
    }

    private void showData() {
        StringBuilder data = new StringBuilder();
        data.append("ID: ").append(txtId.getText()).append("\n");
        data.append("Money: ").append(txtMoney.getText()).append("\n");
        data.append("Bath: ").append(txtBath.getText()).append("\n");
        data.append("Annual Interest Rate: ").append(txtRate.getText()).append("\n");
        data.append("Open Date: ").append(cbDayOpen.getSelectedItem()).append(" ")
            .append(cbMonthOpen.getSelectedItem()).append(" ").append(cbYearOpen.getSelectedItem()).append("\n");
        data.append("First Name: ").append(txtFirstName.getText()).append("\n");
        data.append("Last Name: ").append(txtLastName.getText()).append("\n");
        data.append("Birth Date: ").append(cbDayBirth.getSelectedItem()).append(" ")
            .append(cbMonthBirth.getSelectedItem()).append(" ").append(cbYearBirth.getSelectedItem()).append("\n");
        data.append("Age: ").append(txtAge.getText()).append("\n");

        JOptionPane.showMessageDialog(this, data.toString(), "Account Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            lab_9_7 frame = new lab_9_7();
            frame.setVisible(true);
        });
    }
}

