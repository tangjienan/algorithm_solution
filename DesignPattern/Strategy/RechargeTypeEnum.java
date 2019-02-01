package DesignPattern.Strategy;

/**
 * Created by donezio on 1/30/19.
 */
public enum RechargeTypeEnum {

    E_BANK(1, "bank"),

    BUSI_ACCOUNTS(2, "account"),

    MOBILE(3,"mobile"),

    CARD_RECHARGE(4,"recharges");

    private int value;

    private String description;

    private RechargeTypeEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int value() {
        return value;
    }
    public String description() {
        return description;
    }


    public static RechargeTypeEnum valueOf(int value) {
        for(RechargeTypeEnum type : RechargeTypeEnum.values()) {
            if(type.value() == value) {
                return type;
            }
        }
        return null;
    }
}