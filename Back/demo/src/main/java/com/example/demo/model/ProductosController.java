package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/productos")
public class ProductosController {
    @Autowired
    private RepoProductos repo;
    @Autowired
    private RepoUsuarios repoUser;

    @PostMapping(path={"","/crear"})
    public void postProducto(@RequestBody @Valid Producto producto, BindingResult br,@RequestParam (value= "id_vendedor") Integer idVendedor ) {
        Usuario user= repoUser.getReferenceById(idVendedor);
        producto.setVendedor(user);
        repo.save(producto);
    }
    @DeleteMapping(path={"/borrar"})
    public void borrarUsuario(@RequestParam (value= "id") Integer idProducto){
        Producto product= repo.getReferenceById(idProducto);
        product.setActivo(false);
        repo.save(product);
    }
    @PostMapping(path={"/modificar"})
    public void modificarProducto(@RequestBody @Valid Producto producto,BindingResult br){
        Producto product= repo.getReferenceById(producto.getId());
        product.setNombre(producto.getNombre());
        product.setCategoria(producto.getCategoria());
        product.setDescripcion(producto.getDescripcion());
        product.setPrecio(producto.getPrecio());
        product.setTipoDeMoneda(product.getTipoDeMoneda());
        repo.save(product);
    }


}
