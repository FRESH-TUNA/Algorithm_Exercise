def append_chunk(source, amount, chunk):
    if amount == 1:
        return source + chunk
    else:
        return source + str(amount) + chunk

def get_chunk(data, chunk_len):
    return data[:chunk_len]

def remove_chunk(data, chunk_len):
    return data[chunk_len:]

def check_not_finish_parsing_data(data, chunk_len):
    return len(data) >= chunk_len

def get_max_chunk_len(length):
    return length // 2

def add_remain_data(data, remain_data):
    return data + remain_data

def compress(data, chunk_len):
    compared_from = get_chunk(data, chunk_len)
    chunk_count = 0
    compressed_data = ''
    while check_not_finish_parsing_data(data, chunk_len):
        compared_to = get_chunk(data, chunk_len)
        data = remove_chunk(data, chunk_len)
        if compared_from == compared_to:
            chunk_count = chunk_count + 1
        else:
            compressed_data = append_chunk(
                compressed_data, chunk_count, compared_from
            )
            chunk_count = 1
            compared_from = compared_to
    compressed_data = append_chunk(compressed_data, chunk_count, compared_from)
    return add_remain_data(compressed_data, data)


def calculate_min_length_of_compress(data):
    max_chunk_len = get_max_chunk_len(len(data))
    chunk_len = 1
    min_length = len(data)

    while chunk_len <= max_chunk_len:
        min_length = min(
            min_length,
            len(compress(data, chunk_len))
        )
        chunk_len = chunk_len + 1
    return min_length

if __name__ == "__main__":
    s = input()
    print(calculate_min_length_of_compress(s))
