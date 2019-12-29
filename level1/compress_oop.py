class Compressor:
  def __init__(self, data, chunk_len):
    self.data = data
    self.chunk_len = chunk_len
    self.compressed_data = ''

  def append_chunk(self, amount, chunk):
    if amount == 1:
      self.compressed_data += chunk
    else:
      self.compressed_data += str(amount) + chunk

  def get_chunk(self):
    return self.data[:self.chunk_len]

  def pop_chunk(self):
    poped = self.data[:self.chunk_len]
    self.data = self.data[self.chunk_len:]
    return poped

  def check_not_finish_parsing_data(self):
    return len(self.data) >= self.chunk_len

  def add_remain_data(self):
    self.compressed_data += self.data

  def post_processing(self, chunk_count, compared_from):
    self.append_chunk(chunk_count, compared_from)
    self.add_remain_data()

  def compress(self):
    chunk_count = 0
    compared_from = self.get_chunk()
    compared_to = ''

    while self.check_not_finish_parsing_data():
      compared_to = self.pop_chunk()

      if compared_from == compared_to:
        chunk_count = chunk_count + 1
      else:
        self.append_chunk(chunk_count, compared_from)
        chunk_count = 1
        compared_from = compared_to

    self.post_processing(chunk_count, compared_from)
    return self.compressed_data




class Calculator:
  def __init__(self, data):
    self.data = data

  def get_max_chunk_len(self, length):
    return length // 2

  def _calculate_min_length_of_compress_initial_data(self):
    max_chunk_len = self.get_max_chunk_len(len(self.data))
    chunk_len = 1
    min_length = len(self.data)
    return [max_chunk_len, chunk_len, min_length]

  def calculate_min_length_of_compress(self):
    max_chunk_len, chunk_len, min_length = self._calculate_min_length_of_compress_initial_data()

    while chunk_len <= max_chunk_len:
      compressor = Compressor(self.data, chunk_len)
      min_length = min(
        min_length,
        len(compressor.compress())
      )
      chunk_len = chunk_len + 1
    
    return min_length

if __name__ == "__main__":
  s = input()
  calculater = Calculator(s)
  print(calculater.calculate_min_length_of_compress())
