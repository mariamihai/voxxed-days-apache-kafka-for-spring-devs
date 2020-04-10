package voxxed.apachekafka.forspringdevs.reader;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryCount {

    private Long categoryId;
    private Long count;
}
