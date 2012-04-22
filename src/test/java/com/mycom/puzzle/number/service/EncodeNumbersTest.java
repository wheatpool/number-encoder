package com.mycom.puzzle.number.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class EncodeNumbersTest {

    @Test
    public void testEncodeNumbers() throws FileNotFoundException, IOException {
        final String[] args = {"resources/dictionary.txt", "resources/input.txt"};
        EncodeNumbers.main(args);
    }
}
