class Node(object):
    def __init__(self, contain):
        self.contain = contain
        self.forward = None
        self.backward = None

    def __str__(self):
        return self.contain
