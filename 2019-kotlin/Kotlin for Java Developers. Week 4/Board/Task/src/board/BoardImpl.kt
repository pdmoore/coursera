package board

import board.Direction.*
import kotlin.math.min

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
        val fullRow = squareBoard.get(i - 1)

        if (jRange.step < 0) {
            var y = arrayOf<Cell>()
            for (index2 in jRange.last..jRange.first) {
                y += fullRow[index2 - 1]
            }

            return y.toList().reversed()
        }


        var y = arrayOf<Cell>()
        val bound = min(fullRow.size, jRange.last)
        for (index2 in jRange.first..bound) {
            y += fullRow[index2 - 1]
        }

        return y.toList()
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        var column = arrayOf<Cell>()

        for (index in iRange.first..iRange.last) {
            val row = squareBoard.get(index - 1)
            column += row.get(j - 1)
        }

        return column.toList()
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
