package dojo

class BoardRenderer(private val board: Board) {

    fun render(): String {
        return (0 until board.size())
                .map{ this.renderRow(it) }
                .joinToString("-----\n")
    }

    private fun renderRow(row: Int): String {
        return (0 until board.size())
                .map { column -> renderCell(row, column) + squareSeparator(column) }
                .joinToString("") + "\n"
    }

    private fun renderCell(row: Int, column: Int): String {
        when (board[row, column]) {
            Cell.X -> return "X"
            Cell.O -> return "O"
            Cell.Empty -> return " "
            else -> throw IllegalStateException("It never happens!")
        }
    }

    private fun squareSeparator(column: Int): String = if (column < board.size() - 1) "|" else ""
}
