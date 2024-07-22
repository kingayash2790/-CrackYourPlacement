package Day07;

public class PartitionList {

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
        public ListNode partition(ListNode head, int x) {
            // Initialize two dummy nodes to start the two separate lists.
            // One for nodes with values less than x, and one for nodes with values greater
            // than or equal to x.
            ListNode small = new ListNode(0);
            ListNode large = new ListNode(0);

            // Pointers to the heads of the two lists.
            ListNode smallHead = small;
            ListNode largeHead = large;

            // Traverse the original list.
            while (head != null) {
                if (head.val < x) {
                    // If the current node's value is less than x, add it to the 'small' list.
                    smallHead.next = head;
                    smallHead = smallHead.next;
                } else {
                    // If the current node's value is greater than or equal to x, add it to the
                    // 'large' list.
                    largeHead.next = head;
                    largeHead = largeHead.next;
                }
                // Move to the next node in the original list.
                head = head.next;
            }

            // End the 'large' list by pointing the node's next to null.
            largeHead.next = null;
            // Connect the 'small' list to the 'large' list.
            // The last node of the small list should be connected to the head of the large
            // list, which is large.next(because large is the dummy head amd the original
            // head for large list is at large.next)
            smallHead.next = large.next;

            // Return the head of the 'small' list, skipping the dummy node.
            return small.next;
        }
    }
}
