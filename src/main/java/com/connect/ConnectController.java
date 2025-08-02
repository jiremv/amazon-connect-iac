package com.connect;

import com.squareup.moshi.Moshi;
import com.squareup.moshi.JsonAdapter;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/connect")
public class ConnectController {

    private final Moshi moshi = new Moshi.Builder().build();
    private final JsonAdapter<ContactData> adapter = moshi.adapter(ContactData.class);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response recibirContacto(String body) {
        try {
            ContactData contacto = adapter.fromJson(body);
            System.out.println("🟢 Contacto recibido: " + contacto.customerName);
            return Response.ok("Hola " + contacto.customerName).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(400).entity("Error al parsear JSON").build();
        }
    }
}
