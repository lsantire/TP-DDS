INSERT INTO bdlmanager.administrador VALUES('admin','argentina');

INSERT INTO bdlmanager.politicaseguridad VALUES (1,false,true,true,6,false,true);
INSERT INTO bdlmanager.politicaseguridad VALUES (2,true,false,false,4,false,false);
INSERT INTO bdlmanager.politicaseguridad VALUES (3,false,false,true,8,true,false);

INSERT INTO bdlmanager.docente (dni, mail, `nombreYApellido`) VALUES (11, 'luisbianculli@hotmail.com', 'Bianculli Luis');
INSERT INTO bdlmanager.docente (dni, mail, `nombreYApellido`) VALUES (22, 'pablokler@hotmail.com', 'Kler Pablo');
INSERT INTO bdlmanager.docente (dni, mail, `nombreYApellido`) VALUES (33, 'fabiodlugo@hotmail.com', 'Dlugovitzky Fabio');
INSERT INTO bdlmanager.docente (dni, mail, `nombreYApellido`) VALUES (44, 'dkr2@hotmail.com', 'Beltramino Jose Maria');
INSERT INTO bdlmanager.docente (dni, mail, `nombreYApellido`) VALUES (55, 'malvaAlbrt@hotmail.com', 'Alberto Malva');
INSERT INTO bdlmanager.docente (dni, mail, `nombreYApellido`) VALUES (66, 'tbraca@hotmail.com', 'Bracalenti Tomas');
INSERT INTO bdlmanager.docente (dni, mail, `nombreYApellido`) VALUES (77, 'cjbraca@hotmail.com', 'Bracalenti Claudio');
INSERT INTO bdlmanager.docente (dni, mail, `nombreYApellido`) VALUES (88, 'sgonnet@hotmail.com', 'Gonnet Silvio');
INSERT INTO bdlmanager.docente (dni, mail, `nombreYApellido`) VALUES (99, 'leone_ee@hotmail.com', 'Leone Horacio');
INSERT INTO bdlmanager.docente (dni, mail, `nombreYApellido`) VALUES (1010, 'aldo-vec@hotmail.com', 'Vecchietti Aldo');
INSERT INTO bdlmanager.docente (dni, mail, `nombreYApellido`) VALUES (1111, 'gnero_cari@hotmail.com', 'Gnero Carina');
INSERT INTO bdlmanager.docente (dni, mail, `nombreYApellido`) VALUES (1212, 'nabla_17@hotmail.com', 'Murchio Santiago');
INSERT INTO bdlmanager.docente (dni, mail, `nombreYApellido`) VALUES (1313, 'torresanp@hotmail.com', 'Torresan Patricia');
INSERT INTO bdlmanager.docente (dni, mail, `nombreYApellido`) VALUES (1414, 'mcastellaro1@hotmail.com', 'Castellaro Marta');
INSERT INTO bdlmanager.docente (dni, mail, `nombreYApellido`) VALUES (1515, 'canaves@hotmail.com', 'Canavesio Mercedes');
INSERT INTO bdlmanager.docente (dni, mail, `nombreYApellido`) VALUES (1616, 'chevalier_a@hotmail.com', 'Chevallier Alicia');
INSERT INTO bdlmanager.docente (dni, mail, `nombreYApellido`) VALUES (1717, 'roldsus@hotmail.com', 'Roldan Susana');

