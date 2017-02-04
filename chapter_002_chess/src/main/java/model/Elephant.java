package model;

import exception.ImpossibleMoveException;

/**
 * Class
 *
 * @author Matveev Evgeny.
 * @version 1.0.
 * @since 04.02.17.
 */
public class Elephant extends Figure {

    Elephant(Cell position) {
        super(position);
    }

    private Cell[] cells;

    public Cell[] way(Cell dist) throws ImpossibleMoveException {

        int dx = dist.getX();
        int dy = dist.getY();
        int px = position.getX();
        int py = position.getY();

        if (px > dx && py > dy) {
            if (px - dx == py - dy) {
                cells = new Cell[px - dx];
                for (int i = px - 1, j = py - 1, k = 0; k < px - dx; i--, j--, k++) {
                    cells[k] = new Cell(i, j);
                }
            }
        } else if (px < dx && py > dy) {
            if (dx - px == py - dy) {
                cells = new Cell[dx - px];
                for (int i = px + 1, j = py - 1, k = 0; k < dx - px; i++, j--, k++) {
                    cells[k] = new Cell(i, j);
                }
            }
        } else if (px > dx && py < dy) {
            if (px - dx == dy - py) {
                cells = new Cell[px - dx];
                for (int i = px - 1, j = py + 1, k = 0; k < px - dx; i--, j++, k++) {
                    cells[k] = new Cell(i, j);
                }
            }
        } else if (px < dx && py < dy) {
            if (dx - px == dy - py) {
                cells = new Cell[px - dx];
                for (int i = px - 1, j = py + 1, k = 0; k < px - dx; i--, j++, k++) {
                    cells[k] = new Cell(i, j);
                }
            }
        } else {
            throw new ImpossibleMoveException("Так ходить нельзя");
        }

        for (Cell s : cells) {
            System.out.printf("%s %s" + " " + "\n", s.getX(), s.getY());
        }

        for (Cell s : cells) {
            System.out.println(s);
        }

        return cells;
    }

}


