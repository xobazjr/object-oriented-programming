package graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class mouse_event extends JFrame{
    mouse_event(){
        DrawArea p = new DrawArea();
        add(p);
    }

    //inter class
    static class DrawArea extends JPanel{
        String s = "Moodeng";
        int x=10;
        int y=10;
        DrawArea(){
            addMouseMotionListener(new MouseMotionListener(){
                @Override
                public void mouseDragged(MouseEvent e){
                    x = e.getX();
                    y = e.getY();
                    repaint();
                }

                @Override
                public void mouseMoved(MouseEvent e){}
            });
        }
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawString("X position = "+x+"Y position = "+y,20,20);
            g.drawString(s,x,y);
        }
    }

    public static void main(String[] args){
        JFrame f = new mouse_event();
        f.setSize(1500,1200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
