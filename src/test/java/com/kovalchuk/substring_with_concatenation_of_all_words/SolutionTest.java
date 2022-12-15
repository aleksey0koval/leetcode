package com.kovalchuk.substring_with_concatenation_of_all_words;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SolutionTest {
    private Solution solution;

    @BeforeAll
    public void init() {
        solution = new Solution();
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("barfoothefoobarman", new String[]{"foo", "bar"}, List.of(0, 9)),
                Arguments.of("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}, List.of()),
                Arguments.of("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}, List.of(6, 9, 12))
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void findSubstring(String s, String[] words, List<Integer> expected) {
        List<Integer> actual = solution.findSubstring(s, words);

        assertEquals(expected, actual);
    }
}
