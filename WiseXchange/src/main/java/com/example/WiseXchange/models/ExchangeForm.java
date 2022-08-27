package com.example.WiseXchange.models;

public class ExchangeForm {
    private String to;
    private String from;
    private Double amount;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "exchangeFrom{" +
                "to='" + to + '\'' +
                ", form='" + from + '\'' +
                ", amount=" + amount +
                '}';
    }
}
