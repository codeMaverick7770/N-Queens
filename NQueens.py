# n_queens_solver.py

class NQueensSolver:
    def __init__(self, n):
        self.n = n
        self.solutions = []

    def solve(self):
        board = [-1] * self.n
        self._place_queens(board, 0)
        return self.solutions

    def _place_queens(self, board, row):
        if row == self.n:
            self.solutions.append(self._format_solution(board))
            return

        for col in range(self.n):
            if self._is_valid(board, row, col):
                board[row] = col
                self._place_queens(board, row + 1)
                board[row] = -1

    def _is_valid(self, board, row, col):
        for i in range(row):
            if board[i] == col or \
               board[i] - i == col - row or \
               board[i] + i == col + row:
                return False
        return True

    def _format_solution(self, board):
        return [[1 if col == board[row] else 0 for col in range(self.n)] for row in range(self.n)]

if __name__ == "__main__":
    n = int(input("Enter the value of N: "))
    solver = NQueensSolver(n)
    solutions = solver.solve()
    print(f"Found {len(solutions)} solutions.")
    for solution in solutions:
        for row in solution:
            print(" ".join(str(cell) for cell in row))
        print()

