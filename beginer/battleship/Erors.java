package battleship;


class Eror{

    public static void  CaseSet(int[]StartCord, int[]EndCord, String[][]Field, String PsedoField[][]){

        switch (CheckSet(StartCord, EndCord,Field)){
            case ("Eror: 1"):
            {

                System.out.printf("Error! Wrong length of the %s! Try again\n\n", Ships.NameShips[Ships.CounterShips]);
                --Ships.CounterShips;

                break;
            }
            case ("Eror: 2"):
            {
                --Ships.CounterShips;
                System.out.println("Error! You placed it too close to another one. Try again:\n");

                break;
            }
            case("True"):{
                GameHelp.PlaceShip(StartCord,EndCord, Field, PsedoField);
                GameHelp.PrintBoard(Field);
                break;
            }
            default:{
                --Ships.CounterShips;
                System.out.println("Error! Wrong ship location! Try again:\n");

                break;
            }

        }

    }

    private static String CheckSet(int[]StartCord, int[]EndCord, String Field [][]){
        if ((StartCord[0] == EndCord[0] && (Math.max(StartCord[1],EndCord[1])-Math.min(StartCord[1],EndCord[1])) + 1 != Ships.LenghtShips[Ships.CounterShips])
                ||((StartCord[1] == EndCord[1] && (Math.max(StartCord[0],EndCord[0])-Math.min(StartCord[0],EndCord[0])) + 1 !=  Ships.LenghtShips[Ships.CounterShips]))){
            return "Eror: 1";
        } else if (ClotheToAnother(StartCord, EndCord, Field)) {
            return "Eror: 2";

        } else if ((StartCord[0] == EndCord[0] && (Math.max(StartCord[1],EndCord[1])-Math.min(StartCord[1],EndCord[1])) + 1 == Ships.LenghtShips[Ships.CounterShips])
                ||((StartCord[1] == EndCord[1] && (Math.max(StartCord[0],EndCord[0])-Math.min(StartCord[0],EndCord[0])) + 1 ==  Ships.LenghtShips[Ships.CounterShips]))) {
            return "True";
        }
        return "";

    }
    private static Boolean ClotheToAnother (int[]StartCord, int[]EndCord, String[][] field){
        int StarLine = Math.min(StartCord[0],EndCord[0]);
        int StarColumn = Math.min(StartCord[1],EndCord[1]);
        int EndLine = Math.max(StartCord[0],EndCord[0]);
        int EndColumn = Math.max(StartCord[1],EndCord[1]);

        int tempStartLine = Math.max(StarLine, 1);
        int tempEndLine = Math.min(EndLine, 8);
        int tempStartColumn = Math.max(StarColumn, 1);
        int tempEndColumn = Math.min(EndColumn, 8);

        for (int i = tempStartLine; i <= tempEndLine; i++) {
            for (int j = tempStartColumn; j <= tempEndColumn; j++) {
                if (field[i][j - 1] == (Symbol.Ship) ||
                        field[i][j + 1] == (Symbol.Ship) ||
                        field[i - 1][j] == (Symbol.Ship) ||
                        field[i + 1][j] == (Symbol.Ship) ||
                        field[i - 1][j - 1] == (Symbol.Ship) ||
                        field[i + 1][j - 1] == (Symbol.Ship) ||
                        field[i - 1][j + 1] == (Symbol.Ship) ||
                        field[i + 1][j + 1] == (Symbol.Ship)) {
                    return true;
                }
            }
        }

        for (int i = StarLine; i <= EndLine; ++i) {
            for (int j = StarColumn; j <= EndColumn; ++j) {
                if (field[i][j] == Symbol.Ship);
                return false;
            }
        }

        return true;
    }

}



