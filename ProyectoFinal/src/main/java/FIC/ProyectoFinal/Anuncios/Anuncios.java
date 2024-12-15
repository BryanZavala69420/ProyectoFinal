/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FIC.ProyectoFinal.Anuncios;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author bryan
 */
@Entity
@Table(name="Puta")
public class Anuncios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="nombre")
    private String nombre;

    @Column(name = "asunto")
    private String asunto;

    @Column (name = "comentario")
    private String comentario;

    private String password;

    public Anuncios(){}

    public Anuncios(Long id, String nombre, String asunto, String comentario, String password){
        this.id=id;
        this.nombre=nombre;
        this.asunto=asunto;
        this.comentario=comentario;
        this.password=password;


    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;

    }
    public String getAsunto(){
        return asunto;
    }

    public void setAsunto(String asunto){
        this.asunto=asunto;
    }

    public String getComentario(){
        return comentario;
    }

    public void setComentario(String comentario){
        this.comentario=comentario;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    @Override
    public String toString(){
        return "Anuncios[id=" + id + ", nombre="+ nombre + ", asunto=" + asunto +", comentario=" + comentario + ", password=" + password + "]";
    }







}
    




    












