package ru.jeeconf

import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import java.time.ZonedDateTime

@Slf4j
@SpringBootApplication
public class FbiApplication {
    public static final int DEFAULT_PADDING = 50

    public static void main(String[] args) {
        println 'Starting'.center(DEFAULT_PADDING, '=')
        SpringApplication.run FbiApplication, args
        println 'Started'.center(DEFAULT_PADDING, '=')
    }

    @RestController
    public static class FbiController {
        @RequestMapping('fink')
        def fink(@RequestBody request) {
            log.info 'fink: {}', request
            return '{ "lastFink": ISO8601 (' + ZonedDateTime.now() + ')}'
        }

    }
}