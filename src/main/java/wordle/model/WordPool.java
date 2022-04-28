package wordle.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

public class WordPool {

	public static final int DAY_PLUS_OFFSET = 1;
	public static final String BASE_DATE = "20210619";
	private final List<String> words;

	public WordPool(List<String> words) {
		this.words = Collections.unmodifiableList(words);
	}

	public String getTodayAnswerWord() {
		int period = calculateIndexOfTodayAnswerWord();
		return words.get(period);
	}

	private int calculateIndexOfTodayAnswerWord() {
		LocalDate now = LocalDate.now();
		LocalDate past = LocalDate.parse(BASE_DATE, DateTimeFormatter.BASIC_ISO_DATE);
		int period = ((int) past.until(now, ChronoUnit.DAYS) + DAY_PLUS_OFFSET) % words.size();
		return period;
	}

	public boolean contains(String word) {
		return words.contains(word);
	}

	public int size() {
		return words.size();
	}
}
