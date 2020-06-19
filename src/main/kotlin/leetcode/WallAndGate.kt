package leetcode

import java.util.*

/**
 * You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example:

Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
0  -1 INF INF
After running your function, the 2D grid should be:

3  -1   0   1
2   2   1  -1
1  -1   2  -1
0  -1   3   4
 */

class WallAndGate {
    fun wallsAndGates(rooms: Array<IntArray>) {
        val EMPTY = Int.MAX_VALUE
        val GATE = 0
        val wall = -1
        val paths = listOf(arrayOf(0, -1), arrayOf(0, 1), arrayOf(-1, 0), arrayOf(1, 0))
        val queue = LinkedList<Array<Int>>()
        val height = rooms.size
        if(height == 0) return
        val width = rooms[0].size
        for (i in 0 until height) {
            for (j in 0 until width) {
                if (rooms[i][j] == GATE) {
                    queue.add(arrayOf(i, j))
                }
            }
        }

        while (queue.isNotEmpty()) {
            for (i in 0 until queue.size) {
                val p = queue.pop()
                val row = p[0]
                val col = p[1]
                paths.forEach { path ->
                    val r = row + path[0]
                    val c = col + path[1]
                    if (r < 0 || c < 0 || r >= height || c >= width || rooms[r][c] != EMPTY) {
//                        Skip
                    } else {
                        rooms[r][c] = rooms[row][col] + 1
                        queue.add(arrayOf(r, c))
                    }
                }
            }
        }
    }
}