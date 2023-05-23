package it.nerr.database.buff163;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Sticker(String category, String img_url, String name, int slot, int sticker_id,
                      int wear) {}
