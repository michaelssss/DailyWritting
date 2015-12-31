from Day1.Node import Node


def puton(root, string):
    root.forward = Node(string)
    root.forward.backward = root
    root = root.forward
    return root


def showcontainasc(node):
    print(node)
    if node.forward is not None:
        showcontainasc(node.forward)


root = Node('root')
node = root

for i in range(0, 25):
    node = puton(node, str(i))

showcontainasc(root)
