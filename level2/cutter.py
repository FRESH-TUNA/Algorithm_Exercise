class Cutter:
    def __init__(self, data):
        self.lasers = []
        self.steel_bars = []
        self.left_bracket_stack = []
        self.data = data

    def seperate(self):
        for index, bracket in enumerate(self.data):
            if bracket is '(':
                self.left_bracket_stack.append(index)
            elif self.is_laser(index):
                self.lasers.append(self.left_bracket_stack.pop())
            else:
                self.steel_bars.append((self.left_bracket_stack.pop(), index))

    def last_of_left_bracket_stack(self):
        return self.left_bracket_stack[-1]

    def is_laser(self, index):
        return self.last_of_left_bracket_stack() + 1 == index

    def cut(self):
        count = len(self.steel_bars)
        for steel_bar in self.steel_bars:
            for laser in self.lasers:
                if self.cuttable(laser, steel_bar):
                    count = count + 1
        return count

    def cuttable(self, laser, steel_bar):
        return laser >= steel_bar[0] and laser < steel_bar[1]

    def service(self):
        self.seperate()
        return self.cut()
