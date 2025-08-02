package com.connect;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.IOException;

@ApplicationScoped
public class GreetingHandler implements RequestHandler<GreetingRequest, GreetingResponse> {

    private final Moshi moshi = new Moshi.Builder().build();
    private final JsonAdapter<GreetingRequest> requestAdapter = moshi.adapter(GreetingRequest.class);

    @Override
    public GreetingResponse handleRequest(GreetingRequest input, Context context) {
        context.getLogger().log("Entrada recibida: " + input);

        String mensaje = "Hola, " + input.getNombre() + "! Recibimos tu mensaje: '" + input.getMensaje() + "'";
        return new GreetingResponse(mensaje, "OK");
    }
}
