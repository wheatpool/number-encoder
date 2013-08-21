package com.mycom.puzzle.number.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Mapping between the numeric representation of a word to all the words having
 * the same numeric representation.
 * 
 */
public class NumberToWordMapper {

	/**
	 * This constant array holds the number to character mapping.
	 */
	private static final String LETTER_MAPPING[] = { "e", "jnq", "rwx", "dsy",
			"ft", "am", "civ", "bku", "lop", "ghz" };
	
	final private Map<String, List<Word>> numberToWords;

	public NumberToWordMapper(final Dictionary dict) {
		numberToWords = new HashMap<String, List<Word>>();

		for (Iterator<Word> allWords = dict.getAllWords(); allWords.hasNext();) {
			final Word word = allWords.next();
			final String number = convertToNumber(word);
			addNumber(number, word);
		}
	}

	private void addNumber(final String number, final Word word) {
		List<Word> list = numberToWords.get(number);
		if (list == null) {
			list = new ArrayList<Word>();
			numberToWords.put(number, list);
		}

		list.add(word);
	}

	private String convertToNumber(final Word word) {
		final String normalWord = word.normalize();
		final StringBuilder sb = new StringBuilder();

		for (char ch : normalWord.toCharArray()) {
			for (int i = 0; i < 10; i++) {
				if (LETTER_MAPPING[i].indexOf(ch) >= 0) {
					sb.append(i);
					break;
				}
			}
		}

		return sb.toString();
	}

	/**
	 * Returns a list of words that match this number representation.
	 * 
	 * @param number
	 *            the number to search for
	 * @return Returns a list of words that match this number representation,
	 *         empty list if non found.
	 */
	public List<Word> getWords(final String number) {
		List<Word> result = numberToWords.get(number);
		if (result == null) {
			result = Collections.EMPTY_LIST;
		}
		return Collections.unmodifiableList(result);
	}
}
