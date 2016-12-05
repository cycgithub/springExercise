package com.domain.Utils;

/**
 * Created by chenyuchao on 2016/10/20.
 */
public enum BusinessTypeEnum {
        LOAN(1, "贷款"), REPAY(2, "还贷");
        private int code;
        private String description;

        BusinessTypeEnum(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public static BusinessTypeEnum valueOf(int value) {
            for (BusinessTypeEnum businessTypeEnum : values()) {
                if (businessTypeEnum.getCode() == value) {
                    return businessTypeEnum;
                }
            }

            throw new IllegalArgumentException("Unknown value for type BusinessTypeEnum: " + value);
        }

}
