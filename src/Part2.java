

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Part2 {

	private static final String RAW_DATA = "part2.txt";

	private static final String SORTED_DATA = "part2_sorted.txt";
 

	public static void main(String[] args) {
		System.out.println("input ==> " + createAndWriteNumbers(createRandomNumbers(), RAW_DATA));
		System.out.println("output ==> " +createAndWriteNumbers(sorted(readNumbers(RAW_DATA)), SORTED_DATA));

	}

	private static String createRandomNumbers() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 10; i++) {
			sb.append((int) (Math.random() * 50)).append(" ");
		}

		return sb.toString();
	}

	private static String createAndWriteNumbers(String numbers, String path) {
		try (FileWriter fw = new FileWriter(path)) {
			fw.write(numbers);
		} catch (IOException e) {
			e.printStackTrace();

		}
		return numbers;
	}

	private static String sorted(String text) {
		String[] numbersString = text.split(" ");
		int[] numbersInt = new int[numbersString.length];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numbersString.length; i++) {
			numbersInt[i] = Integer.parseInt(numbersString[i]);
		}
		sort(numbersInt);
		for (int i : numbersInt) {
			sb.append(i).append(" ");
		}
		return sb.toString();
	}

	static private void sort(int[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int t = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = t;
				}
			}
		}
	}

	private static String readNumbers(String nameAndPAth) {
		String s;
		StringBuilder sb = new StringBuilder();
		try (FileReader fr = new FileReader(nameAndPAth)) {
			BufferedReader br = new BufferedReader(fr);

			while ((s = br.readLine()) != null) {
				sb.append(s).append(" ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}