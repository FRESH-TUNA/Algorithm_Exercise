def solution(skill, skill_trees):
    print(list(skill))
    reducer = lambda x: ''.join(filter(
        lambda y: y in list(skill),
        list(x)
    ))

    calculator =  lambda x: skill.find(x) == 0 or len(x) == 0
    skill_trees = list(map(reducer, skill_trees))
    return len(list(filter(calculator, skill_trees)))

print(solution("CBD", ["AF"]))