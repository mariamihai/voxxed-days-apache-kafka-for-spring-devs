package voxxed.apachekafka.forspringdevs.reader;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import voxxed.apachekafka.forspringdevs.reader.controller.PageView;

import static voxxed.apachekafka.forspringdevs.reader.config.KafkaConfig.PAGE_VIEW_TOPIC;

@Slf4j
@SpringBootApplication
public class ReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReaderApplication.class, args);
	}

	// Simple Kafka Consumer
	@KafkaListener(topics = PAGE_VIEW_TOPIC)
	public void processPageView(ConsumerRecord<String, PageView> record) {
		log.info(String.valueOf(record));
	}
}
