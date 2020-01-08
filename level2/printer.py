class Printer:
    def __init__(self, priorities):
        self.priorities = priorities
        self.sequence = list(range(len(self.priorities)))
        
    def get_sequence(self, location):
        count = 1
        while len(self.priorities) != 0:
            normal_seq = self.sequence_change()
            if normal_seq == location:
                return count
            else:
                count = count + 1
        return count
            
            
    def sequence_change(self):        
        for index, value in enumerate(self.priorities):
            if value > self.priorities[0]:
                poped_value = self.priorities.pop(index)
                self.priorities.append(poped_value)
                poped_value = self.sequence.pop(index)
                self.sequence.append(poped_value)
                return -1
        self.priorities.pop(0)
        return self.sequence.pop(0)

if __name__ == "__main__":
    printer = Printer([2, 1, 3, 2])
    printer.sequence_change