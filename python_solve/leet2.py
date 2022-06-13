from typing import *
import functools

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        l1_num, l2_num = 0, 0
        decimal = 0
        l1_node, l2_node = l1, l2

        while l1_node:
            l1_num += l1_node.val * (10 ** decimal)
            l1_node = l1_node.next
            decimal += 1
        decimal = 0
        while l2_node:
            l2_num += l2_node.val * (10 ** decimal)
            l2_node = l2_node.next
            decimal += 1
            
        l1_num += l2_num
    
        num_string = str(l1_num)
        
        prev: ListNode = None
        for r in num_string:
            node = ListNode(r)
            node.next = prev
            prev = node

        return node




# ----------------------------------------------------------------------------

    def reverseList(self, head: ListNode) -> ListNode:
        node, prev = head, None

        while node:
            next, node.next = node.next, prev
            prev, node = node, next

        return prev

    def toList(self, node: ListNode) -> ListNode:
        list: List = []
        while node:
            list.append(node.val)
            node = node.next
        return list

    def toReversedLinkedList(self, result: ListNode) -> ListNode:
        prev: ListNode = None
        for r in result:
            node = ListNode(r)
            node.next = prev
            prev = node

        return node

    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        a = self.toList(self.reverseList(l1))
        b = self.toList(self.reverseList(l2))

        resultStr = int(''.join(str(e) for e in a)) + int(''.join(str(e) for e in b))
        # resultStr = int(''.join(map(str, a)) + int(''.join(map(str, b)))
        resultStr = functools.reduce(lambda x, y: 10*x + y, a, 0) + functools.reduce(lambda x, y: 10*x + y, b, 0)
        return self.toReversedLinkedList(str(resultStr))
        
        
