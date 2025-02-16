package com.parcial2.internacionalizacion;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomErrorController implements ErrorController {

    //Maneja el error en la pagina mostrando el mensaje
    @RequestMapping("/error")
    @ResponseBody
    public String handleError() {
        return "Ha Ocurrido un error al tratar su petición";
    }

    public String getErrorPath() {
        return "/error";
    }

}
