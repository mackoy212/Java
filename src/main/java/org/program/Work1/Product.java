package org.program.Work1;

public class Product {

    private static int IDCounter;
    private int ID;
    private String Name;
    private double Price;
    private Category Category;
    private String Description;

    public Product(String name, Category category, double price, String description) {
        if (name == null || name.isEmpty()) return;
        if (price <= 0) return;
        Name = name;
        Price = price;
        Description = description;
        Category = category;
        ID = IDCounter++;
    }
    public Product(String name, Category category, double price) {
        if (name == null || name.isEmpty()) return;
        if (price <= 0) return;
        Name = name;
        Price = price;
        Category = category;
        ID = IDCounter++;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        if (price > 0) Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        if (!description.isEmpty()) Description = description;
    }

    public org.program.Work1.Category getCategory() {
        return Category;
    }

    public void setCategory(org.program.Work1.Category category) {
        Category = category;
    }
}
