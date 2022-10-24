package com.best.great.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.math.BigDecimal;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class SoundSearcherTest {

    private SoundSearcher soundsearcher;

    @BeforeEach
    public void setup(){
        soundsearcher = new SoundSearcher();
    }

    @Test
    void test() {
        assertTrue(soundsearcher.isMatch("", ""));
        assertTrue(soundsearcher.isMatch("손흥민", "ㅅㅎㅁ"));
        assertTrue(soundsearcher.isMatch("손흥민", "ㅅ흥민"));
        assertTrue(soundsearcher.isMatch("흥민이형", "ㅎㅁ"));
        assertTrue(soundsearcher.isMatch("동해물과", "ㅎㅁ"));
        assertFalse(soundsearcher.isMatch("ㅅ", "ㅇ"));
        assertTrue(soundsearcher.isMatch(";z1aㅅㅇ", "aㅅ"));
        assertTrue(soundsearcher.isMatch("..1", "..1"));
        assertFalse(soundsearcher.isMatch("손흥민", "ㅅㅎㅁㅎㄴ"));

        assertTrue(soundsearcher.isMatch("이정재", "ㅇㅈㅈ"));
        assertTrue(soundsearcher.isMatch("정우성", "ㅈㅇ"));
        assertTrue(soundsearcher.isMatch("황정민", "ㅈㅁ"));
        assertTrue(soundsearcher.isMatch("이루", "ㅇ"));
        assertFalse(soundsearcher.isMatch("동해물과백두산이마르고닳도록하나님이보우하사우리나라만세", "ㅋㄴㄷ"));
    }

    @Test
    void timeOutTest() throws FileNotFoundException {
        InputStream in = new FileInputStream("./src/test/java/textFile/longText.txt");
        InputStreamReader reader = new InputStreamReader(in);
        String line = "";
        try(BufferedReader br = new BufferedReader(reader)) {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long start, end;
        start = System.nanoTime();
        soundsearcher.isMatch(line, "ㅂㅇㅅ");
        end = System.nanoTime();
        BigDecimal time = BigDecimal.valueOf(((double) (end - start)) / 1000000000);
        System.out.println(time);
        assertTimeoutPreemptively(Duration.ofMillis(end-start), () -> Thread.sleep(1));
    }


}
