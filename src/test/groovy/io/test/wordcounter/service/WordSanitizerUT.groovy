package io.test.wordcounter.service

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class WordSanitizerUT extends Specification {

    @Subject
    private WordSanitizer wordSanitizer = new WordSanitizer()

    @Unroll
    def "should return empty string"() {
        expect:
        wordSanitizer.sanitize(input) == ''

        where:
        input << ['', '  ', null]
    }

    @Unroll
    def "should do nothing"() {
        expect:
        wordSanitizer.sanitize(input) == input

        where:
        input << ['regular', 'words', 'or-those-with-dashes']
    }

    @Unroll
    def "should sanitize word"() {
        expect:
        wordSanitizer.sanitize(input) == expected

        where:
        input       || expected
        'comma,'    || 'comma'
        'dot.'      || 'dot'
        'question?' || 'question'
        'shout!'    || 'shout'
        'Uppercase' || 'uppercase'
        'a]|@aa'    || 'aaa'
        'blank   '  || 'blank'
    }
}
