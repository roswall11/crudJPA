package com.example.crudJpa.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudJpa.model.Producto;
import com.example.crudJpa.service.ProductoService;

@RestController
public class ProductoController {
	
	@Autowired
	private ProductoService service;
	
	@GetMapping("/productos")
	public List<Producto> listarproducto(){
		return service.listarProducto();
	}
	@GetMapping("productos/{id}")
	public Producto obtnerProducto(@PathVariable Integer id) {
		return service.obtnerProducto(id);
	}
	
	@PostMapping("/productos")
	public void guardarProducto(@RequestBody Producto producto) {
		service.guardarProducto(producto);
	}
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<?> actualizarProdducto(@RequestBody Producto producto,@PathVariable Integer id){
		try {
			Producto productoExistente = service.obtnerProducto(id);
			productoExistente.setNombre(producto.getNombre());
			productoExistente.setPrecio(producto.getPrecio());	
			service.guardarProducto(productoExistente);
			return new ResponseEntity<Producto>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
	}
	 
	@DeleteMapping("/productos/{id}")
	public void eliminarProducto(@PathVariable Integer id) {
		service.eliminarProducto(id);
	}
}
