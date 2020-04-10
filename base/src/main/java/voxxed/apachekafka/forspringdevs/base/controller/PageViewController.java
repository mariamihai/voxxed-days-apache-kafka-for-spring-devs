package voxxed.apachekafka.forspringdevs.base.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import voxxed.apachekafka.forspringdevs.base.config.KafkaConfig;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PageViewController {

    private final KafkaTemplate<String, PageView> kafkaTemplate;

    @GetMapping("/product/{categoryId}/{productId}")
    public void showProduct(@PathVariable("categoryId") long categoryId,
                            @PathVariable("productId") long productId,
                            @RequestHeader("user-agent") String userAgent,
                            @Value("#{request.requestURI}") String requestUri) {

        log.info("Logging for category = " + categoryId + " | productId = " + productId);

        PageView view = PageView.builder()
                .categoryId(categoryId)
                .productId(productId)
                .userAgent(userAgent)
                .uri(requestUri)
                .timestamp(System.currentTimeMillis())
                .build();

        kafkaTemplate.send(KafkaConfig.PAGE_VIEW_TOPIC, // topic
                           String.valueOf(view.getProductId()), // key
                           view); // value
    }
}
