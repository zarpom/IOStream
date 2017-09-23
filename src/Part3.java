

import java.io.BufferedReader; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
	private static final String forInt = "(?<=\\s)([0-9]){1,}(?=\\s)";
	private static final String forString = "([a-zA-zà-ÿÀ-ß]{2,})(?=\\s)";
	private static final String forChar = "((?<![a-zA-zà-ÿÀ-ß])([a-zA-zà-ÿÀ-ß]){1}(?=\\s))";
	private static final String forDouble = "[0-9]*[.,][0-9]+|[0-9]*[.,]+";
	private static final String pathToText = "part3.txt";
	private static final String ENCODING = "Cp1251";

	public static void main(String[] args) {
		getNumbers();
	}

	private static String readNumbers(String nameAndPAth) {
		String s;
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(nameAndPAth), ENCODING))) {
			while ((s = br.readLine()) != null) {
				sb.append(s).append(" ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	private static void getNumbers() {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String puttedLine = null;
		while (true) {
			try {
				puttedLine = bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if ((puttedLine == null) || puttedLine.equals("stop")) {
				break;
			}
			switch (puttedLine) {
			case "char":
				System.out.println(search(pathToText, forChar));
				break;
			case "int":
				System.out.println(search(pathToText, forInt));
				break;
			case "String":
				System.out.println(search(pathToText, forString));
				break;
			case "double":
				System.out.println(search(pathToText, forDouble));
				break;
			}
		}
	}

	private static String search(String path, String pattern) {
		StringBuilder sb = new StringBuilder();
		Pattern p = Pattern.compile(pattern, Pattern.UNICODE_CHARACTER_CLASS);
		Matcher m = p.matcher(readNumbers(pathToText));
		while (m.find()) {
			sb.append(m.group(0)).append(" ");
		}
		return sb.toString();
	}
}