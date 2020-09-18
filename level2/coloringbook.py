class ColoringBook:
    def __init__(self, *args, **kwargs):
        self.row = self.col = None
        self.picture = self.isTraced = None
        self.spaces = 0
        self.max_space_area = 0
        for key, value in kwargs.items():
            setattr(self, key, value)
        self.is_traced = [
            [False for _ in range(self.col)] for _ in range(self.row)
        ]
    

    def bfs(self, row, col, parent):
        def traceable(obj, row, col):
            return row >= 0 \
                and row < obj.row \
                and col >= 0 \
                and col < obj.col

        if not traceable(self, row, col):
            return 0

        if self.is_traced[row][col]:
            return 0
        
        color = self.picture[row][col]
        
        if color == 0 or color != parent:
            return 0

        self.is_traced[row][col] = True
        
        return sum([
            1,
            self.bfs(row - 1, col, color),
            self.bfs(row + 1, col, color),
            self.bfs(row, col - 1, color),
            self.bfs(row, col + 1, color)
        ])

    def call(self):
        for row in range(self.row):
            for col in range(self.col):
                if not self.is_traced[row][col]:
                    area = self.bfs(row, col, self.picture[row][col])
                    if area > 0:
                        self.spaces += 1
                    if area > self.max_space_area: 
                        self.max_space_area = area
        return [self.spaces, self.max_space_area]

picture = [[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]
obj = ColoringBook(row=6, col=4, picture=picture)
print(obj.call())
