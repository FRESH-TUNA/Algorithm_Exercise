def solution(prices):
    result = []
    for parent_index, parent_value in enumerate(prices):
        result.append(len(prices) - parent_index - 1)
         for child_index, child_value in enumerate(prices[parent_index + 1:]):
            if parent_value > child_value:
                result[parent_index] = result[parent_index] - 1    
    return result
