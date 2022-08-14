CREATE TABLE `tb_alunos` (
  `id_pessoa` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `cv_linkedin` varchar(100) DEFAULT NULL,
  `data_nascimento` date NOT NULL,
  `nomesocial` varchar(35) DEFAULT NULL,
  `sobrenome` varchar(100) DEFAULT NULL,
  `tipo_pcd` int NOT NULL,
  PRIMARY KEY (`id_pessoa`)
)