package com.practice.sp.solutions;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Leetcode# 36
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {
    private static class Square {
        int row;
        int col;

        public Square(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if(obj == null || obj.getClass()!= this.getClass())
                return false;

            Square other = (Square) obj;
            return this.row == other.row
                    && this.col == other.col;
        }

        // Intellij generated hashcode
        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public static boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new Set[9];
        IntStream.range(0, 8).forEach(e -> rows[e] = new HashSet<>());

        Set<Character>[] cols = new Set[9];
        IntStream.range(0, 8).forEach(e -> cols[e] = new HashSet<>());

        HashMap<Square, Set<Character>> squares = new LinkedHashMap<>();

        for(int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++) {
                if('.' == (board[r][c])) continue;

                if(rows[r].contains(board[r][c])
                        || cols[c].contains(board[r][c])
                ) return false;

                rows[r].add(board[r][c]);
                cols[c].add(board[r][c]);

                Square square = new Square(r/3, c/3);
                squares.computeIfAbsent(square, k -> new HashSet<>());
            }
        }

        /**
         * Imagine the sudoku(9 * 9) as a square containing  3*3 squares.
         * Individual boxes will have indices(row, col) as (00, 01, 02, 10, 11, 12, 20, 21, 22).
         * Comparing the indices(r, c) of actual sudoku with the indices our imaginary box(row, col)
         * we get a relationship as (r/3, c/3) == (row, col).
         * This relationship enables us to store values of squares of the sudoku inside our own 3*3 box.
         */
        for(int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++) {
                if('.' == (board[r][c])) continue;

                Square square = new Square(r/3, c/3);
                if(squares.get(square)
                        .contains(board[r][c])) return false;

                squares.get(square).add(board[r][c]);
            }
        }
        return true;
    }

    public static void main(String[] args) {

        /*
        sudoku board =
            [["5", "3", ".", ".", "7", ".", ".", ".", "."]
            ,["6", ".", ".", "1", "9", "5", ".", ".", "."]
            ,[".", "9", "8", ".", ".", ".", ".", "6", "."]
            ,["8", ".", ".", ".", "6", ".", ".", ".", "3"]
            ,["4", ".", ".", "8", ".", "3", ".", ".", "1"]
            ,["7", ".", ".", ".", "2", ".", ".", ".", "6"]
            ,[".", "6", ".", ".", ".", ".", "2", "8", "."]
            ,[".", ".", ".", "4", "1", "9", ".", ".", "5"]
            ,[".", ".", ".", ".", "8", ".", ".", "7", "9"]]
        Output is true
        */
    }
}
