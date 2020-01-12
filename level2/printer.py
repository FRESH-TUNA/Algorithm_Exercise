class Printer:
    def __init__(self, priorities):
        self.priorities = priorities
        self.documents = list(range(len(self.priorities)))

    def get_sequence(self, document):
        count = 1

        while len(self.priorities) != 0:
            normal_seq = self.print()
            if normal_seq == document:
                return count
            else:
                count = count + 1

        return count

    def print(self):
        i = 1      

        while not self.finish_iteration(i):
            if self.has_high_priority(self.priorities[i]):
                self.sequence_change()
                i = 1
            else:
                i = i + 1
        
        self.priorities.pop(0)
        return self.documents.pop(0)
    
    def has_high_priority(self, value):
        return value > self.priorities[0]

    def finish_iteration(self, i):
        return i >= len(self.priorities)

    def sequence_change(self):
        self.priorities_pop_and_append()
        self.documents_pop_and_append()

    def priorities_pop_and_append(self):
        poped_value = self.priorities.pop(0)
        self.priorities.append(poped_value)

    def documents_pop_and_append(self):
        poped_value = self.documents.pop(0)
        self.documents.append(poped_value)

if __name__ == "__main__":
    printer = Printer([2, 1, 3, 2])
    print(printer.get_sequence(2))
