CREATE OR REPLACE FUNCTION registrar_alteracao_order()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.status <> OLD.status THEN
        INSERT INTO historico (id_order, product_name, old_status, new_status)
        VALUES
        (OLD.order_id, OLD.product_name, OLD.status, NEW.status);
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
