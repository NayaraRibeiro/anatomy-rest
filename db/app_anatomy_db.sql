-- MySQL Script generated by MySQL Workbench
-- Dom 05 Mar 2017 10:42:13 BRT
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema app_anatomy
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema app_anatomy
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `app_anatomy` DEFAULT CHARACTER SET utf8 ;
USE `app_anatomy` ;

-- -----------------------------------------------------
-- Table `app_anatomy`.`theme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `app_anatomy`.`theme` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `app_anatomy`.`sub_theme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `app_anatomy`.`sub_theme` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `theme_id` INT NOT NULL,
  PRIMARY KEY (`id`, `theme_id`),
  INDEX `fk_sub_theme_theme_idx` (`theme_id` ASC),
  CONSTRAINT `fk_sub_theme_theme`
    FOREIGN KEY (`theme_id`)
    REFERENCES `app_anatomy`.`theme` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `app_anatomy`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `app_anatomy`.`question` (
  `id` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `sub_theme_id` INT NOT NULL,
  `sub_theme_theme_id` INT NOT NULL,
  PRIMARY KEY (`id`, `sub_theme_id`, `sub_theme_theme_id`),
  INDEX `fk_question_sub_theme1_idx` (`sub_theme_id` ASC, `sub_theme_theme_id` ASC),
  CONSTRAINT `fk_question_sub_theme1`
    FOREIGN KEY (`sub_theme_id` , `sub_theme_theme_id`)
    REFERENCES `app_anatomy`.`sub_theme` (`id` , `theme_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `app_anatomy`.`answer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `app_anatomy`.`answer` (
  `id` INT NOT NULL,
  `answer` VARCHAR(45) NOT NULL,
  `question_id` INT NOT NULL,
  PRIMARY KEY (`id`, `question_id`),
  INDEX `fk_answer_question1_idx` (`question_id` ASC),
  CONSTRAINT `fk_answer_question1`
    FOREIGN KEY (`question_id`)
    REFERENCES `app_anatomy`.`question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `app_anatomy`.`player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `app_anatomy`.`player` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `app_anatomy`.`player_score`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `app_anatomy`.`player_score` (
  `player_id` INT NOT NULL,
  `question_id` INT NOT NULL,
  `question_sub_theme_id` INT NOT NULL,
  `question_sub_theme_theme_id` INT NOT NULL,
  PRIMARY KEY (`player_id`, `question_id`, `question_sub_theme_id`, `question_sub_theme_theme_id`),
  INDEX `fk_player_has_question_question1_idx` (`question_id` ASC, `question_sub_theme_id` ASC, `question_sub_theme_theme_id` ASC),
  INDEX `fk_player_has_question_player1_idx` (`player_id` ASC),
  CONSTRAINT `fk_player_has_question_player1`
    FOREIGN KEY (`player_id`)
    REFERENCES `app_anatomy`.`player` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_player_has_question_question1`
    FOREIGN KEY (`question_id` , `question_sub_theme_id` , `question_sub_theme_theme_id`)
    REFERENCES `app_anatomy`.`question` (`id` , `sub_theme_id` , `sub_theme_theme_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
