package Day11;

public class SortList {
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

        // Method to find the middle node of the linked list
        public ListNode findMiddleNode(ListNode head) {
            ListNode slow = head; // Slow pointer moves one step at a time
            ListNode fast = head; // Fast pointer moves two steps at a time

            // Traverse the list until the fast pointer reaches the end
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next; // Move slow pointer one step
                fast = fast.next.next; // Move fast pointer two steps
            }

            // Slow pointer will be at the middle node
            return slow;
        }

        // Method to merge two sorted linked lists
        public ListNode mergeSortedLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(-1); // Dummy node to act as a placeholder
            ListNode temp = dummy; // Temporary pointer to build the new sorted list

            // Traverse both lists and merge them into a single sorted list
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) { // Compare values of current nodes
                    temp.next = list1; // Attach smaller node to the merged list
                    list1 = list1.next; // Move to the next node in list1
                } else {
                    temp.next = list2; // Attach smaller node to the merged list
                    list2 = list2.next; // Move to the next node in list2
                }

                temp = temp.next; // Move the temp pointer to the next node
            }

            // Attach any remaining nodes from list1 or list2
            if (list1 != null) {
                temp.next = list1;
            } else {
                temp.next = list2;
            }

            // Return the merged list, starting from the node after the dummy
            return dummy.next;
        }

        // Method to sort the linked list using merge sort
        public ListNode sortList(ListNode head) {
            // Base Case: If the list is empty or has only one node, it's already sorted
            if (head == null || head.next == null) {
                return head;
            }

            // Step 1: Find the middle of the list
            ListNode middle = findMiddleNode(head);
            ListNode right = middle.next; // The right half starts from the node after the middle
            middle.next = null; // Split the list into two halves
            ListNode left = head; // The left half starts from the head

            // Step 2: Recursively sort the left and right halves
            ListNode leftHead = sortList(left);
            ListNode rightHead = sortList(right);

            // Step 3: Merge the sorted halves
            return mergeSortedLists(leftHead, rightHead);
        }
    }
}
