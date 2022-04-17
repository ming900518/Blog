package tw.mingchang.blogservice.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Articles(
        @Id
        String id,
        String title,
        String content,
        LocalDateTime updateDate
) {
}
