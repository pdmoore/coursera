package board

import board.Direction.*
import java.util.*

fun createSquareBoard(width: Int): SquareBoard {
    var board = BoardImpl(width)

    return board

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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllCells(): Collection<Cell> {
        return squareBoard.flatten()
    }

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCellOrNull(i: Int, j: Int): Cell? {
        return squareBoard?.getOrNull(i - 1)?.getOrNull(j - 1)
    }
}
