from typing import *

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next




def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
    def reverseList(prev ,head: Optional[ListNode]) -> Optional[ListNode]:
        now = head

        for i in range(right - left):
            next, now.next = now.next, prev
            prev, now = now, next
        
        return prev
    
    prev = end = start = head
    for i in range(left - 2):
        prev = prev.next

    for i in range(left-1):
        start = start.next
    for i in range(right):
        end = end.next
    tail = reverseList(prev ,start)
    tail.next = end

    return head

def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
    if not head or left == right:
        return head

    root = start = ListNode(None)
    root.next = head

    for _ in range(left - 1):
        start = start.next
    end = start.next

    for _ in range(right - left):
        tmp, start.next, end.next = start.next, end.next, end.next.next
        start.next.next = tmp
    return root.next
    