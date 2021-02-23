package com.gimnasio.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gimnasio.model.entities.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	public Usuario findByUsuario(String usuario);
    public Usuario findByUsuarioAndPassword(String usuario, String password);

}
