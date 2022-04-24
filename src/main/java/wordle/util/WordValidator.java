package wordle.util;

import java.util.List;

public class WordValidator {

	private static final int WORD_LENGTH = 5;
	private static final String WORD_PATTERN = "^[A-Za-z]+$";

	public static boolean validate(String userInput, List<String> wordList) {
		// 글자 수가 5자가 아닌 경우
		if (!validateWordLength(userInput)) {
			return false;
		}
		// 입력된 단어가 영문자로만 구성되어 있는지
		if (!validateAlphabet(userInput)) {
			return false;
		}
		// 단어 목록에 일치하는 단어가 있는지 없는지
		if (!validateExistedWord(userInput, wordList)) {
			return false;
		}
		return true;
	}

	private static boolean validateWordLength(String userInput) {
		return userInput.length() == WORD_LENGTH;
	}

	private static boolean validateAlphabet(String userInput) {
		return userInput.matches(WORD_PATTERN);
	}

	private static boolean validateExistedWord(String userInput, List<String> wordList) {
		return wordList.contains(userInput);
	}
}