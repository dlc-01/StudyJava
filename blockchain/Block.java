package  blockchain;


import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

class Block {
    private int id;
    private long timestamp;
    private  String blockHash;
    private String previousHash;
    private long magicNumber;
    private int timeToGenerate;

    public Block (int id, long timestamp, String previousHash){
        this.id = id;
        this.timestamp = timestamp;
        this.previousHash = previousHash;

    }
    public static Block getProved(int id, String prevBlockHash, int zeroes) {
        final var startTime = Instant.now();
        final var block = new Block(id, new Date().getTime(), prevBlockHash);
        block.findMagicNumber(zeroes);
        block.timeToGenerate = Math.toIntExact(Duration.between(startTime, Instant.now()).toSeconds());
        return block;
    }

    public String getBlockHash() {
        return blockHash;
    }


    private void findMagicNumber(int zeroes) {
        final var random = new Random();
        var hash = "";
        do {
            magicNumber = Math.abs(random.nextLong());
            hash = StringUtil.applySha256(stringify());
        } while (!isProved(zeroes, hash));
        blockHash = hash;
    }



    private boolean isProved(int zeroes, String blockHash) {
        for (int i = 0; i < zeroes; i++) {
            if (blockHash.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    private String stringify() {
        return "" +
                id +
                timestamp +
                previousHash +
                magicNumber;
    }
    @Override
    public String toString() {
        return String.format("Block: \n" +
                        "Id: %d \n" +
                        "Timestamp: %d \n" +
                        "Magic number: %d \n" +
                        "Hash of the previous block: \n" +
                        "%s \n" +
                        "Hash of the block: \n" +
                        "%s \n" +
                        "Block was generating for %d seconds",
                id,
                timestamp,
                magicNumber,
                previousHash,
                blockHash,
                timeToGenerate);
    }

}


