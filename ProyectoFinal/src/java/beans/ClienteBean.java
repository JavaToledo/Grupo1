/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.Cliente;
import dao.Provincias;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Alumno
 */
@Named(value = "cliente")
@SessionScoped
public class ClienteBean implements Serializable {

    private int codCliente;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private int codigopostal;
    private String municipio;
    private int codprovincia;
    private int telefono;
    private String email;
    private boolean estado;
    private List<Cliente> listadoCliente;
    private List listadoProvincia;

    public ManejadorCliente mn;
    
    public ClienteBean() {
        listadoProvincia =  mn.listarProvincias();
    }

    
    
    
    
    /**
     * @return the codCliente
     */
    public int getCodCliente() {
        return codCliente;
    }

    /**
     * @param codCliente the codCliente to set
     */
    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido1
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * @param apellido1 the apellido1 to set
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * @return the apellido2
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * @param apellido2 the apellido2 to set
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the codigopostal
     */
    public int getCodigopostal() {
        return codigopostal;
    }

    /**
     * @param codigopostal the codigopostal to set
     */
    public void setCodigopostal(int codigopostal) {
        this.codigopostal = codigopostal;
    }

    /**
     * @return the municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * @return the codprovincia
     */
    public int getCodprovincia() {
        return codprovincia;
    }

    /**
     * @param codprovincia the codprovincia to set
     */
    public void setCodprovincia(int codprovincia) {
        this.codprovincia = codprovincia;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the listadoCliente
     */
    public List<Cliente> getListadoCliente() {
        return listadoCliente;
    }

    /**
     * @param listadoCliente the listadoCliente to set
     */
    public void setListadoCliente(List<Cliente> listadoCliente) {
        this.listadoCliente = listadoCliente;
    }

    /**
     * @return the listadoProvincia
     */
    public List<Provincias> getListadoProvincia() {
        return listadoProvincia;
    }

    /**
     * @param listadoProvincia the listadoProvincia to set
     */
    public void setListadoProvincia(List<Provincias> listadoProvincia) {
        this.listadoProvincia = listadoProvincia;
    }

  

}
