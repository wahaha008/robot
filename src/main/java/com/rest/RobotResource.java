package com.rest;

import com.conf.Config;
import com.util.Msg;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: liqiang
 * @Version: 1.0
 * @Create Date Time: 2019-07-25 11:12
 * @Update Date Time:
 * @see
 */
@RestController
@RequestMapping("/robot")
@CrossOrigin(origins = "*")
@Component
public class RobotResource implements CommandLineRunner {

    Map<String, String> answers = new HashMap<>();

    @GetMapping("/answer/{question}")
    @ResponseBody
    public String getAnswer(@PathVariable("question") String question) {

        List<String> list = new ArrayList<>();
        Map<String, List<String>> response = new HashMap<>();

        //TODO ： 分词提取关键词

        answers.forEach((k, v) -> {
            if (k.contains(question)) {
                list.add(v);
                response.put(question, list);
            }
        });

        return new Msg<>(Msg.SUCCESS, response).toJson();
    }

    @Override
    public void run(String... args) throws Exception {

        String path = Config.getFile("path-dev");
//        String path = "N:\\语料\\raw_chat_corpus\\chinese_chatbot_corpus-master\\chinese_chatbot_corpus-master\\clean_chat_corpus\\xiaohuangji.tsv";
        String line = null;
        BufferedReader br = null;
        Map<String, String> map = new HashMap<>();

        try {
            br = new BufferedReader(new FileReader(new File(path))); // 与上等效

            while (null != (line = br.readLine())) {
                String question = line.split("\t")[0];
                String answer = line.split("\t")[1];
                map.put(question, answer);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.answers = map;
    }
}