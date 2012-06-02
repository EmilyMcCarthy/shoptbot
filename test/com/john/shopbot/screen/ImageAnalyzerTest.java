package com.john.shopbot.screen;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Copyright CloudMine LLC
 * User: johnmccarthy
 * Date: 5/26/12, 2:13 PM
 */
public class ImageAnalyzerTest {

    @Test
    public void testIsAverageColor() throws IOException {

        BufferedImage image = ImageIO.read(new File("/Users/johnmccarthy/dev/workspace/shop/test/com/john/shopbot/screen/greenbanner.png"));

        Color pink = new Color(250, 128, 114);
        Color green = new Color(34, 139, 34);
        assertFalse(ImageAnalyzer.isAverageColor(image, pink));
        assertTrue(ImageAnalyzer.isAverageColor(image, green));
    }
}
