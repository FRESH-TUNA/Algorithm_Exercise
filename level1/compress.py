def append_chunk(amount, source, chunk):
    if amount == 1:
        return source + chunk
    else:
        return source + str(amount) + chunk

def compress(data, chunk, amount, result):
    for x in data:
        if x == chunk:
            amount = amount + 1
        else:
            result = append_chunk(amount, result, chunk)
            chunk = x
            amount = 1
    return append_chunk(amount, result, chunk)

def calculate_min_length_of_compress(data):
    chunk = data[0]
    amount = 0
    result = ''
    return compress(data, chunk, amount, result)

if __name__ == "__main__":
    s = input()
    print(calculate_min_length_of_compress(s))
