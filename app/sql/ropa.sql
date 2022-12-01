-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ropadb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ropadb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ropadb` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci ;
USE `ropadb` ;

-- -----------------------------------------------------
-- Table `ropadb`.`ropa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ropadb`.`ropa` (
  `codropa` VARCHAR(10) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `talla` VARCHAR(45) NOT NULL,
  `color` VARCHAR(45) NOT NULL,
  `preciov` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`codropa`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
