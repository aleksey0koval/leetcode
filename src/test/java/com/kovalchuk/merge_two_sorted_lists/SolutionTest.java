package com.kovalchuk.merge_two_sorted_lists;

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
                Arguments.of(creatNode(new int[]{1, 2, 4}), creatNode(new int[]{1, 3, 4}), creatNode(new int[]{1, 1, 2, 3, 4, 4})),
                Arguments.of(creatNode(new int[]{}), creatNode(new int[]{}), creatNode(new int[]{})),
                Arguments.of(creatNode(new int[]{}), creatNode(new int[]{0}), creatNode(new int[]{0}))
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void mergeTwoLists(ListNode list1, ListNode list2, ListNode expected) {
        ListNode actual = solution.mergeTwoLists(list1, list2);

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
