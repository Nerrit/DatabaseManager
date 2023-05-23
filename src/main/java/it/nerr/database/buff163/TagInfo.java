package it.nerr.database.buff163;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TagInfo(Map<String, Tag> tags) {}
