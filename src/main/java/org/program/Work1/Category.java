package org.program.Work1;

public class Category {
    private String Name;

    public Category(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) Name = name;
    }
}
