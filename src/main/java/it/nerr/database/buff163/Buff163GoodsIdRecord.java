package it.nerr.database.buff163;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "public.buff163_goods_ids")
public record Buff163GoodsIdRecord(@Column("goods_id") Integer goodsId,
                                   @Column("hash_name") String hashName) {

}
