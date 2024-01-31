package com.example.board.util;

import com.example.board.controller.IndexController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Namer {

    private static Random random = new Random();

    private static String firstName() {
        List<String> names = Arrays.asList("화난", "귀여운", "걸어다니는", "심각한", "사랑스러운", "날고있는", "웃긴", "배고픈", "행복한", "우울한");
        return names.get(random.nextInt(names.size() - 1));
    }

    private static String lastName() {
        List<String> names = Arrays.asList("강아지", "고양이", "낙타", "펭귄", "라마", "타조", "비행기", "쿼카", "하마", "토끼");
        return names.get(random.nextInt(names.size() - 1));
    }

    public String getRandomNickname() {
        return String.format("%s%s%s", firstName(), lastName(), (int)(Math.random() * 100000));
    }


    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    public static void main(String[] args) {
        Namer namer = new Namer();
        logger.info("randomName : {}", namer.getRandomNickname());
    }
}
