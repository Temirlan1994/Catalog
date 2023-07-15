package main;

import entity.Category;
import entity.Option;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class CreateCategory {
    public static void main(String[] args) {
        // Введите название категории: Мебель
        // Введите характеристики категории (через запятую): Габариты, Материал

        // Необходимо чтобы в результате работы программы в базе данных была
        // создана категория с введенным пользователем названием.

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
        EntityManager manager = factory.createEntityManager();


        Scanner sc = new Scanner(System.in);
        System.out.print("Введите название категории: ");
        String nameCategory = sc.nextLine();
        System.out.print("Введите характеристики категории (через запятую): ");
        String characters = sc.nextLine();
        String[] word = characters.split(", ");

        try {
            manager.getTransaction().begin();

            Category category = new Category();
            category.setName(nameCategory);
            manager.persist(category);

            for (int i = 0; i < word.length; i++) {
                Option option = new Option();
                option.setCategory(category);
                option.setOption(word[i]);
                manager.persist(option);
            }

            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        }


    }
}
