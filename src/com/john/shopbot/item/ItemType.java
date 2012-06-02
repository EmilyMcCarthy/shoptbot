package com.john.shopbot.item;

import com.john.shopbot.screen.EquipmentScreen;
import com.john.shopbot.screen.HasPoint;
import com.john.shopbot.screen.ScreenPosition;

/**
 * Copyright CloudMine LLC
 * User: johnmccarthy
 * Date: 5/26/12, 4:50 PM
 */
public enum ItemType implements HasPoint {
    ONE_HAND, TWO_HAND, OFF_HAND, ARMOR, FOLLOWER;

    private static final int START_Y = 413;

    private final ScreenPosition position;

    private ItemType() {
        position = EquipmentScreen.itemSelect(START_Y, ordinal());
    }

    private ItemType(int y) {
        this(EquipmentScreen.DEFAULT_X, y);
    }

    private ItemType(int x, int y) {
        position = new ScreenPosition(x, y);
    }

    public int x() {
        return position.x();
    }

    public int y() {
        return position.y();
    }

}
