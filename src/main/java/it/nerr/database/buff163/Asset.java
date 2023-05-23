package it.nerr.database.buff163;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Asset(String auction_link, int appid, String assetid, String classid, int contextid,
                    int goods_id, boolean has_tradable_cooldown, Info info, String instanceid, String paintwear,
                    String tradable_cooldown_text, String tradable_unfrozen_time) {

}
