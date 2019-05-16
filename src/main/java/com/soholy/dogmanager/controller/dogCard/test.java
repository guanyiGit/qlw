package com.soholy.dogmanager.controller.dogCard;

import com.soholy.dogmanager.common.utils.Md5Encode;

public class test {
    public static void main(String[] args) {
        String password= Md5Encode.getCredentials("ZhangTian","123456").toString();
        System.out.println(password);
    }
}
