CREATE TABLE `tb_empresas` (
  `id_pessoa` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `cnpj` varchar(18) DEFAULT NULL,
  `sobre_instituicao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_pessoa`)
)