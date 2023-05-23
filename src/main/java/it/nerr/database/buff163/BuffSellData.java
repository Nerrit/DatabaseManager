package it.nerr.database.buff163;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BuffSellData(String fop_str, Map<String, GoodsInfo> goods_info, Map<String, Boolean> has_market_stores,
                           List<SellOrder> items, int page_num, int page_size, Map<String, String> preview_screenshots,
                           boolean show_play_method_icon, String sorty_by,
                           String src_url_background, int total_count, int total_page,
                           Map<String, User> user_infos) {

}
