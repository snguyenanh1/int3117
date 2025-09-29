package W3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class discountCalculatorTestWithDecisionTable {
    @ParameterizedTest
    @CsvFileSource(resources = "testcase/discountCalculatorTestWithDecisionTable_validdata.csv", numLinesToSkip = 1)
    void testReturnDiscount_ValidOrderTotal (int id, CustomerTier customerTier, int orderTotal, int expectedDiscount) throws NegativeTotalException {
        int actualDiscount = discountCalculator.returnDiscount(customerTier, orderTotal);
        Assertions.assertEquals(expectedDiscount, actualDiscount);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "testcase/discountCalculatorTestWithDecisionTable_invaliddata.csv", numLinesToSkip = 1)
    void testReturnDiscount_InvalidOrderTotal (int id, CustomerTier customerTier, int orderTotal, String expectedDiscount) {
        Assertions.assertThrows(NegativeTotalException.class, () -> {
            discountCalculator.returnDiscount(customerTier, orderTotal);
        });
    }
}
