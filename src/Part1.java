


import java.io.BufferedReader; 
import java.io.FileInputStream; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

	private static final String FILE_NAME = "part1.txt";

	private static final String ENCODING = "Cp1251";

	public static void main(String[] args) {
		try {
			System.out.println(replaceChar(readTextInFile()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String readTextInFile() throws IOException {
		String nextString;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
		    br = new BufferedReader(
					new InputStreamReader(new FileInputStream(FILE_NAME), ENCODING));
			while ((nextString = br.readLine()) != null) {
				sb.append(nextString).append("\n");
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		finally {
			br.close();
		}

		return sb.toString();
	}

	public static String replaceChar(String input) {
		StringBuilder sb = new StringBuilder(input);
		Pattern p = Pattern.compile("([\\w]{4,})", Pattern.UNICODE_CHARACTER_CLASS);
		Matcher m = p.matcher(sb);
		while (m.find()) {
			String letter = m.group(1).toUpperCase();
			sb.replace(m.start(1), m.end(1), letter);
		}
		return sb.substring(0);
	}
}