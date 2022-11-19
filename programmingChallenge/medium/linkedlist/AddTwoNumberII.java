package programmingChallenge.medium.linkedlist;

import programmingChallenge.utils.ListNode;

import java.util.Stack;

// https://leetcode.com/problems/add-two-numbers-ii/
public class AddTwoNumberII {
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();

        while(l1 != null){
            stack1.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            stack2.add(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode list = new ListNode(0);
        while(!stack1.empty() || !stack2.empty()){
            if(!stack1.empty()) sum += stack1.pop();
            if(!stack2.empty()) sum += stack2.pop();

            list.val = sum % 10;
            ListNode head = new ListNode(sum/10);
            head.next = list;
            list = head;
            sum /= 10;
        }
        return list.val == 0 ? list.next : list;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Head = l1, l2Head = l2;

        int l1Size = 0, l2Size = 0;
        while(l1 != null){
            l1Size++;
            l1 = l1.next;
        }
        while(l2 != null){
            l2Size++;
            l2 = l2.next;
        }

        ListNode temp = new ListNode(), tempHead = temp;
        for(int i = l1Size; i < l2Size; i++){
            temp.next = new ListNode();
            temp = temp.next;
        }
        for(int i = l2Size; i < l1Size; i++){
            temp.next = new ListNode();
            temp = temp.next;
        }

        if(l1Size < l2Size){
            temp.next = l1Head;
            l1Head = tempHead.next;
        }else if(l2Size < l1Size){
            temp.next = l2Head;
            l2Head = tempHead.next;
        }

        ListNode output;
        ListNode[] pair = sum(l1Head, l2Head);
        if(pair[0].val > 0){
            output = new ListNode(pair[0].val);
            output.next = pair[1];
        } else output = pair[1];
        return output;
    }

    ListNode[] sum(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null) return new ListNode[]{new ListNode(), null};
        ListNode[] from = sum(l1.next, l2.next);
        int sum = l1.val + l2.val + from[0].val;
        int first, end;
        if(sum == 10){
            first = 1;
            end = 0;
        }else{
            first = sum / 10;
            end = sum % 10;
        }
        ListNode curr = new ListNode(end);
        curr.next = from[1];
        return new ListNode[]{new ListNode(first), curr};
    }
}
