# 这里实现一颗树 ，二叉树
# 这里录入叶子的时候叶子之间没有关系的，定义：
# 叶子先录入根结点，
# 如果左节点是空接着录入左节点
# 如果左节点不是空，录入右节点

from Day2.leaf import Leaf


class Tree(object):
    def __init__(self, string):
        self.root = Leaf(string)
        self.NowPoint = self.root

    def read(self, root):

        if root.left is not None:
            return self.read(root.left)
        if root.right is not None:
            return self.read(root.right)
        return root.contain


def buildtree(nextPoint, string):
    if nextPoint.left is None:
        nextPoint.left = Leaf(string)
        return
    elif nextPoint.right is None:
        nextPoint.right = Leaf(string)
        return
    if nextPoint.left is not None:
        return buildtree(nextPoint.left, string)
    if nextPoint.right is not None:
        return buildtree(nextPoint.right, string)


tree = Tree('root')
for i in range(0, 10):
    buildtree(tree.root, str(i))

print('Hi')
