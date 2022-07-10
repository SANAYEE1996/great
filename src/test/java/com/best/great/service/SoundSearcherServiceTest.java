package com.best.great.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SoundSearcherServiceTest {

    private SoundSearcherService soundsearcher;

    @BeforeEach
    public void setup(){
        soundsearcher = new SoundSearcherService();
    }

    @Test
    void test() {
        assertEquals(true, soundsearcher.isMatch("", ""));
        assertEquals(true, soundsearcher.isMatch("손흥민", "ㅅㅎㅁ"));
        assertEquals(true, soundsearcher.isMatch("손흥민", "ㅅ흥민"));
        assertEquals(true, soundsearcher.isMatch("흥민이형", "ㅎㅁ"));
        assertEquals(true, soundsearcher.isMatch("동해물과", "ㅎㅁ"));
        assertEquals(false, soundsearcher.isMatch("ㅅ", "ㅇ"));
        assertEquals(true, soundsearcher.isMatch(";z1aㅅㅇ", "aㅅ"));
        assertEquals(true, soundsearcher.isMatch("..1", "..1"));
        assertEquals(false, soundsearcher.isMatch("손흥민", "ㅅㅎㅁㅎㄴ"));

        assertEquals(true, soundsearcher.isMatch("이정재", "ㅇㅈㅈ"));
        assertEquals(true, soundsearcher.isMatch("정우성", "ㅈㅇ"));
        assertEquals(true, soundsearcher.isMatch("황정민", "ㅈㅁ"));
        assertEquals(true, soundsearcher.isMatch("이루", "ㅇ"));
        assertEquals(false, soundsearcher.isMatch("동해물과백두산이마르고닳도록하나님이보우하사우리나라만세", "ㅋㄴㄷ"));

    }


}
