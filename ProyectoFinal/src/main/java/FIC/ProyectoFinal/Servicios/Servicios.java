/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package FIC.ProyectoFinal.Servicios;

import java.util.List;
import java.util.Optional;

import FIC.ProyectoFinal.Anuncios.Anuncios;

/**
 *
 * @author bryan
 */
public interface Servicios {
    public List<Anuncios> ListarAnuncios();

    Optional<Anuncios> AnuncioPorId(Long id);

    Optional<Anuncios> CrearAnuncio(Anuncios anuncios);


    Optional<Anuncios> BuscarPorID(Long id);

    
}
