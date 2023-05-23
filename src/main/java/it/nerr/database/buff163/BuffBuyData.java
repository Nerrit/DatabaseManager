package it.nerr.database.buff163;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BuffBuyData(List<BuyOrder> items, int page_num, int page_size, boolean show_pay_method_icon,
                          int total_count,
                          int total_page, Map<String, User> user_infos) {

}
