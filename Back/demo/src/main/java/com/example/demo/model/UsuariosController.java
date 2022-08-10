package com.example.demo.model;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    @Qualifier("jpa")
    private RepoUsuarios repo;
    // alta
    @PostMapping(path={"","/crear"})
    public void postUsuario(@RequestBody @Valid Usuario usuario,BindingResult br) {
        repo.save(usuario);
    }
    @DeleteMapping(path={"/{nombreusuario}"})
    public void borrarUsuario(@PathVariable("nombreusuario") String nombreUsuario ){
        Usuario user= repo.findByNombreDeUsuario(nombreUsuario);
        user.setActivo(false);
        repo.save(user);
    }
    // investigar metodo HEAD para poder hacer modificaciones

    @PostMapping(path={"/modificar"})
    public void modificarUsuario(@RequestBody @Valid Usuario usuario,BindingResult br){
        Usuario user= repo.findByNombreDeUsuario(usuario.getNombreDeUsuario());
        user.setNombre(usuario.getNombre());
        user.setApellido(usuario.getApellido());
        user.setContrasenia(usuario.getContrasenia());
        repo.save(user);
    }


    @PostMapping(path={"/login"}) // agregarle la validacion por si el usuario no esta activo
    public ResponseEntity validarUsuario(@RequestBody Map<String, String> param){
        Usuario user= repo.findByNombreDeUsuario(param.get("nombreDeUsuario"));
        if(user.getContrasenia().equals(param.get("password")) && user.isActivo()){
            return ResponseEntity.ok().body(user.getId());
            } else return ResponseEntity.notFound().build();
        //user.getContrasenia().equals(param.get("password"));
    }

}