package ana.franco.databaseSql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/")
    public String index(){
        return "Seja Bem vindo ao Doguinho de ouro";
    }

}