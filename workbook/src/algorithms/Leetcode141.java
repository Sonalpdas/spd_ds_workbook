package algorithms;

 // Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }


public class Leetcode141 {
    public boolean hasCycle(ListNode head) {

        // Using slow and fast pointers to determine
        // if LL has a cycle

        // If empty LL
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {

            if (fast == null || fast.next == null) {

                // Fast node reached end of the LL
                return false;
            }

            slow = slow.next; // Increase pointer by one node
            fast = fast.next.next; // Increase fast node by two nodes
        }

        // Process reaches here when slow = fast node
        return true;
    }

}
