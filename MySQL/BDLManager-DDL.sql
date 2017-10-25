-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bdlmanager
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bdlmanager
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdlmanager` DEFAULT CHARACTER SET utf8 ;
USE `bdlmanager` ;

-- -----------------------------------------------------
-- Table `bdlmanager`.`administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdlmanager`.`administrador` (
  `id` VARCHAR(255) NOT NULL,
  `contrasenia` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdlmanager`.`aula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdlmanager`.`aula` (
  `DTYPE` VARCHAR(31) NOT NULL,
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `capacidad` INT(11) NOT NULL,
  `habilitado` BIT(1) NOT NULL,
  `nombreAula` VARCHAR(255) NULL DEFAULT NULL,
  `piso` INT(11) NOT NULL,
  `tipoPizarron` VARCHAR(255) NULL DEFAULT NULL,
  `aireAcondicionado` BIT(1) NULL DEFAULT NULL,
  `canion` BIT(1) NULL DEFAULT NULL,
  `cantidadPcs` INT(11) NULL DEFAULT NULL,
  `computadora` BIT(1) NULL DEFAULT NULL,
  `dvd` BIT(1) NULL DEFAULT NULL,
  `televisor` BIT(1) NULL DEFAULT NULL,
  `tipoClimatizacion` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdlmanager`.`bedel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdlmanager`.`bedel` (
  `id` VARCHAR(255) NOT NULL,
  `apellido` VARCHAR(255) NULL DEFAULT NULL,
  `contrasenia` VARCHAR(255) NULL DEFAULT NULL,
  `eliminado` BIT(1) NOT NULL,
  `nombre` VARCHAR(255) NULL DEFAULT NULL,
  `turno` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdlmanager`.`contraseniaanterioradministrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdlmanager`.`contraseniaanterioradministrador` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `contrasenia` VARCHAR(255) NULL DEFAULT NULL,
  `idAdministradorFK` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_a4xa5i2dip4jxqhjgfyiofkwv` (`idAdministradorFK` ASC),
  CONSTRAINT `FK_a4xa5i2dip4jxqhjgfyiofkwv`
    FOREIGN KEY (`idAdministradorFK`)
    REFERENCES `bdlmanager`.`administrador` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdlmanager`.`contraseniaanteriorbedel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdlmanager`.`contraseniaanteriorbedel` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `contrasenia` VARCHAR(255) NULL DEFAULT NULL,
  `idBedelFK` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_mwcno93n4p6d74s8agu8ro24j` (`idBedelFK` ASC),
  CONSTRAINT `FK_mwcno93n4p6d74s8agu8ro24j`
    FOREIGN KEY (`idBedelFK`)
    REFERENCES `bdlmanager`.`bedel` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdlmanager`.`cuatrimestre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdlmanager`.`cuatrimestre` (
  `cicloLectivo` INT(11) NOT NULL,
  `fechaInicio` DATETIME NOT NULL,
  `fechaFin` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`cicloLectivo`, `fechaInicio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdlmanager`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdlmanager`.`curso` (
  `id` INT(11) NOT NULL,
  `nombreCurso` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdlmanager`.`docente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdlmanager`.`docente` (
  `dni` INT(11) NOT NULL,
  `mail` VARCHAR(255) NULL DEFAULT NULL,
  `nombreYApellido` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`dni`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdlmanager`.`reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdlmanager`.`reserva` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cantidadAlumnos` INT(11) NOT NULL,
  `esPeriodica` BIT(1) NOT NULL,
  `idBedelFK` VARCHAR(255) NULL DEFAULT NULL,
  `idCursoFK` INT(11) NULL DEFAULT NULL,
  `dniDocenteFK` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_eyclk0el6q6jculahb3yyr9ex` (`idBedelFK` ASC),
  INDEX `FK_dbipufwmnyu64jo00lyuny05h` (`idCursoFK` ASC),
  INDEX `FK_e29blhp8htacao7en0npte17m` (`dniDocenteFK` ASC),
  CONSTRAINT `FK_dbipufwmnyu64jo00lyuny05h`
    FOREIGN KEY (`idCursoFK`)
    REFERENCES `bdlmanager`.`curso` (`id`),
  CONSTRAINT `FK_e29blhp8htacao7en0npte17m`
    FOREIGN KEY (`dniDocenteFK`)
    REFERENCES `bdlmanager`.`docente` (`dni`),
  CONSTRAINT `FK_eyclk0el6q6jculahb3yyr9ex`
    FOREIGN KEY (`idBedelFK`)
    REFERENCES `bdlmanager`.`bedel` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdlmanager`.`diareserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdlmanager`.`diareserva` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NULL DEFAULT NULL,
  `horaFin` TIME NULL DEFAULT NULL,
  `horaInicio` TIME NULL DEFAULT NULL,
  `idAulaFK` INT(11) NULL DEFAULT NULL,
  `idReservaFK` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_52tmba3hc668n0mpk0ov328t7` (`idAulaFK` ASC),
  INDEX `FK_2cgr6bnwx3gky8glsybg1mxus` (`idReservaFK` ASC),
  CONSTRAINT `FK_2cgr6bnwx3gky8glsybg1mxus`
    FOREIGN KEY (`idReservaFK`)
    REFERENCES `bdlmanager`.`reserva` (`id`),
  CONSTRAINT `FK_52tmba3hc668n0mpk0ov328t7`
    FOREIGN KEY (`idAulaFK`)
    REFERENCES `bdlmanager`.`aula` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdlmanager`.`politicaseguridad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdlmanager`.`politicaseguridad` (
  `id` INT(11) NOT NULL,
  `debeEspecial` BIT(1) NOT NULL,
  `debeUnNumero` BIT(1) NOT NULL,
  `debeUnaMayus` BIT(1) NOT NULL,
  `longitudMinima` INT(11) NOT NULL,
  `puedeRepetirse` BIT(1) NOT NULL,
  `vigente` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
