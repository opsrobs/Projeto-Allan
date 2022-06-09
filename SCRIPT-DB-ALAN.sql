-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema controle_horas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema controle_horas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `controle_horas` DEFAULT CHARACTER SET utf8 ;
USE `controle_horas` ;

-- -----------------------------------------------------
-- Table `controle_horas`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controle_horas`.`endereco` (
  `idEndereco` INT NOT NULL AUTO_INCREMENT,
  `cep` VARCHAR(45) NULL DEFAULT NULL,
  `estado` VARCHAR(45) NULL DEFAULT NULL,
  `cidade` VARCHAR(45) NULL DEFAULT NULL,
  `bairro` VARCHAR(45) NULL DEFAULT NULL,
  `rua` VARCHAR(45) NULL DEFAULT NULL,
  `numero` VARCHAR(45) NULL DEFAULT NULL,
  `complemento` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idEndereco`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `controle_horas`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controle_horas`.`funcionario` (
  `cod_funcionaio` INT NOT NULL AUTO_INCREMENT,
  `nome_Funcionario` VARCHAR(45) NOT NULL,
  `CPF` VARCHAR(15) NOT NULL,
  `Rg` VARCHAR(15) NOT NULL,
  `genero` VARCHAR(10) NOT NULL,
  `valor_Hora` FLOAT NOT NULL,
  `data_nasc` VARCHAR(20) NOT NULL,
  `status` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`cod_funcionaio`))
ENGINE = InnoDB
AUTO_INCREMENT = 62
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `controle_horas`.`lancamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controle_horas`.`lancamento` (
  `id_Controle` INT NOT NULL AUTO_INCREMENT,
  `hora_trabalhada` FLOAT NOT NULL,
  `mes` INT NOT NULL,
  `ano` INT NOT NULL,
  `funcionario_cod_funcionaio` INT NOT NULL,
  PRIMARY KEY (`id_Controle`),
  INDEX `fk_lancamento_funcionario_idx` (`funcionario_cod_funcionaio` ASC) VISIBLE,
  CONSTRAINT `fk_lancamento_funcionario`
    FOREIGN KEY (`funcionario_cod_funcionaio`)
    REFERENCES `controle_horas`.`funcionario` (`cod_funcionaio`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `controle_horas`.`pessoa_masculino`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controle_horas`.`pessoa_masculino` (
  `idpessoa_masculino` INT NOT NULL AUTO_INCREMENT,
  `nome_Funcionario` VARCHAR(45) NULL DEFAULT NULL,
  `cpf` VARCHAR(14) NULL DEFAULT NULL,
  `data_inclusao` DATE NULL DEFAULT NULL,
  `data_alteracao` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`idpessoa_masculino`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

USE `controle_horas` ;

-- -----------------------------------------------------
-- Placeholder table for view `controle_horas`.`getquerybyano`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controle_horas`.`getquerybyano` (`cod_funcionaio` INT, `nome_Funcionario` INT, `horas_trabalhadas` INT, `hora_trabalhada` INT, `mes` INT, `ano` INT, `valor_Hora` INT, `total_mes` INT, `status` INT);

-- -----------------------------------------------------
-- Placeholder table for view `controle_horas`.`gettabelabyhorasomada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controle_horas`.`gettabelabyhorasomada` (`nome_Funcionario` INT, `horas_trabalhadas` INT, `hora_trabalhada` INT, `mes` INT, `valor_Hora` INT, `total_mes` INT, `status` INT);

-- -----------------------------------------------------
-- Placeholder table for view `controle_horas`.`gettabelabyquery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `controle_horas`.`gettabelabyquery` (`nome_Funcionario` INT, `horas_trabalhadas` INT, `hora_trabalhada` INT, `mes` INT, `valor_Hora` INT, `total_mes` INT, `status` INT);

-- -----------------------------------------------------
-- View `controle_horas`.`getquerybyano`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `controle_horas`.`getquerybyano`;
USE `controle_horas`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `controle_horas`.`getquerybyano` AS select `controle_horas`.`funcionario`.`cod_funcionaio` AS `cod_funcionaio`,`controle_horas`.`funcionario`.`nome_Funcionario` AS `nome_Funcionario`,sum(`controle_horas`.`lancamento`.`hora_trabalhada`) AS `horas_trabalhadas`,`controle_horas`.`lancamento`.`hora_trabalhada` AS `hora_trabalhada`,`controle_horas`.`lancamento`.`mes` AS `mes`,`controle_horas`.`lancamento`.`ano` AS `ano`,`controle_horas`.`funcionario`.`valor_Hora` AS `valor_Hora`,(sum(`controle_horas`.`lancamento`.`hora_trabalhada`) * `controle_horas`.`funcionario`.`valor_Hora`) AS `total_mes`,`controle_horas`.`funcionario`.`status` AS `status` from (`controle_horas`.`lancamento` join `controle_horas`.`funcionario`) where (`controle_horas`.`funcionario`.`cod_funcionaio` = `controle_horas`.`lancamento`.`funcionario_cod_funcionaio`) group by `controle_horas`.`lancamento`.`mes`,`controle_horas`.`funcionario`.`nome_Funcionario` order by `controle_horas`.`lancamento`.`mes`;

-- -----------------------------------------------------
-- View `controle_horas`.`gettabelabyhorasomada`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `controle_horas`.`gettabelabyhorasomada`;
USE `controle_horas`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `controle_horas`.`gettabelabyhorasomada` AS select `controle_horas`.`funcionario`.`nome_Funcionario` AS `nome_Funcionario`,sum(`controle_horas`.`lancamento`.`hora_trabalhada`) AS `horas_trabalhadas`,`controle_horas`.`lancamento`.`hora_trabalhada` AS `hora_trabalhada`,`controle_horas`.`lancamento`.`mes` AS `mes`,`controle_horas`.`funcionario`.`valor_Hora` AS `valor_Hora`,(sum(`controle_horas`.`lancamento`.`hora_trabalhada`) * `controle_horas`.`funcionario`.`valor_Hora`) AS `total_mes`,`controle_horas`.`funcionario`.`status` AS `status` from (`controle_horas`.`lancamento` join `controle_horas`.`funcionario`) where (`controle_horas`.`funcionario`.`cod_funcionaio` = `controle_horas`.`lancamento`.`funcionario_cod_funcionaio`) group by `controle_horas`.`lancamento`.`mes` order by `controle_horas`.`lancamento`.`mes`;

-- -----------------------------------------------------
-- View `controle_horas`.`gettabelabyquery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `controle_horas`.`gettabelabyquery`;
USE `controle_horas`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `controle_horas`.`gettabelabyquery` AS select `controle_horas`.`funcionario`.`nome_Funcionario` AS `nome_Funcionario`,sum(`controle_horas`.`lancamento`.`hora_trabalhada`) AS `horas_trabalhadas`,`controle_horas`.`lancamento`.`hora_trabalhada` AS `hora_trabalhada`,`controle_horas`.`lancamento`.`mes` AS `mes`,`controle_horas`.`funcionario`.`valor_Hora` AS `valor_Hora`,(sum(`controle_horas`.`lancamento`.`hora_trabalhada`) * `controle_horas`.`funcionario`.`valor_Hora`) AS `total_mes`,`controle_horas`.`funcionario`.`status` AS `status` from (`controle_horas`.`lancamento` join `controle_horas`.`funcionario`) where (`controle_horas`.`funcionario`.`cod_funcionaio` = `controle_horas`.`lancamento`.`funcionario_cod_funcionaio`) group by `controle_horas`.`lancamento`.`mes`,`controle_horas`.`funcionario`.`nome_Funcionario` order by `controle_horas`.`lancamento`.`mes`;
USE `controle_horas`;

DELIMITER $$
USE `controle_horas`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `controle_horas`.`funcionario_AFTER_INSERT`
AFTER INSERT ON `controle_horas`.`funcionario`
FOR EACH ROW
BEGIN
if new.genero = 'Masculino' then
insert into genero_pessoa.pessoa_masculino(idpessoa_masculino, nome_funcionario, cpf, data_inclusao)
 values(new.cod_funcionaio, new.nome_funcionario, new.cpf, now());
else
insert into genero_pessoa.pessoa_feminino(idpessoa_feminino, nome_funcionario, cpf, data_inclusao)
 values(new.cod_funcionaio, new.nome_funcionario, new.cpf, now());
end if;
END$$

USE `controle_horas`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `controle_horas`.`funcionario_BEFORE_UPDATE`
BEFORE UPDATE ON `controle_horas`.`funcionario`
FOR EACH ROW
BEGIN
if new.genero = 'Masculino' then
UPDATE genero_pessoa.pessoa_masculino set
    nome_funcionario = new.nome_funcionario,
    cpf = new.cpf,
    data_alteracao = now()
    where idpessoa_masculino = old.cod_funcionaio;
else
update genero_pessoa.pessoa_feminino set
    nome_funcionario =new.nome_funcionario,
	cpf= new.cpf,
    data_alteracao = now()
    where idpessoa_feminino = old.cod_funcionaio;
end if;
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
