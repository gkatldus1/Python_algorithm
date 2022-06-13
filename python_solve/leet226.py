import collections

def invertTree(self, root: TreeNode) -> TreeNode:
    if root:
        root.left, root.right = self.invertTree(root.right), self.invertTree(root.left)
        return root
    return None

def invertTree(self, root: TreeNode) -> TreeNode:
    queue = collections.deque([root])

    while queue:
        node = queue.popleft()
        
        node.left, node.right = node.right, node.left
        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)

    return root

def invertTree(self, root: TreeNode) -> TreeNode:
    stack = collections.deque([root])

    while stack:
        node = stack.pop()
        if node:
            node.left, node.right = node.right, node.left

            stack.append(node.left)
            stack.append(node.right)
    return root

def invertTree(self, root: TreeNode) -> TreeNode:
    stack = collections.deque([root])

    while stack:
        node = stack.pop()

        if node:
            stack.append(node.left)
            stack.append(node.right)

            node.left, node.right = node.right, node.left

    return root