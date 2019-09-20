package pl.bykowski.week2homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;


@Controller
@Profile("start")
public class StartProfile {


    private  ProductService productService;

    @Autowired
    public StartProfile(ProductService productService) {
        this.productService = productService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showCurrentList() {
        productService.showProducts();
    }





}
