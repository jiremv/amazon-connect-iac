package com.connect;

public class GreetingResponse {
    private String resultado;
    private String estado;

    public GreetingResponse(String resultado, String estado) {
        this.resultado = resultado;
        this.estado = estado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
