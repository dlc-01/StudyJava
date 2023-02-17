package battleship;
class Start{
    public  static void Game(){

        System.out.println("Player 1, place your ships to the game field");
        GameHelp.CreateHidenField(firstPlayer.PseodoFieldOne);
        GameHelp.CreateField(firstPlayer.FieldPLayerOne);
        GameHelp.SetShips(firstPlayer.FieldPLayerOne, firstPlayer.PseodoFieldOne);
        GameHelp.CreateHidenField(firstPlayer.HidenFieldOne);

        GameHelp.enterToCont();

        System.out.println("Player 2, place your ships to the game field");
        GameHelp.CreateHidenField(secondPlayer.PseodoFieldTwo);

        GameHelp.CreateField(secondPlayer.FieldPLayerTwo);
        GameHelp.SetShips(secondPlayer.FieldPLayerTwo, secondPlayer.PseodoFieldTwo);
        GameHelp.CreateHidenField(secondPlayer.HidenFieldTwo);

        GameHelp.enterToCont();

        Shooting.MassShooting(firstPlayer.FieldPLayerOne, firstPlayer.HidenFieldOne, firstPlayer.CounterHitShipOne,
                secondPlayer.FieldPLayerTwo, secondPlayer.HidenFieldTwo, secondPlayer.CounterHitShipTwo,
                firstPlayer.PseodoFieldOne, secondPlayer.PseodoFieldTwo);
    }
}
class Symbol{

    public static String FogOfWar = "~";
    public  static String OutputNumb = "  1 2 3 4 5 6 7 8 9 10";
    public static String Ship = "O";
    public static String Miss = "M";
    public static String Hit = "X";

}
class Ships{

    public static String[] NameShips = new String[]{"Aircraft Carrier"," Battleship", "Submarine", "Cruiser", "Destroyer"};
    public static int[] LenghtShips = new int[]{5, 4, 3, 3, 2};
    public static String[] SymbolShip = new  String[]{"A", "B", "S", "C", "D"};
    public  static  int CounterShips = 0;


}
