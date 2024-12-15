package FIC.ProyectoFinal.Repositorio;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import FIC.ProyectoFinal.Anuncios.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long >  {
    Optional<Usuario> findByUsername(String username);
}
