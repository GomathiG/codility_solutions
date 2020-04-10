package com.java.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class BinaryGap {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		String binary = Integer.toBinaryString(l);
		String[] arr = binary.split("");
		int count = 0, zeroCount = 0;
		boolean isSet = false, isGap = false;
		for (int i = 0; i < arr.length; i++) {
			System.out.println(binary.charAt(i));
			if (arr[i].equals("1")) {
				isSet = true;
			}
			if (arr[i].equals("0") && isSet) {
				zeroCount++;
			}
			if (arr[i].equals("1") && isSet && zeroCount > 0) {
				isGap = true;
			}
			if (isGap && count < zeroCount) {
				isGap = false;
				count = zeroCount;
				zeroCount = 0;
			}
		}
		System.out.println(count);
	}
}
