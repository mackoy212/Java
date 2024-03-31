package org.program.Work1;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int IDCounter;
    private int ID;
    private String Name;
    private final List<Order> OrdersHistory = new ArrayList<>();

    public User(String name) {
        if (name == null || name.isEmpty()) return;
        Name = name;
        ID = IDCounter++;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) return;
        Name = name;
    }

    public void addOrderToHistory(Order order) {
        OrdersHistory.add(order);
    }
}
