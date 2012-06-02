package com.john.shopbot.screen;

import java.awt.image.BufferedImage;

/**
 * Copyright CloudMine LLC
 * User: johnmccarthy
 * Date: 5/26/12, 9:24 PM
 */
public class ScreenChecker {

    public static boolean isConfirmBuyoutScreen(BufferedImage buyoutScreen) {
        int rgb = buyoutScreen.getRGB(729, 720);//729, 720
        int red = (rgb >> 16) & 0xFF;
        //120 to 125 R
        return (120 <= red) && (135 >= red);
    }
}
