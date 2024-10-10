package practica4.ej3;

import java.util.SortedSet;

public class Test {

	public static void main(String[] args) {

		GrammaDictionary dictionary = new GrammaDictionary(2);

		dictionary.addWord("casa");
		dictionary.addWord("helado");
		dictionary.addWord("halle");
		dictionary.addWord("canguro");
		dictionary.addWord("calla");
		dictionary.addWord("valle");

		ComparisonEngine comparator = ComparisonEngine.getInstance();

		SortedSet<String> set = comparator.matchingWords(dictionary, "calle");

		set.stream().forEach(System.out::println);

		GrammaDictionary dictionary1 = new GrammaDictionary(2);

		dictionary1.addWord("lluvias");
		dictionary1.addWord("lluvia");
		dictionary1.addWord("llueva");
		dictionary1.addWord("fluvia");
		dictionary1.addWord("lluvia");

		dictionary1.addWord("nieve");
		dictionary1.addWord("sol");
		dictionary1.addWord("trueno");
		dictionary1.addWord("tormenta");
		dictionary1.addWord("bruma");

		SortedSet<String> set2 = comparator.matchingWords(dictionary1, "lluvia");

		set2.stream().forEach(System.out::println);

	}

}
