package Day08;

public class MergeTwoSortedLists {

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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            // Create a dummy node that will act as the start of the merged list
            ListNode dummy = new ListNode(0);

            // Initialize the current pointer to the dummy node
            ListNode curr = dummy;

            // Iterate through both lists as long as neither is null
            while (list1 != null && list2 != null) {
                // Compare the current nodes of both lists
                if (list1.val <= list2.val) {
                    // If list1's node is smaller or equal, add it to the merged list
                    curr.next = list1;
                    // Move list1 pointer to the next node
                    list1 = list1.next;
                } else {
                    // If list2's node is smaller, add it to the merged list
                    curr.next = list2;
                    // Move list2 pointer to the next node
                    list2 = list2.next;
                }
                // Move the current pointer to the newly added node
                curr = curr.next;
            }

            // If either list is not null, add the remaining elements to the merged list
            curr.next = list1 != null ? list1 : list2;

            // Return the merged list starting from the node after the dummy node
            return dummy.next;
        }
    }
}
