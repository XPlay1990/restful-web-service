CREATE OR REPLACE VIEW orders_view AS
    (
        (
            select UUID()                as id,
                   'confirmed'           as type,
                   quantity              as quantity,
                   confirmed_target_date as target_date
            from order_confirmedline
        )
        UNION
        (select UUID()        as id,
                'unconfirmed' as type,
                quantity      as quantity,
                target_date   as target_date
         from order_line)
    );