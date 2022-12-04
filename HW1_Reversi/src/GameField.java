import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GameField {

    /// Private fields.
    private static final int GAME_FIELD_SIZE = 8;
    private final HashMap<GameFieldSquare, GameFieldDisk> positions;
    private ArrayList<int[]> deltas;

    /// Constructor for game initial field creation.
    public GameField() {
        positions = new HashMap<>();
        for (int row = 0; row < GAME_FIELD_SIZE; ++row) {
            for (int column = 0; column < GAME_FIELD_SIZE; ++column) {
                GameFieldDisk diskColor = GameFieldDisk.NO_PLAYER;
                if ((row == 3 && column == 3) || (row == 4 && column == 4)) {
                    diskColor = GameFieldDisk.WHITE_PLAYER;
                }
                if ((row == 3 && column == 4) || (row == 4 && column == 3)) {
                    diskColor = GameFieldDisk.BLACK_PLAYER;
                }
                positions.put(new GameFieldSquare(row, column), diskColor);
            }
        }
        fillDeltasArray();
    }

    public HashMap<GameFieldSquare, GameFieldDisk> getPositions() {
        return positions;
    }

    /// Method which returns the amount of white and black disks.
    public int[] getWhiteAndBlackCount() {
        int black = 0;
        int white = 0;
        for (var disk : positions.values()) {
            if (disk == GameFieldDisk.BLACK_PLAYER) {
                black++;
            }
            if (disk == GameFieldDisk.WHITE_PLAYER) {
                white++;
            }
        }
        return new int[]{white, black};
    }

    /// Method which finds possible moves.
    public ArrayList<ArrayList<GameFieldSquare>> findMoves(GameFieldDisk disk) {
        ArrayList<ArrayList<GameFieldSquare>> foundMoves = new ArrayList<>();

        for (GameFieldSquare square : positions.keySet()) {
            if (positions.get(square) != GameFieldDisk.NO_PLAYER) continue;
            for (int[] delta : deltas) {
                int newRow = square.getCoordinates()[0] + delta[0];
                int newColumn = square.getCoordinates()[1] + delta[1];
                if (newRow < 0 || newRow > 7 || newColumn < 0 || newColumn > 7) continue;

                GameFieldSquare tempSquare = new GameFieldSquare(newRow, newColumn);
                if (positions.get(tempSquare) == disk) continue;

                GameFieldSquare squareToPlace = new GameFieldSquare(newRow - delta[0], newColumn - delta[1]);

                ArrayList<GameFieldSquare> disksToChangeInMove = new ArrayList<>();
                boolean coordinatesInField = true;
                while (coordinatesInField) {
                    if (positions.get(tempSquare) == GameFieldDisk.NO_PLAYER) break;
                    if (positions.get(tempSquare) == disk) {
                        disksToChangeInMove.add(squareToPlace);
                        foundMoves.add(disksToChangeInMove);
                        break;
                    } else {
                        disksToChangeInMove.add(tempSquare);
                        tempSquare = new GameFieldSquare(
                                tempSquare.getCoordinates()[0] + delta[0],
                                tempSquare.getCoordinates()[1] + delta[1]
                        );
                        if (!positions.containsKey(tempSquare)) {
                            coordinatesInField = false;
                        }
                    }
                }
            }
        }

        // Code below checks if there are moves with the same first disk coordinates but different coordinates for placing disks.
        HashMap<GameFieldSquare, ArrayList<ArrayList<GameFieldSquare>>> movesWithFirstSquareCount = new HashMap<>();
        for (var move : foundMoves) {
            GameFieldSquare firstSquareOfMove = move.get(move.size() - 1);
            if (!movesWithFirstSquareCount.containsKey(firstSquareOfMove)) {
                movesWithFirstSquareCount.put(firstSquareOfMove, new ArrayList<>());

            }
            movesWithFirstSquareCount.get(firstSquareOfMove).add(move);
        }
        for (var move : movesWithFirstSquareCount.keySet()) {
            if (movesWithFirstSquareCount.get(move).size() > 1) {
                ArrayList<ArrayList<GameFieldSquare>> movesWithSameFirstSquare = new ArrayList<>();
                for (var sameMove : movesWithFirstSquareCount.get(move)) {
                    movesWithSameFirstSquare.add(sameMove);
                    foundMoves.remove(sameMove);
                }
                HashSet<GameFieldSquare> finalMove = new HashSet<>();
                for (var sameMove : movesWithSameFirstSquare) {
                    finalMove.addAll(sameMove);
                }
                ArrayList<GameFieldSquare> finalMoveArrayList = new ArrayList<>(finalMove);
                foundMoves.add(finalMoveArrayList);
            }
        }

        return foundMoves;
    }

    /// Method for execution of the move.
    public void makeMoveOnField(ArrayList<GameFieldSquare> squaresToPlace, GameFieldDisk diskColor) {
        for (var square : squaresToPlace) {
            positions.replace(square, diskColor);
        }
    }

    /// Method that fills deltas for each of 8 directions.
    private void fillDeltasArray() {
        deltas = new ArrayList<>();
        deltas.add(new int[]{0, 1});
        deltas.add(new int[]{1, 0});
        deltas.add(new int[]{-1, 0});
        deltas.add(new int[]{0, -1});
        deltas.add(new int[]{1, 1});
        deltas.add(new int[]{-1, -1});
        deltas.add(new int[]{-1, 1});
        deltas.add(new int[]{1, -1});
    }
}