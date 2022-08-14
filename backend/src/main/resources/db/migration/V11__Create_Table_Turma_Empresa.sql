CREATE TABLE `tb_turma_empresa` (
  `id_turma` bigint NOT NULL,
  `id_pessoa` bigint NOT NULL,
  PRIMARY KEY (`id_turma`,`id_pessoa`),
  KEY `FKa1w5pg530v48l0vwjcy1pqtm7` (`id_pessoa`),
  CONSTRAINT `FKa1w5pg530v48l0vwjcy1pqtm7` FOREIGN KEY (`id_pessoa`) REFERENCES `tb_empresas` (`id_pessoa`),
  CONSTRAINT `FKgl0ovfg5eet4llxe9oahtx6xn` FOREIGN KEY (`id_turma`) REFERENCES `tb_turmas` (`id_turma`)
)