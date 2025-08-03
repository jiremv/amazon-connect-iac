package com.connect;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.squareup.moshi.Moshi;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class GreetingHandler implements RequestHandler<GreetingRequest, Map<String, Object>> {
    @Override
    public Map<String, Object> handleRequest(GreetingRequest input, Context context) {
        context.getLogger().log("Entrada recibida: " + input);

        String mensaje = "Hola, " + input.getNombre() + "! Recibimos tu mensaje: '" + input.getMensaje() + "'";
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("resultado", mensaje);
        respuesta.put("estado", "OK");

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 200);
        response.put("headers", Map.of(
                "Access-Control-Allow-Origin", "*",
                "Content-Type", "application/json"
        ));
        response.put("body", new Moshi.Builder().build().adapter(Map.class).toJson(respuesta));
        return response;
    }
}
