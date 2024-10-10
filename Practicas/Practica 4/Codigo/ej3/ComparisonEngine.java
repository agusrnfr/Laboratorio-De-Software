package practica4.ej3;

import java.util.List;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

public class ComparisonEngine {

	private static ComparisonEngine INSTANCE = new ComparisonEngine();

	private ComparisonEngine() {

	}

	public static ComparisonEngine getInstance() {
		return INSTANCE;
	}

	public SortedSet<String> matchingWords(GrammaDictionary dictionary, String str) {

		List<String> splitStr = QGrammasMaker.getInstance(dictionary.getWindow()).getGrammas(str, str.length())
				.getValue();

		SortedSet<String> set = new TreeSet<>();

		for (Entry<String, List<String>> entry : dictionary.getDictionary().entrySet()) {
			int matchingCount = (int) entry.getValue().stream().filter((s) -> !splitStr.contains(s)).count();

			if (matchingCount < 3) {
				set.add(entry.getKey());
			}
		}
		return set;
	}

}
