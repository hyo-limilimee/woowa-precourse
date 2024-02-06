package christmas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.Model.Menu;
import org.junit.jupiter.api.Test;

public class MenuTest {
    @Test
    void testGetMenuName() {
        assertEquals("양송이수프", Menu.PINE_MUSHROOM_SOUP.getMenuName());
        assertEquals("타파스", Menu.TAPAS.getMenuName());
        assertEquals("시저샐러드", Menu.CAESAR_SALAD.getMenuName());
        assertEquals("티본스테이크", Menu.T_BONE_STEAK.getMenuName());
        assertEquals("바비큐립", Menu.BARBECUE_RIBS.getMenuName());
        assertEquals("해산물파스타", Menu.SEAFOOD_PASTA.getMenuName());
        assertEquals("크리스마스파스타", Menu.CHRISTMAS_PASTA.getMenuName());
        assertEquals("초코케이크", Menu.CHOCOLATE_CAKE.getMenuName());
        assertEquals("아이스크림", Menu.ICECREAM.getMenuName());
        assertEquals("제로콜라", Menu.ZERO_COLA.getMenuName());
        assertEquals("레드와인", Menu.RED_WINE.getMenuName());
        assertEquals("샴페인", Menu.CHAMPAGNE.getMenuName());
    }

    @Test
    void testGetMenuPrice() {
        assertEquals(6_000, Menu.PINE_MUSHROOM_SOUP.getMenuPrice());
        assertEquals(5_500, Menu.TAPAS.getMenuPrice());
        assertEquals(8_000, Menu.CAESAR_SALAD.getMenuPrice());
        assertEquals(55_000, Menu.T_BONE_STEAK.getMenuPrice());
        assertEquals(54_000, Menu.BARBECUE_RIBS.getMenuPrice());
        assertEquals(35_000, Menu.SEAFOOD_PASTA.getMenuPrice());
        assertEquals(25_000, Menu.CHRISTMAS_PASTA.getMenuPrice());
        assertEquals(15_000, Menu.CHOCOLATE_CAKE.getMenuPrice());
        assertEquals(5_000, Menu.ICECREAM.getMenuPrice());
        assertEquals(3_000, Menu.ZERO_COLA.getMenuPrice());
        assertEquals(60_000, Menu.RED_WINE.getMenuPrice());
        assertEquals(25_000, Menu.CHAMPAGNE.getMenuPrice());
    }

    @Test
    void testGetMenuType() {
        assertEquals("appetizer", Menu.PINE_MUSHROOM_SOUP.getMenuType());
        assertEquals("appetizer", Menu.TAPAS.getMenuType());
        assertEquals("appetizer", Menu.CAESAR_SALAD.getMenuType());
        assertEquals("main", Menu.T_BONE_STEAK.getMenuType());
        assertEquals("main", Menu.BARBECUE_RIBS.getMenuType());
        assertEquals("main", Menu.SEAFOOD_PASTA.getMenuType());
        assertEquals("main", Menu.CHRISTMAS_PASTA.getMenuType());
        assertEquals("dessert", Menu.CHOCOLATE_CAKE.getMenuType());
        assertEquals("dessert", Menu.ICECREAM.getMenuType());
        assertEquals("drink", Menu.ZERO_COLA.getMenuType());
        assertEquals("drink", Menu.RED_WINE.getMenuType());
        assertEquals("drink", Menu.CHAMPAGNE.getMenuType());
    }
}
