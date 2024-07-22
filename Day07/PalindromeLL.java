package Day07;

public class PalindromeLL {

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
        public ListNode reverse(ListNode head) {
            ListNode temp = null;
            ListNode next = null;

            while (head != null) {
                next = head.next;
                head.next = temp;
                temp = head;
                head = next;
            }
            return temp;
        }

        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode reverseList = reverse(slow);
            while (reverseList != null) {
                if (head.val != reverseList.val) {
                    return false;
                }
                head = head.next;
                reverseList = reverseList.next;
            }
            return true;
        }
    }
}
