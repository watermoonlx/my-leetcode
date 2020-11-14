package 回溯;

public class 单词搜索_79 {

    private static int[][] fourDirections = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] used = new boolean[board.length][board[0].length];
                used[i][j] = true;
                boolean exists = this.existRec(board, word, 0, used, new int[]{i, j});
                if (exists) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existRec(char[][] board, String word, int wordIndex, boolean[][] used, int[] pos) {

        if (wordIndex == word.length() - 1) {
            return board[pos[0]][pos[1]] == word.charAt(wordIndex);
        } else {
            if (board[pos[0]][pos[1]] != word.charAt(wordIndex)) {
                return false;
            }

            boolean exists = false;
            for (int[] direction : fourDirections) {
                pos[0] = pos[0] + direction[0];
                pos[1] = pos[1] + direction[1];
                if (pos[0] < board.length && pos[0] >= 0
                        && pos[1] < board[0].length && pos[1] >= 0
                        && !used[pos[0]][pos[1]]) {
                    used[pos[0]][pos[1]] = true;
                    exists = this.existRec(board, word, wordIndex + 1, used, pos);
                    used[pos[0]][pos[1]] = false;
                }
                pos[0] = pos[0] - direction[0];
                pos[1] = pos[1] - direction[1];
                if (exists) {
                    break;
                }
            }
            return exists;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'a', 'a'}
        };
        System.out.println(new 单词搜索_79().exist(board, "aaa"));
    }
}
