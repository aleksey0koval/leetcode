package com.kovalchuk.add_two_numbers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
                Arguments.of(creatNode(new int[]{2, 4, 3}), creatNode(new int[]{5, 6, 4}), creatNode(new int[]{7, 0, 8})),
                Arguments.of(creatNode(new int[]{0}), creatNode(new int[]{0}), creatNode(new int[]{0})),
                Arguments.of(creatNode(new int[]{9, 9, 9, 9, 9, 9, 9}), creatNode(new int[]{9, 9, 9, 9}), creatNode(new int[]{8, 9, 9, 9, 0, 0, 0, 1}))
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void addTwoNumbers(ListNode l1, ListNode l2, ListNode expected) {
        ListNode actual = solution.addTwoNumbers(l1, l2);

        assertEquals(expected, actual);
    }

    static ListNode creatNode(int[] data) {
        ListNode root = new ListNode(data[0]);
        ListNode node = root;
        for (int i = 1; i < data.length; i++) {
            node.next = new ListNode(data[i]);
            node = node.next;
        }
        return root;
    }
}
