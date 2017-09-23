

import java.io.IOException;

public class Part4 {

	private static final String FILE_NAME = "part4.txt";

	private static final String ENCODING = "Cp1251";

	public static void main(String[] args) {
		Parser parser = null;
		try {
			parser = new Parser(FILE_NAME, ENCODING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		for (String str : parser) {
			System.out.println(str);
		}
	}
}