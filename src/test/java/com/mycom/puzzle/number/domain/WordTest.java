package com.mycom.puzzle.number.domain;

import org.junit.Test;

import junit.framework.Assert;

public class WordTest {

    @Test
	public void testWord() {
		String text = "word";
		Word word = new Word(text);
		Assert.assertEquals(text, word.toString());
	}

    @Test
	public void testWordNormalilze() {
		String text = "\"W-o-r-d\"";
		Word word = new Word(text);

		String expectedResult = "word";
		Assert.assertEquals(expectedResult, word.normalize());
	}
}
