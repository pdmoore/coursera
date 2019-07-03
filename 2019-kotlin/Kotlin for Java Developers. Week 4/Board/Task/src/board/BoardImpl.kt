package board

import board.Direction.*

fun createSquareBoard(width: Int): SquareBoard {
    return BoardImpl(width)
}


fun <T> createGameBoard(width: Int): GameBoard<T> = TODO()

data class BoardImpl(override val width: Int) : SquareBoard {
    var squareBoard = arrayOf<Array<Cell>>()


    init {
        for (i in 1..width) {
            var rowCells = arrayOf<Cell>()

            for (j in 1..width) {
                val cell = Cell(i, j)
                rowCells += cell
            }

            squareBoard += rowCells
        }
    }

    override fun getCell(i: Int, j: Int): Cell {
        return squareBoard.get(i - 1).get(j - 1)
    }

    override fun getAllCells(): Collection<Cell> {
        return squareBoard.flatten()
    }

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        return squareBoard.get(i - 1).toList()
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? {
        return when (direction) {
            UP -> getCellOrNull(i - 1, j)
            DOWN -> getCellOrNull(i + 1, j)
            LEFT -> getCellOrNull(i, j - 1)
            RIGHT -> getCellOrNull(i, j + 1)
        }
    }

    override fun getCellOrNull(i: Int, j: Int): Cell? {
        return squareBoard?.getOrNull(i - 1)?.getOrNull(j - 1)
    }
}
