package ru.jeeconf

import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import java.util.concurrent.ThreadLocalRandom

@Slf4j
@SpringBootApplication
public class ParrotApplication {
    public static final int DEFAULT_PADDING = 50

    public static void main(String[] args) {
        println 'Starting'.center(DEFAULT_PADDING, '=')
        SpringApplication.run ParrotApplication, args
        println 'Started'.center(DEFAULT_PADDING, '=')
    }

    @RestController
    public static class ParrotController {
        @RequestMapping('fee')
        def fee() {
            int randomFee = ThreadLocalRandom.current().nextInt(100)
            return [fee: randomFee]
        }
    }

}