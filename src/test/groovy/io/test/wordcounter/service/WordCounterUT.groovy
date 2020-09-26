package io.test.wordcounter.service

import spock.lang.Specification
import spock.lang.Subject

class WordCounterUT extends Specification {

    @Subject
    private WordCounter wordCounter = new WordCounter(new WordSanitizer())

    def "should process test file"() {
        when:
        def result = wordCounter.process("src/test/resources/test-input.txt")

        then: 'all words were fetched'
        result.size() == 7

        and: 'number of occurrences is valid'
        result[0].key == 'dolor'
        result[0].value == 2
        for (int i = 1; i < result.size(); i++) {
            result[i].value == 1
        }

        and: 'words with the same occurrences number are in alphabetical order'
        for (int i = 2; i < result.size(); i++) {
            result[i].key > result[i - 1].key
        }
    }
}
