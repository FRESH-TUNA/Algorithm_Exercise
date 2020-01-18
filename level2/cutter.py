class Cutter:
    def __init__(self, data):
        self.steel_bars = []
        self.left_bracket_stack = []
        self.data = data

    def service(self):
        return self.cut()

    def cut(self):
        cutted_count = 0
        for index, bracket in enumerate(self.data):
            if bracket is '(':
                self.left_bracket_stack.append(index)
            elif self.is_laser(index):
                self.left_bracket_stack.pop()
                count = count + len(self.left_bracket_stack)
            else:
                self.steel_bars.append((self.left_bracket_stack.pop(), index))
        return cutted_count + len(self.steel_bars)
    
    def last_of_left_bracket_stack(self):
        return self.left_bracket_stack[-1]

    def is_laser(self, index):
        return self.last_of_left_bracket_stack() + 1 == index
