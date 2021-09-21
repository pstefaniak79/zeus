package pl.pstefaniak.zeus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pstefaniak.zeus.entities.Book;
import pl.pstefaniak.zeus.repositories.BookRepository;

import java.io.File;
import java.io.FileWriter;
import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@PropertySource(value = "file:${config.sys}", ignoreResourceNotFound = true)
public class SelfDiscovery {
    AtomicInteger i = new AtomicInteger();

    //@Value("${token}")
    //String token;

    @Autowired
    Environment env;

    @GetMapping("/ip")
    public String selfDiscovery() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            String userHome = System.getProperty("user.home");
            String userDir = System.getProperty("user.dir");
            //File file = new File("/zeus_logs/logs_" + i.incrementAndGet());
            //file.getParentFile().mkdirs();
            //FileWriter writer = new FileWriter(file, true);
            //writer.write("hostName/ip=" + ip + "| userHome=" + userHome + "| userDir=" + userDir);
            //writer.close();
            String token = env.getProperty("token");
            String app_name = env.getProperty("app_name");
            return "hostName/ip=" + ip + "| userHome=" + userHome + "| userDir=" + userDir + "| token=" + token+ "|app_name"+ app_name;
        } catch (Exception e) {
        }
        return "cannot obtain server ip!";
    }

    @Autowired
    private BookRepository bookRepository;

    public List<Book> list() {
        return bookRepository.findAll();
    }

    @GetMapping("/book/get")
    public List<Book> getBooks() {
        return list();
    }


}
