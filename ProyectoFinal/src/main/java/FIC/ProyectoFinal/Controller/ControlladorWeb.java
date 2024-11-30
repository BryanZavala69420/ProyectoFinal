/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FIC.ProyectoFinal.Controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

import FIC.ProyectoFinal.Anuncios.Anuncios;
import FIC.ProyectoFinal.Repositorio.RepositorioWeb;
import FIC.ProyectoFinal.Servicios.ServiciosIMPL;

import org.springframework.ui.Model;


/**
 *
 * @author bryan
 */
@Controller
//@RestController
public class ControlladorWeb {

    @Autowired
    public ServiciosIMPL serviciosIMPL;

    @Autowired
    private RepositorioWeb RepositorioWeb;


    @GetMapping("/")
public String mostrarAnuncios(Model model) {
    // Obtener la lista de anuncios desde el repositorio o servicio
    List<Anuncios> listaDeAnuncios = RepositorioWeb.findAll();
    
    // Verificar si la lista tiene datos
    System.out.println("Lista de anuncios: " + listaDeAnuncios);
    
    // Pasar la lista al modelo
    model.addAttribute("anuncios", listaDeAnuncios);

    return "index"; // Asegúrate de que el nombre coincide con tu plantilla
}





    @GetMapping("/new") //Esto sirve para que dentro de la pagina web puedas insertar el formulario
    public String OdioJavaXDXD(Model model){ //el metodo, o sepa que sea esto porque bueno, odio Java
        Anuncios anuncios = new Anuncios(); // LA VERDAD NO SE QUE ES ESTO TODAVIA, PERO BUENO NO LO MODIFIQUES A MENOS QUE DEBAS
        model.addAttribute("anuncios", anuncios); // addAttribute (sin 's') es el método correcto




        return "NuevoAnuncios"; 
    }


    @PostMapping("/new")
    public String CrearAnuncio(@ModelAttribute Anuncios anuncios, Model model) {
        // Llama al servicio para guardar el anuncio
        Optional<Anuncios> newAnuncios = serviciosIMPL.CrearAnuncio(anuncios);

        // Se verifica si el anuncio se guardo a la verga
        if (newAnuncios.isPresent()) {
            // Agrega el objeto <anuncios> al modelo para mostrarlo en la vista
            model.addAttribute("anuncio", newAnuncios.get());

            // Redirige o renderiza la vista "InsertarAnuncio.html"
        return "InsertarAnuncio";
        } else {
            // Si no se pudo guardar, redirige o renderiza una página de error
            return "Error"; 
        }
    }
    //ESTO ES PARA EL HTML, TODAVIA NO SE COMO ANADIR COSITAS
    @GetMapping("/Sexo")
    public String ListarAnuncios(Model model) {
        // Llama al servicio para obtener la lista de anuncios
        List<Anuncios> listaAnuncios = serviciosIMPL.ListarAnuncios();
    
        // Agrega la lista al modelo
        model.addAttribute("anuncios", listaAnuncios);
    
        // Retorna la vista "VerCositas.html"
        return "VerCositas";
    }


@GetMapping("/show/{id}")
public String AnuncioSolito(@PathVariable Long id, Model model) {
    // Buscar el anuncio por id
    Anuncios anuncios = RepositorioWeb.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Anuncio no encontrado: " + id));

    // Pasar el anuncio al modelo
    model.addAttribute("anuncios", anuncios);

    // Redirigir a la vista "AnuncioSolitario"
    return "AnuncioSolitario";
}






    //sexo












    /*ESTE ES SOLO PARA VER SI 
    TODO VA BIEN EN EL POSTMAN,
     REALMENTE SOLO LE ESTOY DANDO UN USO EN EL
      DESARROLLO, Y SE TENDRA QUE BORRAR DESPUES */
    @GetMapping("/todos")
    @ResponseBody
    public List<Anuncios> ListarAnunciosPOSTMAN() {

        return serviciosIMPL.ListarAnuncios();
    }

//ESTO SIRVE PARA LO MISMO QUE ARRIBA, PERO CON EL ID
//TAL VEZ TE SIRVA, TAL VEZ NO, NO LO SE XXDXDXDXD
    @GetMapping("/porno/{id}")
    @ResponseBody
    public Anuncios AnuncioIDSexo(@PathVariable(name="id") Long id){
        Optional<Anuncios> anuncios = serviciosIMPL.BuscarPorID(id);
        if(anuncios.isPresent()){
            return anuncios.get();
        }else{
            throw new NoSuchElementException("No existe");

        }

    }









}
