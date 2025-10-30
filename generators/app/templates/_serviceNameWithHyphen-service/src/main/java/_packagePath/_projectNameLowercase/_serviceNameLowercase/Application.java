package <%= packagePath %>.<%= projectNameLowercase %>.<%= serviceNameLowercase %>;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ir.msob.jima", "<%= packagePath %>.<%= projectNameLowercase %>"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
