package com.util;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;

/**
 * @Description:
 * @Author: liqiang
 * @Version: 1.0
 * @Create Date Time: 2019-07-26 10:17
 * @Update Date Time:
 * @see
 */
public class Ikanalyzer {

    /**
     * 将句子分词后返回
     * @param text
     * @return
     */
    public static String toSegmenter(String text) {

        StringReader reader = new StringReader(text);
        IKSegmenter ik = new IKSegmenter(reader, true);
        Lexeme lexeme = null;
        String result = null;
        try {
            while ((lexeme = ik.next()) != null) {
                System.out.print(lexeme.getLexemeText() + "|");
                result = lexeme.getLexemeText() + "|";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}