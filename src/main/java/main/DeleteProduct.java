package main;

import entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.Scanner;

public class DeleteProduct {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
        EntityManager manager = factory.createEntityManager();

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите id товара: ");
        Integer product_id = Integer.parseInt(sc.nextLine());

        try {
            manager.getTransaction().begin();

            Product product = manager.find(Product.class, product_id);

            Query query = manager.createQuery(
                    "delete from Value s where s.product=?1"
            );
            query.setParameter(1,product);
            query.executeUpdate();

            /*
            for (Specification specification : product.getSpecifications()) {
                Specification spec = manager.find(Specification.class, specification.getId());
                manager.remove(spec);
            }
            */

            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
