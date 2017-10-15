package xyz.liinns.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * @author  LiinNs on 2017-4-10 0010.
 */
@RestController
public class HelloController {

    @Value("${sys.url: not work!}")
    private String sysUr;

    @RequestMapping("/")
    public String index() {
        System.out.println(sysUr);
        return "Greetings from Spring Boot!";
    }



    public static void main(String[] args) {
        Class<HelloController> aClass = HelloController.class;

        int modifiers = aClass.getModifiers();
    }

}
