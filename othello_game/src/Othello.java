import java.util.Scanner;

public class Othello {
    public static void main(String[] args) {

        final int SIZE = 8;
        final int BLANK = 0;
        final int WHITE = 1;
        final int BLACK = -1;

        int boardRow, boardColumn;
        int turn;

        boolean isAnyReversed;

        int rowPosition, columnPosition;
        int rowExpected, columnExpected;
        int rowDirection, columnDirection;

        Scanner in = new Scanner(System.in);

        int[][] board = new int[SIZE][SIZE];

        board[3][3] = WHITE;
        board[3][4] = BLACK;
        board[4][3] = BLACK;
        board[4][4] = WHITE;

        turn = WHITE;

        while (true) { //보드 전체의 while문은 현재 종료 조건이 없음. 보드가 꽉 찼거나, 더 이상 놓을 곳이 없는 등의 종료 알고리즘 직접 넣어보기
            System.out.println(" 1 2 3 4 5 6 7 8"); //보드 생성
            for (boardRow = 0; boardRow < SIZE; boardRow++) {
                System.out.print(boardRow + 1);
                for (boardColumn= 0; boardColumn < SIZE; boardColumn++) {
                    switch (board[boardRow][boardColumn]) {
                        case BLANK -> System.out.print(". ");
                        case WHITE -> System.out.print("○ ");
                        case BLACK -> System.out.print("● ");
                    }
                }
                System.out.println();
            }
            System.out.println("\n" + ((turn == WHITE) ? "○(백돌)" : "●(흑돌)") + " 의 차례입니다.");
            System.out.println("위치를 선택하세요.");
            System.out.print("행? ");
            rowPosition = in.nextInt();
            System.out.print("열? ");
            columnPosition = in.nextInt();

            rowPosition--;
            columnPosition--;

            if (board[rowPosition][columnPosition] != BLANK) {
                System.out.println("놓을 수 없는 위치입니다.");
                continue;
            }

            isAnyReversed = false;

            for (rowDirection = -1; rowDirection <= 1; rowDirection++) {

                rowExpected = rowPosition + rowDirection;

                if (rowExpected < 0) {
                    continue;
                }

                if (rowExpected >= SIZE) {
                    continue;
                }

                for (columnDirection = -1; columnDirection <= 1; columnDirection++) {
                    if ((rowDirection == 0) && (columnDirection == 0)) {
                        continue;
                    }

                    columnExpected = columnPosition + columnDirection;

                    if (columnExpected < 0) {
                        continue;
                    }

                    if (columnExpected >= SIZE) {
                        continue;
                    }

                    if (board[rowExpected][columnExpected] == BLANK) {
                        continue;
                    }

                    if (board[rowExpected][columnExpected] == turn) {
                        continue;
                    }

                    while (true) {

                        rowExpected += rowDirection;

                        if (rowExpected < 0) {
                            break;
                        }

                        if (rowExpected >= SIZE){
                            break;
                        }

                        columnExpected += columnDirection;

                        if (columnExpected < 0) {
                            break;
                        }

                        if (columnExpected >= SIZE) {
                            break;
                        }

                        if (board[rowExpected][columnExpected] == BLANK) {
                            //while문에 들어온 후 break할 경우 while문 내의 rowExpected += rowDirection이
                            //적용되어 rowExpected를 초기화하기 때문에 원상복귀시켜준다
                            rowExpected -= rowDirection;
                            break;
                        }
                        if (board[rowExpected][columnExpected] != turn) {
                            continue;
                        }

                        rowExpected -= rowDirection;
                        columnExpected -= columnDirection;

                        board[rowPosition][columnPosition] = turn;

                        do {

                            board[rowExpected][columnExpected] = turn;
                            rowExpected -= rowDirection;
                            columnExpected -= columnDirection;

                        } while (board[rowExpected][columnExpected] != turn);

                        isAnyReversed = true;
                        break;
                    }
                }
            }

            if (isAnyReversed) {
                turn = (turn == WHITE ? BLACK : WHITE);
            }
            else {
                System.out.println("놓을 수 없는 위치입니다.");
            }
        }
    }
}

