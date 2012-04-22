package com.mycom.puzzle.number.domain;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class NumberToWordMapperTest {

    private String[] dictWords = { "an", "blau", "Bo\"", "Boot", "bo\"s", "da",
        "Fee", "fern", "Fest", "fort", "je", "jemand", "mir", "Mix",
        "Mixer", "Name", "neu", "o\"d", "Ort", "so", "Tor", "Torf",
        "Wasser" };

    private NumberToWordMapper mapper;

    @Before
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
        Assert.assertNotNull(words);
        Assert.assertEquals(expectedValue.length, words.size());
        for (int i = 0; i < expectedValue.length; i++) {
            Assert.assertEquals(expectedValue[i], words.get(i).toString());
        }
    }
}
