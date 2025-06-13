package org.caiqiang;


/**
 * @program: leetcode
 * @description:给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2021-11-22 18:41
 **/
public class Solution2 {



    public static void main(String[] args) {
        Solution2 s = new Solution2();
        ListNode n1 = new ListNode();
        n1.val = 9;
        ListNode n2 = new ListNode();
        n2.val = 9;
        ListNode n3 = new ListNode();
        n3.val = 9;
        ListNode n4 = new ListNode();
        n4.val = 9;
        ListNode n5 = new ListNode();
        n5.val = 9;
        ListNode n6 = new ListNode();
        n6.val = 9;
        ListNode n7 = new ListNode();
        n7.val = 9;
        n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;n5.next=n6;n6.next=n7;

        ListNode k1 = new ListNode();
        k1.val = 9;
        ListNode k2 = new ListNode();
        k2.val = 9;
        ListNode k3 = new ListNode();
        k3.val = 9;
        ListNode k4 = new ListNode();
        k4.val = 9;
        k1.next=k2;k2.next=k3;k3.next=k4;

        System.out.println(s.addTwoNumbers(n1, k1));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rh = null;
        ListNode r = null;

        int temp = 0;
        while(true){
            ListNode tempListNode = new ListNode();
            if (r != null) {
                r.next = tempListNode;
                r = r.next;
            }else {
                r = new ListNode();
            }
            temp = xxx(l1,l2,r,temp);
            if (rh == null){
                rh = r;
            }
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
            if (l1 == null && l2==null){
                if (temp == 1){
                    r.next = new ListNode(1);;
                }
                break;
            }
        }
        return rh;
    }

    private int xxx(ListNode l1, ListNode l2,ListNode r,int temp){
        int i1 = 0;
        int i2 = 0;
        if (l1 != null){
            i1 = l1.val;
        }
        if (l2 != null){
            i2 = l2.val;
        }

        int i = i1 + i2 + temp;

        if (i < 10){
            r.val = i;
            return 0;
        }else {
            r.val = i - 10;
            return 1;
        }
    }
}



