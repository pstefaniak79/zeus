package pl.pstefaniak.zeus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ZeusApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ZeusApplication.class, args);
    }

}
