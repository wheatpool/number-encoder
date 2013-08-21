package com.mycom.puzzle.number.service;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.mycom.puzzle.number.domain.Dictionary;
import com.mycom.puzzle.number.domain.NumberToWordMapper;
import com.mycom.puzzle.number.domain.PhoneNumber;

public class EncoderTest {

    private String[] dictWords = { "an", "blau", "Bo\"", "Boot", "bo\"s", "da",
        "Fee", "fern", "Fest", "fort", "je", "jemand", "mir", "Mix",
        "Mixer", "Name", "neu", "o\"d", "Ort", "so", "Tor", "Torf",
        "Wasser" };

    private Encoder encoder;

    @Before
    public void setUp() throws Exception {
        Dictionary dict = Dictionary.createDictionary(dictWords);
        NumberToWordMapper mapper = new NumberToWordMapper(dict);
        encoder = new Encoder(mapper);
    }

    @Test
    public void testEncoding1() {
        List<String> words = encoder.encode(new PhoneNumber("112"));
        String[] expectedValue = {};
        assertValues(expectedValue, words);
    }

    @Test
    public void testEncoding2() {
        List<String> words = encoder.encode(new PhoneNumber("5624-82"));
        String[] expectedValue = { "Mix Tor", "mir Tor" };
        assertValues(expectedValue, words);
    }

    @Test
    public void testEncoding3() {
        List<String> words = encoder.encode(new PhoneNumber("4824"));
        String[] expectedValue = { "fort", "Torf", "Tor 4" };
        assertValues(expectedValue, words);
    }

    @Test
    public void testEncoding4() {
        List<String> words = encoder.encode(new PhoneNumber("0721/608-4067"));
        String[] expectedValue = {};
        assertValues(expectedValue, words);
    }

    @Test
    public void testEncoding5() {
        List<String> words = encoder.encode(new PhoneNumber("10/783--5"));
        String[] expectedValue =
        	{ "je Bo\" da", "je bo\"s 5", "neu o\"d 5" };
        assertValues(expectedValue, words);
    }

    @Test
    public void testEncoding6() {
        List<String> words = encoder.encode(new PhoneNumber("1078-913-5"));
        String[] expectedValue = {};
        assertValues(expectedValue, words);
    }

    @Test
    public void testEncoding7() {
        List<String> words = encoder.encode(new PhoneNumber("381482"));
        String[] expectedValue = { "so 1 Tor" };
        assertValues(expectedValue, words);
    }

    @Test
    public void testEncoding8() {
        List<String> words = encoder.encode(new PhoneNumber("04824"));
        String[] expectedValue = { "0 fort", "0 Torf", "0 Tor 4" };
        assertValues(expectedValue, words);
    }

    private void assertValues(String[] expectedValue, List<String> words) {
        Assert.assertNotNull(words);
        Assert.assertEquals(expectedValue.length, words.size());
        for (int i = 0; i < expectedValue.length; i++) {
            Assert.assertEquals(expectedValue[i], words.get(i));
        }
    }
}
