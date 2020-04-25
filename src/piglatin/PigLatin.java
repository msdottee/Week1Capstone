package piglatin;

import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		boolean translate = true;

		System.out.println("Welcome to the Pig Latin Translator!");

		System.out.println();

		whileLoop(translate);

	}

	private static void whileLoop(boolean translate) {
		try (Scanner scnr = new Scanner(System.in)) {
			while (translate) {

				System.out.println("Enter a line to be translated: ");

				String userString = scnr.nextLine();

				System.out.println(stringBuilderMethod(userString));

				System.out.println();

				System.out.println("Translate another line? (y/n):");

				String answer = scnr.nextLine().toLowerCase();

				if (answer.equals("n")) {
					translate = false;
					System.out.println();
				} else if (answer.isEmpty()) {
					System.out.println("Please enter a sentence or n/N to exit.");
				}
			}
		}
	}

	private static String stringBuilderMethod(String userString) {
		StringBuilder pigLatin = new StringBuilder();

		String[] stringSplit = userString.split(" ");

		for (String seperateWords : stringSplit) {
			if (isAlphaString(seperateWords)) {
				willItPigLatin(pigLatin, seperateWords);
			} else {
				pigLatin.append(seperateWords).append(" ");
			}
		}

		return pigLatin.toString();

	}

	private static void willItPigLatin(StringBuilder pigLatin, String seperateWords) {
		if (startsWithVowel(seperateWords)) {
			pigLatin.append(seperateWords).append("way ");
		} else {
			pigLatin.append(seperateWords.substring(1)).append(seperateWords.charAt(0)).append("ay ");
		}
	}

	private static boolean isAlphaString(String userString) {
		for (char currentChar : userString.toCharArray()) {
			if (!(currentChar >= 'A' && currentChar <= 'Z') && !(currentChar >= 'a' && currentChar <= 'z') && currentChar != '\'') {
				return false;
			}
		}

		return true;
	}

	private static boolean startsWithVowel(String word) {
		return "AEIOUaeiou".indexOf(word.charAt(0)) != -1;
	}
}
