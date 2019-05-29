package com.company;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlgoVisualizer {

    private Circle[] circles;
    private AlgoFrame frame;
    private boolean isAnimated = true;

    public AlgoVisualizer(int w, int h, int N){

        // 初始化数据
        circles = new Circle[N];
        int R = 50;
        for(int i = 0 ; i < N ; i ++){
            int x = (int)(Math.random()*(w-2*R)) + R;
            int y = (int)(Math.random()*(h-2*R)) + R;
            int vx = (int)(Math.random()*11) - 5;
            int vy = (int)(Math.random()*11) - 5;
            circles[i] = new Circle(x, y, R, vx, vy);
        }

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", w, h);
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){

        while(true){
            // 绘制数据
            frame.render(circles);
            AlgoVisHelper.pause(20);

            // 更新数据
            if(isAnimated)
                for(Circle circle : circles)
                    circle.move(0, 0, frame.GetW(), frame.GetH());
        }
    }

    private class AlgoKeyListener extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent event){
            if(event.getKeyChar() == ' ')
                isAnimated = !isAnimated;
        }
    }

    private class AlgoMouseListener extends MouseAdapter{

        @Override
        public void mousePressed(MouseEvent event){


//            event.translatePoint(0,
//                    -(frame.getBounds().height - frame.GetH()));
            System.out.println(event.getX()+"\t"+event.getY());

        }
    }
}
