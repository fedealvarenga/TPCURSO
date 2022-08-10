package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
@Entity
@Table(name = "usuario")
public class Usuario {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private Integer id;
        @Column(name = "nombre_de_usuario", unique=true, columnDefinition = "VARCHAR(255)")
        @NotBlank
        private String nombreDeUsuario;
        @Column(name = "nombre", columnDefinition = "VARCHAR(255)")
        @NotBlank
        private String nombre;
        @Column(name = "apellido", columnDefinition = "VARCHAR(255)")
        @NotBlank
        private String apellido;
        @Column(name = "contrasenia", columnDefinition = "VARCHAR(255)")
        @NotBlank
        private String contrasenia;
        @Column(name="tipo")
        @Enumerated(value = EnumType.STRING)
        //@NotBlank
        private Tipo tipo;
        @Column(name="activo",columnDefinition = "BOOLEAN")
        private boolean activo;

        @OneToMany(mappedBy = "vendedor",cascade = {CascadeType.ALL})
        private List<Producto> productosPublicados;

        public Tipo getTipo() {
                return tipo;
        }

        public void setTipo(Tipo tipo) {
                this.tipo = tipo;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getNombreDeUsuario() {
                return nombreDeUsuario;
        }

        public void setNombreDeUsuario(String nombreDeUsuario) {
                this.nombreDeUsuario = nombreDeUsuario;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getApellido() {
                return apellido;
        }

        public void setApellido(String apellido) {
                this.apellido = apellido;
        }

        public String getContrasenia() {
                return contrasenia;
        }

        public void setContrasenia(String contrasenia) {
                this.contrasenia = contrasenia;
        }

        public boolean isActivo() {
                return activo;
        }

        public void setActivo(boolean activo) {
                this.activo = activo;
        }




}
