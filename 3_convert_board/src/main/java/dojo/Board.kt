package dojo

import java.util.ArrayList

class Board(private val grid: List<List<Cell>>) {

    constructor(board: Board): this(board.grid)

    operator fun set(row: Int, column: Int, value: Cell): Board {
        val gridCopy = grid.map { ArrayList(it) }
        gridCopy[row][column] = value
        return Board(gridCopy)
    }

    operator fun get(row: Int, column: Int) = grid[row][column]

    fun size() = grid.size
}
