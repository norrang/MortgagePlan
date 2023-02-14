package com.norrang.mortgageplan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UtilsTests {

    @Test
    void testPowerOfWithIntExponent() {
        // Test 5^1 = 5
        Assertions.assertEquals(5, Utils.powerOf(5,1));

        // Test 2^2 = 4
        Assertions.assertEquals(4, Utils.powerOf(2,2));
    }

    @Test
    void testPowerOfWithDoubleExponent() {
        // Test 2.5^3 = 15.625
        Assertions.assertEquals(15.625, Utils.powerOf(2.5, 3));
    }

    @Test
    void testPowerOfWithZeroExponent() {
        // Test 2.5^3 = 15.625
        Assertions.assertEquals(1, Utils.powerOf(5, 0));
    }

    @Test
    void testPowerOfWithNegativeExponent() {
        // Test 3^-1 ≈ 1/3
        Assertions.assertEquals(0.3333333333333333, Utils.powerOf(3, -1));

        // Test 3^-3 ≈ 1/27
        Assertions.assertEquals(0.037037037037037035, Utils.powerOf(3, -3));
    }

    @Test
    void testCalculateMortgage() {
        // Test with the first example, a loan of 1000€ and 5% yearly interest over 2 years.
        Assertions.assertEquals(43.8713897340686, Utils.calculateMortgage(1000,0.05,2));
    }

    @Test
    void testRounding() {
        Assertions.assertEquals(12.34, Utils.round(12.336 * 100) / 100);
        Assertions.assertEquals(27.00, Utils.round(26.999 * 100) / 100);
    }

}
