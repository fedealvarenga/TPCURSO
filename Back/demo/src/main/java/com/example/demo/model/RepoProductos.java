package com.example.demo.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoProductos extends JpaRepository<Producto,Integer> {

}
