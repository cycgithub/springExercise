package com.dataTrans;


/**
 * 还款方式枚举
 * @author chenyuchao
 * @date 2016/8/24.
 */
public enum RepayWayEnum {

    MANUAL("01","主动还贷"),
    EXPIRE("02","到期账扣"),
    AUTO_DAY("03","按天自动还款"),
    OVERDUE("04","逾期还款"),
    SETTLE("05","结算单自动还款"),
    WY_ORDER("06","结算单（网银挂单）自动还款"),
    OFFLINE("07","线下还款"),
    JING_REPAY("08","京户通还款"),
    ;

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    RepayWayEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}

