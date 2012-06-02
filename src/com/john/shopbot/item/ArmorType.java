package com.john.shopbot.item;

import com.john.shopbot.screen.EquipmentScreen;
import com.john.shopbot.screen.HasPoint;
import com.john.shopbot.screen.ScreenPosition;

/**
 * Copyright CloudMine LLC
 * User: johnmccarthy
 * Date: 5/26/12, 5:00 PM
 */
public enum ArmorType implements HasPoint {
    ALL, AMULET, BELT;
    private static int numCreated = 0;
    private static final int STARTING_POSITION = 455;
    private final ScreenPosition position;
    private ArmorType() {
        position = EquipmentScreen.itemSelect(STARTING_POSITION, ordinal());
    }

    public int x() {
        return position.x();
    }

    public int y() {
        return position.y();
    }

}
