# class MyMeta(type):
#     def __new__(cls, name, bases, dct):
#         print("meta: creating %s %s" % (name, bases))
#         return type.__new__(cls, name, bases, dct)


class HigherParentClass():
    highParentA = 'a'

    def __new__(cls, **kwargs):
        print('grandparent create')
        return super(HigherParentClass, cls).__new__(cls)

    def __init__(self, **kwargs):
        self.highParentA = kwargs['highParentA']
        print('parent init')
        


class ParentClass(HigherParentClass):
    parentA = 'a'

    def __new__(cls, **kwargs):
        print('parent create')
        return super(ParentClass, cls).__new__(cls)

    def __init__(self, **kwargs):
        print(self.parentA)
        self.parentA = kwargs['parentA']
        super(ParentClass, self).__init__(**kwargs)

    def getParentA(self):
        print(self.parentA)


class ChildClass(ParentClass):
    childA = 'b'

    def __new__(cls, **kwargs):
        print('child create')
        return super(ChildClass, cls).__new__(cls)

    def __init__(self, childA, **kwargs):
        self.childA = childA
        super(ChildClass, self).__init__(**kwargs)
        print('child init')

    def getParentB(self):
        print(self.childA)


test = ChildClass(childA='child', parentA='parent', highParentA='higherParent')
print(test.childA)
print(test.parentA)
print(test.highParentA)


