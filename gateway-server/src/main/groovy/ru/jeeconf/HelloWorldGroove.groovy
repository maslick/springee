package ru.jeeconf
import java.util.Date

/**
 * Created by maslick on 25/05/16.
 */
class HelloWorldGroove {
    public static final int DEFAULT_PADDING = 20

    public static void main(String[] args) {
        println "Helloworld".center(DEFAULT_PADDING, '=')
        println ("hello " + Date())
                .center(DEFAULT_PADDING, '=')
    }
}
