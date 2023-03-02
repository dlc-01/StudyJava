package blockchain;

import java.util.Date;

class Block {
    private int id;
    private long timestamp;
    private  String hash;
    private String previousHash;

    public Block (int id, String previousHash){
        this.id = id;
        this.timestamp = new Date().getTime();
        this.previousHash = previousHash;
        this.hash = calcHash();
    }

    public int getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    public String calcHash(){
        return StringUtil.applySha256(Integer.toString(id) + Long.toString(timestamp) + previousHash);
    }

}
