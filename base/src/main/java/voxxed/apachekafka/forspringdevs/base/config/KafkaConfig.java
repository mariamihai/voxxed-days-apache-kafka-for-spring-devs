package voxxed.apachekafka.forspringdevs.base.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaConfig {

    public static final String PAGE_VIEW_TOPIC = "page-view";
    public static final String PRODUCT_TOPIC = "product";

    @Bean
    public NewTopic pageViewTopic() {
        return TopicBuilder.name(PAGE_VIEW_TOPIC).partitions(2).build();
    }

    @Bean
    public NewTopic productTopic() {
        return TopicBuilder.name(PRODUCT_TOPIC).compact().build();
    }
}
