package W3;

class NegativeTotalException extends Exception {
    public NegativeTotalException(String message) {
        super(message);
    }
}
public class discountCalculator {
    public static int returnDiscount(CustomerTier customerTier, int orderTotal) throws NegativeTotalException {
        if (orderTotal < 0) {
            throw new NegativeTotalException("Total amount cannot be negative.");
        }
        switch (customerTier) {
            case COPPER:
                return 0;
            case SILVER:
                if(orderTotal >= 3000000) return 10;
                else return 0;
            case GOLD:
                if (orderTotal >= 4000000) return 30;
                else if (orderTotal >= 3000000) return 20;
                else if (orderTotal >= 2000000) return 10;
                else return 0;
            case PLATINUM:
                if (orderTotal >= 3000000) return 30;
                else if (orderTotal >= 2000000) return 20;
                else return 0;
            default:
                return 0;
        }
    }

    public static void main(String[] args) throws NegativeTotalException {
        System.out.println(returnDiscount(CustomerTier.COPPER, 100));
    }
}
