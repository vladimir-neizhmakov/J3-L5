BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), cost numeric(6, 2));
INSERT INTO products (title, cost) VALUES
('Milk', 43.60),
('Bread', 32.00),
('Apple', 72.00),
('BlackBread', 38.00),
('Orange', 58.90);

COMMIT;