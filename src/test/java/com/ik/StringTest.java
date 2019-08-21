package com.ik;

import org.junit.Test;

/**
 * @Description:
 * @Author: liqiang
 * @Version: 1.0
 * @Create Date Time: 2019-07-26 11:07
 * @Update Date Time:
 * @see
 */
public class StringTest {

    @Test
    public void testString() {
        String s = "这你都知道？";
        System.out.println(s.replaceAll("\\?", ""));
    }
}