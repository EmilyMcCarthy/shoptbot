package com.john.shopbot;

import com.john.shopbot.screen.HasPoint;
import com.john.shopbot.screen.ScreenPosition;

/**
 * Copyright CloudMine LLC
 * User: johnmccarthy
 * Date: 5/26/12, 4:30 PM
 */
public enum CharacterClass implements HasPoint {
    PLAYER(326, 335), BARBARIAN(326, 375), DEMON_HUNTER(326, 405), MONK(326, 435), WITCH_DOCTOR(326, 465), WIZARD(326, 495);

    private final ScreenPosition equipmentPosition;

    private CharacterClass(int x, int y) {
        equipmentPosition = new ScreenPosition(x, y);
    }

    public ScreenPosition position() {
        return equipmentPosition;
    }

    public int x() {
        return equipmentPosition.x();
    }

    public int y() {
        return equipmentPosition.y();
    }
}
