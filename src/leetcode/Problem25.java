package leetcode;

public class Problem25 {
    // approach 2
    // optimised one pass
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null||k==1)
            return head;
        int i=0;
        ListNode start=head,tail=null,ans=null;
        ListNode nextStart=null,revHead=null;
        while(head!=null){
            i++;
            if(i%k==0){
                nextStart = head.next;
                revHead = reverseList(start,nextStart);
                if(tail!=null)
                    tail.next=revHead;
                else
                    ans=head;
                tail=start;
                start=nextStart;
                head=nextStart;
                continue;
            }
            head=head.next;
        }
        if(i%k!=0)
            tail.next=nextStart;
        return ans;
    }
    private ListNode reverseList(ListNode node,ListNode end) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null && curr!=end) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    // approach 1: 2 pass
//    public ListNode reverseKGroup(ListNode head, int k) {
//        if (head == null || head.next == null)
//            return head;
//        ListNode cgh = head, lgh = null;
//        int tot = 0;
//        // count total nodes
//        while (head != null) {
//            tot++;
//            head = head.next;
//        }
//        int groups = tot / k;
//        ListNode newHead = null;
//        // process each groups and link it with previous group unmodified head
//        while (groups > 0) {
//            Node r = reverseList(cgh, k);
//            if (lgh != null) {
//                lgh.next = r.reverseHead;
//            } else {
//                newHead = r.reverseHead;
//            }
//            lgh = cgh;
//            cgh = r.nextGroupHead;
//            groups--;
//        }
//        if(tot%k!=0){
//            lgh.next = cgh;
//        }
//        return newHead;
//    }
//
//    private Node reverseList(ListNode node, int k) {
//        ListNode prev = null;
//        ListNode curr = node;
//        while (curr != null && k > 0) {
//            ListNode temp = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = temp;
//            k--;
//        }
//        return new Node(prev, curr);
//    }

//    class Node {
//        ListNode reverseHead;
//        ListNode nextGroupHead;
//
//        public Node(ListNode reverseHead, ListNode nextGroupHead) {
//            this.reverseHead = reverseHead;
//            this.nextGroupHead = nextGroupHead;
//        }
//    }


}
