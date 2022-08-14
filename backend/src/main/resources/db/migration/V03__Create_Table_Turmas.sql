CREATE TABLE `tb_turmas` (
  `id_turma` bigint NOT NULL AUTO_INCREMENT,
  `data_inicio` date NOT NULL,
  `data_termino` date NOT NULL,
  `horario` varchar(50) DEFAULT NULL,
  `status_turma` int NOT NULL,
  `tipo_turma` int NOT NULL,
  `id_curso` bigint DEFAULT NULL,
  PRIMARY KEY (`id_turma`),
  KEY `FKo2ka5fibex646kv8gy55qn38m` (`id_curso`),
  CONSTRAINT `FKo2ka5fibex646kv8gy55qn38m` FOREIGN KEY (`id_curso`) REFERENCES `tb_cursos` (`id_curso`)
)