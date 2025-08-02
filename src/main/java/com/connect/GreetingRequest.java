package com.connect;

public class GreetingRequest {
    private String nombre;
    private String mensaje;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "GreetingRequest{" +
                "nombre='" + nombre + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}
