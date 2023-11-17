package com.Tienda_v1.service;

import com.Tienda_v1.domain.Usuario;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsuarioDetailsService {
    
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException;
    
   
}
