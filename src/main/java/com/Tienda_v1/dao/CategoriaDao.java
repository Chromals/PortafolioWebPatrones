package com.Tienda_v1.dao;

import com.Tienda_v1.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaDao extends JpaRepository<Categoria,Long>{

    
}
