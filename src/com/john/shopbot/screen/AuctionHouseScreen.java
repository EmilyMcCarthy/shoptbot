package com.john.shopbot.screen;

/**
 * Copyright CloudMine LLC
 * User: johnmccarthy
 * Date: 5/26/12, 3:45 PM
 */
public class AuctionHouseScreen extends Screen {
    public static final ScreenPosition OK_BUY_PIXEL_CHECK = new ScreenPosition(813, 468);
    public static final ScreenPosition OK_BUY = new ScreenPosition(889, 469);
    public static final ScreenPosition BUY_PIXEL_CHECK = new ScreenPosition(1244, 867);
    public static final ScreenPosition BUY = new ScreenPosition(1311, 852);
    public static final ScreenPosition CONFIRM_BUY = new ScreenPosition(736, 706);
    public static final ScreenPosition SEARCH = new ScreenPosition(515, 154);
    public static final ScreenPosition EQUIPMENT = new ScreenPosition(389, 222);
    public static final ScreenPosition START_BUY_POSITION = new ScreenPosition(867, 313);
    private static final int BUY_ITEMS_PER_PAGE = 11;
    private static final int BUY_ITEM_LENGTH = 44;
    public EquipmentScreen openEquipmentScreen() {
        click(SEARCH);
        click(EQUIPMENT);

        return new EquipmentScreen();
    }

    public static void main(String... args) {

        AuctionHouseScreen ah = new AuctionHouseScreen();
        ah.click();


    }

    public void buyAll() {
        ScreenPosition buyPosition = START_BUY_POSITION;
        for(int i = 0; i < BUY_ITEMS_PER_PAGE; i++) {
            buy(buyPosition);
            buyPosition = buyPosition.changeY(BUY_ITEM_LENGTH);
        }

    }

    public void buy(ScreenPosition toBuy) {
        click(toBuy);
        move(BUY);
        if(isButtonClickable(BUY_PIXEL_CHECK)) {
            click(BUY);
            robot.delay(500);
            click(CONFIRM_BUY);
            waitForClickable(OK_BUY_PIXEL_CHECK);
            click(OK_BUY);
        }
    }
}
