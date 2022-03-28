package com.tech.interview.playground.two_d;

import java.util.HashSet;

/**
 * Sudoku Board:
 * Row should not have duplicate values and in range [1-9]
 * Columns should not have duplicate values and in range [1-9]
 * 3*3 matrix should not have duplicates and in range [1-9]
 * <p>
 * {
 * {7, 9, 2, 1, 5, 4, 3, 8, 6},
 * {6, 4, 3, 8, 2, 7, 1, 5, 9},
 * {8, 5, 1, 3, 9, 6, 7, 2, 4},
 * {2, 6, 5, 9, 7, 3, 8, 4, 1},
 * {4, 8, 9, 5, 6, 1, 2, 7, 3},
 * {3, 1, 7, 4, 8, 2, 9, 6, 5},
 * {1, 3, 6, 7, 4, 8, 5, 9, 2},
 * {9, 7, 4, 2, 1, 5, 6, 3, 8},
 * {5, 2, 8, 6, 3, 9, 4, 1, 7}
 * }
 * O/P- Valid
 */
public class ValidSudoku {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {7, 9, 2, 1, 5, 4, 3, 8, 6},
                {6, 4, 3, 8, 2, 7, 1, 5, 9},
                {8, 5, 1, 3, 9, 6, 7, 2, 4},
                {2, 6, 5, 9, 7, 3, 8, 4, 1},
                {4, 8, 9, 5, 6, 1, 2, 7, 3},
                {3, 1, 7, 4, 8, 2, 9, 6, 5},
                {1, 3, 6, 7, 4, 8, 5, 9, 2},
                {9, 7, 4, 2, 1, 5, 6, 3, 8},
                {5, 2, 8, 6, 3, 9, 4, 1, 7}
        };

        ValidSudoku validSudoku = new ValidSudoku();
        if (validSudoku.checkDuplicateInCol(board) && validSudoku.checkDuplicateInRow(board) && validSudoku.check3_3Matrix(board)) {
            System.out.println("Not Valid");
        } else {
            System.out.println("Valid");
        }
    }

    boolean checkDuplicateInRow(int[][] board) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            HashSet<Integer> rowElements = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (rowElements.contains(board[i][j])) {
                    result = true;
                    return result;
                } else {
                    result = false;
                    rowElements.add(board[i][j]);
                }
            }
        }
        return result;
    }

    boolean checkDuplicateInCol(int[][] board) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            HashSet<Integer> colElements = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (colElements.contains(board[j][i])) {
                    result = true;
                    return result;
                } else {
                    result = false;
                    colElements.add(board[j][i]);
                }
            }
        }
        return result;
    }

    boolean check3_3Matrix(int[][] board) {
        boolean result = false;
        for (int i = 0; i < board.length - 2; i += 3) {
            for (int j = 0; j < board[0].length - 2; j += 3) {
                HashSet<Integer> crossCheck = new HashSet<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int xAxis = i + k;
                        int yAxis = j + l;
                        if (crossCheck.contains(board[xAxis][yAxis])) {
                            result = true;
                            return result;
                        } else {
                            result = false;
                            crossCheck.add(board[xAxis][yAxis]);
                        }
                    }
                }
            }

        }
        return result;
    }
}
