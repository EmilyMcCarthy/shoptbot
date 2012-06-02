package com.john.shopbot.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;

/**
 * Copyright CloudMine LLC
 * User: johnmccarthy
 * Date: 5/26/12, 2:22 PM
 */
public class ImageAnalyzer {

    private static final int SCALE_TO = 15;

    public static boolean isAverageColor(BufferedImage image, Color color) {
        BufferedImage scaledImage = scaleImage(image);

        int imageHeight = scaledImage.getHeight();
        int imageWidth = scaledImage.getWidth();
        for(int x = 0; x < imageHeight; x++) {
            for(int y = 0; y < imageWidth; y++) {

            }
        }

        return true;
    }

    private static BufferedImage scaleImage(BufferedImage image) {
        return scaleImage(image, SCALE_TO);
    }

    private static BufferedImage scaleImage(BufferedImage image, int scaleTo) {
        int height = image.getHeight();
        int width = image.getWidth();
        int scaledHeight, scaledWidth;
        if(height > width) {
            scaledHeight = height / scaleTo;
            int scaleRatio = scaledHeight / height;
            scaledWidth = width / scaleRatio;
        } else {
            scaledWidth = width / scaleTo;
            int scaleRatio = scaledWidth / width;
            scaledHeight = width / scaleRatio;
        }

        return toBufferedImage(image.getScaledInstance(scaledHeight,  scaledWidth,  Image.SCALE_AREA_AVERAGING));
    }

    public static BufferedImage toBufferedImage(Image image) {

        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }

        // This code ensures that all the pixels in the image are loaded
        image = new ImageIcon(image).getImage();

        // Determine if the image has transparent pixels
        boolean hasAlpha = hasAlpha(image);

        // Create a buffered image with a format that's compatible with the
        // screen
        BufferedImage bimage = null;
        GraphicsEnvironment ge = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        try {
            // Determine the type of transparency of the new buffered image
            int transparency = Transparency.OPAQUE;
            if (hasAlpha == true) {
                transparency = Transparency.BITMASK;
            }

            // Create the buffered image
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gs.getDefaultConfiguration();
            bimage = gc.createCompatibleImage(image.getWidth(null), image
                    .getHeight(null), transparency);
        } catch (HeadlessException e) {
        } // No screen

        if (bimage == null) {
            // Create a buffered image using the default color model
            int type = BufferedImage.TYPE_INT_RGB;
            if (hasAlpha == true) {
                type = BufferedImage.TYPE_INT_ARGB;
            }
            bimage = new BufferedImage(image.getWidth(null), image
                    .getHeight(null), type);
        }

        // Copy image to buffered image
        Graphics g = bimage.createGraphics();

        // Paint the image onto the buffered image
        g.drawImage(image, 0, 0, null);
        g.dispose();

        return bimage;
    }

    public static boolean hasAlpha(Image image) {
        // If buffered image, the color model is readily available
        if (image instanceof BufferedImage) {
            return ((BufferedImage) image).getColorModel().hasAlpha();
        }

        // Use a pixel grabber to retrieve the image's color model;
        // grabbing a single pixel is usually sufficient
        PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
        try {
            pg.grabPixels();
        } catch (InterruptedException e) {
        }

        // Get the image's color model
        return pg.getColorModel().hasAlpha();
    }

}
