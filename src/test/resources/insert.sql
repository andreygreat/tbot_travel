TRUNCATE TABLE city RESTART IDENTITY ;
INSERT INTO city (id, name, info) VALUES (1, 'Mogilew', 'Mogilew info');
INSERT INTO city (id, name, info) VALUES (2, 'Moscow', 'Capital of Russia');
INSERT INTO city (id, name, info) VALUES (3, 'Minsk', 'Capital of Belarus');
INSERT INTO city (id, name, info) VALUES (4, 'Grodno', 'Grodno info');
INSERT INTO city (id, name, info) VALUES (5, 'Brest', 'Brest info');
SELECT pg_catalog.setval('public.city_id_seq', 5);