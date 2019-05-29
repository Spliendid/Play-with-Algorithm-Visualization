package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AlgoVisHelper {
    private AlgoVisHelper(){

    }
    //设置颜色
    public static void setColor(Graphics2D g2d,Color color)
    {
        g2d.setColor(color);
    }
    //设置画笔粗细
    public static void setStrokeWidth(Graphics2D g2d,int w)
    {
        g2d.setStroke(new BasicStroke(w,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
    }
    //画圈圈
    public static void strokeCircle(Graphics2D g2d,int x,int y,int r)
    {
        Ellipse2D circle = new Ellipse2D.Double(x-r,y-r,2*r,2*r);
        g2d.draw(circle);
    }
    //画实心圆
    public static void fillCircle(Graphics2D g2d,int x,int y,int r)
    {
        Ellipse2D circle = new Ellipse2D.Double(x-r,y-r,2*r,2*r);
        g2d.fill(circle);
    }

    public static void pause(int t)
    {
        try {
            Thread.sleep(t);
        }catch (InterruptedException e)
        {
            System.out.println("Error in sleeping"+e.toString());
        }
    }
}
