package com.mycom.puzzle.number.service;

import java.util.ArrayList;
import java.util.List;

import com.mycom.puzzle.number.domain.NumberToWordMapper;
import com.mycom.puzzle.number.domain.PhoneNumber;
import com.mycom.puzzle.number.domain.Word;

/**
 * The class that uses the mapper to encode a phone number into corresponding words.
 * 
 */
public class Encoder {

	private final NumberToWordMapper mapper;

	public Encoder(NumberToWordMapper mapper) {
		this.mapper = mapper;
	}

	/**
	 * The method encodes the given {@link PhoneNumber} into a list of words. 
	 * 
	 * @param number the given {@link PhoneNumber} 
	 * @return a list of words that correspond to the given {@link PhoneNumber}. 
	 */
	public List<String> encode(PhoneNumber number) {
		return findWords(number.normalize(), false);
	}

	/**
	 * The method recursively computes all the possible words for the given number.  
	 * 
	 * @param number the given number
	 * @param leftIsDigit true if the left part of the number is encoded as a digit.
	 * @return a list of words corresponding to the given number.
	 */
	private List<String> findWords(final String number, final boolean leftIsDigit) {
		final List<String> result = new ArrayList<String>();
		addAllWords(result, mapper.getWords(number));
		if (number.length() == 1) {
			if (result.isEmpty() && !leftIsDigit) {
				result.add(number);
			}
			return result;
		}

		for (int i = 0; i < number.length() - 1; i++) {
			final String left = number.substring(0, i + 1);
			final String right = number.substring(i + 1);

			final List<String> leftWords = new ArrayList<String>();
			boolean currentLeftIsDigit = false;
			addAllWords(leftWords, mapper.getWords(left));

			if (!leftWords.isEmpty()) {
				final List<String> rightWords = findWords(right, currentLeftIsDigit);

				if (!rightWords.isEmpty()) {
					combineLeftAndRight(result, leftWords, rightWords);
				}
			}
		}
		
		if (result.isEmpty() && !leftIsDigit) {
			final String right = number.substring(1);
			final List<String> rightWords = findWords(right, true);
			if (!rightWords.isEmpty()) {
				final List<String> leftWords = new ArrayList<String>();
				leftWords.add(number.substring(0, 1));
				combineLeftAndRight(result, leftWords, rightWords);
			}
		}

		return result;
	}

	private void combineLeftAndRight(List<String> result,
			List<String> leftWords, List<String> rightWords) {
		for (String left : leftWords) {
			for (String right : rightWords) {
				result.add(left + " " + right);
			}
		}
	}

	private void addAllWords(List<String> result, List<Word> words) {
		for (Word word : words) {
			result.add(word.toString());
		}
	}
}
