package DesignPattern.Strategy;

/**
 * Created by donezio on 1/30/19.
 */
public class main {
    public static void main(String[] args) {
        Context context = new Context();
        // ????100 ?????
        Double money = context.calRecharge(100D,
                RechargeTypeEnum.E_BANK.value());
        System.out.println(money);

        // ??????100 ?????
        Double money2 = context.calRecharge(100D,
                RechargeTypeEnum.BUSI_ACCOUNTS.value());
        System.out.println(money2);

        // ????100 ?????
        Double money3 = context.calRecharge(100D,
                RechargeTypeEnum.MOBILE.value());
        System.out.println(money3);

        // ?????100 ?????
        Double money4 = context.calRecharge(100D,
                RechargeTypeEnum.CARD_RECHARGE.value());
        System.out.println(money4);
    }
}
