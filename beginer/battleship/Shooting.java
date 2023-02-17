package battleship;



import java.util.Scanner;

class Shooting{
    protected static int TempCount = 0;
    public static void MassShooting(String FieldOne[][], String HidenFieldOne[][], int HitShipOne,
                                    String FieldTwo[][], String HidenFieldTwo[][], int HitShipTwo,
                                    String PsedoOne[][], String PsedoTwo[][]){
        while(HitShipOne != 0 || HitShipTwo != 0){
            GameHelp.PrintStatusBoard(HidenFieldOne, FieldOne);
            System.out.println("Player 1, it's your turn");
            HitShipOne = Shoot(HitShipOne,HidenFieldOne,FieldTwo, PsedoTwo);


            if (HitShipOne == 0 || HitShipTwo == 0) break;

            GameHelp.enterToCont();

            GameHelp.PrintStatusBoard(HidenFieldTwo,FieldTwo);
            System.out.println("Player 2, it's your turn");
            HitShipTwo = Shoot(HitShipTwo, HidenFieldTwo, FieldOne, PsedoOne);

            if (HitShipOne == 0 || HitShipTwo == 0) break;

            GameHelp.enterToCont();
            }
        System.out.println("You sank the last ship. You won. Congratulations!");




    }
    private static  int Shoot(int CountHitShip, String HidenField[][], String EnemyField[][], String PsedoFieldEnemy[][]){
        Scanner scanner = new Scanner(System.in);
        String ShootCord = scanner.next();
        int[] CordShoot = GameHelp.getCord(ShootCord);

        CountHitShip = CheckShoot.CaseShoot(CordShoot, HidenField, EnemyField, PsedoFieldEnemy, CountHitShip);
        return CountHitShip;

    }

}
