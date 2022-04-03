class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum = l1.val + l2.val;
        int pass = 0;
        if (sum >= 10) {
            sum -= 10;
            pass = 1;
        }

        ListNode answer = new ListNode(sum);
        ListNode currNode = answer;

        while (true) {
            int l1Val = 0;
            int l2Val = 0;

            if (l1.next != null) {
                l1 = l1.next;
                l1Val = l1.val;
            }
            if (l2.next != null) {
                l2 = l2.next;
                l2Val = l2.val;
            }

            sum = l1Val + l2Val + pass;
            if (sum == 0 && l1.next == null && l2.next == null)
                break;

            if (sum >= 10) {
                sum -= 10;
                pass = 1;
            } else
                pass = 0;

            ListNode node = new ListNode(sum);
            currNode.next = node;
            currNode = node;
        }
        
        return answer;
    }
}

class ListNode {
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
