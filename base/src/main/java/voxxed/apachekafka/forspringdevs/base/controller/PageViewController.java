package voxxed.apachekafka.forspringdevs.base.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PageViewController {

    @GetMapping("/product/{categoryId}/{productId}")
    public void showProduct(@PathVariable("categoryId") long categoryId,
                            @PathVariable("productId") long productId) {
        log.info("Showing category = " + categoryId + " | productId = " + productId);
    }
}
