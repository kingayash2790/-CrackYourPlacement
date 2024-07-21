package Day06;

public class AddTwoNumbers {
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // Create a dummy node that will act as the start of the resultant list
            ListNode dummyHead = new ListNode(0);

            // Initialize the curr pointer to the dummy node
            ListNode curr = dummyHead;
            int carry = 0;

            // Iterate as long as there are elements in either list or there is a carry
            while (l1 != null || l2 != null || carry != 0) {
                int digit1 = l1 != null ? l1.val : 0;
                int digit2 = l2 != null ? l2.val : 0;

                // Calculate the sum of the current digits and the carry
                int sum = digit1 + digit2 + carry;

                // to find the digit at unit's place
                int digit = sum % 10;

                // to find the digit at the carry position
                carry = sum / 10;

                // Creating a new node with dgit in it
                ListNode newNode = new ListNode(digit);
                curr.next = newNode;
                curr = curr.next;

                // if pointers/lists l1 and l2 exist, they advance to their next nodes
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }

            }
            // Return the next node of the dummy node, which is the start of the resultant
            // list
            return dummyHead.next;

        }
    }
}
