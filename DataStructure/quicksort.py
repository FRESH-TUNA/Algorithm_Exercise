def quicksort(arr):
    stack = [[0, len(arr) - 1]]

    while len(stack) > 0:
        low = stack[0][0]
        high = stack[0][1]
        stack = stack[1:]

        mid = partition(arr, low, high)

        if low < mid - 1:
            stack = stack + [[low, mid - 1]]
        if mid + 1 < high:
            stack = stack + [[mid + 1, high]]

def swap(arr, i, j):
    temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp

def partition(arr, low, high):
    pivot_index = high
    pivot_value = arr[high]
    mid = -1
    
    for index, value in enumerate(arr):
        if value < pivot_value:
            mid = mid + 1
            swap(arr, index, mid)
    
    mid = mid + 1
    swap(arr, mid, pivot_index)
    return mid

if __name__ == "__main__":
    arr = [2, 4, 1, 2, 4]
    quicksort(arr)
    print(arr)

    arr = [10, 80, 30, 90, 40, 50, 70]
    quicksort(arr)
    print(arr)