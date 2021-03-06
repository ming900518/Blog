package tw.mingchang.blogservice.handler;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tw.mingchang.blogservice.model.Articles;
import tw.mingchang.blogservice.repository.ArticlesRepository;

/**
 * BlogRouter
 *
 * @author Ming Chang (<a href="mailto:mail@mingchang.tw">mail@mingchang.tw</a>)
 */

@Component
public class BlogHandler {

    private final ArticlesRepository articlesRepository;

    public BlogHandler(ArticlesRepository articlesRepository) {
        this.articlesRepository = articlesRepository;
    }

    public Flux<Articles> list() {
        return articlesRepository
                .findAll()
                .flatMap(data ->
                        Mono.just(new Articles
                                (
                                        data.id(),
                                        data.title(),
                                        data.content()
                                                .replaceAll("<(?:.|\n)*?>", "")
                                                .replaceAll("\n", "")
                                                .substring(0, 200) + "...",
                                        data.updateDate()
                                )
                        )
                );
    }

    public Mono<Articles> content(String id) {
        return articlesRepository.findById(id);
    }
}
