package com.mycom.puzzle.number.domain;

import java.util.Iterator;

import org.junit.Test;

import junit.framework.Assert;

public class DictionaryTest {

    @Test
	public void testDictionary() {
		String[] words = {"one", "two"}; 
		Dictionary dict = Dictionary.createDictionary(words);
		
		Iterator<Word> allWords = dict.getAllWords();
		
		Assert.assertNotNull(allWords);
		Assert.assertTrue(allWords.hasNext());
		Assert.assertNotNull(allWords.next());
		Assert.assertTrue(allWords.hasNext());
		Assert.assertNotNull(allWords.next());
		Assert.assertFalse(allWords.hasNext());
	}
}
