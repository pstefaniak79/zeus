package pl.pstefaniak.zeus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class SelfDiscovery {
    AtomicInteger i = new AtomicInteger();

    @GetMapping("/ip")
    public String selfDiscovery() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            String userHome = System.getProperty("user.home");
            String userDir = System.getProperty("user.dir");
            File file = new File("/zeus_logs/logs_" + i.incrementAndGet());
            file.getParentFile().mkdirs();
            FileWriter writer = new FileWriter(file, true);
            writer.write("hostName/ip=" + ip + "| userHome=" + userHome + "| userDir=" + userDir);
            writer.close();
            return "hostName/ip=" + ip + "| userHome=" + userHome + "| userDir=" + userDir;
        } catch (Exception e) {
        }
        return "cannot obtain server ip!";
    }
}
