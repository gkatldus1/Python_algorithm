from typing import *


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        l1_num = 0
        l2_num = 0
        decimal = 0
        l1_node = l1
        l2_node = l2

        while l1:
            l1_num += l1_node.val * (10 ** decimal)
            l2_num += l2_node.val * (10 ** decimal)
            l1 = l1_node.next
            l2 = l2_node.next
            decimal += 1
        decimal -= 1
        l1_num += l2_num
        ans_node = ListNode()
        temp = 0
        while not (decimal < 0):
            temp = l1.val // (10 ** decimal)
            l1.val = l1.val % (10 ** decimal)
            node = ListNode(temp)
            node.next = ans_node
            ans_node = node
            decimal -= 1
            
        return ans_node


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

        return self.toReversedLinkedList(str(resultStr))
        
        
