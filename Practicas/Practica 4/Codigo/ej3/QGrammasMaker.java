package practica4.ej3;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

public class QGrammasMaker {

	private int window;
	private static QGrammasMaker INSTANCE;

	private QGrammasMaker(int window) {
		this.window = window;
	}

	public static QGrammasMaker getInstance(int window) {
		if (INSTANCE == null)
			INSTANCE = new QGrammasMaker(window);
		return INSTANCE;
	}

	public void setWindow(int window) {
		this.window = window;

	}

	public int getWindow() {
		return this.window;
	}

	public SimpleEntry<String, List<String>> getGrammas(String str, int position) {

		if (position < 0 || position > str.length()) {
			throw new IllegalArgumentException("Invalid position");
		}

		String strFormatted = this.format(str);

		if (position + window > strFormatted.length()) {
			throw new IllegalArgumentException("Position exceeds formatted string length with the current window size");
		}

		strFormatted = strFormatted.substring(0, position + this.window).toLowerCase();

		List<String> list = new ArrayList<>();

		for (int i = 0; i <= strFormatted.length() - this.window; i++) {

			list.add(strFormatted.substring(i, i + this.window));
		}

//		return new SimpleEntry<>(strFormatted.substring(position),list); //the key is the extracted q-gramma
		return new SimpleEntry<>(str, list); // the key is the original string

	}

	private String format(String str) {
		return "#" + str + "$";
	}
}
