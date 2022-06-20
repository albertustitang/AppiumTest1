package com.nexsoft.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CSortingTest {
	CSorting cs = new CSorting();

	@ParameterizedTest
	@DisplayName("Test Bubble Sort Split")
	@CsvFileSource(resources = "/data.csv", delimiter = ';', numLinesToSkip = 1)
	public void testBubbleSort(String angka) {

		String angkaS[] = angka.split(",");
		int panjang = angkaS.length;
		int angkaResult[] = new int[angkaS.length];
		int angkaExpected[] = new int[angkaS.length];
		for (int i = 0; i < 5; i++) {
			panjang--;
			if (panjang < 0) {
				break;
			} else {
				angkaExpected[i] = Integer.parseInt(angkaS[i]);
				angkaResult[i] = Integer.parseInt(angkaS[i]);
			}
		}
		cs.bubbleSort(angkaResult, angkaS.length);
		Arrays.sort(angkaExpected);
		assertArrayEquals(angkaExpected, angkaResult);

	}

}
