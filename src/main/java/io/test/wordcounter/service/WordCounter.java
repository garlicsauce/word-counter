package io.test.wordcounter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class WordCounter {

    private final WordSanitizer wordSanitizer;

    public List<Map.Entry<String, Long>> process(String inputFilePath) {
        try {
            return Files.lines(Paths.get(inputFilePath))
                .filter(StringUtils::hasText)
                .map(l -> l.split(" "))
                .flatMap(Arrays::stream)
                .map(wordSanitizer::sanitize)
                .filter(StringUtils::hasText)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet().stream()
                .sorted(valueThenKeyComparator())
                .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    private Comparator<Map.Entry<String, Long>> valueThenKeyComparator() {
        return (entry1, entry2) -> {
            if (entry1.getValue().compareTo(entry2.getValue()) == 0) {
                return entry1.getKey().compareTo(entry2.getKey());
            } else {
                return entry2.getValue().compareTo(entry1.getValue());
            }
        };
    }
}
