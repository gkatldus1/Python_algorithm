from typing import *

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
    def reverse(now: ListNode, prev: ListNode = None):
        if not now:
            return prev
        next, now.next = now.next, prev
        return reverse(next, now)

    return reverse(head)

def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
    now, prev = head, None

    while now:
        next, now.next = now.next, prev
        prev, now = now, next
    
    return prev