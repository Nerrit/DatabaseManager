package it.nerr.database.buff163;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BuyOrder(int allow_tradable_cooldown, int appid, long created_at, long expire_time, String fee,
                       String frozen_amount, int frozen_num, String game, int goods_id, String icon_url, String id,
                       int num, int pay_expire_timeout, int pay_method, String pay_method_text, String price, int real_num,
                       List<Specific> specific, String state, String state_text, String tradable_cooldown, long updated_at,
                       String user_id) {

}
