package com.mycom.puzzle.number.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberToWordMapperTest {

    private String[] dictWords = { "an", "blau", "Bo\"", "Boot", "bo\"s", "da",
        "Fee", "fern", "Fest", "fort", "je", "jemand", "mir", "Mix",
        "Mixer", "Name", "neu", "o\"d", "Ort", "so", "Tor", "Torf",
        "Wasser" };

    private NumberToWordMapper mapper;

    @BeforeEach
    public void setUp() throws Exception {
        Dictionary dict = Dictionary.createDictionary(dictWords);
        mapper = new NumberToWordMapper(dict);
    }

    @Test
    public void testMapper1() {
        List<Word> words = mapper.getWords("112");
        String[] expectedValue = { };
        assertValues(expectedValue, words);
    }

    @Test
    public void testMapper2() {
        List<Word> words = mapper.getWords("4824");
        String[] expectedValue = { "fort", "Torf" };
        assertValues(expectedValue, words);
    }
    
    private void assertValues(String[] expectedValue, List<Word> words) {
        assertNotNull(words);
        assertEquals(expectedValue.length, words.size());
        for (int i = 0; i < expectedValue.length; i++) {
            assertEquals(expectedValue[i], words.get(i).toString());
        }
    }
}
