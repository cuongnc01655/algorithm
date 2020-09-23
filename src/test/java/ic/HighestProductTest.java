package ic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HighestProductTest {
    HighestProduct prod = new HighestProduct();

    @Test
    public void shortArrayTest() {
        final int actual = prod.highestProductOf3(new int[] {1, 2, 3, 4});
        final int expected = 24;
        assertEquals(expected, actual);
    }

    @Test
    public void longerArrayTest() {
        final int actual = prod.highestProductOf3(new int[] {6, 1, 3, 5, 7, 8, 2});
        final int expected = 336;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasOneNegativeTest() {
        final int actual = prod.highestProductOf3(new int[] {-5, 4, 8, 2, 3});
        final int expected = 96;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasTwoNegativesTest() {
        final int actual = prod.highestProductOf3(new int[] {-10, 1, 3, 2, -10});
        final int expected = 300;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayIsAllNegativesTest() {
        final int actual = prod.highestProductOf3(new int[] {-5, -1, -3, -2});
        final int expected = -6;
        assertEquals(expected, actual);
    }

//    @Test(expected = Exception.class)
//    public void exceptionWithEmptyArrayTest() {
//        prod.highestProductOf3(new int[] {});
//    }
//
//    @Test(expected = Exception.class)
//    public void exceptionWithOneNumberTest() {
//        prod.highestProductOf3(new int[] {1});
//    }
//
//    @Test(expected = Exception.class)
//    public void exceptionWithTwoNumbersTest() {
//        prod.highestProductOf3(new int[] {1, 1});
//    }
}