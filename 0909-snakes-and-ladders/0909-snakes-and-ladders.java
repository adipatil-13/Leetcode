class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] moves = new int[n * n + 1]; 
        Arrays.fill(moves, -1);

        Queue<Integer> queue = new LinkedList<>();
        moves[1] = 0;
        queue.offer(1);

        while (!queue.isEmpty()) {
            int currentSquare = queue.poll();

            for (int diceRoll = 1; diceRoll <= 6; diceRoll++) {
                int nextSquare = currentSquare + diceRoll;
                if (nextSquare > n * n) break;

                // Convert the 1D square number to 2D board coordinates
                int boardRow = (nextSquare - 1) / n;
                int boardCol = (nextSquare - 1) % n;

                // Boustrophedon order
                if (boardRow % 2 == 1) boardCol = n - 1 - boardCol;
                
                // The board is indexed from top-left (0,0), but we start from bottom-left
                int boardValue = board[n - 1 - boardRow][boardCol];

                // Determine final destination after checking for a snake or ladder
                int destinationSquare = (boardValue > 0) ? boardValue : nextSquare;

                if (destinationSquare == n * n) {
                    return moves[currentSquare] + 1;
                }

                // If destination has not been visited, record the moves and add it to  queue
                if (moves[destinationSquare] == -1) {
                    moves[destinationSquare] = moves[currentSquare] + 1;
                    queue.offer(destinationSquare);
                }
            }
        }
        return -1;
    }
}