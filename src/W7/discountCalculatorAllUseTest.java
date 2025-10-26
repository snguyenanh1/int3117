package W7;

import W3.CustomerTier;
import W3.NegativeTotalException;
import W3.discountCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class discountCalculatorAllUseTest {
    @ParameterizedTest
    @CsvFileSource(resources = "testcase.csv", numLinesToSkip = 1)
    void testReturnDiscount_ValidOrderTotal (int id, CustomerTier customerTier, int orderTotal, int expectedDiscount) throws NegativeTotalException {
        int actualDiscount = discountCalculator.returnDiscount(customerTier, orderTotal);
        Assertions.assertEquals(expectedDiscount, actualDiscount);
    }
}
