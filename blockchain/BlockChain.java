package blockchain;

import java.util.ArrayList;

class BlockChain {
    private ArrayList<Block> blockChain;

    public BlockChain() {
        blockChain = new ArrayList<>();
        Block genesisBlock = new Block(1, "0");
        blockChain.add(genesisBlock);
    }

    public void addBlockChain() {
        Block latest = blockChain.get(blockChain.size() - 1);
        Block newBlock = new Block(latest.getId() + 1, latest.getHash());
        blockChain.add(newBlock);
    }
    public void printBlockchain() {
        for (Block block : blockChain) {
            System.out.println("Block:");
            System.out.println("Id: " + block.getId());
            System.out.println("Timestamp: " + block.getTimestamp());
            System.out.println("Hash of the previous block: \n" + block.getPreviousHash());
            System.out.println("Hash of the block: \n" + block.getHash() + "\n");
        }
    }

}
