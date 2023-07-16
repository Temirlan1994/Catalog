package main;

import entity.Option;
import entity.Product;
import entity.Value;
import jakarta.persistence.*;

import java.util.List;
import java.util.Scanner;

public class ChangeProducts {

    public void launch(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
        EntityManager manager = factory.createEntityManager();

        Scanner sc = new Scanner(System.in);System.out.print("Введите id товара: ");
        String product_id = sc.nextLine();Integer productId = Integer.parseInt(product_id);
        try {
            manager.getTransaction().begin();

            Product product = manager.find(Product.class, productId);
            System.out.print("Введите новое название товара: ");
            String newProduct = sc.nextLine();
            product.setName(newProduct);
            while (true){
                try {
                    System.out.print("Введите новую цену товара: ");
                    String newPrice = sc.nextLine();
                    product.setPrice(Integer.parseInt(newPrice));
                    break;
                }catch (NumberFormatException e) {
                    System.out.println("Введите цифру!");
                }
            }

            List<Option> options = product.getCategory().getOption();

            for (Option option : options) {
                TypedQuery<Value> characterQuery = manager.createQuery(
                        "select v from Value v where v.product.id = ?1 and v.option = ?2", Value.class
                );
                characterQuery.setParameter(1,product_id);
                characterQuery.setParameter(2,option);
                try {
                    Value spec = characterQuery.getSingleResult();
                    System.out.print("введите новое значение "+option.getOption()+": ");
                    String newValue = sc.nextLine();
                    if (!(newValue.isEmpty())) {
                        spec.setValue(newValue);
                    }
                }catch (NoResultException e){
                    Value value = new Value();
                    System.out.print("введите новое значение "+option.getClass()+": ");
                    String addValue= sc.nextLine();
                    value.setValue(addValue);
                    value.setProduct(product);
                    value.setOption(option);
                    manager.persist(value);
                }
            }

            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}



