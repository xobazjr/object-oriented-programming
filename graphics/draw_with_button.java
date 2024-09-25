package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class draw_with_button extends JFrame {
    JButton jbtEnlarge = new JButton("Enlarge");
    JButton jbtShrink = new JButton("Shrink");
    DrawCircle p = new DrawCircle();

    draw_with_button() {
        setLayout(new BorderLayout());
        JPanel p2 = new JPanel();
        p2.add(jbtEnlarge);
        p2.add(jbtShrink);
        add(p, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        jbtEnlarge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.enlarge();
            }
        });

        jbtShrink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.shrink();
            }
        });
    }

    // Inner class
    static class DrawCircle extends JPanel {
        int radius = 5;

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawOval((getWidth() / 2) - radius, (getHeight() / 2) - radius, 2 * radius, 2 * radius);
        }

        public void enlarge() {
            radius += 30;
            repaint();
        }

        public void shrink() {
            radius -= 30;
            repaint();
        }
    }

    public static void main(String[] args) {
        draw_with_button frame = new draw_with_button();
        frame.setSize(1500, 1200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
