package tw.mingchang.blogservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import tw.mingchang.blogservice.model.Articles;

/**
 * ArticlesRepository
 *
 * @author Ming Chang (<a href="mailto:mail@mingchang.tw">mail@mingchang.tw</a>)
 */

@Repository
public interface ArticlesRepository extends ReactiveMongoRepository<Articles, String> {
}
