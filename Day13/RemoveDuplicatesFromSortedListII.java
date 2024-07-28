package Day13;

public class RemoveDuplicatesFromSortedListII {
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
        public ListNode deleteDuplicates(ListNode head) {
            // Create a dummy node which simplifies edge cases, especially when head node(s)
            // need to be removed.
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            // prev is used to track the last node before the sequence of duplicates
            ListNode prev = dummy;

            // Iterate through the linked list
            while (head != null) {
                // Check if the current node has a duplicate (i.e., its value is the same as the
                // next node's value)
                if (head.next != null && head.val == head.next.val) {
                    // Skip all nodes that have the same value as the current node
                    while (head.next != null && head.val == head.next.val) {
                        head = head.next;
                    }
                    // Link prev node to the node after the last duplicate node
                    prev.next = head.next;
                } else {
                    // If no duplicate, just move prev to the current node
                    prev = prev.next;
                }
                // Move head to the next node
                head = head.next;
            }
            // Return the new head of the modified list, skipping the dummy node
            return dummy.next;
        }
    }
}
