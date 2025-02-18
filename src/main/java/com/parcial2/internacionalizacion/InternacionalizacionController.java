package com.parcial2.internacionalizacion;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternacionalizacionController {

    @Autowired
    private MessageSource messageSource;

    /*
     * Método que retorna el saludo, modifiqué el método original adicionando más llamados del archivo properties con más saludos
     */
    @GetMapping("/saludo")
    public String saludo(@RequestHeader(name = "Accept-Language", required = false) String language) {
        Locale locale = (language != null) ? Locale.forLanguageTag(language) : Locale.getDefault();
        
        String saludos = messageSource.getMessage("welcome.greeting", null, locale);
        saludos += " ";
        saludos += messageSource.getMessage("welcome.desarrollo", null, locale);
        saludos += " ";
        saludos += messageSource.getMessage("welcome.fin", null, locale);

        return saludos;
    }
    //Ejemplo peticion con el header -> Accept-Language <-
    //"Accept-Language: es" http://localhost:8080/saludo
    //"Accept-Language: en" http://localhost:8080/saludo


    /*
     * @GetMapping("/saludo")
     * public String obtenerSaludo(@RequestHeader(name = "Accept-Language", required
     * = false) Locale locale) {
     * return messageSource.getMessage("welcome.message", null, locale);
     * }
     */

     /*
      * En caso de que retorne un error la peticion se mostrará el mensaje del método
      */
    @GetMapping("/error")
    public String errorEndpoint() {
        return "Ha Ocurrido un error al tratar su petición";
    }

}
