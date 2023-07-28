package it.nerr.database.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.r2dbc.postgresql.codec.Json;
import it.nerr.database.buff163.BuffBuyData;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.time.LocalDateTime;

@Repository
public interface Buff163BuyOrdersRepository extends ReactiveCrudRepository<Buff163BuyOrdersRepository.Buff163BuyOrdersRecord, Integer> {

    @Query("SELECT buy_orders FROM public.buff163_buy_orders WHERE goods_id = :goodsId ORDER BY updated_at DESC LIMIT" +
            " 1")
    Mono<String> findBuyDataJsonByGoodsId(Integer goodsId);

    default Mono<BuffBuyData> findBuyDataByGoodsId(Integer goodsId) {
        return findBuyDataJsonByGoodsId(goodsId).handle((buyDataJson, sink) -> {
            try {
                sink.next(new ObjectMapper().readValue(buyDataJson, BuffBuyData.class));
            } catch (JsonProcessingException e) {
                sink.error(new RuntimeException(e));
            }
        });
    }

    @Query("SELECT buy_orders FROM public.buff163_buy_orders WHERE goods_id = :goodsId AND updated_at > :updatedAfter ORDER BY updated_at DESC LIMIT" +
            " 1")
    Mono<String> findBuyDataJsonByGoodsId(Integer goodsId, LocalDateTime updatedAfter);

    default Mono<BuffBuyData> findBuyDataByGoodsId(Integer goodsId, LocalDateTime updatedAfter) {
        return findBuyDataJsonByGoodsId(goodsId, updatedAfter).handle((buyDataJson, sink) -> {
            try {
                sink.next(new ObjectMapper().readValue(buyDataJson, BuffBuyData.class));
            } catch (JsonProcessingException e) {
                sink.error(new RuntimeException(e));
            }
        });
    }

    default Mono<BuffBuyData> saveBuyData(Integer goodsId, BuffBuyData buyData, LocalDateTime updatedAt) {
        try {
            return save(new Buff163BuyOrdersRecord(goodsId, Json.of(new ObjectMapper().writeValueAsString(buyData)),
                    updatedAt)).map(Buff163BuyOrdersRecord::buyData).handle((buyDataJson, sink) -> {
                try {
                    sink.next(new ObjectMapper().readValue(buyDataJson.asString(), BuffBuyData.class));
                } catch (JsonProcessingException e) {
                    sink.error(new RuntimeException(e));
                }
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    default Mono<BuffBuyData> saveBuyData(Integer goodsId, BuffBuyData buyData) {
        return saveBuyData(goodsId, buyData, LocalDateTime.now());
    }

    @Table(name = "public.buff163_buy_orders")
    record Buff163BuyOrdersRecord(@Column("goods_id") Integer goodsId,
                                  @Column("buy_orders") Json buyData,
            @Column("updated_at") LocalDateTime updatedAt) implements Serializable {

    }
}
