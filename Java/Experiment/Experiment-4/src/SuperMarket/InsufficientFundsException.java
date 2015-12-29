package SuperMarket;

/**
 * Created by nicholas on 15-12-28.
 */
public class InsufficientFundsException extends Exception {
    @Override
    public String getMessage() {
        return "金额不足!，无法购买";
    }
}
