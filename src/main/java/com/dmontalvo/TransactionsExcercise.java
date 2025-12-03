package com.dmontalvo;

import java.util.HashMap;
import java.util.Map;

public class TransactionsExcercise {

    private final Map<Integer, Double> balances = new HashMap<>();

    public Map<Integer,Double> getBalances(){
        return balances;
    }

    // Each string is a transaction. 100,300.50,200. User 100 transfer 300.5 USD to user 200
    // Asuming User codes are Integer
    public void registerTransactions(String[] transactions) {
        for (String transaction : transactions) {
            String[] data = transaction.split(",");
            Integer source = Integer.valueOf(data[0]);
            Double amount = Double.valueOf(data[1]);
            Integer destination = Integer.valueOf(data[2]);

            balances.putIfAbsent(source, 0.0d);
            balances.putIfAbsent(destination, 0.0d);

            balances.put(source, balances.get(source) - amount);
            balances.put(destination, balances.get(destination) + amount);
        }
    }
}
