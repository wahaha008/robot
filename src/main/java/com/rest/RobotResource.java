package com.rest;

import com.conf.Config;
import com.util.Ikanalyzer;
import com.util.Msg;
import lombok.extern.slf4j.Slf4j;
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
 * // TODO： 添加天气接口
 */
@RestController
@RequestMapping("/robot")
@CrossOrigin(origins = "*")
@Component
@Slf4j
public class RobotResource implements CommandLineRunner {

    Map<String, String> answers = new HashMap<>();

    /**
     * 问答接口
     * @param question 请求的问句
     * @return  返回对应问句的回答列表
     */
    @GetMapping("/answer/{question}")
    @ResponseBody
    public String getAnswer(@PathVariable("question") String question) {

        List<String> list = new    ArrayList<>();
        Map<String, List<String>> response = new HashMap<>();

        //TODO ： 分词提取关键词、语料问答训练
        String result = Ikanalyzer.toSegmenter(question)
                .split("|")
                [0];

        answers.forEach((k, v) -> {
            if (k.contains(question.replaceAll("？", ""))) {
                list.add(v);
                response.put(question, list);
            }
        });

        return new Msg<>(Msg.SUCCESS, response).toJson();
    }

    /**
     * 预读文件，启动服务时候就调用次方法，加快响应时间
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {

//        String path = Config.getFile("path-dev");
        String path = "N:\\语料\\raw_chat_corpus\\chinese_chatbot_corpus-master\\chinese_chatbot_corpus-master\\clean_chat_corpus\\xiaohuangji.tsv";
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
        log.info("the all answers size is {}.", answers.size());
    }
}