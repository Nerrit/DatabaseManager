CREATE TABLE IF NOT EXISTS public.buff163_goods_ids
(
    goods_id integer NOT NULL,
    hash_name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT buff163_goods_ids_pkey PRIMARY KEY (goods_id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.buff163_goods_ids
    OWNER to postgres;

CREATE UNIQUE INDEX IF NOT EXISTS buff163_goods_ids_idx
    ON public.buff163_goods_ids USING btree
        (goods_id ASC NULLS LAST, hash_name COLLATE pg_catalog."default" ASC NULLS LAST)
    INCLUDE(goods_id, hash_name)
    TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS public.buff163_buy_orders
(
    goods_id integer NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    buy_orders jsonb NOT NULL,
    CONSTRAINT buff163_buy_orders_pkey PRIMARY KEY (goods_id, updated_at)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.buff163_buy_orders
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.buff163_sell_orders
(
    goods_id integer NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    sell_orders jsonb NOT NULL,
    CONSTRAINT buff163_sell_orders_pkey PRIMARY KEY (goods_id, updated_at)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.buff163_sell_orders
    OWNER to postgres;