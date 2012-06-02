package com.john.shopbot.screen;

import com.john.shopbot.CharacterClass;
import com.john.shopbot.item.ArmorItemProperty;
import com.john.shopbot.item.ArmorType;
import com.john.shopbot.item.ItemType;
import com.john.shopbot.item.RarityType;

import java.awt.event.KeyEvent;

/**
 * Copyright CloudMine LLC
 * User: johnmccarthy
 * Date: 5/26/12, 3:59 PM
 */
public class EquipmentScreen extends AuctionHouseScreen {

    public static final ScreenPosition CHARACTER_SELECT = new ScreenPosition(511, 297);
    public static final ScreenPosition ITEM_SELECT = new ScreenPosition(511, 372);
    public static final ScreenPosition ITEM_TYPE = new ScreenPosition(511, 414);
    public static final ScreenPosition RARITY_TYPE = new ScreenPosition(511, 494);
    public static final ScreenPosition BUYOUT = new ScreenPosition(505, 741);
    public static final ScreenPosition SEARCH = new ScreenPosition(414, 814);

    public static final ScreenPosition SLOT_1_VALUE = new ScreenPosition(513, 577);
    public static final ScreenPosition SLOT_2_VALUE = new ScreenPosition(513, 616);
    public static final ScreenPosition SLOT_3_VALUE = new ScreenPosition(513, 655);
    public static final ScreenPosition[] SLOT_VALUES = {SLOT_1_VALUE, SLOT_2_VALUE, SLOT_3_VALUE};
    public static final ScreenPosition SLOT_1 = new ScreenPosition(466, 578);
    public static final ScreenPosition SLOT_2 = new ScreenPosition(466, 615);
    public static final ScreenPosition SLOT_3 = new ScreenPosition(466, 655);
    private static final ScreenPosition[] SLOTS = { SLOT_1, SLOT_2,  SLOT_3};
    public static final ScrollableList SLOT_1_LIST = new ScrollableList(SLOT_1, new ScreenPosition(640, 901));
    public static final ScrollableList SLOT_2_LIST = new ScrollableList(SLOT_2, new ScreenPosition(640, 938));
    public static final ScrollableList SLOT_3_LIST = new ScrollableList(SLOT_3, new ScreenPosition(640, 974));
    public static final ScrollableList[] SLOT_LISTS = { SLOT_1_LIST, SLOT_2_LIST, SLOT_3_LIST};

    public static final int DEFAULT_X = 403;
    public static final int MENU_ITEM_HEIGHT = 32;
    private final CharacterClass characterClass;
    private final ItemType itemType;

    public EquipmentScreen() {
        this(CharacterClass.PLAYER, ItemType.ONE_HAND);
    }

    private EquipmentScreen(CharacterClass characterClass, ItemType itemType) {
        this.characterClass = characterClass;
        this.itemType = itemType;
    }

    public EquipmentScreen select(CharacterClass toSelect) {
        click(CHARACTER_SELECT);
        click(toSelect.position());
        return new EquipmentScreen(toSelect, itemType);
    }

    public EquipmentScreen rarity(RarityType rarity) {
        click(RARITY_TYPE);
        click(rarity);
        return this;
    }

    public EquipmentScreen statSlot(int slotPosition, Enum property, int value) {
        return statSlot(slotPosition, property.ordinal(), value);
    }

    public EquipmentScreen statSlot(int slotPosition, int propertyPosition, int value) {
        SLOT_LISTS[slotPosition].select(propertyPosition);
        click(SLOT_VALUES[slotPosition]);
        type(value);
        return this;
    }

    public EquipmentScreen buyout(int amount) {
        click(BUYOUT);
        write(amount);
        return this;
    }

    public CharacterScreen exit() {
        type(KeyEvent.VK_ESCAPE);
        if(isBannerVisible()) {
            return new CharacterScreen();
        }
        return exit();
    }

    public EquipmentScreen search() {
        click(SEARCH);
        return this;
    }

    public EquipmentScreen armor(ArmorType armor) {
        EquipmentScreen armorSelected = item(ItemType.ARMOR);
        click(ITEM_TYPE);
        click(armor);
        return armorSelected;
    }

    public EquipmentScreen item(ItemType item) {
        click(ITEM_SELECT);
        click(ItemType.ARMOR);
        return new EquipmentScreen(characterClass, item);
    }

    public static ScreenPosition itemSelect(int startY, int ordinal) {
        return  new ScreenPosition(EquipmentScreen.DEFAULT_X, startY + ordinal * EquipmentScreen.MENU_ITEM_HEIGHT);
    }

    public static void main(String... args) {

        EquipmentScreen screen = new EquipmentScreen(CharacterClass.BARBARIAN, ItemType.ARMOR);
        screen.click();
        screen
                .item(ItemType.ARMOR)
                .statSlot(0, ArmorItemProperty.ALL_RESISTANCE, 40)
                .statSlot(1, ArmorItemProperty.VITALITY, 30)
                .statSlot(2, ArmorItemProperty.DEXTERITY, 60)
                .search();
    }

}
