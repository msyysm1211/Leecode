package com.Problem.Q500_Q999;

public class Solution0733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        DFS(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    void DFS(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sc < 0 || sr > image.length - 1 || sc > image[0].length - 1 || newColor == oldColor || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        DFS(image, sr - 1, sc, oldColor, newColor);
        DFS(image, sr + 1, sc, oldColor, newColor);
        DFS(image, sr, sc - 1, oldColor, newColor);
        DFS(image, sr, sc + 1, oldColor, newColor);
    }

}

