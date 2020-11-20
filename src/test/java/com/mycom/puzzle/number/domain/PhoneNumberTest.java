package com.mycom.puzzle.number.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PhoneNumberTest {

    @Test
	public void testWord() {
		String number = "0123-4567";
		PhoneNumber phoneNumber = new PhoneNumber(number);
		assertEquals(number, phoneNumber.toString());
	}

    @Test
	public void testWordNormalilze() {
		String number = "0123-4567";
		PhoneNumber phoneNumber = new PhoneNumber(number);

		String expectedResult = "01234567";
		assertEquals(expectedResult, phoneNumber.normalize());
	}
}
