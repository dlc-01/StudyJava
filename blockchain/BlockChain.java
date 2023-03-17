package blockchain;

import java.io.IOException;
import java.util.ArrayList;

class BlockChain {
    private ArrayList<Block> blockChain;
    private final int zeroes;

    private BlockChain(int zeroes) {
        this.blockChain = new ArrayList<>();
        this.zeroes = zeroes;
    }

    private void addBlock() {
        blockChain.add(Block.getProved(
                blockChain.size(),
                blockChain.isEmpty() ? "0" : blockChain.get(blockChain.size() - 1).getBlockHash(),
                zeroes));

    }

    public void generateBlocks(int blocksNumber) {
        for (var i = 0; i < blocksNumber; i++) {
            addBlock();
        }
    }

    public static BlockChain getInstance(int zeroes) {
        return new BlockChain(zeroes);
    }

    @Override
    public String toString() {
        final var stringBuilder = new StringBuilder();
        for (var block : blockChain) {
            stringBuilder.append(block).append("\n\n");
        }
        return String.valueOf(stringBuilder);
    }
}
