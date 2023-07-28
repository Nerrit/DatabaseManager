package it.nerr.database.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.r2dbc.postgresql.codec.Json;
import it.nerr.database.buff163.BuffSellData;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.time.LocalDateTime;

@Repository
public interface Buff163SellOrdersRepository extends
        ReactiveCrudRepository<Buff163SellOrdersRepository.Buff163SellOrdersRecord, Integer> {

    @Query("SELECT sell_orders FROM public.buff163_sell_orders WHERE goods_id = :goodsId ORDER BY updated_at DESC LIMIT" +
            " 1")
    Mono<String> findSellDataJsonByGoodsId(Integer goodsId);

    default Mono<BuffSellData> saveSellData(Integer goodsId, BuffSellData sellData, LocalDateTime updatedAt) {
        try {
            return save(new Buff163SellOrdersRecord(goodsId, Json.of(new ObjectMapper().writeValueAsString(sellData)),
                    updatedAt)).map(Buff163SellOrdersRecord::sellData).handle((sellDataJson, sink) -> {
                try {
                    sink.next(new ObjectMapper().readValue(sellDataJson.asString(), BuffSellData.class));
                } catch (JsonProcessingException e) {
                    sink.error(new RuntimeException(e));
                }
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    default Mono<BuffSellData> saveSellData(Integer goodsId, BuffSellData sellData) {
        return saveSellData(goodsId, sellData, LocalDateTime.now());
    }

    default Mono<BuffSellData> findSellDataByGoodsId(Integer goodsId) {
        return findSellDataJsonByGoodsId(goodsId).handle((sellDataJson, sink) -> {
            try {
                sink.next(new ObjectMapper().readValue(sellDataJson, BuffSellData.class));
            } catch (JsonProcessingException e) {
                sink.error(new RuntimeException(e));
            }
        });
    }

    @Table(name = "public.buff163_sell_orders")
    record Buff163SellOrdersRecord(@Column("goods_id") Integer goodsId,
                                  @Column("sell_orders") Json sellData,
                                  @Column("updated_at") LocalDateTime updatedAt) implements Serializable {

    }
}