INSERT INTO bdlmanager.curso (id, `nombreCurso`) VALUES (1, 'Matematica Superior');
INSERT INTO bdlmanager.curso (id, `nombreCurso`) VALUES (2, 'Algebra y Geometria Analitica');
INSERT INTO bdlmanager.curso (id, `nombreCurso`) VALUES (3, 'Arquitectura de Computadoras');
INSERT INTO bdlmanager.curso (id, `nombreCurso`) VALUES (4, 'Comunicaciones');
INSERT INTO bdlmanager.curso (id, `nombreCurso`) VALUES (5, 'Diseño de Sistemas');
INSERT INTO bdlmanager.curso (id, `nombreCurso`) VALUES (6, 'Analisis de Sistemas');
INSERT INTO bdlmanager.curso (id, `nombreCurso`) VALUES (7, 'Paradigmas de Programacion');
INSERT INTO bdlmanager.curso (id, `nombreCurso`) VALUES (8, 'Gestion de Datos');
INSERT INTO bdlmanager.curso (id, `nombreCurso`) VALUES (9, 'Fisica I');
INSERT INTO bdlmanager.curso (id, `nombreCurso`) VALUES (10, 'Fisica II');
INSERT INTO bdlmanager.curso (id, `nombreCurso`) VALUES (11, 'Sistemas Operativos');
INSERT INTO bdlmanager.curso (id, `nombreCurso`) VALUES (12, 'Redes');
INSERT INTO bdlmanager.curso (id, `nombreCurso`) VALUES (13, 'Diseño y Estructura de Datos');
INSERT INTO bdlmanager.curso (id, `nombreCurso`) VALUES (14, 'Algoritmos y Estructuras de Datos');
INSERT INTO bdlmanager.curso (id, `nombreCurso`) VALUES (15, 'Sistemas y Organizaciones');

INSERT INTO bdlmanager.cuatrimestre (`cicloLectivo`, `fechaInicio`, `fechaFin`) VALUES (2016, '2016-03-04 00:00:00.000', '2016-07-05 23:59:59.999');
INSERT INTO bdlmanager.cuatrimestre (`cicloLectivo`, `fechaInicio`, `fechaFin`) VALUES (2016, '2016-08-09 00:00:00.000', '2016-11-30 23:59:59.999');
INSERT INTO bdlmanager.cuatrimestre (`cicloLectivo`, `fechaInicio`, `fechaFin`) VALUES (2017, '2017-02-28 00:00:00.000', '2017-07-01 23:59:59.999');
INSERT INTO bdlmanager.cuatrimestre (`cicloLectivo`, `fechaInicio`, `fechaFin`) VALUES (2017, '2017-08-02 00:00:00.000', '2017-12-29 23:59:59.999');
INSERT INTO bdlmanager.cuatrimestre (`cicloLectivo`, `fechaInicio`, `fechaFin`) VALUES (2018, '2018-03-15 00:00:00.000', '2018-07-12 23:59:59.999');
INSERT INTO bdlmanager.cuatrimestre (`cicloLectivo`, `fechaInicio`, `fechaFin`) VALUES (2018, '2018-08-15 00:00:00.000', '2018-12-06 23:59:59.999');

INSERT INTO bdlmanager.aula (`id`,`DTYPE`,`capacidad`,`habilitado`,`nombreAula`,`piso`,`tipoPizarron`,`aireAcondicionado`,`canion`,`cantidadPcs`) VALUES (1,'AulaInformatica',30, true, 'Lab 1', 3, 'A fibrón', true, true, 15);
INSERT INTO bdlmanager.aula (`id`,`DTYPE`,`capacidad`,`habilitado`,`nombreAula`,`piso`,`tipoPizarron`,`aireAcondicionado`,`canion`,`cantidadPcs`) VALUES (2,'AulaInformatica',35, true, 'Lab 2', 3, 'A tiza', true, false, 15);
INSERT INTO bdlmanager.aula (`id`,`DTYPE`,`capacidad`,`habilitado`,`nombreAula`,`piso`,`tipoPizarron`,`aireAcondicionado`,`canion`,`cantidadPcs`) VALUES (3,'AulaInformatica',42, true, 'Lab 3', 3, 'A tiza', true, false, 15);
INSERT INTO bdlmanager.aula (`id`,`DTYPE`,`capacidad`,`habilitado`,`nombreAula`,`piso`,`tipoPizarron`,`aireAcondicionado`,`canion`,`cantidadPcs`) VALUES (4,'AulaInformatica',25, true, 'Lab 4', 3, 'A fibrón', false, true, 15);
INSERT INTO bdlmanager.aula (`id`,`DTYPE`,`capacidad`,`habilitado`,`nombreAula`,`piso`,`tipoPizarron`,`aireAcondicionado`,`canion`,`cantidadPcs`) VALUES (5,'AulaInformatica',50, true, 'Lab 5', 3, 'A fibrón', true, true, 15);

