package it.nerr.database.buff163;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SellOrder(boolean allow_bargain, int appid, Asset asset_info, String background_image_url,
                        boolean bookmarked, boolean can_bargain, boolean can_use_inspect_trn_url,
                        String cannot_bargain_reason, List<Coupon> coupon_infos, long created_at, String description,
                        int featured, String fee, String game, int goods_id, String id, String img_src, String income,
                        String lowest_bargain_price, int mode, String price, BigDecimal recent_average_duration,
                        BigDecimal recent_deliver_rate, int state, List<Integer> supported_pay_methods,
                        String tradable_cooldown, long updated_at, String user_id) {

}
