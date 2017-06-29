package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringmvcApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringmvcApplication.class, args);

//        for (String name : ctx.getBeanDefinitionNames()){
//            System.out.println(name);
//        }
//        System.out.println("******* Bean Count *******");
//        System.out.println(ctx.getBeanDefinitionCount());
    }
}
