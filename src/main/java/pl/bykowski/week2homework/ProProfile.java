package pl.bykowski.week2homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

@Controller
@Profile("pro")
public class ProProfile {

    ProductService productService;

    @Value("${vat}")
    double vatValue;

    @Value("${discount}")
    double discountValue;

    @Autowired
    public ProProfile(ProductService productService) {
        this.productService = productService;
    }



    @EventListener(ApplicationReadyEvent.class)
    public void showCurrentList() {
        productService.showProducts();
        double grossValue = productService.getSumPrice() * (1F + vatValue);
        System.out.println(String.format("Cena brutto przed rabatem = %.2f zł",grossValue));
        System.out.println(String.format("Udzielono rabatu =  %.1f %% ",discountValue*100));
        System.out.println(String.format("Cena z rabatem =  %.2f zł ",grossValue*(1-discountValue)));


    }

}
