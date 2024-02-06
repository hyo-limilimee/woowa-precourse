package christmas.Model;

public enum Menu {
    PINE_MUSHROOM_SOUP("양송이수프", 6_000, "appetizer"),
    TAPAS("타파스", 5_500, "appetizer"),
    CAESAR_SALAD("시저샐러드", 8_000, "appetizer"),
    T_BONE_STEAK("티본스테이크", 55_000, "main"),  // Corrected the price
    BARBECUE_RIBS("바비큐립", 54_000, "main"),
    SEAFOOD_PASTA("해산물파스타", 35_000, "main"),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, "main"),
    CHOCOLATE_CAKE("초코케이크", 15_000, "dessert"),
    ICECREAM("아이스크림", 5_000, "dessert"),
    ZERO_COLA("제로콜라", 3_000, "drink"),
    RED_WINE("레드와인", 60_000, "drink"),
    CHAMPAGNE("샴페인", 25_000, "drink");

    private final String menuName;
    private final int menuPrice;
    private final String menuType;

    Menu(String menuName, int menuPrice, String menuType) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuType = menuType;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public String getMenuType() {
        return menuType;
    }
}
