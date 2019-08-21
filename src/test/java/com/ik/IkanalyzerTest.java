package com.ik;

import com.util.Ikanalyzer;
import org.junit.Test;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;

/**
 * @Description:
 * @Author: liqiang
 * @Version: 1.0
 * @Create Date Time: 2019-07-26 10:09
 * @Update Date Time:
 * @see
 */
public class IkanalyzerTest {

    @Test
    public void ik() {
        String text = "确认过眼神，爱上了女神";
        StringReader reader = new StringReader(text);
        IKSegmenter ik = new IKSegmenter(reader, true);
        Lexeme lexeme = null;

        try {
            while ((lexeme = ik.next()) != null) {
                System.out.print(lexeme.getLexemeText() + "|");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIkanalyzer() {
        System.out.println(Ikanalyzer.toSegmenter("确认过眼神，爱上了女神，我的女神是小美"));
    }
}