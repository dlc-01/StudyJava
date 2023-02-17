package battleship;


class CheckShoot{
    public static int CaseShoot(int[]ShootCoord, String HidenField[][] , String FieldEnemy[][], String PsedoFieldEnemy[][],
                                 int CountHit) {
        int xShoot = ShootCoord[0];
        int yShoot = ShootCoord[1];

        switch (CheckShoot(xShoot,yShoot, FieldEnemy)) {
            case ("true"): {
                if (HidenField[xShoot][yShoot] != Symbol.Hit ){
                    CountHit--;
                }

                HidenField[xShoot][yShoot] = Symbol.Hit;
                FieldEnemy[xShoot][yShoot] = Symbol.Hit;


                if (win(FieldEnemy)){

                    if (sankShip(PsedoFieldEnemy,xShoot,yShoot)) {
                        System.out.println("You sank a ship! Specify a new target:");
                    }else System.out.println("You hit a ship! Try again:\n");

                }else{
                    return CountHit;
                }

                PsedoFieldEnemy[xShoot][yShoot] = Symbol.Hit;


                return CountHit;

            }
            case ("false"): {
                HidenField[xShoot][yShoot] = Symbol.Miss;
                FieldEnemy[xShoot][yShoot] = Symbol.Miss;

                System.out.println("You missed.");

                break;
            }
            default: {
                System.out.println("Error! You entered the wrong coordinates! Try again:\n");
                break;
            }
        }
        return CountHit;

    }




    private static String CheckShoot( int xShoot, int yShoot, String Field [][] ) {
        if (xShoot>9 || yShoot>9){
            return ("");
        } else if ((Field[xShoot][yShoot] == Symbol.FogOfWar)){
            return ("false");
        }else if (Field[xShoot][yShoot] == Symbol.Ship){
            return "true";
        }
        return ("");
    }


    public static boolean sankShip(String[][] pseudoMap, int Xcord, int Ycord) {

        String TempSymbol = pseudoMap[Xcord][Ycord];
        int TempCounter = 0;
        for (int i = 0; i < pseudoMap.length; i++) {
            for (int j = 0; j < pseudoMap[i].length; j++) {
                if (pseudoMap[i][j].equals(TempSymbol)) {
                    TempCounter++;
                }
            }
        }
        if (TempCounter == 1){
            return true;
        }else return  false;

    }
    public static boolean win(String[][] pseudoMap) {
        for (int i = 0; i < pseudoMap.length; i++) {
            for (int j = 0; j < pseudoMap[i].length; j++) {
                if (pseudoMap[i][j].equals(Symbol.Ship)) {
                    return true;
                }
            }
        }
        return false;
    }
}
