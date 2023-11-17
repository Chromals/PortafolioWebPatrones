package com.Tienda_v1.service.impl;

import com.Tienda_v1.dao.CategoriaDao;
import com.Tienda_v1.dao.UsuarioDao;
import com.Tienda_v1.domain.Categoria;
import com.Tienda_v1.domain.Rol;
import com.Tienda_v1.domain.Usuario;
import com.Tienda_v1.service.CategoriaService;
import com.Tienda_v1.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUsername(username);
        if(usuario== null)
            throw new UsernameNotFoundException(username);
        
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());
        var roles = new ArrayList<GrantedAuthority>();
        for(Rol rol : usuario.getRoles())
        {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        return new User(usuario.getUsername(),usuario.getPassword(),roles);
    }


}
