package blockchain;
public class Main {
    public static void main(String[] args) {

        BlockChain blockchain = new BlockChain();
        
        for (int i = 0; i < 4; i++) {
            blockchain.addBlockChain();
        }
        blockchain.printBlockchain();


    }
}

