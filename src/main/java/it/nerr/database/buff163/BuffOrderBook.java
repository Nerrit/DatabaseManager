package it.nerr.database.buff163;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BuffOrderBook(List<OrderBook> items, int page_num, int page_size, int total_count, int total_page) {

}
