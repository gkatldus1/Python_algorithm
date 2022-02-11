def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
    if not root:
        return 0

    return (root.val if L <= root.val <= R else 0) + \
            self.rangeSumBST(root.left, L, R) + \
            self.rangeSumBST(root.right, L, R)

def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
    def dfs(node: TreeNode):
        if not node:
            return 0
        
        if node.val < L:
            return dfs(node.right)
        elif node.val > R:
            return dfs(node.left)
        return node.val + dfs(node.left) + dfs(node.right)
    
    return dfs(root)
def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
    stack, sum = [root], 0

    while stack:
        node = stack.pop()
        if node:
            if node.val > L:
                stack.append(node.left)
            if node.val < R:
                stack.append(node.right)
            if L <= node.val <= R:
                sum += node.val
    return sum