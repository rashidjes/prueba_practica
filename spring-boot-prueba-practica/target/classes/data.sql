UPDATE prueba_practica.tipo_activo_sequ SET next_val=4 WHERE next_val=1;
INSERT INTO prueba_practica.tipo_activo VALUES (1, 'Bienes Inmuebles');
INSERT INTO prueba_practica.tipo_activo VALUES (2, 'Maquinaria');
INSERT INTO prueba_practica.tipo_activo VALUES (3, 'Material de Oficina');


UPDATE prueba_practica.tipo_asignacion_sequ SET next_val=4 WHERE next_val=1;
INSERT INTO prueba_practica.tipo_asignacion VALUES (1, 'NA');
INSERT INTO prueba_practica.tipo_asignacion VALUES (2, 'Área');
INSERT INTO prueba_practica.tipo_asignacion VALUES (3, 'Persona');

UPDATE prueba_practica.activo_fijo_sequ SET next_val=3 WHERE next_val=1;
INSERT INTO prueba_practica.activo_fijo
	(id_activo, alto, ancho, descripcion, fecha_compra, largo, nombre, numero_interno, peso, serial, valor_compra, id_tipo_activo, id_tipo_asignacion)
VALUES 
	(1, 10, 45, 'Equipo de oficina informática y tecnología', '2021-02-15', 60, 'Computador DELL', 13579, 5, 'S5679AX', 1500000, 3, 1);
INSERT INTO prueba_practica.activo_fijo
	(id_activo, alto, ancho, descripcion, fecha_compra, largo, nombre, numero_interno, peso, serial, valor_compra, id_tipo_activo, id_tipo_asignacion)
VALUES 
	(2, 20, 35, 'Muebles de cafetería y cocina', '2019-06-21', 85, 'Mesa Comedor', 24680, 10, 'M9383K', 500000, 1, 2);
	
UPDATE prueba_practica.area_sequ SET next_val=4 WHERE next_val=1;
INSERT INTO prueba_practica.area VALUES (1, 'Financiera');
INSERT INTO prueba_practica.area VALUES (2, 'Sistemas');
INSERT INTO prueba_practica.area VALUES (3, 'Recursos Humanos');

UPDATE prueba_practica.persona_sequ SET next_val=4 WHERE next_val=1;
INSERT INTO prueba_practica.persona VALUES (1, 'Torres', 80816975, 'Jesús');
INSERT INTO prueba_practica.persona VALUES (2, 'Cortés', 11111111, 'Alberto');
INSERT INTO prueba_practica.persona VALUES (3, 'Serna', 11111111, 'Pilar');

UPDATE prueba_practica.ciudad_sequ SET next_val=4 WHERE next_val=1;
INSERT INTO prueba_practica.ciudad VALUES (1, 'Bogotá');
INSERT INTO prueba_practica.ciudad VALUES (2, 'Cali');
INSERT INTO prueba_practica.ciudad VALUES (3, 'Medellín');


UPDATE prueba_practica.asignacion_persona_sequ SET next_val=2 WHERE next_val=1;
INSERT INTO prueba_practica.asignacion_persona VALUES (1, '2020-09-15', 1, 1);


UPDATE prueba_practica.asignacion_area_sequ SET next_val=2 WHERE next_val=1;
INSERT INTO prueba_practica.asignacion_area VALUES (1, '2018-04-21', 2, 1);