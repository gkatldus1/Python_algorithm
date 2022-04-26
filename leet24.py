from typing import *

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
    cur = head

    while cur and cur.next:
        cur.val, cur.next.val = cur.next.val, cur.val
        cur = cur.next.next

    return head

def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
    root = prev = ListNode(None)
    prev.next = head
    while head and head.next:
        b = head.next
        head.next = b.next
        b.next = head

        prev.next = b

        head = head.next
        prev = prev.next.next

    return root.next
