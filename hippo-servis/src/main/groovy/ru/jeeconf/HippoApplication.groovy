package ru.jeeconf

import groovy.json.JsonSlurper
import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import java.util.concurrent.atomic.AtomicInteger

@Slf4j
@RestController
@SpringBootApplication
public class HippoApplication {
    public static final int DEFAULT_PADDING = 50

    public static void main(String[] args) {
        println 'Starting'.center(DEFAULT_PADDING, '=')
        SpringApplication.run HippoApplication, args
        println 'Started'.center(DEFAULT_PADDING, '=')
    }

    private AtomicInteger hippoCount = new AtomicInteger(Integer.MAX_VALUE)

    @RequestMapping(value = '/rent', method = RequestMethod.GET)
    def rent(@RequestParam(value = "count")Optional<Integer> count) {
        def response = new JsonSlurper().parseText('http://localhost:8081/fee'.toURL().text)
        def fee = response.fee
        println count
        return [hippoRemain: hippoCount.addAndGet(-1 * count.orElse(1)),
                parrotFee: fee
        ]
    }
}