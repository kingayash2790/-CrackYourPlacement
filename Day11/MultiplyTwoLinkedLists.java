package Day11;

public class MultiplyTwoLinkedLists {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class Solution {
        public long multiplyTwoLists(Node first, Node second) {
            // Code here
            if (first == null || second == null) {
                return 0;
            }
            long num1 = 0, num2 = 0;
            while (first != null || second != null) {
                if (first != null) {
                    num1 = num1 * 10 + first.data;
                    first = first.next;

                }
                if (second != null) {
                    num2 = num2 * 10 + second.data;
                    second = second.next;

                }
            }
            return num1 * num2;
        }
    }
}
