package com.example.ex1_calculator;

import java.util.List;

public class InputItem {
    private String value;
    private TYPE type;
    private List<TYPE> frontType;


    /*
    * 为了提高用户输入容错（如一个数字不能输入两个小数点、不能连续输入两个运算符等等），
    * 本系统将运算表达式字符分为：
    * NUM(数字型)，包括小数点和0-9的数字，可以连续输入数字型；
    * OPE(操作符)，包括加减乘除乘方，不能连续输入，它们前面和后面都必须加数字型或其他类型运算符
    * OPE_NUM(类操作符的数字型)，包括PI和e，叫OPE_NUM是因为它们像操作符一样不能直接加数字（如不能输入PI9，e8等），但又像数字一样可以加运算符
    * NUM_OPE(类数字型的操作符)，包括三角函数运算符,对数运算符，指数运算符，根号，叫NUM_OPE是因为它们前面像数字一样加操作符，后面像操作符一样加数字
    * OPE_OPE，包括倒数运算，阶乘运算和百分号运算，前面加数字，后面加操作符
    * LEFT_BRACKET(左括号)
    *  RIGHT_BRACKET(右括号)
    * */
    public static enum TYPE{
        NUM,        //'.'and'0-9'
        OPE,         //加减乘除 乘方
        OPE_NUM,   //PI,e
        NUM_OPE,   //sin,lg,ln,root,
        OPE_OPE,    //倒数，阶乘，,%
        LEFT_BRACKET,
        RIGHT_BRACKET,
    }

    public InputItem(){}

    public InputItem(String value, TYPE type){
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }
}
