package com.mycom.puzzle.number.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * The Dictionary of all the words.
 * 
 */
public class Dictionary {
	private static final int MAX_WORDS = 75000;

	private Set<Word> words;

	private Dictionary() {
		words = new HashSet<Word>(MAX_WORDS);
	}

	public Iterator<Word> getAllWords() {
		return Collections.unmodifiableSet(words).iterator();
	}

	/**
	 * Factory method to create a Dictionary from an input stream.
	 * 
	 * @param input
	 *            input stream.
	 * @return An instance of the Dictionary.
	 * @throws IOException
	 *             exception if the stream could not be read.
	 */
	public static Dictionary createDictionary(final InputStream input) throws IOException {
		final Dictionary dict = new Dictionary();

		final BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		String line;
		while ((line = reader.readLine()) != null) {
			try {
				final Word word = new Word(line);
				dict.words.add(word);
			} catch (IllegalArgumentException e) {
				// TODO: Log
				System.err.println(e.toString());
			}
		}

		return dict;
	}

	/**
	 * Factory method to create a Dictionary from an array of words.
	 * 
	 * @param newWords
	 *            array of words
	 * @return An instance of the Dictionary.
	 */
	public static Dictionary createDictionary(final String[] newWords) {
		final Dictionary dict = new Dictionary();

		for (String oneWord : newWords) {
			try {
				final Word word = new Word(oneWord);
				dict.words.add(word);
			} catch (IllegalArgumentException e) {
				// TODO: Log
				System.err.println(e.toString());
			}
		}

		return dict;
	}
}
