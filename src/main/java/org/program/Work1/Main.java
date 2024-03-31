package org.program.Work1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Category electronicsCategory = new Category("Електроніка");
    private static final Category clothingCategory = new Category("Одяг");
    private static final Category booksCategory = new Category("Книги");
    private static Product Notebook = new Product("Ноутбук", electronicsCategory, 1500.0);
    private static Product TShirt = new Product("Футболка", clothingCategory, 25.0);
    private static Product Book = new Product("Книга", booksCategory, 10.0);
    //================================================================================================
    private static final List<Product> AllProducts = new ArrayList<>();
    private static final List<Order> AllOrders = new ArrayList<>();
    private static final Cart UserCart = new Cart();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        User user = new User("UserName");

        AllProducts.add(Notebook);
        AllProducts.add(TShirt);
        AllProducts.add(Book);

        boolean running = true;
        while (running) {
            System.out.println("1. Переглянути список товарів");
            System.out.println("2. Додати товар до кошика");
            System.out.println("3. Переглянути кошик");
            System.out.println("4. Зробити замовлення");
            System.out.println("5. Пошук товару");
            System.out.println("6. Вийти");
            System.out.print("Виберіть опцію: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayProductList();
                    break;
                case 2:
                    addProductToCart(UserCart);
                    break;
                case 3:
                    displayCart(UserCart);
                    break;
                case 4:
                    makeOrder(user, UserCart);
                    break;
                case 5:
                    displayProductSearch();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
        scanner.close();
    }

    public static void displayProductList() {
        System.out.println("Список товарів:");
        for (Product product : AllProducts) {
            System.out.println("Назва: " + product.getName() + "; ID: " + product.getID());
        }
    }

    public static void addProductToCart(Cart cart) {
        if (cart == null) return;
        System.out.print("Введіть ідентифікатор товару для додавання до кошика: ");
        int productID = scanner.nextInt();
        Product product = AllProducts.get(productID);
        if (product != null) cart.addProduct(product);
    }

    public static void displayCart(Cart cart) {
        if (cart == null) return;
        System.out.println("Ваш кошик:");
        List<Product> products = cart.getProducts();
        for (Product product : products) {
            System.out.println("Назва: " + product.getName() + "; ID: " + product.getID());
        }
    }

    public static void makeOrder(User user, Cart cart) {
        if (cart == null) {
            return;
        }
        if (cart.isEmpty()) {
            System.out.println("Кошик порожній. Додайте товари до кошика.");
            return;
        }

        Order order = new Order(cart);
        AllOrders.add(order);
        user.addOrderToHistory(order);
        System.out.println("Замовлення " + order.getID() + " успішно оформлено " + order.getOrderDate());
    }

    public static void displayProductSearch() {
        boolean running = true;
        while (running) {
            System.out.println("1. Пошук за ім'ям");
            System.out.println("2. Пошук за категорією");
            System.out.println("3. Повернутись у головне меню");
            System.out.print("Виберіть опцію: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введіть назву товару: ");
                    String name = scanner.nextLine();
                    List<Product> productsByName = searchProductsByName(name);
                    displaySearchResults(productsByName);
                    break;
                case 2:
                    System.out.print("Введіть назву категорії: ");
                    String category = scanner.nextLine();
                    List<Product> productsByCategory = searchProductsByCategory(category);
                    displaySearchResults(productsByCategory);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    private static void displaySearchResults(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Товари не знайдені.");
        } else {
            System.out.println("Знайдені товари:");
            for (Product product : products) {
                System.out.println(product.getName() + " - " + product.getCategory().getName() + " - Ціна: " + product.getPrice());
            }
        }
    }

    private static List<Product> searchProductsByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : AllProducts) {
            if (product.getName().equalsIgnoreCase(name)) {
                result.add(product);
            }
        }
        return result;
    }

    private static List<Product> searchProductsByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product product : AllProducts) {
            if (product.getCategory().getName().equalsIgnoreCase(category)) {
                result.add(product);
            }
        }
        return result;
    }
}
