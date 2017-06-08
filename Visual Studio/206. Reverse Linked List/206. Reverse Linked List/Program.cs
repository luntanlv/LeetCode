using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _206.Reverse_Linked_List
{
    class Program
    {
        static void Main(string[] args)
        {
            var node1 = new ListNode(1);
            var node2 = new ListNode(2);
            var node3 = new ListNode(3);

            node1.next = node2;
            node2.next = node3;

            var res = ReverseList_better(node1);

        }

        //O(1) space
        public static ListNode ReverseList_better(ListNode head)
        {
            ListNode cur = head, pre = null;

            while (cur != null)
            {
                var next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            return pre;
        }

        //O(n) space
        public static ListNode ReverseList(ListNode head)
        {
            var st = new Stack<ListNode>();

            var cur = head;
            while (cur != null)
            {
                st.Push(cur);
                cur = cur.next;
            }

            var fakeNewHead = new ListNode(0);
            ListNode pre = fakeNewHead;
            while (st.Count>0)
            {
                var curR = st.Pop();
                pre.next = curR;                    
                pre = curR;

                if (st.Count == 0)
                    curR.next = null;
            }

            return fakeNewHead.next;
        }
    }

    //Definition for singly-linked list.
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

}
