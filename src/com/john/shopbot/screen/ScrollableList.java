package com.john.shopbot.screen;

/**
 * Copyright CloudMine LLC
 * User: johnmccarthy
 * Date: 5/26/12, 6:34 PM
 */
public class ScrollableList extends Screen {

    private static final int[] CLICKS = { 2, 2, 3};

    private final ScreenPosition scrollDownPosition;
    private final ScreenPosition listStartPosition;
    private final ScreenPosition openListPosition;
    private final int elementsPerScreen;

    //40
    public ScrollableList(ScreenPosition openListPosition, ScreenPosition scrollDownPosition) {
        this(openListPosition, 10, openListPosition.changeY(40), scrollDownPosition);
    }

    public ScrollableList(ScreenPosition openListPosition, int elementsPerScreen, ScreenPosition listStartPosition, ScreenPosition scrollDownPosition) {
        super();
        this.openListPosition = openListPosition;
        this.elementsPerScreen = elementsPerScreen;
        this.scrollDownPosition = scrollDownPosition;
        this.listStartPosition = listStartPosition;
    }

    public void openList() {
        click(openListPosition);
    }

    public void select(int element) {
        openList();
        if(element > elementsPerScreen) {
            System.out.println("Scrolling the screen");
            int scrollAmount = element - (element % elementsPerScreen);
            element = element % elementsPerScreen;
            scroll(scrollAmount);

        }
        click(listStartPosition.changeY(EquipmentScreen.MENU_ITEM_HEIGHT * (element)));
    }

    public void scroll(int amount) {
        for(int i = 0; i < amount; i++) {
            for(int clickTimes = 0; clickTimes < CLICKS[i % CLICKS.length]; clickTimes++) {
                fastClick(scrollDownPosition);
            }
        }
    }

//2, 2, 3

}
