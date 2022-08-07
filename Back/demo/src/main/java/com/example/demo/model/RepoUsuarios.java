package com.example.demo.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
@Qualifier("jpa")
public interface RepoUsuarios extends JpaRepository<Usuario,Integer> {

    public Usuario findByNombreDeUsuario(String nombre);

}
