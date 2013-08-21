package com.mycom.puzzle.number.domain;

/**
 * The Phone number
 * 
 */
public class PhoneNumber {
	private static final String PHONE_REGEX = "[0-9/-]{1,50}";
	private final String phoneNumber;

	public PhoneNumber(final String phoneNumber) {
		if (phoneNumber.matches(PHONE_REGEX)) {
			this.phoneNumber = phoneNumber;
		} else {
			throw new IllegalArgumentException(phoneNumber);
		}
	}

	public String normalize() {
		return phoneNumber.replace("/", "").replace("-", "").trim();
	}

	@Override
	public String toString() {
		return phoneNumber;
	}
}
