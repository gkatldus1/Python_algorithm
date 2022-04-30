from tracemalloc import start
from typing import *

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
    def reverseList(prev ,head: Optional[ListNode]) -> Optional[ListNode]:
            now = head

            for _ in range(right - (left-1)):
                next, now.next = now.next, prev
                prev, now = now, next
            return prev
        
    if not head or left == right:
        return head
    
    
    end = start = head
    for _ in range(left-2):
        start = start.next
    
    for _ in range(right):
        end = end.next
    prev = reverseList(end, start.next)
    start.next = prev
    

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
    