package com.mycom.puzzle.number.domain;

import junit.framework.Assert;

import org.junit.Test;

public class PhoneNumberTest {

    @Test
	public void testWord() {
		String number = "0123-4567";
		PhoneNumber phoneNumber = new PhoneNumber(number);
		Assert.assertEquals(number, phoneNumber.toString());
	}

    @Test
	public void testWordNormalilze() {
		String number = "0123-4567";
		PhoneNumber phoneNumber = new PhoneNumber(number);

		String expectedResult = "01234567";
		Assert.assertEquals(expectedResult, phoneNumber.normalize());
	}
}
