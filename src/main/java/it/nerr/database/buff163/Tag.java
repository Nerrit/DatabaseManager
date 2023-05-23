package it.nerr.database.buff163;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Tag(String category, String internal_name, String localized_name) {}
