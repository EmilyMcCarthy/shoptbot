package com.john.shopbot.screen;

import com.john.shopbot.item.ArmorItemProperty;
import com.john.shopbot.item.ItemSearch;
import com.john.shopbot.item.ItemSearchBuilder;
import com.john.shopbot.item.ItemType;

/**
 * Copyright CloudMine LLC
 * User: johnmccarthy
 * Date: 5/26/12, 4:03 PM
 */
public class RobotRunner {

    private static long WAIT_TIME = 1000 * 3;

    public static void waitForDiablo() {
        try {
            Thread.sleep(WAIT_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void runForever(ItemSearch... toSearchFor) {
        CharacterScreen screen = new CharacterScreen();
        screen.click();

        for(ItemSearch searchItem : toSearchFor) {
            searchItem.runSearch(screen);
        }

    }

    public static void main(String... args) {
        CharacterScreen screen = new CharacterScreen();
        screen.click();

        ItemSearch allResVit = new ItemSearchBuilder().type(ItemType.ARMOR).property(ArmorItemProperty.ALL_RESISTANCE, 40)
                                                    .property(ArmorItemProperty.VITALITY, 30)
                                                    .build();

        ItemSearch allResIAS = new ItemSearchBuilder().type(ItemType.ARMOR).property(ArmorItemProperty.ALL_RESISTANCE, 20)
                .property(ArmorItemProperty.ATTACK_SPEED, 15)
                .build();
        runForever(allResVit, allResIAS);
    }
}
