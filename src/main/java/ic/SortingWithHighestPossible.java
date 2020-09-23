package ic;

import java.util.Arrays;

/**
 * /**
 * You created a game that is more popular than Angry Birds.
 * Each round, players receive a score between 0 and 100, which you use to rank them from highest to lowest. So far you're using an algorithm that sorts in
 * O(nlog(n)) time, but players are complaining that their rankings aren't updated fast enough. You need a faster sorting algorithm.
 *
 * Write a method that takes:
 *
 * an array of unsortedScores
 * the highestPossibleScore in the game
 * and returns a sorted array of scores in less than O(nlog(n)) time.
 *
 * For example:
 *
 * int[] unsortedScores = {37, 89, 41, 65, 91, 53};
 * final int HIGHEST_POSSIBLE_SCORE = 100;
 *
 * int[] sortedScores = sortScores(unsortedScores, HIGHEST_POSSIBLE_SCORE);
 * // sortedScores: [91, 89, 65, 53, 41, 37]
 *
 * We’re defining n
 * n as the number of unsortedScores because we’re expecting the number of players to keep climbing.
 *
 * And, we'll treat highestPossibleScore as a constant instead of factoring it into our big O time and space costs because
 * the highest possible score isn’t going to change.
 * Even if we do redesign the game a little, the scores will stay around the same order of magnitude.
 */
public class SortingWithHighestPossible {
    public int[] sortedScores(int[] unsortedScores, int HIGHEST_POSSIBLE_SCORE) {
        int[] scoreHolders = new int[HIGHEST_POSSIBLE_SCORE + 1];
        int totalPlayers = 0;
        for (int i : unsortedScores) {
            if (i <= HIGHEST_POSSIBLE_SCORE) {
                scoreHolders[i] = scoreHolders[i] + 1;
                totalPlayers ++;
            }
        }
        int[] sortedScores = new int[totalPlayers];
        int sortedIndex = 0;
        for (int i = HIGHEST_POSSIBLE_SCORE; i >= 0; i--) {
            if (scoreHolders[i] > 0) {
                for (int j = 0; j < scoreHolders[i]; j++) {
                    sortedScores[sortedIndex++] = i;
                }
            }
        }
        return sortedScores;
    }

    public static void main(String[] args) {
        SortingWithHighestPossible solution = new SortingWithHighestPossible();
        int[] input = {91, 89, 65, 53, 41, 37, 53, 37, 101, 500};
        int[] sorted = solution.sortedScores(input, 100);
        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i] + ", ");
        }
    }
}
