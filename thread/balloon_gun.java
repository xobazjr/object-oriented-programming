import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class balloon_gun extends JFrame {
    public static void main(String[] args) {
        balloon_gun game = new balloon_gun();
        game.setSize(600, 500);
        game.setVisible(true);
    }

    private BalloonPanel paintPanel = new BalloonPanel();

    public balloon_gun() {
        setLayout(new BorderLayout());
        add(paintPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class BalloonPanel extends JPanel implements Runnable {
        final static int BALLOON_RADIUS = 10;
        final static int BALL_RADIUS = 5;
        final static int GUN_LENGTH = 25;
        final static int PANEL_WIDTH = 200;
        final static int PANEL_HEIGHT = 100;

        private int x_Balloon = (int) (Math.random() * PANEL_WIDTH);
        private int y_Balloon = (int) (Math.random() * PANEL_HEIGHT);
        private int angle = 90;

        private LinkedList<SmallBall> list = new LinkedList<>();
        private boolean running = true;

        class SmallBall {
            int length;
            int angle;

            SmallBall(int length, int angle) {
                this.length = length;
                this.angle = angle;
            }
        }

        public BalloonPanel() {
            setFocusable(true);
            this.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        if (angle < 180) angle += 3;
                    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        if (angle > 0) angle -= 3;
                    } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                        // Launch a small ball
                        list.add(new SmallBall(GUN_LENGTH, angle));
                    }
                }
            });
            new Thread(this).start();
        }

        boolean hit = false;

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawGame(g);
        }

        private void drawGame(Graphics g) {
            // Display the gun
            int x = (int) (GUN_LENGTH * Math.cos(Math.toRadians(angle)) + getWidth() / 2);
            int y = (int) (getHeight() - GUN_LENGTH * Math.sin(Math.toRadians(angle)));
            g.drawLine(getWidth() / 2, getHeight(), x, y);
            g.drawLine(getWidth() / 2 - 1, getHeight(), x - 1, y);
            g.drawLine(getWidth() / 2 - 2, getHeight(), x - 2, y);
            g.drawLine(getWidth() / 2 + 1, getHeight(), x + 1, y);
            g.drawLine(getWidth() / 2 + 2, getHeight(), x + 2, y);

            if (hit) {
                // Display three small pieces
                drawHitBalloon(g);
                hit = false;
                // New random location
                x_Balloon = (int) (Math.random() * PANEL_WIDTH);
                y_Balloon = (int) (Math.random() * PANEL_HEIGHT);
                return;
            }

            g.drawOval(x_Balloon - BALLOON_RADIUS,y_Balloon - BALLOON_RADIUS, 2 * BALLOON_RADIUS,2 * BALLOON_RADIUS);
            // Draw small hitting balls
            for (int i = 0; i < list.size(); i++) {
                SmallBall ball = list.get(i);
                ball.length += 5;

                x = (int) (ball.length * Math.cos(Math.toRadians(ball.angle)) + getWidth() / 2);
                y = (int) (getHeight() - ball.length * Math.sin(Math.toRadians(ball.angle)));

                g.fillOval(x - BALL_RADIUS, y - BALL_RADIUS, 2 * BALL_RADIUS,2 * BALL_RADIUS);

                if (overlaps(x, y, BALL_RADIUS,x_Balloon, y_Balloon, BALLOON_RADIUS)) {
                    list.remove(i);
                    hit = true;
                }

                if (x > getWidth() || x < 0 || y < 0)
                    list.remove(i);
            }
        }

        private void drawHitBalloon(Graphics g) {
            g.drawOval(x_Balloon - BALLOON_RADIUS / 2 - 5,y_Balloon - BALLOON_RADIUS / 2, BALLOON_RADIUS,BALLOON_RADIUS);
            g.drawOval(x_Balloon + 2 * BALLOON_RADIUS + 5 - BALLOON_RADIUS / 2,y_Balloon - BALLOON_RADIUS / 2, BALLOON_RADIUS,BALLOON_RADIUS);
            g.drawOval(x_Balloon - BALLOON_RADIUS / 2,y_Balloon + 2 * BALLOON_RADIUS + 5 - BALLOON_RADIUS / 2, BALLOON_RADIUS,BALLOON_RADIUS);
            g.drawOval(x_Balloon - BALLOON_RADIUS / 2,y_Balloon - 2 * BALLOON_RADIUS - 5 - BALLOON_RADIUS / 2, BALLOON_RADIUS,BALLOON_RADIUS);
        }

        @Override
        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    
                }
            }
        }

        public static boolean overlaps(double x1, double y1, double radius1,double x2, double y2, double radius2) {
            return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) <= radius1 + radius2;
        }
    }
}