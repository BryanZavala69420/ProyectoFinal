/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FIC.ProyectoFinal.Servicios;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FIC.ProyectoFinal.Anuncios.Anuncios;
import FIC.ProyectoFinal.Repositorio.RepositorioWeb;

/**
 *
 * @author bryan
 */
@Service
public class ServiciosIMPL implements Servicios{

    @Autowired
    private RepositorioWeb RepositorioWeb;

    org.slf4j.Logger logger = LoggerFactory.getLogger(ServiciosIMPL.class);


    @Override
        public List<Anuncios> ListarAnuncios() {
        List<Anuncios> Anuncios = RepositorioWeb.findAll();

    return Anuncios;
    }


    @Override
    public Optional<Anuncios> AnuncioPorId(Long id) {
    Optional<Anuncios> BuscameAnuncios = RepositorioWeb.findById(id);
        if(BuscameAnuncios.isPresent()){
            logger.error("Usuario encontrado");
            return BuscameAnuncios;

        }else{
            throw new NoSuchElementException("No hay anuncio, sacate, lol");
            //aqui se acaba ya que no se ingreso nada
        }        
        
            

    }


    @Override
    public Optional<Anuncios> CrearAnuncio(Anuncios anuncios) {
    Optional<Anuncios> AnuncioNuevo = Optional.of(anuncios);
        if(AnuncioNuevo.isPresent()){

            Anuncios newAnuncios = new Anuncios();
            
            newAnuncios.setNombre(anuncios.getNombre());
            newAnuncios.setAsunto(anuncios.getAsunto());
            newAnuncios.setComentario(anuncios.getComentario());
            
            RepositorioWeb.save(newAnuncios);

            Optional<Anuncios> RetornarAnuncio = Optional.of(newAnuncios);
            return RetornarAnuncio;
        }else{
            throw new NoSuchElementException("Nada");
        
        }



    }


    @Override
    public Optional<Anuncios> BuscarPorID(Long id) {
        
        Optional<Anuncios> BuscameID = RepositorioWeb.findById(id);

            if(BuscameID.isPresent()){
                logger.error("El anuncio " + id + "Si existe");
                return BuscameID;
            }else{
                throw new NoSuchElementException("No existe esta madre loco");
            }

    }




   /*  @Override
    public Optional<Anuncios> ListarPorID(Long id, Anuncios anuncios) {
        Optional<Anuncios> BuscameEsta = RepositorioWeb.findById(id);
            if(BuscameEsta.isPresent()){
                logger.error("El anuncio si existe y sera mostrado.");
                return BuscameEsta;
            }else{
                logger.error("No existe el anuncio");
                throw new NoSuchElementException("No hay nada, no");

            }


    }**/
    



    
    


    
}
