package com.kovalchuk.remove_nth_node_from_end_of_list;

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
                Arguments.of(creatNode(new int[]{1, 2, 3, 4, 5}), 2, creatNode(new int[]{1, 2, 3, 5})),
                Arguments.of(creatNode(new int[]{1}), 1, creatNode(new int[]{})),
                Arguments.of(creatNode(new int[]{1, 2}), 1, creatNode(new int[]{1}))
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void removeNthFromEnd(ListNode head, int n, ListNode expected) {
        ListNode actual = solution.removeNthFromEnd(head, n);

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
