package graphics.lab;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class hangman extends JPanel implements ActionListener {
    private int bodyOffset = 0;  
    private boolean moveRight = true;  

    public hangman() {
        Timer timer = new Timer(100, this);  
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int xBase = 20;
        int headX = xBase + 40 + 100 + bodyOffset;  
        int headY = 40;                             
        int radius = 20;

        g.setColor(Color.RED);
        g.drawArc(xBase, 220, 80, 40, 0, 180);
        g.drawLine(xBase + 40, 220, xBase + 40, 20);
        g.drawLine(xBase + 40, 20, xBase + 40 + 100, 20);
        g.drawLine(xBase + 40 + 100, 20, xBase + 40 + 100+ bodyOffset, 40);

        g.setColor(Color.BLUE);
        g.drawOval(headX - radius, headY, 2 * radius, 2 * radius);

        g.setColor(Color.MAGENTA);
        g.drawLine(headX, headY + 2 * radius, headX + bodyOffset, headY + radius + 80);
        
        g.drawLine(headX - (int)(radius * Math.cos(Math.toRadians(45))),
            headY + radius + (int)(radius * Math.sin(Math.toRadians(45))),
            headX - 60 + bodyOffset, headY + radius + 60);
        
        g.drawLine(headX + (int)(radius * Math.cos(Math.toRadians(45))),
            headY + radius + (int)(radius * Math.sin(Math.toRadians(45))),
            headX + 60 + bodyOffset, headY + radius + 60);
        
        g.drawLine(headX + bodyOffset, headY + radius + 80,
            headX + bodyOffset - 40, headY + radius + 80 + 40);
        
        g.drawLine(headX + bodyOffset, headY + radius + 80,
            headX + bodyOffset + 40, headY + radius + 80 + 40);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (moveRight) {
            bodyOffset += 5;
            if (bodyOffset >= 20) {  
                moveRight = false;
            }
        } else {
            bodyOffset -= 5;
            if (bodyOffset <= -20) {  
                moveRight = true;
            }
        }
        repaint(); 
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hangman Swing Animation");
        hangman panel = new hangman();
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}