package com.john.shopbot.item;

import com.john.shopbot.screen.EquipmentScreen;
import com.john.shopbot.screen.HasPoint;
import com.john.shopbot.screen.ScreenPosition;

/**
 * Copyright CloudMine LLC
 * User: johnmccarthy
 * Date: 5/26/12, 5:36 PM
 */
public enum RarityType implements HasPoint {
    ALL, INFERIOR, NORMAL, SUPERIOR, MAGIC, RARE, LEGENDARY;
    private static final int START_Y = 538;

    private final ScreenPosition position;

    private RarityType() {
        position = EquipmentScreen.itemSelect(START_Y, ordinal());
    }

    public int x() {
        return position.x();
    }

    public int y() {
        return position.y();
    }
}
