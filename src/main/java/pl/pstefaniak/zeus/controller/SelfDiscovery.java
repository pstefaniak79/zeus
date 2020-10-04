package pl.pstefaniak.zeus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
public class SelfDiscovery {
    @GetMapping("/ip")
    public String selfDiscovery() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            return "hostName/ip=" + ip;
        } catch (Exception e) {
        }
        return "cannot obtain server ip!";
    }
}
