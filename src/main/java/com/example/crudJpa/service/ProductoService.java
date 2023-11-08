package com.example.crudJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudJpa.model.Producto;
import com.example.crudJpa.repository.ProductoRepo;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepo repo;
	
	public List<Producto> listarProducto(){
		return repo.findAll()
;	}
	
	public void guardarProducto(Producto producto) {
		repo.save(producto);
	}

	public Producto obtnerProducto(Integer id){
		return repo.findById(id).get();
	}
	
	public void eliminarProducto(Integer id) {
		repo.deleteById(id);
	}
}
