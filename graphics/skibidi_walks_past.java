package graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class skibidi_walks_past extends JFrame{
    skibidi_walks_past(){
        URL imgBgURL = getClass().getResource("assets/bg.jpg");
        URL imgActorURL = getClass().getResource("assets/skibidi.png");
        Image imgBg = new ImageIcon(imgBgURL).getImage();
        Image imgActor = new ImageIcon(imgActorURL).getImage();
        add(new DrawArea(imgBg,imgActor));
    }

    //inner class
    static class DrawArea extends JPanel{
        Image imgBg;
        Image imgActor;
        int x=-300,y=300;

        public DrawArea(Image imgBg,Image imgActor){
            this.imgBg = imgBg;
            this.imgActor = imgActor;
            Timer time = new Timer(10,new Listener());
            time.start();
        }
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            if(x < 2000){
                x=x+10;
            }else{
                x=-300;  
            }
            g.drawImage(imgBg,0,0,getWidth(),getHeight(),this);
            g.drawImage(imgActor,x,y,200,280,this);
        }

        //inner class
        class Listener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        }
    }
    
    public static void main(String[] args){
        JFrame f = new skibidi_walks_past();
        f.setSize(1500,1200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}