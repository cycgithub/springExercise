package com.dataTrans;

import java.math.BigDecimal;

/**
 * Created by chenyuchao on 2016/8/2.
 */
public class Initial {
    private String name = "cyc";
    private Integer age = 20;
    private BigDecimal amount=new BigDecimal(0.00);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
