package board

import board.Direction.*
import kotlin.math.min

fun createSquareBoard(width: Int): SquareBoard {
    return BoardImpl(width)
}


fun <T> createGameBoard(width: Int): GameBoard<T> {
    return BoardGameImpl<T>(width)
}


data class BoardGameImpl<T>(override val width: Int) : GameBoard<T> {
    var squareBoard: SquareBoard
    lateinit var cellMap: HashMap<Cell, T?>

    init {
        squareBoard = createSquareBoard(width)
        cellMap = hashMapOf<Cell, T?>()

        // stuff null in all cells
        squareBoard.getAllCells().forEach { it -> cellMap.put(it, null) }
    }

    override fun getCellOrNull(i: Int, j: Int): Cell? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCell(i: Int, j: Int): Cell {
        return squareBoard.getCell(i, j)
    }

    override fun getAllCells(): Collection<Cell> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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

    override fun get(cell: Cell): T? {
        return cellMap[cell]
    }

    override fun find(predicate: (T?) -> Boolean): Cell? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun set(cell: Cell, value: T?) {
        value?.let { cellMap.put(cell, it) }
    }

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> {
        return cellMap.filterValues(predicate).keys
    }

    override fun all(predicate: (T?) -> Boolean): Boolean {
        return cellMap.filterValues(predicate).size.equals(width * width)
    }

    override fun any(predicate: (T?) -> Boolean): Boolean {

        // This is failing Test 4 second assert
        // it is checking for any cell mapping to null.
        // Right now only populating cellMap on set, can resolve this be initializing cellMap cells -> null at start

        return cellMap.filterValues(predicate).isNotEmpty()
    }
}

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

        if (iRange.step < 0) {
            for (index in iRange.last..iRange.first) {
                val row = squareBoard.get(index - 1)
                column += row.get(j - 1)
            }

            return column.toList().reversed()
        }

        val bound = min(iRange.last, width)
        for (index in iRange.first..bound) {
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
