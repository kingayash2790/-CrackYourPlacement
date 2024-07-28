package Day11;

public class IntersectionOfTwoLL {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // Base Case
            if (headA == null || headB == null) {
                return null;
            }

            ListNode temp1 = headA;
            ListNode temp2 = headB;

            while (temp1 != temp2) {
                temp1 = temp1.next;
                temp2 = temp2.next;

                // Point of collision
                if (temp1 == temp2) {
                    return temp1;
                }
                if (temp1 == null) {
                    temp1 = headB;
                }
                if (temp2 == null) {
                    temp2 = headA;
                }
            }
            return temp1;
        }
    }
}
