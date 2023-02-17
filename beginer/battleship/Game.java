package battleship;


import java.util.Scanner;

class GameHelp {



    public static void CreateField(String Field[][]){
        for (int i = 0; i < 10;++i){
            for (int j = 0; j < 10;++j){
                Field[i][j] = Symbol.FogOfWar;
            }
        }
        GameHelp.PrintBoard(Field);
    }
    public static void CreateHidenField(String HidenField[][]){
        for (int i = 0; i < 10;++i){
            for (int j = 0; j < 10;++j){
                HidenField[i][j] = Symbol.FogOfWar;
            }
        }

    }
    protected static void PrintBoard(String Field[][]) {
        System.out.println();
        char line = 'A';
        System.out.println(Symbol.OutputNumb);
        for (String[] field : Field) {
            System.out.print(line + " ");
            for (String s : field) {
                System.out.print(s + " ");
            }
            line++;
            System.out.println();
        }
        System.out.println(" ");
    }
    protected static void PrintStatusBoard(String HidenField[][], String Field[][]){
        PrintBoard(HidenField);
        System.out.println("---------------------");
        PrintBoard(Field);

    }
    public static void SetShips(String Field[][], String PsedoField[][]){
        for (Ships.CounterShips = 0; Ships.CounterShips < 5; Ships.CounterShips++){
            System.out.printf("Enter the coordinates of the %s (%d cells):%n\n", Ships.NameShips[Ships.CounterShips], Ships.LenghtShips[Ships.CounterShips]);
            Scanner scanner = new Scanner(System.in);
            String CordStart = scanner.next();
            String CordEnd = scanner.next();
            int[] StartCord;
            StartCord = GameHelp.getCord(CordStart);
            int[] EndCord;
            EndCord = GameHelp.getCord(CordEnd);
            Eror.CaseSet(StartCord,EndCord, Field, PsedoField);

        }
    }
    public  static int[] getCord(String cord) {
        int x = cord.charAt(0) - 65;
        int y = Integer.parseInt(cord.substring(1)) - 1;
        return new int[]{x, y};
    }
    public static void PlaceShip(int[]StartCord, int[]EndCord, String Field[][], String PsedoFiels[][]){
        int StarLine = Math.min(StartCord[0],EndCord[0]);
        int StarColumn = Math.min(StartCord[1],EndCord[1]);
        int EndLine = Math.max(StartCord[0],EndCord[0]);
        int EndColumn = Math.max(StartCord[1],EndCord[1]);
        for (int i = StarLine; i <= EndLine; ++i){
            for (int j = StarColumn; j <= EndColumn; ++j){
                Field[i][j]=Symbol.Ship;
                PsedoFiels[i][j] = Ships.SymbolShip[Ships.CounterShips];

            }
        }

    }



    public static void enterToCont() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%nPress Enter and pass the move to another player");
        scanner.nextLine();


    }
}

