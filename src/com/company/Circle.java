package com.company;

public class Circle {
    public int x,y;
    private int r;
    public int vx,vy;

    public Circle(int x,int y,int r,int vx,int vy)
    {
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }

    public int getR(){return r;}

    public void move(int minx,int miny,int maxx,int maxy)
    {
        x+=vx;
        y+=vy;
        checkCollisition(minx, miny,maxx,maxy);
    }

    private void checkCollisition(int minx,int miny,int maxx,int maxy)
    {
        if(x-r<minx||x+r>maxx){vx = -vx;}
//        if(x+r>maxx){x=maxx-r; vx = -vx;}
        if(y-r<miny||y+r>maxy){vy=-vy;}
    }
}