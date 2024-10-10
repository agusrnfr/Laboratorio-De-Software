package practica4.ej3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GrammaDictionary {

	private Map<String, List<String>> dictionary;
	private int window;

	public int getWindow() {
		return this.window;
	}

	public Map<String, List<String>> getDictionary() {
		return this.dictionary;
	}

	public GrammaDictionary(int window) {
		this.dictionary = new HashMap<>();
		this.window = window;
	}

	public void addWord(String key) {
		List<String> value = QGrammasMaker.getInstance(window).getGrammas(key, key.length()).getValue();
		this.dictionary.put(key, value);
	}

	public List<String> getWordGrammas(String key) {
		return this.dictionary.get(key);
	}

	public void printAllEntries() {
		for (Entry<String, List<String>> entry : this.dictionary.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Values: " + entry.getValue());
		}
	}
}
