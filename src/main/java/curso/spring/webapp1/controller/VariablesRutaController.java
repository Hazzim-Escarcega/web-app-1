package curso.spring.webapp1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/variables")
public class VariablesRutaController {
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("titulo", "Enviar parametros de la ruta");
        return "/variables/index";
    }
    @GetMapping("/string/{texto}")
    public String variables(@PathVariable String texto, Model model){
        model.addAttribute("titulo", "Recibir parametros de la ruta");
        model.addAttribute("contenido", "El texto enviado en la ruta es "+ texto);

        return "/variables/ver";
    }
    @GetMapping("/string/{texto}/{numero}")
    public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model){
        model.addAttribute("titulo", "Recibir parametros de la ruta");
        model.addAttribute("contenido", "El texto enviado en la ruta es "+ texto
                + " y El numero es "+numero);

        return "/variables/ver";
    }
}
