package org.caiqiang;

/**
 * @program: leetcode
 * @description:
 * @author: caiqiang
 * @create: 2022-03-10 18:53
 **/
public class Solution21 {

    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();

        ListNode header3 = new ListNode(4);
        ListNode header2 = new ListNode(2,header3);
        ListNode header = new ListNode(1,header2);

        ListNode header31 = new ListNode(4);
        ListNode header21 = new ListNode(3,header31);
        ListNode header1 = new ListNode(1,header21);

        System.out.println(solution21.mergeTwoLists(header1, header));
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null){
            return null;
        }
        ListNode header = new ListNode();
        ListNode start = header;
        while (true){
            ListNode test = test(list1, list2);
            if (test == null){
                break;
            }
            //首节点废弃掉

             start.next = new ListNode();
             start = start.next;
            start.val = test.val;


            if (test.equals(list1)){
                list1 = list1.next;
            }else {
                list2 = list2.next;
            }
        }
        return header.next;
    }

    public ListNode test(ListNode list1, ListNode list2){
        Integer val1 = null;
        Integer val2 = null;
        if (list1 != null){
            val1 = list1.val;
        }
        if (list2 != null){
            val2 = list2.val;
        }
        if (val1 == null){
            return list2;
        }
        if (val2 == null){
            return list1;
        }
        return val1.equals(Math.min(val1,val2)) ? list1 : list2;

    }


}


