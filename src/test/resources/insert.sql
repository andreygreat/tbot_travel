TRUNCATE TABLE city RESTART IDENTITY ;
INSERT INTO city (id, name, info) VALUES (1, 'Mogilew', 'Mogilew info');
INSERT INTO city (id, name, info) VALUES (2, 'Moscow', 'Capital of Russia');
INSERT INTO city (id, name, info) VALUES (3, 'Minsk', 'Capital of Belarus');
INSERT INTO city (id, name, info) VALUES (4, 'Grodno', 'Grodno info');
INSERT INTO city (id, name, info) VALUES (5, 'Brest', 'Brest info');
INSERT INTO city (id, name, info) VALUES (6, 'Gomel', 'Gomel info');
INSERT INTO city (id, name, info) VALUES (7, 'Vitebsk', 'Capital of Russia');
INSERT INTO city (id, name, info) VALUES (8, 'Berlin', 'Capital of Germany');
INSERT INTO city (id, name, info) VALUES (9, 'Paris', 'Capital of France');
INSERT INTO city (id, name, info) VALUES (10, 'Madrid', 'Capital of Spain');
INSERT INTO city (id, name, info) VALUES (11, 'Slutsk', '');
INSERT INTO city (id, name, info) VALUES (12, 'Solgorsk', '');
INSERT INTO city (id, name, info) VALUES (13, 'Lida', '');
INSERT INTO city (id, name, info) VALUES (14, 'Orsha', '');
SELECT pg_catalog.setval('public.city_id_seq', 14);