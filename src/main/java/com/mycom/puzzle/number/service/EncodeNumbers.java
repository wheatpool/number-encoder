package com.mycom.puzzle.number.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.mycom.puzzle.number.domain.Dictionary;
import com.mycom.puzzle.number.domain.NumberToWordMapper;
import com.mycom.puzzle.number.domain.PhoneNumber;

/**
 * The main class.
 * 
 * Usage: EncodeNumber dict-file number-file
 * 
 */
public class EncodeNumbers {

	public static void main(final String[] args) throws FileNotFoundException,
			IOException {
		if (args.length == 2) {
			BufferedReader br = null;
			FileInputStream dictFile = null;
			try {
				dictFile = new FileInputStream(args[0]);
				final Dictionary dict = Dictionary.createDictionary(dictFile);
				final NumberToWordMapper mapper = new NumberToWordMapper(dict);
				final Encoder encoder = new Encoder(mapper);

				br = new BufferedReader(new FileReader(args[1]));
				String number;
				while ((number = br.readLine()) != null) {
					final PhoneNumber phoneNumber = new PhoneNumber(number);
					final List<String> result = encoder.encode(phoneNumber);
					
					for (String text : result) {
						System.out.println(phoneNumber.toString() + ": " + text);
					}
				}
			} finally {
				if (dictFile != null) {
					dictFile.close();
				}
				
				if (br != null) {
					br.close();
				}
			}
		} else {
			System.out
					.println("Expected format: EncodeNumbers dict-file number-file");
		}
	}
}
