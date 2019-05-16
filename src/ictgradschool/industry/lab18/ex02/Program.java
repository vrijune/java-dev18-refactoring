package ictgradschool.industry.lab18.ex02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * TODO Have fun :)
 */
public class Program extends JFrame {

    private static final Random r = new Random();
    private Canvas c = new Canvas();
    private int fx = -1, fy = -1;
    private ArrayList<Integer> xs1 = new ArrayList<>();
    private ArrayList<Integer> xs2 = new ArrayList<>();
    private ArrayList<Integer> ys1 = new ArrayList<>();
    private ArrayList<Integer> ys2 = new ArrayList<>();
    private int d;
    private boolean done = false;

    public static void main(String[] args) {
        new Program().go();
    }

    public Program() {
        for (int i = 0; i < 6; i++) {
            xs2.add(10 - i);
            ys2.add(10);
        }
        this.d = 39;
        setTitle("Program" + " : " + 6);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200, 200, 30 * 25 + 6, 20 * 25 + 28);
        setResizable(false);
        c.setBackground(Color.white);
        add(BorderLayout.CENTER, c);

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int d1 = e.getKeyCode();
                if ((d1 >= 37) && (d1 <= 40)) {// block wrong codes
                    if (Math.abs(Program.this.d - d1) != 2) {// block moving back
                        Program.this.d = d1;
                    }
                }
            }
        });
        setVisible(true);
    }

    void go() { // main loop
        while (!done) {
            int x2 = xs2.get(0);
            int y2 = ys2.get(0);
            if (d == 37) {
                x2--;
            }
            if (d == 39) {
                x2++;
            }
            if (d == 38) {
                y2--;
            }
            if (d == 40) {
                y2++;
            }
            if (x2 > 30 - 1) {
                x2 = 0;
            }
            if (x2 < 0) {
                x2 = 30 - 1;
            }
            if (y2 > 20 - 1) {
                y2 = 0;
            }
            if (y2 < 0) {
                y2 = 20 - 1;
            }
            boolean check11 = false;
            boolean check21 = false;
            for (int i1 = 0; i1 < xs1.size(); i1++) {
                if (xs1.get(i1) == x2 && ys1.get(i1) == y2) {
                    check11 = true;
                }
            }
            for (int i1 = 0; i1 < xs2.size(); i1++) {
                if ((xs2.get(i1) == x2) && (ys2.get(i1) == y2)) {
                    if (!((xs2.get(xs2.size() - 1) == x2) && (ys2.get(ys2.size() - 1) == y2))) {
                        check21 = true;
                    }
                }
            }
            done = check11 || check21;
            xs2.add(0, x2);
            ys2.add(0, y2);
            if (((xs2.get(0) == fx) && (ys2.get(0) == fy))) {
                fx = -1;
                fy = -1;
                setTitle("Program" + " : " + xs2.size());
            } else {
                xs2.remove(xs2.size() - 1);
                ys2.remove(ys2.size() - 1);
            }
            if (fx == -1) {
                int x, y;
                boolean check1 = false;
                boolean check2 = false;
                do {
                    x = r.nextInt(30);
                    y = r.nextInt(20);
                    for (int i = 0; i < xs1.size(); i++) {
                        if (xs1.get(i) == x && ys1.get(i) == y) {
                            check1 = true;
                        }
                    }
                    for (int i = 0; i < xs2.size(); i++) {
                        if ((xs2.get(i) == x) && (ys2.get(i) == y)) {
                            if (!((xs2.get(xs2.size() - 1) == x) && (ys2.get(ys2.size() - 1) == y))) {
                                check2 = true;
                            }
                        }
                    }
                } while (check2 || check1);
                fx = x;
                fy = y;
                int x1, y1;
                boolean check3 = false;
                boolean check4 = false;
                do {
                    x1 = r.nextInt(30);
                    y1 = r.nextInt(20);
                    for (int i = 0; i < xs1.size(); i++) {
                        if (xs1.get(i) == x1 && ys1.get(i) == y1) {
                            check3 = true;
                        }
                    }
                    for (int i = 0; i < xs2.size(); i++) {
                        if ((xs2.get(i) == x1) && (ys2.get(i) == y1)) {
                            if (!((xs2.get(xs2.size() - 1) == x1) && (ys2.get(ys2.size() - 1) == y1))) {
                                check4 = true;
                            }
                        }
                    }
                } while (check3 || check4 || fx == x1 && fy == y1);

                xs1.add(x1);
                ys1.add(y1);
            }
            c.repaint();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class Canvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i < xs2.size(); i++) {
                g.setColor(Color.gray);
                g.fill3DRect(xs2.get(i) * 25 + 1, ys2.get(i) * 25 + 1, 25 - 2, 25 - 2, true);
            }
            g.setColor(Color.green);
            g.fill3DRect(fx * 25 + 1, fy * 25 + 1, 25 - 2, 25 - 2, true);
            for (int i = 0; i < xs1.size(); i++) {
                g.setColor(Color.red);
                g.fill3DRect(xs1.get(i) * 25 + 1, ys1.get(i) * 25 + 1, 25 - 2, 25 - 2, true);
            }
            if (done) {
                g.setColor(Color.red);
                g.setFont(new Font("Arial", Font.BOLD, 60));
                FontMetrics fm = g.getFontMetrics();
                g.drawString("Over", (30 * 25 + 6 - fm.stringWidth("Over")) / 2, (20 * 25 + 28) / 2);
            }
        }
    }
}