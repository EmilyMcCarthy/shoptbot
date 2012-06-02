package com.john.shopbot.item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Copyright CloudMine LLC
 * User: johnmccarthy
 * Date: 5/26/12, 11:33 PM
 */
public class ItemSearchBuilder {

    private final List<ItemSearch.StatDescriptor> descriptors = new ArrayList<ItemSearch.StatDescriptor>(3);
    private ItemType item;
    private RarityType rarity;
    public ItemSearchBuilder property(Enum property, int value) {
        if(descriptors.size() == 3) {
            throw new IllegalStateException("Too many properties");
        }
        descriptors.add(new ItemSearch.StatDescriptor(property, value));
        return this;
    }

    public ItemSearchBuilder type(ItemType type) {
        this.item = type;
        return this;
    }

    public ItemSearchBuilder rarity(RarityType type) {
        this.rarity = type;
        return this;
    }

    public ItemSearch build() {
        if(rarity == null)
            rarity = RarityType.ALL;
        if(item == null)
            item = ItemType.ARMOR;
        Collections.sort(descriptors);
        return new ItemSearch(item, rarity, descriptors);
    }
}
