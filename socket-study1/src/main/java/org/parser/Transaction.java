package main.java.org.parser;

public class Transaction {
    private int id;
    private String gubun;
    private String sender;
    private String receiver;
    private int amount;

    public Transaction(int id, String gubun, String sender, String receiver, int amount) {
        this.id = id;
        this.gubun = gubun;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGugun() {
        return gubun;
    }

    public void setGugun(String gugun) {
        this.gubun = gugun;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
