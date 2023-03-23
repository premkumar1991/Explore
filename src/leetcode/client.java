package leetcode;

import leetcode.string.Problem49;
import leetcode.string.Problem5;

public class client {
    public static void main(String[] args){
       Problem25 p = new Problem25();
       ListNode n =new ListNode(1);
       n.next = new ListNode(2);
       n.next.next = new ListNode(3);
       n.next.next.next = new ListNode(4);
       n.next.next.next.next = new ListNode(5);
       printSingleLinkedList(p.reverseKGroup(n, 2));
    }
    public static void printSingleLinkedList(ListNode head){
        while(head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
