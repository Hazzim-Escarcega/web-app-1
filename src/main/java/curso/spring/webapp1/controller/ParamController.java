package curso.spring.webapp1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ParamController {

    @GetMapping("/string")
    public String param(@RequestParam(name = "texto") String texto, Model model){
        model.addAttribute("resultado", "El valor de la variable es ".concat(texto));
        return "params/ver";
    }
    @GetMapping("/")
    public String index(){
        return "params/index";
    }
    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model){
        model.addAttribute("resultado","El suludo es "+ saludo + " El numero es "+numero);
        return "params/ver";
    }
    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model){
        String saludo = request.getParameter("saludo");
        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        }catch (NumberFormatException e){
            System.out.println(e);
        }
        model.addAttribute("resultado","El suludo es "+ saludo + " El numero es "+numero);

        return "params/ver";
    }
}
