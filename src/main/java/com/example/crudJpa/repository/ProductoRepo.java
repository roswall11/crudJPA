package com.example.crudJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudJpa.model.Producto;

public interface ProductoRepo extends JpaRepository<Producto, Integer> {

}
