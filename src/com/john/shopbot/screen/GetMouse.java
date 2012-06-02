package com.john.shopbot.screen;

import java.awt.*;

public class GetMouse
{
    public static void main(String[] args)
    {
        while (true)
        {
            PointerInfo a = MouseInfo.getPointerInfo();
            Point b = a.getLocation();
            int x = (int) b.getX();
            int y = (int) b.getY();
            System.out.println(x + ":" + y);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}