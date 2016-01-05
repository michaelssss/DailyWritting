# 本日目标，实现一棵二叉树
# 这里是定义叶子:
# 因为没有特别的目标，叶子包含的信息就是一串字符串

class Leaf(object):
    def __init__(self, contain):
        self.contain = contain
        self.left = None
        self.right = None

    def __str__(self):
        return self.contain
