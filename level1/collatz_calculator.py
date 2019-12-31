class CollatzCalculator:
  def __init__(self, num):
    self.count = 0
    self.num = num

  def is_collatzable(self):
    return self.num == 1

  def has_collatzable_possibility(self):
    return self.count != 500 and not self.is_collatzable()

  def is_even(self):
    return self.num & 1 == 0

  def divide_by_two(self):
    self.num = self.num // 2

  def multiple_three_and_plus_one(self):
    self.num = self.num * 3 + 1

  def inclement_count(self):
    self.count = self.count + 1

  def service(self):
    if self.is_collatzable():
      return 0

    while self.has_collatzable_possibility():
      if self.is_even():
        self.divide_by_two()
      else:
        self.multiple_three_and_plus_one()
      self.inclement_count()
      if self.is_collatzable():
        return self.count

    return -1


def solution(num):
  calculator = CollatzCalculator(num)
  return calculator.service()
