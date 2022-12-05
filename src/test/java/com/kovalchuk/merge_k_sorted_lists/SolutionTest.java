package com.kovalchuk.merge_k_sorted_lists;

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
                Arguments.of(new ListNode[]{creatNode(new int[]{1, 4, 5}), creatNode(new int[]{1, 3, 4}), creatNode(new int[]{2, 6})}, creatNode(new int[]{1, 1, 2, 3, 4, 4, 5, 6})),
                Arguments.of(new ListNode[]{}, null),
                Arguments.of(new ListNode[]{creatNode(new int[]{})}, null)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void mergeKLists(ListNode[] input, ListNode expected) {
        ListNode actual = solution.mergeKLists(input);

        assertEquals(expected, actual);
    }

    static ListNode creatNode(int[] data) {
        if (data.length == 0) {
            return null;
        }
        ListNode root = new ListNode(data[0]);
        ListNode node = root;
        for (int i = 1; i < data.length; i++) {
            node.next = new ListNode(data[i]);
            node = node.next;
        }
        return root;
    }
}
