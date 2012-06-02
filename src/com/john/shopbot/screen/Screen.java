package com.john.shopbot.screen;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Copyright CloudMine LLC
 * User: johnmccarthy
 * Date: 5/26/12, 3:43 PM
 */
public class Screen {
    public static final long MOVE_SLEEP = 1000;
    public static final long CLICK_SLEEP = 1000;
    public static final long CLICK_TIME = 500;
    protected final Robot robot;

    public Screen() {
        try {
            robot = new Robot();
            robot.setAutoWaitForIdle(true);
            robot.delay(500);

        } catch (AWTException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String... args) {
        Screen s = new Screen();
        s.click();
        s.paste();

    }

    public void waitForClickable(ScreenPosition position) {
        while(!isButtonClickable(position)) {
            robot.delay(500);
        }
    }

    public boolean isBannerVisible() {
        ScreenPosition BANNER_POSITION = new ScreenPosition(1031, 266);
        ScreenPosition position = BANNER_POSITION;
        int totalGreen = 0;
        int totalBlue = 0;
        int totalRed = 0;
        for(int i = 0; i < 5; i++) {
            Color pixelColor = robot.getPixelColor(BANNER_POSITION.x(), position.y());
            totalGreen += pixelColor.getGreen();
            totalBlue += pixelColor.getBlue();
            totalRed += pixelColor.getRed();
            position = position.changeY(1);
        }

        return (totalGreen > totalBlue) && (totalGreen > totalRed);
    }

    public boolean isButtonClickable(ScreenPosition position) {
        int totalRed = 0;
        for(int i = 0; i< 5; i++) {
            totalRed += robot.getPixelColor(position.x(), position.y()).getRed();
            position = position.changeY(1);
        }
        double averageRed = totalRed / 5;
        return averageRed > 20;
    }

    public void paste() {
        robot.keyPress(KeyEvent.META_MASK);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.META_MASK);
    }

    public void write(int value) {
        String valueString = String.valueOf(value);
        for(int i = 0; i < valueString.length(); i++) {
            switch(valueString.charAt(i)) {
                case '0':
                    type(KeyEvent.VK_0);
                    break;
                case '1':
                    type(KeyEvent.VK_1);
                    break;
                case '2':
                    type(KeyEvent.VK_2);
                    break;
                case '3':
                    type(KeyEvent.VK_3);
                    break;
                case '4':
                    type(KeyEvent.VK_4);
                    break;
                case '5':
                    type(KeyEvent.VK_5);
                    break;
                case '6':
                    type(KeyEvent.VK_6);
                    break;
                case '7':
                    type(KeyEvent.VK_7);
                    break;
                case '8':
                    type(KeyEvent.VK_8);
                    break;
                case '9':
                    type(KeyEvent.VK_9);
                    break;
                default:
                    System.err.println("Unrecognized character will not be written: " + valueString.charAt(i));
            }
        }

    }

    protected void type(int keyEventIdentifier) {
        robot.keyPress(keyEventIdentifier);
        robot.keyRelease(keyEventIdentifier);
    }

    public void click(HasPoint clickable) {
        move(clickable.x(), clickable.y());
        click();
    }

    public void fastClick(HasPoint clickable) {

        int oldDelay = robot.getAutoDelay();
        robot.setAutoDelay(1);
        robot.mouseMove(clickable.x(), clickable.y());
        robot.mousePress((InputEvent.BUTTON1_MASK));
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.setAutoDelay(oldDelay);
    }

    protected void click() {
        robot.mousePress((InputEvent.BUTTON1_MASK));
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    protected void move(ScreenPosition position) {
        move(position.x(), position.y());
    }

    protected void move(int x, int y) {
        robot.mouseMove(x, y);
    }
}
