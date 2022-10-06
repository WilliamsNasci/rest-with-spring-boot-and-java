package br.com.williams;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    // Estancia das variaveis e templateString para mudar o output apartir do queryParam passada na requisicao
    private static final String template = "Hello, %s!";
    private static final AtomicLong counter = new AtomicLong();
    
    // Endpoint 
    @RequestMapping("/greeting")
    public Greeting greeting(
        @RequestParam(value = "name", defaultValue = "World") 
        String name) {
            return new Greeting(counter.incrementAndGet(), String.format(template, name));
        }
}
