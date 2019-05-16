package com.soholy.dogmanager.service.member.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CodeFactory {

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyMMdd");
    /**
     * 随即编码
     */
    private static final int[] r = new int[]{7, 9, 6, 2, 8, 1, 3, 0, 5, 4};


    /**
     * 生成固定长度的随机码
     *
     * @param len
     * @param isPerfix
     * @return
     */
    public static String generateCode(long len, boolean isPerfix) {
        long min = 1, max = 9;
        for (int i = 1; i < len; i++) {
            min *= 10;
            max *= 10;
        }
        long result = (((long) (new Random().nextDouble() * (max - min)))) + min;
        return isPerfix ? perfix() + result : String.valueOf(result);
    }


    public static String perfix() {
        return LocalDate.now().format(fmt);
    }

}
