package it.nerr.database.buff163;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GoodsInfo(int appid, String description, String game, int goods_id, String icon_rul, TagInfo info,
                        String item_id, String market_hash_name, String market_min_price, String name,
                        String original_icon_url, String short_name, String steam_price, String steam_price_cny,
                        String steam_price_custom, Map<String, Tag> tags) {

}
