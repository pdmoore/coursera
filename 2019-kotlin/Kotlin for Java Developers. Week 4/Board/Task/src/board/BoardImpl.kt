package board

import board.Direction.*
import java.util.*

fun createSquareBoard(width: Int): SquareBoard {
    var board = BoardImpl(width)

    return board

}


fun <T> createGameBoard(width: Int): GameBoard<T> = TODO()

data class BoardImpl(override val width: Int) : SquareBoard {
    override fun getCell(i: Int, j: Int): Cell {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllCells(): Collection<Cell> {
        val cell1 = Cell(1, 1)
        val cell2 = Cell(1, 2)
        val cell3 = Cell(2, 1)
        val cell4 = Cell(2, 2)
        val cells = listOf(cell1, cell2, cell3, cell4)
        return cells
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
