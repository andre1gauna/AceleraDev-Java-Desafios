package br.com.codenation;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StatisticUtil {

	private static IntStream stream;

	public static int average(int[] elements) {

		stream = IntStream.of(elements);
		return (int)stream.average().getAsDouble();
	}

	public static int mode(int[] elements) {
		Map<Integer, Integer> map = new HashMap<>();

		for (Integer i : elements) {
			Integer value = map.get(i);
			map.put(i, value == null ? 1 : value + 1);
		}

		Map.Entry<Integer, Integer> mode = null;

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (mode == null || entry.getValue() > mode.getValue())
				mode = entry;
		}

		return mode.getKey();
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);
		int metade = elements.length/2;

		if (!(elements.length % 2 == 0))
			return elements[metade];

		return (elements[metade] + elements[metade - 1]) / 2;
	}

}