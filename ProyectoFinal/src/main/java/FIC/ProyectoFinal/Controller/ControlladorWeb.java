package FIC.ProyectoFinal.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import FIC.ProyectoFinal.Anuncios.Anuncios;
import FIC.ProyectoFinal.Repositorio.RepositorioWeb;
import FIC.ProyectoFinal.Servicios.ServiciosIMPL;

@Controller
public class ControlladorWeb {

    @Autowired
    public ServiciosIMPL serviciosIMPL;

    @Autowired
    private RepositorioWeb RepositorioWeb;

    // Mostrar todos los anuncios en la página principal
    @GetMapping("/anuncios")
    public String mostrarAnuncios(Model model) {
        List<Anuncios> listaDeAnuncios = RepositorioWeb.findAll();
        System.out.println("Lista de anuncios: " + listaDeAnuncios);
        model.addAttribute("anuncios", listaDeAnuncios);
        return "index"; // Asegúrate de que la plantilla "index.html" exista
    }

    // Página de inicio de sesión
    @GetMapping("/")
    public String login() {
        return "index";
    }

    // Formulario para crear un nuevo anuncio
    @GetMapping("/new")
    public String OdioJavaXDXD(Model model) {
        Anuncios anuncios = new Anuncios();
        model.addAttribute("anuncios", anuncios);
        return "NuevoAnuncios"; // Asegúrate de que la plantilla "NuevoAnuncios.html" exista
    }

    // Crear un nuevo anuncio y redirigir a la página de confirmación
    @PostMapping("/new")
    public String CrearAnuncio(@ModelAttribute Anuncios anuncios, Model model) {
        Optional<Anuncios> newAnuncios = serviciosIMPL.CrearAnuncio(anuncios);

        if (newAnuncios.isPresent()) {
            model.addAttribute("anuncio", newAnuncios.get());
            return "InsertarAnuncio"; // Asegúrate de que la plantilla "InsertarAnuncio.html" exista
        } else {
            return "Error"; // Asegúrate de que la plantilla "Error.html" exista
        }
    }

    // Listar todos los anuncios en una vista específica
    @GetMapping("/Sexo")
    public String ListarAnuncios(Model model) {
        List<Anuncios> listaAnuncios = serviciosIMPL.ListarAnuncios();
        model.addAttribute("anuncios", listaAnuncios);
        return "VerCositas"; // Asegúrate de que la plantilla "VerCositas.html" exista
    }

    // Mostrar un anuncio individual basado en el ID
    @GetMapping("/show/{id}")
    public String AnuncioSolito(@PathVariable Long id, Model model) {
        Anuncios anuncios = RepositorioWeb.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Anuncio no encontrado: " + id));
        model.addAttribute("anuncios", anuncios);
        return "AnuncioSolitario"; // Asegúrate de que la plantilla "AnuncioSolitario.html" exista
    }

    // Métodos utilizados para Postman y depuración
    /*@GetMapping("/todos")
    @ResponseBody
    public List<Anuncios> ListarAnunciosPOSTMAN() {
        return serviciosIMPL.ListarAnuncios();
    }

    @GetMapping("/porno/{id}")
    @ResponseBody
    public Anuncios AnuncioIDSexo(@PathVariable(name = "id") Long id) {
        return serviciosIMPL.BuscarPorID(id)
                .orElseThrow(() -> new NoSuchElementException("No existe"));
    } */
}
