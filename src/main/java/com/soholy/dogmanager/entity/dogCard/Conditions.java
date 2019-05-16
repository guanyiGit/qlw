package com.soholy.dogmanager.entity.dogCard;

//封装查询条件的对象
public class Conditions {
    private static final long serialVersionUID = 1L;

    private String name;//条件文字描述含义
    private Integer value;//条件值

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Conditions{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
