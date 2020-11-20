package com.mycom.puzzle.number.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WordTest {

    @Test
	public void testWord() {
		String text = "word";
		Word word = new Word(text);
		assertEquals(text, word.toString());
	}

    @Test
	public void testWordNormalilze() {
		String text = "\"W-o-r-d\"";
		Word word = new Word(text);

		String expectedResult = "word";
		assertEquals(expectedResult, word.normalize());
	}
}
