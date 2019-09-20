package pl.bykowski.week2homework;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {


    private List<Product> productList;
    private double sumPrice;

    public ProductService() {

        productList = new ArrayList<>();
        Random random = new Random();


        Product product1 = new Product("Jabłka",Math.round(100*(50+(random.nextDouble()*250)))/100D);
        Product product2 = new Product("Gruszki",Math.round(100*(50+(random.nextDouble()*250)))/100D);
        Product product3 = new Product("Śliwki",Math.round(100*(50+(random.nextDouble()*250)))/100D);
        Product product4 = new Product("Borówki",Math.round(100*(50+(random.nextDouble()*250)))/100D);
        Product product5 = new Product("Czereśnie",Math.round(100*(50+(random.nextDouble()*250)))/100D);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);

        sumPrice = countPrice(productList);

    }


    public void showProducts() {

        for (Product p : productList) {
            System.out.println(p);

        }

        System.out.println(String.format("Łączna cena = %.2f zł netto",sumPrice));

    }

    public double countPrice(List<Product> productList) {
        double sumPrice = 0;
        for (Product p : productList) {

            sumPrice += p.getPrice();
        }

        return sumPrice;

    }

    public void addNewProduct(Product p) {
        productList.add(p);

    }

    public List<Product> getProductList() {
        return productList;
    }

    public double getSumPrice() {
        return sumPrice;
    }
}


/*
Twoje zadanie:
Zaimplementuj sklep internetowy, który oferuje 3 warianty.
Podstawową funkcjonalnością jaką posiada każdy sklep jest wariant „START”. Umożliwia on na dodawanie produktów do koszyka (produkt przechowuje nazwę i cenę),
oraz na ich podstawie wypisywać na oknie konsoli cenę wszystkich produktów.
Pakiet „PLUS” dodatkowo umożliwia doliczenie do ceny wynikowej podatku VAT. Stawka podatku VAT ma zostać uwzględniona w pliku konfiguracyjnym.
Pakiet „PRO” oprócz wyliczania podatku ma również możliwość wyliczenia rabatu, którego wartość jest uwzględniona w pliku konfiguracyjnym.
Aplikacja na start dodaje 5 dowolnych produktów z losowaną ceną (w przedziale 50-300 zł) i wyświetla ich sumaryczną cenę.
 */