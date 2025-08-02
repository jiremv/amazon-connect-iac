package com.connect;

import com.squareup.moshi.Json;

public class ContactData {
    @Json(name = "contactId")
    public String contactId;

    @Json(name = "customerName")
    public String customerName;

    @Json(name = "queue")
    public String queue;

    // Getters y setters si deseas agregarlos
}
