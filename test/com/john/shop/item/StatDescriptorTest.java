package com.john.shop.item;

import com.john.shopbot.item.ArmorItemProperty;
import com.john.shopbot.item.ItemSearch;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Copyright CloudMine LLC
 * User: johnmccarthy
 * Date: 5/26/12, 11:51 PM
 */
public class StatDescriptorTest {

    @Test
    public void testSort() {
        List<ItemSearch.StatDescriptor> descriptors = new ArrayList<ItemSearch.StatDescriptor>();
        descriptors.add(new ItemSearch.StatDescriptor(ArmorItemProperty.ALL_RESISTANCE));
        descriptors.add(new ItemSearch.StatDescriptor(ArmorItemProperty.WITCH_D_ACID_CLOUD));
        descriptors.add(new ItemSearch.StatDescriptor(ArmorItemProperty.EXPERIENCE));
        Collections.sort(descriptors);

        assertEquals(ArmorItemProperty.WITCH_D_ACID_CLOUD, descriptors.get(0).property());
        assertEquals(ArmorItemProperty.EXPERIENCE, descriptors.get(1).property());
        assertEquals(ArmorItemProperty.ALL_RESISTANCE, descriptors.get(2).property());
    }
}
