package tw.mingchang.blogservice.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import tw.mingchang.blogservice.handler.BlogHandler;
import tw.mingchang.blogservice.model.Articles;

import java.net.URI;

/**
 * BlogRouter
 *
 * @author Ming Chang (<a href="mailto:mail@mingchang.tw">mail@mingchang.tw</a>)
 */

@Configuration(proxyBeanMethods = false)
public class BlogRouter {

    @Bean
    public RouterFunction<ServerResponse> blog(BlogHandler blogHandler) {
        return RouterFunctions
                .route()
                .GET(("/"), request -> ServerResponse.permanentRedirect(URI.create("https://mingchang.tw")).build())
                .GET(("/list"), request -> ServerResponse.ok().body(blogHandler.list(), Articles.class))
                .GET(("/{id}"), request -> {
                    String id = request.pathVariable("id");
                    return ServerResponse.ok().body(blogHandler.content(id), Articles.class);
                })
                .build();
    }

}
