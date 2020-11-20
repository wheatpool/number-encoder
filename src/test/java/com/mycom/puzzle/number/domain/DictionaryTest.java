package com.mycom.puzzle.number.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class DictionaryTest {

    @Test
	public void testDictionary() {
		String[] words = {"one", "two"}; 
		Dictionary dict = Dictionary.createDictionary(words);
		
		Iterator<Word> allWords = dict.getAllWords();
		
		assertNotNull(allWords);
		assertTrue(allWords.hasNext());
		assertNotNull(allWords.next());
		assertTrue(allWords.hasNext());
		assertNotNull(allWords.next());
		assertFalse(allWords.hasNext());
	}
}
