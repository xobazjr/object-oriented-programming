import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class lab_9_8 extends JFrame {
    private JTextField txtPositionY, txtSpeed, txtAngle, txtScore;
    private JPanel gamePanel;
    private JLabel lblBird, lblPig;
    private int score = 0;

    public lab_9_8() {
        setTitle("Angry Birds Game");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 10));
        topPanel.add(new JLabel("SCENE 1: At Tokyo"));
        txtScore = new JTextField("0", 5);
        txtScore.setEditable(false);
        JPanel scorePanel = new JPanel(new FlowLayout());
        scorePanel.add(new JLabel("SCORE"));
        scorePanel.add(txtScore);
        topPanel.add(scorePanel);
        add(topPanel, BorderLayout.NORTH);

        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bgImage = new ImageIcon(getClass().getResource("/assets/background.jpg"));
                if (bgImage.getImageLoadStatus() == MediaTracker.COMPLETE) {
                    g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), null);
                } else {
                    System.out.println("Background image failed to load.");
                }
            }
        };
        gamePanel.setLayout(null);
        
        lblBird = new JLabel();
        lblPig = new JLabel();

        loadAndSetIcon(lblBird, "/assets/sigma_skibidi.png", 50, 60);
        loadAndSetIcon(lblPig, "/assets/speakerman.png", 50, 60);
        
        gamePanel.add(lblBird);
        gamePanel.add(lblPig);
        add(gamePanel, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        inputPanel.add(new JLabel("Bird Position in y-axis"));
        txtPositionY = new JTextField();
        inputPanel.add(txtPositionY);
        inputPanel.add(new JLabel("Shooting Speed"));
        txtSpeed = new JTextField();
        inputPanel.add(txtSpeed);
        inputPanel.add(new JLabel("Angle"));
        txtAngle = new JTextField();
        inputPanel.add(txtAngle);
        JButton btnOk = new JButton("OK");
        inputPanel.add(btnOk);
        add(inputPanel, BorderLayout.SOUTH);

        resetGameObjects();

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double yPosition = Double.parseDouble(txtPositionY.getText());
                    double speed = Double.parseDouble(txtSpeed.getText());
                    double angle = Double.parseDouble(txtAngle.getText());
                    performProjectileMotion(yPosition, speed, angle);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numerical values.");
                }
            }
        });
    }

    private void loadAndSetIcon(JLabel label, String path, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(scaledImage));
        } else {
            System.out.println("Failed to load image at " + path);
        }
    }

    private void resetGameObjects() {
        lblBird.setBounds(50, 200, 50, 50);
        Random rand = new Random();
        int pigX = 250 + rand.nextInt(250);
        int pigY = rand.nextInt(200) + 50;
        lblPig.setBounds(pigX, pigY, 50, 50);
    }

    private void performProjectileMotion(double yPosition, double speed, double angle) {
        double gravity = -10.0; // m/s^2
        double radianAngle = Math.toRadians(angle);

        double velocityX = speed * Math.cos(radianAngle);
        double velocityY = speed * Math.sin(radianAngle);

        double a = 0.5 * gravity;
        double b = -velocityY;
        double c = -yPosition;
        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            JOptionPane.showMessageDialog(this, "The bird will not reach the ground. Try different inputs.");
            return;
        }

        double time1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double time2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        double time = Math.max(time1, time2); 

        int finalX = (int) (50 + velocityX * time);
        int finalY = (int) (200 - (velocityY * time + 0.5 * gravity * time * time));

        int pigX = lblPig.getX();
        int pigY = lblPig.getY();
        if (Math.abs(finalX - pigX) <= 20 && Math.abs(finalY - pigY) <= 20) {
            score += 100;
            txtScore.setText(String.valueOf(score));
            JOptionPane.showMessageDialog(this, "Hit! Score +100.");
        } else {
            JOptionPane.showMessageDialog(this, "Missed! Try again.");
        }

        resetGameObjects();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            lab_9_8 frame = new lab_9_8();
            frame.setVisible(true);
        });
    }
}
