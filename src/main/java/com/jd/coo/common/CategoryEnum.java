package com.jd.coo.common;

/**
 * Created by linlingyue on 2016/4/22.
 */
public enum CategoryEnum {

    CURRENT("c"),NEXTPLAN("p");

    public String getValue() {
        return value;
    }

    private String value ;

    private CategoryEnum(String value){
        this.value = value ;
    }



}
