package voxxed.apachekafka.forspringdevs.reader.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageView {

    private long productId;
    private long categoryId;

    private String userAgent;
    private String uri;

    private long timestamp;
}
