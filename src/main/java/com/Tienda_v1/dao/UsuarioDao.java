package com.Tienda_v1.dao;

import com.Tienda_v1.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario,Long>{

    Usuario findByUsername(String username);
    
    Usuario findByUsernameAndPassword(String username, String password);
    
    Usuario findByUsernameOrCorreo(String username, String correo);
    
    Boolean existsByUsernameOrCorreo(String username, String correo);
}
