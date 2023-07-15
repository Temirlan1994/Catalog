package main;

import entity.Category;
import entity.Option;
import entity.Product;
import entity.Value;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class CreateProduct {

    public static void main(String[] args) {
        // id category;
        // название, стоимость товара

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
        EntityManager manager = factory.createEntityManager();

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите id категорий: ");
        Long categoryId = Long.parseLong(sc.nextLine());
        System.out.print("Введите название товара: ");
        String nameProduct = sc.nextLine();
        System.out.print("Введите стоимость товара: ");
        Integer price = Integer.parseInt(sc.nextLine());

        try {
            manager.getTransaction().begin();

            Category category = manager.find(Category.class, categoryId);
            Product product = new Product();
            product.setCategory(category);
            product.setName(nameProduct);
            product.setPrice(price);
            manager.persist(product);

            for (int i = 0; i < category.getOption().size(); i++) {
                System.out.print("Введите "+category.getOption().get(i).getOption()+": ");
                String values = sc.next();
                Option option = manager.find(Option.class, category.getOption().get(i).getId());
                Value value = new Value();
                value.setProduct(product);
                value.setOption(option);
                value.setValue(values);
                manager.persist(value);
            }

            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        }


    }
}
