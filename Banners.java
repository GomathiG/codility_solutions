package com.java.codelity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Banners {

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 1, 7, 6, 6, 6 };
		int r = solution(arr);
		System.out.println(r);

	}

	public static int solution(int[] arr) {
		IntStream is = IntStream.of(arr).sorted().distinct();
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		int banner1 = 0;
		int highestNo = is.max().getAsInt();
		int startIndex = list.indexOf(highestNo);
		int endIndex = list.lastIndexOf(highestNo);
		if (startIndex != endIndex && endIndex >0) {
			int num = endIndex - startIndex;
			banner1 = banner1 + num + 1;
		} else {
			banner1++;
		}
		List<Integer> leftList = new ArrayList<Integer>();
		List<Integer> rightList = new ArrayList<Integer>();
		if (startIndex == 0) {
			if (endIndex > 0) {
				leftList = list.subList(endIndex + 1, list.size());
			} else {
				leftList = list.subList(startIndex + 1, list.size());
			}
		} else if (startIndex == list.size()) {
			leftList = list.subList(0, startIndex - 1);
		} else {
			leftList = list.subList(0, startIndex);
			if (startIndex != endIndex && endIndex > 0) {
				rightList = list.subList(endIndex + 1, list.size());
			} else {
				rightList = list.subList(startIndex + 1, list.size());
			}
		}
		if (leftList.size() > 0) {
			int leftListMax = leftList.stream().max(Comparator.naturalOrder()).get();
			int total = banner1 * highestNo;
			int sum1 = (leftList.size() * leftListMax);

			if (rightList.size() > 0) {
				int rightListMax = rightList.stream().max(Comparator.naturalOrder()).get();
				int sum2 = (rightList.size() * rightListMax);
				int r1 = sum1 + total + (rightList.size() * total);
				int r2 = sum2 + total + (leftList.size() * total);
				if (r1 > r2) {
					return r2;
				} else {
					return r1;
				}
			} else {
				return sum1 + total + (rightList.size() * total);
			}
		} else {
			return banner1 * highestNo;
		}
	}
}
