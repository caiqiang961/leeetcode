package org.caiqiang;

/**
 * @program: leetcode
 * @description:给你一个链表数组，每个链表都已经按升序排列。 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2022-03-14 18:11
 **/
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode header = new ListNode();
        ListNode start = header;
        Integer index = null;
        Integer min = null;
        while (true) {
            for (int i = 0; i < lists.length; i++) {
                ListNode list = lists[i];
                if (list == null) {
                    continue;
                }
                if (min == null) {
                    min = list.val;
                    index = i;
                } else {
                    if (min > list.val) {
                        min = list.val;
                        index = i;
                    }
                }
            }
            if (min != null) {
                start.next = new ListNode(min);
                start = start.next;
                lists[index] = lists[index].next;
                min = null;
                index = null;
            } else {
                break;
            }
        }

        return header.next;
    }


    //双链表法 （空复O(1)）
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode ref = null;
        for (int i = 0; i < lists.length; i++) {
            ref = mergeKListsRef(ref, lists[i]);
        }
        return ref;
    }

    private ListNode mergeKListsRef(ListNode ref, ListNode list) {
        if (ref == null || list == null) {
            return ref != null ? ref : list;
        }
        ListNode header = new ListNode();
        ListNode start = header;
        ListNode a = ref;
        ListNode b = list;
        while (a != null && b != null){
            if (a.val > b.val){
                start.next = b;
                b = b.next;
            }else {
                start.next = a;
                a = a.next;
            }
            start = start.next;

        }
        start.next = a == null? b : a;
        return header.next;
    }
}
