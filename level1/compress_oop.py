class Compressor:
  def __init__(self, data):
    self.data = data

  def append_chunk(self, source, amount, chunk):
    if amount == 1:
      return source + chunk
    else:
      return source + str(amount) + chunk

  def get_chunk(self, remain_data, chunk_len):
    return remain_data[:chunk_len]

  def remove_chunk(self, remain_data, chunk_len):
    return remain_data[chunk_len:]

  def check_not_finish_parsing_data(self, remain_data, chunk_len):
    return len(remain_data) >= chunk_len

  def get_max_chunk_len(self, length):
    return length // 2

  def add_remain_data(self, data, remain_data):
    return data + remain_data

  def _compress_initial_data(self, chunk_len):
    compared_from = self.get_chunk(self.data, chunk_len)
    chunk_count = 0
    compressed_data = ''
    remain_data = self.data
    return [compared_from, chunk_count, compressed_data, remain_data]

  def compress(self, chunk_len):
    compared_from, chunk_count, compressed_data, remain_data = self._compress_initial_data(chunk_len)

    while self.check_not_finish_parsing_data(remain_data, chunk_len):
      compared_to = self.get_chunk(remain_data, chunk_len)
      remain_data = self.remove_chunk(remain_data, chunk_len)

      if compared_from == compared_to:
        chunk_count = chunk_count + 1
      else:
        compressed_data = self.append_chunk(
          compressed_data, chunk_count, compared_from
        )
        chunk_count = 1
        compared_from = compared_to

        compressed_data = self.append_chunk(
          compressed_data, chunk_count, compared_from
        )
        return self.add_remain_data(compressed_data, remain_data)

  def _calculate_min_length_of_compress_initial_data(self):
    max_chunk_len = self.get_max_chunk_len(len(self.data))
    chunk_len = 1
    min_length = len(self.data)
    return [max_chunk_len, chunk_len, min_length]

  def calculate_min_length_of_compress(self):
    max_chunk_len, chunk_len, min_length = self._calculate_min_length_of_compress_initial_data()

    while chunk_len <= max_chunk_len:
      min_length = min(
        min_length,
        len(self.compress(chunk_len))
      )
      chunk_len = chunk_len + 1
    
    return min_length


if __name__ == "__main__":
  s = input()
  calculater = Compressor(s)
  print(calculater.calculate_min_length_of_compress())
