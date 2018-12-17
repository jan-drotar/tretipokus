-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema prvodarca
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema prvodarca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `prvodarca` DEFAULT CHARACTER SET utf8 ;
USE `prvodarca` ;

-- -----------------------------------------------------
-- Table `prvodarca`.`physician`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prvodarca`.`physician` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `surname` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `prvodarca`.`participant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prvodarca`.`participant` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` ENUM("DONOR", "RECIPIENT") NOT NULL,
  `bloodType` ENUM("A_POS", "A_NEG", "B_POS", "B_NEG", "AB_POS", "AB_NEG", "O_POS", "O_NEG") NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `surname` VARCHAR(50) NOT NULL,
  `insurandeId` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `dateOfBirth` DATETIME NOT NULL,
  `gender` ENUM("MALE", "FEMALE") NOT NULL,
  `weight` DOUBLE NOT NULL,
  `dateOfLastDonation` DATETIME NOT NULL,
  `countOfDonations` INT NOT NULL,
  `message` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `prvodarca`.`donation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prvodarca`.`donation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `donationType` ENUM("WHOLE_BLOOD", "PLASMA") NOT NULL,
  `idRecipient` INT NOT NULL,
  `idDonor` INT NOT NULL,
  `idPhysician` INT NOT NULL,
  `tested` TINYINT NOT NULL,
  `approved` TINYINT NOT NULL,
  `registered` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_donor_id_idx` (`idDonor` ASC) VISIBLE,
  INDEX `fk_pacient_id_idx` (`idRecipient` ASC) VISIBLE,
  INDEX `fk_physician_id_idx` (`idPhysician` ASC) VISIBLE,
  CONSTRAINT `fk_donor_id`
    FOREIGN KEY (`idDonor`)
    REFERENCES `prvodarca`.`participant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_recipient_id`
    FOREIGN KEY (`idRecipient`)
    REFERENCES `prvodarca`.`participant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_physician_id`
    FOREIGN KEY (`idPhysician`)
    REFERENCES `prvodarca`.`physician` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `prvodarca`.`notification`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prvodarca`.`notification` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `physicianId` INT NOT NULL,
  `message` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_physician_idx_idx` (`physicianId` ASC) VISIBLE,
  CONSTRAINT `fk_physician_idx`
    FOREIGN KEY (`physicianId`)
    REFERENCES `prvodarca`.`physician` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
