def isBalanced(self, root: TreeNode) -> bool:
    def check(root):
        if not root:
            return 0

        left = check(root.left)
        right = check(root.right)

        if left == -1 or \
            right == -1 or \
                abs(left - right) > 1:
                retun -1
        return max(left, right) + 1
    return check(root) != -1