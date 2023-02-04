
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution n = new Solution();
        int[][] routes1 = new int[][]{{1,2,7},{3,6,7}};
        System.out.println(n.numBusesToDestination(routes1,1,6));
        int[][] routes2 = new int[][] {{7,12},{4,5,15},{6},{15,19},{9,12,13}};
        System.out.println(n.numBusesToDestination(routes2,15,12));

    }

































    public static Node sumList(Node l1, Node l2){
        if(l1==null || l2 == null)
            return  null;
        // reverse list 1
        Node revL1 = reverse(l1);
        Node revL2 = reverse(l2);
        Node dummyHead = new Node(-1);
        Node head = dummyHead;
        int carry = 0;
        while(revL1!=null){
            int sum = revL1.data + revL2.data + carry;
            if(sum>9)
                carry=sum/10;
            else
                carry=0;
            Node n = new Node(sum%10);
            dummyHead.next=n;
            dummyHead=dummyHead.next;
            revL1=revL1.next;
            revL2=revL2.next;
        }
        if(carry!=0)
            dummyHead.next = new Node(carry);
        return reverse(head.next);
    }

    public static Node reverse(Node head){
        Node prev=null;
        Node curr= head;
        while(curr!=null){
            var temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }

    public static List<Integer> checkLeader(int[] leaders){
        Stack<Integer> st=new Stack<>();
        int maxSoFar = leaders[leaders.length-1];
        List<Integer> ans = new ArrayList<>();
        ans.add(leaders[leaders.length-1]);
        System.out.println(ans.get(0));
        for(int i=leaders.length-2;i>=0;--i){
            if(leaders[i]>maxSoFar) {
                System.out.println(leaders[i]);
                ans.add(leaders[i]);
            }
            maxSoFar=Math.max(maxSoFar,leaders[i]);
        }
        return ans;
    }

    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }


}



    //Write a program to print all the LEADERS in the array. An element is leader if it is greater than all the elements to its right side. And the rightmost element is always a leader. For example in the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.


//    l1 - 2 3 4
//    l2 - 3 4 9

// l3 - 5 8 3


   // Given two numbers represented by two linked lists, write a function that returns the sum list. The sum list is a list representation of the addition of two input numbers.