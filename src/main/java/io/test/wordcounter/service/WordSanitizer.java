package io.test.wordcounter.service;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class WordSanitizer {

    public String sanitize(String word) {
        if (!StringUtils.hasText(word)) {
            return "";
        }

        word = word.toLowerCase();
        word = removePunctuationMarks(word);
        word = removeNonAlphanumerics(word);
        return word;
    }

    private String removePunctuationMarks(String word) {
        return isPunctuationMark(word.charAt(word.length() - 1))
            ? word.substring(0, word.length() - 1)
            : word;
    }

    private boolean isPunctuationMark(char c) {
        return c == ',' || c == '.' || c == '?' || c == '!';
    }

    private String removeNonAlphanumerics(String word) {
        return word.replaceAll("[^a-zA-Z0-9\\-]", "");
    }
}
