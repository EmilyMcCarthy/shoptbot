package com.john.shopbot.screen;

import com.john.shopbot.item.ArmorItemProperty;
import com.john.shopbot.item.ItemType;

/**
 * Copyright CloudMine LLC
 * User: johnmccarthy
 * Date: 5/26/12, 3:43 PM
 */
public class CharacterScreen extends Screen {

    public ScreenPosition AUCTION_HOUSE = new ScreenPosition(215, 621);

    public AuctionHouseScreen openAuctionHouse() {
        click(AUCTION_HOUSE);

        return new AuctionHouseScreen();
    }

    public static void main(String... args) {
        CharacterScreen screen = new CharacterScreen();
        screen.openAuctionHouse().openEquipmentScreen().item(ItemType.ARMOR)
                .statSlot(2, ArmorItemProperty.VITALITY, 20)
                .statSlot(1, ArmorItemProperty.STRENGTH, 20)
                .statSlot(0, ArmorItemProperty.ALL_RESISTANCE, 30)
                .search();
    }
}
