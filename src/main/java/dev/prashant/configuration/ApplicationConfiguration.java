package dev.prashant.configuration;

import dev.prashant.client.JsonPlaceHolderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ApplicationConfiguration {

    @Bean
    JsonPlaceHolderService jsonPlaceHolderService() {
        RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com");
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build();

        return factory.createClient(JsonPlaceHolderService.class);
    }
}
