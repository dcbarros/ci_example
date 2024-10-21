create table IF NOT EXISTS orders (
	order_id INT PRIMARY KEY NOT NULL,
	product_name VARCHAR(22) NOT NULL,
	quantity INTEGER NOT NULL,
	price DECIMAL(7,2) NOT NULL,
	customer_name VARCHAR(50) NOT NULL,
	shipping_address VARCHAR(50) NOT NULL,
	order_date DATE NOT NULL,
	payment_method VARCHAR(16) NOT NULL,
	status VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS historico (
	id SERIAL PRIMARY KEY,
	id_order INTEGER,
	product_name VARCHAR(22) NOT NULL,
	old_status VARCHAR(10) NOT NULL,
	new_status VARCHAR(10) NOT NULL,
	data_alteracao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)