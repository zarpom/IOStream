
import java.io.BufferedReader;
import java.io.FileInputStream; 
import java.io.IOException;
import java.io.InputStreamReader; 
import java.util.Iterator; 
 
class Parser implements Iterable<String> {
	private static String[] sentences;

	public Parser(String fileName, String encoding) throws IOException {
		readTextInFile(fileName, encoding);
	}

	@Override
	public Iterator<String> iterator() {
		return new IteratorImpl();
	}

	private class IteratorImpl implements Iterator<String> {
		int currentPosition = 0;

		@Override
		public boolean hasNext() {
			return currentPosition != sentences.length - 1 && sentences[currentPosition] != null;
		}

		@Override
		public String next() {
			String string = sentences[currentPosition];
			currentPosition++;
			return string;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	private static void readTextInFile(String FILE_NAME, String ENCODING) throws IOException {
		String nextString;
		StringBuilder sb = new StringBuilder();
		 BufferedReader br = null;
		try {
			 br = new BufferedReader(
					new InputStreamReader(new FileInputStream(FILE_NAME), ENCODING));
			while ((nextString = br.readLine()) != null) {
				if (!nextString.substring(nextString.length() - 1, nextString.length()).equals(" ")
						| nextString.substring(nextString.length() - 1, nextString.length()).equals(".")) {
					nextString = nextString.concat(" ");
				}
				sb.append(nextString);
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			br.close();
		}
		sentences = sb.toString().split("\\.");
		for (int i = 0; i < sentences.length; i++) {
			if (sentences[i].substring(0, 1).equals(" ")) {
				sentences[i] = sentences[i].substring(0, 0) + sentences[i].substring(1);
			}

			sentences[i] = sentences[i].concat(".");
		}
	}
}