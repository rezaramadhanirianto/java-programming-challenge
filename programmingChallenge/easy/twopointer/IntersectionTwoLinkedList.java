package programmingChallenge.easy.twopointer;

import programmingChallenge.utils.ListNode;

// https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;
        while(a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}

// explanation from https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
// Case 1 (Have Intersection & Same Len):
/**
 *        a
 * A:     a1 → a2 → a3
 *                    ↘
 *                      c1 → c2 → c3 → null
 *                    ↗
 * B:     b1 → b2 → b3
 *        b
 *             a
 * A:     a1 → a2 → a3
 *                    ↘
 *                      c1 → c2 → c3 → null
 *                    ↗
 * B:     b1 → b2 → b3
 *             b
 *                  a
 * A:     a1 → a2 → a3
 *                    ↘
 *                      c1 → c2 → c3 → null
 *                    ↗
 * B:     b1 → b2 → b3
 *                  b
 * A:     a1 → a2 → a3
 *                    ↘ a
 *                      c1 → c2 → c3 → null
 *                    ↗ b
 * B:     b1 → b2 → b3
 * */
// Case 2 (Have Intersection & Different Len):
/**
 *             a
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3 → null
 *                    ↗
 * B:     b1 → b2 → b3
 *        b
 *                  a
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3 → null
 *                    ↗
 * B:     b1 → b2 → b3
 *             b
 * A:          a1 → a2
 *                    ↘ a
 *                      c1 → c2 → c3 → null
 *                    ↗
 * B:     b1 → b2 → b3
 *                  b
 * A:          a1 → a2
 *                    ↘      a
 *                      c1 → c2 → c3 → null
 *                    ↗ b
 * B:     b1 → b2 → b3
 * A:          a1 → a2
 *                    ↘           a
 *                      c1 → c2 → c3 → null
 *                    ↗      b
 * B:     b1 → b2 → b3
 * A:          a1 → a2
 *                    ↘                a = null, then a = b1
 *                      c1 → c2 → c3 → null
 *                    ↗           b
 * B:     b1 → b2 → b3
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3 → null
 *                    ↗                b = null, then b = a1
 * B:     b1 → b2 → b3
 *        a
 *             b
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3 → null
 *                    ↗
 * B:     b1 → b2 → b3
 *             a
 *                  b
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3 → null
 *                    ↗
 * B:     b1 → b2 → b3
 *                  a
 * A:          a1 → a2
 *                    ↘ b
 *                      c1 → c2 → c3 → null
 *                    ↗ a
 * B:     b1 → b2 → b3
 * */
// Case 3 (Have No Intersection & Same Len):
/**
 *        a
 * A:     a1 → a2 → a3 → null
 * B:     b1 → b2 → b3 → null
 *        b
 *             a
 * A:     a1 → a2 → a3 → null
 * B:     b1 → b2 → b3 → null
 *             b
 *                  a
 * A:     a1 → a2 → a3 → null
 * B:     b1 → b2 → b3 → null
 *                  b
 *                       a = null
 * A:     a1 → a2 → a3 → null
 * B:     b1 → b2 → b3 → null
 *                       b = null
 * */
// Case 4 (Have No Intersection & Different Len):
/**
 *        a
 * A:     a1 → a2 → a3 → a4 → null
 * B:     b1 → b2 → b3 → null
 *        b
 *             a
 * A:     a1 → a2 → a3 → a4 → null
 * B:     b1 → b2 → b3 → null
 *             b
 *                  a
 * A:     a1 → a2 → a3 → a4 → null
 * B:     b1 → b2 → b3 → null
 *                  b
 *                       a
 * A:     a1 → a2 → a3 → a4 → null
 * B:     b1 → b2 → b3 → null
 *                       b = null, then b = a1
 *        b                   a = null, then a = b1
 * A:     a1 → a2 → a3 → a4 → null
 * B:     b1 → b2 → b3 → null
 *             b
 * A:     a1 → a2 → a3 → a4 → null
 * B:     b1 → b2 → b3 → null
 *        a
 *                  b
 * A:     a1 → a2 → a3 → a4 → null
 * B:     b1 → b2 → b3 → null
 *             a
 *                       b
 * A:     a1 → a2 → a3 → a4 → null
 * B:     b1 → b2 → b3 → null
 *                  a
 *                            b = null
 * A:     a1 → a2 → a3 → a4 → null
 * B:     b1 → b2 → b3 → null
 *                       a = null
 * */