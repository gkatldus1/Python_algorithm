from typing import *
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
    if head is None:
            return None
    odd_start = odd = head
    even_start = even = head.next

    while even and even.next :
        odd.next = odd.next.next
        odd = odd.next

        even.next = even.next.next
        even = even.next

    odd.next = even_start
    return odd_start

def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
    def toList(self, node: ListNode) -> List:
        _list = []
        while head.next:
            _list.append(head.val)
            head = head.next
        return _list
    def toLinkedList(self, result: str) -> ListNode:
        prev: ListNode = None
        count = 0
        tail = None
        for r in result[::-1]:
            node = ListNode(r)
            if count == 0:
                tail = node
            count += 1
            node.next = prev
            prev = node
        return node, tail
    list = toList(head)
    odd, tail_odd = toLinkedList(list[::2])
    even, tail_even = toLinkedList(list[1::2])
    tail_odd.next = even
    return odd

def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
    if head is None:
        return None
    
    odd = head
    even_head = even = head.next

    while even and even.next:
        odd.next, even.next = odd.next.next, even.next.next
        odd, even = odd.next, even.next

    odd.next = even_head
    return head
    