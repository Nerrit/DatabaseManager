package it.nerr.database.repositories;

import it.nerr.database.buff163.Buff163GoodsIdRecord;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface Buff163GoodsIdRepository extends ReactiveCrudRepository<Buff163GoodsIdRecord, Integer> {

    @Query("SELECT goods_id FROM public.buff163_goods_ids WHERE hash_name = :hashName")
    Flux<Integer> findGoodsIdByHashName(String hashName);

    @Query("SELECT goods_id FROM public.buff163_goods_ids")
    Flux<Integer> findAllGoodsIds();
}
