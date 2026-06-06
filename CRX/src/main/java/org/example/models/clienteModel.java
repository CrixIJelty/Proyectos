package org.example.models;

public class clienteModel {
    private int idcliente;
    private String nombredecliente;
    private String direcciondecliente;
    private int telefonodecliente;
    private String emaildecliente;

    public clienteModel() {
    }

    public clienteModel(String Idcliente, String nombredelcliente, String direcciondecliente, int telefonodecliente, String emaildecliente) {
        this.idcliente = idcliente;
        this.nombredecliente = nombredelcliente;
        this.direcciondecliente = direcciondecliente;
        this.telefonodecliente = telefonodecliente;
        this.emaildecliente = emaildecliente;

    }

    public clienteModel(String nombredecliente) {
        this.nombredecliente = nombredecliente;
    }

    //Obtener
    public String getNombredecliente() {
        return this.nombredecliente;
    }

    //Setear
    public void setNombredecliente(String nombredecliente) {
        this.nombredecliente = nombredecliente;
    }

    public clienteModel(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdcliente() {
        return this.idcliente;
    }

    public void setIdcliente() {
        this.idcliente = idcliente;
    }

    //Obtener
    public String getDirecciondecliente() {
        return this.direcciondecliente;
    }

    //Setear
    public void setDirecciondecliente(String direcciondecliente) {
        this.direcciondecliente = direcciondecliente;
    }
    //Obtener
    public String getEmaildecliente(){
        return this.emaildecliente;
    }
    //Setear
    public void setEmaildecliente(String emaildecliente) {
        this.emaildecliente = emaildecliente;
    }
    //Obtener
    public int getTelefonodecliente(){
        return this.telefonodecliente;
    }
    //Setear
    public void setTelefonodecliente(String telefonodecliente) {
        this.telefonodecliente = Integer.parseInt(telefonodecliente);
    }
}