import collections

class Bridge(object):
    def __init__(self, length, max_weight):
        self.length = length
        self.max_weight = max_weight
        self.queue = collections.deque()
        self.current_weight = 0

    def push(self, truck):
        added_weight = self.current_weight + truck
        if added_weight <= self.max_weight and len(self.queue) < self.length:
            self.queue.append(truck)
            self.current_weight = added_weight
            return True
        else:
            return False

    def pop(self):
        item = self.queue.popleft()
        self.current_weight -= item
        return item

    def __len__(self):
        return len(self.queue)

    def __repr__(self):
        return 'Bridge({}/{} : [{}])'.format(self.current_weight, self.max_weight, list(self.queue))


def solution(bridge_length, weight, truck_weights):
    bridge = Bridge(bridge_length, weight)
    trucks = collections.deque(truck_weights)

    for _ in range(bridge_length):
        bridge.push(0)

    count = 0
    while trucks:
        bridge.pop()

        if bridge.push(trucks[0]):
            trucks.popleft()
        else:
            bridge.push(DUMMY_TRUCK)

        count += 1

    while bridge:
        bridge.pop()
        count += 1

    return count


def main():
    print(solution(2, 10, [7, 4, 5, 6]), 8)
    print(solution(100, 100, [10]), 101)
    print(solution(100, 100, [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]), 110)


if __name__ == '__main__':
    main()