package com.john.shopbot.item;

import com.john.shopbot.screen.CharacterScreen;
import com.john.shopbot.screen.EquipmentScreen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Copyright CloudMine LLC
 * User: johnmccarthy
 * Date: 5/26/12, 4:49 PM
 */
public class ItemSearch {

    public static class StatDescriptor implements Comparable {
        private final Enum itemProperty;
        private final int minimumValue;

        public StatDescriptor(Enum itemProperty) {
            this(itemProperty, 0);
        }

        public StatDescriptor(Enum itemProperty, int minimumValue) {
            this.itemProperty = itemProperty;
            this.minimumValue = minimumValue;
        }

        public Enum property() {
            return itemProperty;
        }

        @Override
        public int compareTo(Object o) {
            StatDescriptor other = (StatDescriptor)o;
            return other.itemProperty.compareTo(itemProperty);
        }
    }

    private final List<StatDescriptor> searchParameters = new ArrayList<StatDescriptor>(3);
    private final ItemType itemType;
    private final RarityType rarityType;

    public ItemSearch(ItemType itemType, RarityType rarityType, StatDescriptor first, StatDescriptor second, StatDescriptor third) {
        this(itemType, rarityType);
        searchParameters.add(first);
        searchParameters.add(second);
        searchParameters.add(third);
    }

    public ItemSearch(ItemType itemType, RarityType rarityType, StatDescriptor first, StatDescriptor second) {
        this(itemType, rarityType);
        searchParameters.add(first);
        searchParameters.add(second);
    }

    public ItemSearch(ItemType itemType, RarityType rarityType, StatDescriptor first) {
        this(itemType, rarityType);
        searchParameters.add(first);
    }

    public ItemSearch(ItemType itemType, RarityType rarityType, List<StatDescriptor> descriptors) {
        this(itemType, rarityType);
        if(descriptors.size() > 3)
            throw new IllegalStateException("Can't have more then 3 properties");
        searchParameters.addAll(descriptors);
    }

    public ItemSearch(ItemType itemType, RarityType rarityType) {
        this.itemType = itemType;
        this.rarityType = rarityType;
    }

    public CharacterScreen runSearch(CharacterScreen screen) {
        Collections.sort(searchParameters);
        EquipmentScreen equipmentScreen =
                screen.openAuctionHouse()
                .openEquipmentScreen()
                .item(itemType)
                .rarity(rarityType);
        int i = 0;
        for(StatDescriptor descriptor : searchParameters) {
            equipmentScreen.statSlot(i, descriptor.property(), descriptor.minimumValue);
            i++;
        }
        equipmentScreen.search();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return equipmentScreen.exit();
    }

}
