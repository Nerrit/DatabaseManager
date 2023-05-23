package it.nerr.database.buff163;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderBook(int appid, boolean bookmarked, String buy_max_price, int buy_num, boolean can_bargain,
                        boolean can_search_by_tournament, String description, String game, GoodsInfo goods_info,
                        boolean has_buff_price_history, int id, String market_hash_name, String market_min_price,
                        String name, String quick_price, String sell_min_price, int sell_num, String sell_reference_price,
                        String short_name, String steam_market_url, int transacted_num) {

}
