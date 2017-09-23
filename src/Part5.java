
 
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Part5 {
 
	private static final String separator = System.lineSeparator();

	public static void main(String[] args) {
		System.out.println(getText());
	}

	private static String getText() {
		Scanner sc = new Scanner(System.in);
		String str = "";
		String stop = "stop";
		String result = "";
		while (!(stop.equals(str = sc.nextLine()))) {
			try {
				String[] mass = str.split(" ");
				result+= getLocale(mass[0], mass[1]) + separator;	
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
				sc.close();
			}
		}
		return result;
	}

	static String getLocale( String key,String language) {
		Locale locale = new Locale(language);
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resources", locale);
		return (String) resourceBundle.getObject(key);
	}
}