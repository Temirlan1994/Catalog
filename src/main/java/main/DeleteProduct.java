package main;

import entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.Scanner;

public class DeleteProduct {

    public void launch(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
        EntityManager manager = factory.createEntityManager();

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите id товара: ");
        Integer product_id = Integer.parseInt(sc.nextLine());

        try {
            manager.getTransaction().begin();

            Product product = manager.find(Product.class, product_id);

            Query query = manager.createQuery(
                    "delete from Value v where v.product=?1"
            );
            query.setParameter(1,product);
            query.executeUpdate();

            query = manager.createQuery(
                    "delete from Product p where p.id=?1"
            );
            query.setParameter(1,product_id);
            query.executeUpdate();


            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
