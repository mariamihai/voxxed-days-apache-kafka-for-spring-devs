package voxxed.apachekafka.forspringdevs.base.controller;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageView {

    private long productId;
    private long categoryId;

    private String userAgent;
    private String uri;

    private long timestamp;
}