INSERT INTO bdlmanager.aula (`id`,`DTYPE`,`capacidad`,`habilitado`,`nombreAula`,`piso`,`tipoPizarron`,`aireAcondicionado`,`canion`,`computadora`,`dvd`,`televisor`) VALUES (6,'AulaMultimedios',40, true, 'MM1', 3, 'A tiza', true, true, true, true, true);
INSERT INTO bdlmanager.aula (`id`,`DTYPE`,`capacidad`,`habilitado`,`nombreAula`,`piso`,`tipoPizarron`,`aireAcondicionado`,`canion`,`computadora`,`dvd`,`televisor`) VALUES (7,'AulaMultimedios',30, true, 'MM2', 3, 'A fibrón', true, false, true, true, false);
INSERT INTO bdlmanager.aula (`id`,`DTYPE`,`capacidad`,`habilitado`,`nombreAula`,`piso`,`tipoPizarron`,`aireAcondicionado`,`canion`,`computadora`,`dvd`,`televisor`) VALUES (8,'AulaMultimedios',60, true, 'MM3', 3, 'A tiza', false, true, false, false, true);
INSERT INTO bdlmanager.aula (`id`,`DTYPE`,`capacidad`,`habilitado`,`nombreAula`,`piso`,`tipoPizarron`,`aireAcondicionado`,`canion`,`computadora`,`dvd`,`televisor`) VALUES (9,'AulaMultimedios',50, true, 'MM4', 3, 'A fibrón', true, false, false, true, false);
INSERT INTO bdlmanager.aula (`id`,`DTYPE`,`capacidad`,`habilitado`,`nombreAula`,`piso`,`tipoPizarron`,`aireAcondicionado`,`canion`,`computadora`,`dvd`,`televisor`) VALUES (10,'AulaMultimedios',25, true, 'MM5', 3, 'A tiza', true, false, false, true, true);

INSERT INTO bdlmanager.aula (`id`,`DTYPE`,`capacidad`,`habilitado`,`nombreAula`,`piso`,`tipoPizarron`,`tipoClimatizacion`) VALUES (11,'AulaSinRecursos',40, true, 'Aula 1', 1, 'A tiza', 'Aire Acondiconado');
INSERT INTO bdlmanager.aula (`id`,`DTYPE`,`capacidad`,`habilitado`,`nombreAula`,`piso`,`tipoPizarron`,`tipoClimatizacion`) VALUES (12,'AulaSinRecursos',32, true, 'Aula 2', 1, 'A fibrón', 'Sin Climatizacion');
INSERT INTO bdlmanager.aula (`id`,`DTYPE`,`capacidad`,`habilitado`,`nombreAula`,`piso`,`tipoPizarron`,`tipoClimatizacion`) VALUES (13,'AulaSinRecursos',50, true, 'Aula 3', 1, 'A fibrón', 'Ventiladores');
INSERT INTO bdlmanager.aula (`id`,`DTYPE`,`capacidad`,`habilitado`,`nombreAula`,`piso`,`tipoPizarron`,`tipoClimatizacion`) VALUES (14,'AulaSinRecursos',46, true, 'Aula 4', 1, 'A tiza', 'Aire Acondiconado');
INSERT INTO bdlmanager.aula (`id`,`DTYPE`,`capacidad`,`habilitado`,`nombreAula`,`piso`,`tipoPizarron`,`tipoClimatizacion`) VALUES (15,'AulaSinRecursos',38, true, 'Aula 5', 1, 'A fibrón', 'Ventiladores');