package voxxed.apachekafka.forspringdevs.reader.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaConfig {

    public static final String PAGE_VIEW_TOPIC = "page-view";
    public static final String PAGE_AGGREGATE_TOPIC = "page-aggregate";

    @Bean
    public NewTopic pageViewTopic() {
        return TopicBuilder.name(PAGE_VIEW_TOPIC).partitions(2).build();
    }


    @Bean
    public NewTopic pageAggregateTopic() {
        return TopicBuilder.name(PAGE_AGGREGATE_TOPIC).partitions(2).build();
    }
}
