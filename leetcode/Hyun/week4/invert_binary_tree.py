class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:

        if root is None:
            return root

        ans = root
        queue = [root]
        while queue:
            current_node = queue.pop(0)
            tmp_left = tmp_right = None

            if current_node.right is not None:
                tmp_left = current_node.right
                queue.append(current_node.right)
            if current_node.left is not None:
                tmp_right = current_node.left
                queue.append(current_node.left)

            current_node.right = tmp_right
            current_node.left = tmp_left

        return ans
