# 입력으로 들어온 binary tree 를 invert
# TreeNode 존재,
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:

        ans = []
        queue = [root]
        while queue:
            current_node = queue.pop(0)
            ans.append(current_node.val)
            if current_node.right:
                queue.append(current_node.right)
            if current_node.left:
                queue.append(current_node.left)

        return ans











