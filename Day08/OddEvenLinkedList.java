package Day08;

public class OddEvenLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            // Base case
            if (head == null || head.next == null) {
                return head;
            }

            ListNode oddNode = head; // pointer for the odd indices
            ListNode evenNode = head.next; // pointer for the even indices
            ListNode evenHead = head.next; // initially stores the next of the head for future use

            while (oddNode.next != null && evenNode.next != null) {
                oddNode.next = oddNode.next.next;
                evenNode.next = evenNode.next.next;

                // Updating the odd and even pointers
                oddNode = oddNode.next;
                evenNode = evenNode.next;
            }

            oddNode.next = evenHead;
            return head;
        }
    }
}
