CREATE TABLE `articles` (
  `idArticle` INT NOT NULL AUTO_INCREMENT,
  `titre` VARCHAR(42) NOT NULL,
  `image` VARCHAR(42) NOT NULL,
  `texte` VARCHAR(42) NOT NULL,
  `emailAdmin` VARCHAR(42) NOT NULL,
  PRIMARY KEY (`idArticle`)
)
