package curso.spring.webapp1.controller;

import curso.spring.webapp1.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexController {
    @GetMapping({"/index", "/", "", "", "/home"})
    public String index(ModelMap model){
        model.addAttribute("titulo", "Hola Spring Framework");
        model.addAttribute("contenido", "This is content");
        return "index";
    }
    @GetMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Hazzim");
        usuario.setApellido("Escarcega");
        usuario.setEmail("mail@mail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Bienvenido ".concat(usuario.getNombre()).concat(" ".concat(usuario.getApellido())));
        model.addAttribute("contenido", "Perfil del Usuario: ".concat(usuario.getNombre()).concat(" ".concat(usuario.getApellido())));
       model.addAttribute("error", "El usuario no tiene correo");
        return "perfil";
    }
}
