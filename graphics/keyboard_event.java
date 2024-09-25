package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyboard_event extends JFrame {
    keyboard_event() {
        DrawArea p = new DrawArea();
        add(p);
        setSize(1500, 1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        p.setFocusable(true);
        p.requestFocusInWindow(); 
    }

    // Inner class
    static class DrawArea extends JPanel {
        char ch = 'A';
        int x = 20, y = 20;

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString(String.valueOf(ch), x, y);
        }

        DrawArea() {
            addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {}

                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_W: y = y - 20; break;
                        case KeyEvent.VK_S: y = y + 20; break;
                        case KeyEvent.VK_A: x = x - 20; break;
                        case KeyEvent.VK_D: x = x + 20; break;
                        default: ch = e.getKeyChar(); break;
                    }
                    repaint();
                }

                @Override
                public void keyReleased(KeyEvent e) {}
            });
        }
    }

    public static void main(String[] args) {
        new keyboard_event();
    }
}
