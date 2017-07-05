package dojo

import dojo.Cell.*
import java.util.*
import java.util.Arrays.asList

class Game private constructor(private val board: Board, private val currentPlayer: Cell) {

    constructor() : this(
            Board((0 until 3)
                    .map { ArrayList(asList(Empty, Empty, Empty)) }),
            X)

    @Throws(Game.InvalidMove::class)
    fun makeMove(move: Move, cell: Cell): Game {
        if (move.row < 0 || move.row >= board.size() || move.column < 0 || move.column >= board.size()) {
            throw InvalidMove("Invalid move: (" + move.row + "," + move.column + ") it must be between 0 and " + (board.size() - 1))
        }

        return Game(board.set(move.row, move.column, cell), if (currentPlayer == X) O else X)
    }

    fun board(): Board {
        return Board(board)
    }

    fun nextCellToPlace(): Cell {
        return currentPlayer
    }

    // TODO implement later
    val isGameOver: Boolean
        get() = false

    // TODO implement later
    val isGameADraw: Boolean
        get() = false

    class InvalidMove(message: String) : Exception(message)
}
