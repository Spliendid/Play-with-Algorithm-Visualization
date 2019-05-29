package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AlgoFrame extends JFrame {

    private int w;
    private int h;
    public AlgoFrame(String title,int w,int h)
    {
        super(title);

        this.w = w;
        this.h = h;

//        AlgoCanvas canvas = new AlgoCanvas();
//        setContentPane(canvas);
//        pack();
        setSize(w,h);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public AlgoFrame(String title)
    {
        this(title,1024,768);
    }

    public int GetW(){return  w;}
    public int GetH(){return h;}

    private Circle[] circles;
    public void render(Circle[] circles)
    {
        this.circles = circles;
        //刷新
        repaint();
    }

    //内部Panel
    private class AlgoCanvas extends JPanel
    {
        public AlgoCanvas()
        {
            //双缓存
            super(true);
        }

        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D)g;

            //抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            g2d.setColor(Color.magenta);

            AlgoVisHelper.setStrokeWidth(g2d,10);

//           for (Circle circle :circles)
//               AlgoVisHelper.strokeCircle(g2d,circle.x,circle.y,circle.getR());
        }

        @Override
        public Dimension getPreferredSize()
        {
            return new Dimension(w,h);
        }
    }
}
