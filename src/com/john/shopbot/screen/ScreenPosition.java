package com.john.shopbot.screen;

/**
 * Copyright CloudMine LLC
 * User: johnmccarthy
 * Date: 5/26/12, 3:35 PM
 */
public class ScreenPosition implements HasPoint {
    public static class ScreenPoint {
        public final int x;
        public final int y;
        public ScreenPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public String toString() {
            return "X: " + x + ", Y: " + y;
        }
    }

    private final ScreenPoint point;

    public ScreenPosition(int x, int y) {
        point = new ScreenPoint(x, y);
    }

    public ScreenPoint getPoint() {
        return point;
    }

    public ScreenPosition changeX(int change) {
        return new ScreenPosition(x() + change, y());
    }

    public ScreenPosition changeY(int change) {
        return new ScreenPosition(x(), y() + change);
    }

    public int x() {
        return point.x;
    }

    public int y() {
        return point.y;
    }
}
