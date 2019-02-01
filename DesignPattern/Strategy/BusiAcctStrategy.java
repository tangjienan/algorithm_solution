package DesignPattern.Strategy;

/**
 * Created by donezio on 1/30/19.
 */
public class BusiAcctStrategy implements Strategy {
    @Override
    public Double calRecharge(Double charge, RechargeTypeEnum type) {
        return charge*0.90;
    }
}
