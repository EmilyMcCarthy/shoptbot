package com.john.shopbot.screen;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static junit.framework.Assert.*;

/**
 * Copyright CloudMine LLC
 * User: johnmccarthy
 * Date: 5/26/12, 9:25 PM
 */
public class ScreenCheckerTest {

    @Test
    public void testIsConfirmBuyoutScreen() {
        assertTrue(ScreenChecker.isConfirmBuyoutScreen(read("confirmbuyout.png")));
        assertFalse(ScreenChecker.isConfirmBuyoutScreen(read("auctionhouse.png")));
    }

    public static void main(String... args) throws AWTException {
        Robot robot = new Robot();
        Screen s = new Screen();
        s.click();
        robot.mouseMove(1401, 852);
        Color rgb = robot.getPixelColor(1244, 867);
        System.out.println(rgb.getRed() + ", " + rgb.getGreen() + ", " + rgb.getBlue());
        rgb = robot.getPixelColor(1244, 868);
        System.out.println(rgb.getRed() + ", " + rgb.getGreen() + ", " + rgb.getBlue());
        rgb = robot.getPixelColor(1244, 869);
        System.out.println(rgb.getRed() + ", " + rgb.getGreen() + ", " + rgb.getBlue());
        rgb = robot.getPixelColor(1244, 870);
        System.out.println(rgb.getRed() + ", " + rgb.getGreen() + ", " + rgb.getBlue());
//        BufferedImage buyScreen = read("buy.png");
//        1228, 865;
//        1395, 870
//        buyScreen.getSubimage(0, 0, 0, 0);
    }

    private static void saveImage(String fileName, BufferedImage toSave) {
        File output = new File("/Users/johnmccarthy/Desktop/screen/" + fileName);
        try {
            ImageIO.write(toSave, "png", output);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private static BufferedImage read(String fileName) {
        try {
            BufferedImage image = ImageIO.read(new File("/Users/johnmccarthy/dev/workspace/shop/test/com/john/shopbot/screen/" + fileName));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        return null;
    }
}
