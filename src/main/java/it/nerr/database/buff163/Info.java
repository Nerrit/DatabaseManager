package it.nerr.database.buff163;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Info(String fraudwarnings, String icon_url, String inspect_en_size,
                   String inspect_en_url, String inspect_mobile_size, String inspect_mobile_url,
                   String inspect_size, String inspect_start_at, int inspect_state, String inspect_trn_size,
                   String inspect_trn_url, String inspect_url, int inspect_version, String inspected_at,
                   String original_icon_url, int paintindex, int paintseed, List<Sticker> stickers,
                   List<TournamentTag> tournament_tags) {

}
