CREATE TRIGGER trigger_alteracao_status
AFTER UPDATE ON orders
FOR EACH ROW
EXECUTE FUNCTION registrar_alteracao_order() 