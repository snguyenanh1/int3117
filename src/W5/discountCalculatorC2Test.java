package W5;

import W3.CustomerTier;
import W3.NegativeTotalException;
import W3.discountCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class discountCalculatorC2Test {
    @ParameterizedTest
    @CsvFileSource(resources = "validtestcase.csv", numLinesToSkip = 1)
    void testReturnDiscount_ValidOrderTotal (int id, CustomerTier customerTier, int orderTotal, int expectedDiscount) throws NegativeTotalException {
        int actualDiscount = discountCalculator.returnDiscount(customerTier, orderTotal);
        Assertions.assertEquals(expectedDiscount, actualDiscount);
    }

    @Test
    void testReturnDiscount_throwsException () {
        Assertions.assertThrows(NegativeTotalException.class, () -> {
            discountCalculator.returnDiscount(CustomerTier.COPPER, -100);
        });
    }
}
