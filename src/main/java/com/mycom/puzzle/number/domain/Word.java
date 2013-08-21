package com.mycom.puzzle.number.domain;

/**
 * The class defines a single word.
 * 
 */
public class Word {

	private static final String WORD_REGEX = "[a-zA-Z\"-]{1,50}";
	private final String word;

	// private String normalized;

	public Word(final String word) {
		if (word.matches(WORD_REGEX)) {
			this.word = word;
		} else {
			throw new IllegalArgumentException(word);
		}
	}

	/**
	 * Normalizes the word.
	 * 
	 * Removes ("), (-) and converts the word to lower case.
	 * 
	 * @return the normalized representation.
	 */
	public String normalize() {
		return word.replace("\"", "").replace("-", "").trim().toLowerCase();
	}

	@Override
	public String toString() {
		return word;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
		    return true;
		}
		if (obj == null) {
		    return false;
		}
		if (getClass() != obj.getClass()) {
		    return false;
		}
		final Word other = (Word) obj;
		if (word == null) {
			if (other.word != null) {
			    return false;
			}
		} else if (!word.equals(other.word)) {
		    return false;
		}
		return true;
	}
}
