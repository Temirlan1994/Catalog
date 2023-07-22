package main;

import entity.Category;

import java.util.Scanner;

public class CatalogApplication {

    public static void main(String[] args) {
        // - Создание товара [1]
        // - Редактирование товара [2]
        // - Удаление товара [3]
        // Выберите действие: _

        System.out.println("-Создание товара [1]");
        System.out.println("-Редактирование товара [2]");
        System.out.println("-Удаление товара [3]");
        Scanner sc = new Scanner(System.in);
        System.out.print("Выберите действие:");
        String action = sc.nextLine();

        if(action.equals("1")){
            CreateProduct createProduct = new CreateProduct();
            createProduct.launch();
        }else if(action.equals("2")){
            ChangeProducts changeProducts = new ChangeProducts();
            changeProducts.launch();
        }else if(action.equals("3")){
            DeleteProduct deleteProduct = new DeleteProduct();
            deleteProduct.launch();
        }else {
            System.out.println("wrong action");
        }



    }
}












