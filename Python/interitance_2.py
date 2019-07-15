class Parent(object):
    def __init__(self, motherArg1, motherArg2=100):
        self.motherArg1 = motherArg1
        self.motherArg2 = motherArg2
    def printParent(self):
        print(self.motherArg1)
        print(self.motherArg2)

class Child(Parent):
    def __init__(self, childArg1, *args, childArg2=100, **kwargs):
        super(Child, self).__init__(*args, **kwargs)
        self.childArg1 = childArg1
        self.childArg2 = childArg2
    def printChild(self):
        print(self.childArg1)
        print(self.childArg2)

child = Child(1, 3, childArg2=2, motherArg2=4)
child.printChild()
child.printParent()