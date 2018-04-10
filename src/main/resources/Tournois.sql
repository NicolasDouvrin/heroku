CREATE TABLE tournoi (
  idTournoi INT NOT NULL AUTO_INCREMENT,
  nbInscrits INT NOT NULL,
  nbPlaces INT NOT NULL,
  type VARCHAR(15) NOT NULL,
  PRIMARY KEY (idTournoi)
);
/*
CREATE TABLE participe (
  emailInscrit VARCHAR(42) NOT NULL,
  idTournoiInscrit INT NOT NULL,
  PRIMARY KEY (emailInscrit,idTournoiInscrit)
)*/
