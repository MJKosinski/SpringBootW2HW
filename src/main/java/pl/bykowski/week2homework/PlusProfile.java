package pl.bykowski.week2homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

@Controller
@Profile("plus")
public class PlusProfile {

    ProductService productService;

    @Value("${vat}")
    double vatValue;

    @Autowired
    public PlusProfile(ProductService productService) {
        this.productService = productService;
    }



    @EventListener(ApplicationReadyEvent.class)
    public void showCurrentList() {
        productService.showProducts();
        System.out.println(String.format("Wartość brutto zamówienia = %.2f zł",productService.getSumPrice()*(1F+vatValue)));


    }

}
