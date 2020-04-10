package voxxed.apachekafka.forspringdevs.reader;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import voxxed.apachekafka.forspringdevs.reader.controller.PageView;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static voxxed.apachekafka.forspringdevs.reader.config.KafkaConfig.PAGE_AGGREGATE_TOPIC;
import static voxxed.apachekafka.forspringdevs.reader.config.KafkaConfig.PAGE_VIEW_TOPIC;

@Slf4j
@SpringBootApplication
public class ReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReaderApplication.class, args);
	}

	// Simple Kafka Consumer
//	@KafkaListener(topics = PAGE_VIEW_TOPIC)
//	public void processPageView(ConsumerRecord<String, PageView> record) {
//		log.info(String.valueOf(record));
//	}

	// Concurrent Kafka Consumer
//	@KafkaListener(topics = PAGE_VIEW_TOPIC, concurrency = "2")
//	public void processPageViewConcurrently(ConsumerRecord<String, PageView> record) {
//		long threadId = Thread.currentThread().getId();
//		log.info(threadId + ": " + record);
//	}


	// Consumer with manual aggregation
	private Map<Long, AtomicLong> count = new HashMap<>();
	@KafkaListener(topics = PAGE_VIEW_TOPIC)
	@SendTo(PAGE_AGGREGATE_TOPIC)
	public CategoryCount processPageViewAndSendCount(ConsumerRecord<String, PageView> record) {
		long categoryId = record.value().getCategoryId();

		count.putIfAbsent(categoryId, new AtomicLong(0));
		long categoryCount = count.get(categoryId).incrementAndGet();


		return new CategoryCount(categoryId, categoryCount);
	}
}
