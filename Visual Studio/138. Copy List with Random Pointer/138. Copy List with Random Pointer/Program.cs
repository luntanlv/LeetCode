using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;

namespace _138.Copy_List_with_Random_Pointer
{
    class Program
    {
        static void Main(string[] args)
        {
        }

        //O(1) space
        public RandomListNode copyRandomList(RandomListNode head)
        {
            var cur = head;
            // First round: make copy of each node,
            // and link them together side-by-side in a single list.
            while (cur != null)
            {
                var newCur = new RandomListNode(cur.label);
                newCur.next = cur.next;
                cur.next = newCur;

                cur = newCur.next;
            }

            // Second round: assign random pointers for the copy nodes.
            cur = head;
            while (cur != null)
            {
                var newCur = cur.next;
                if(cur.random != null)
                    newCur.random = cur.random.next;
                cur = newCur.next;
            }

            // Third round: restore the original list, and extract the copy list.
            cur = head;
            var fakeNewHead = new RandomListNode(0);
            var newPre = fakeNewHead;

            while (cur != null)
            {
                var newCur = cur.next;
                cur.next = newCur.next;
                newPre.next = newCur;
                newPre = newCur;

                cur = cur.next;
            }

            return fakeNewHead.next;
        }

    }

    //Definition for singly-linked list with a random pointer.
    public class RandomListNode
    {
        public int label;
        public RandomListNode next, random;
        public RandomListNode(int x) { this.label = x; }
    };
}


