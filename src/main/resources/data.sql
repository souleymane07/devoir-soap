-- Vider les tables pour éviter les conflits d'IDs lors du redémarrage
DELETE FROM classe_entity;
DELETE FROM sector_entity;

-- Réinitialiser les auto-incréments des IDs
ALTER TABLE sector_entity AUTO_INCREMENT = 1;
ALTER TABLE classe_entity AUTO_INCREMENT = 1;

-- Insertion des secteurs
INSERT INTO sector_entity (name) VALUES ('Informatique');
INSERT INTO sector_entity (name) VALUES ('Gestion');
INSERT INTO sector_entity (name) VALUES ('Sciences');

-- Insertion des classes pour le secteur 'Informatique' (ID 1)
INSERT INTO classe_entity (class_name, description, sector_id) VALUES ('L1 Info', 'Première année de Licence en Informatique', 1);
INSERT INTO classe_entity (class_name, description, sector_id) VALUES ('L2 Info', 'Deuxième année de Licence en Informatique', 1);
INSERT INTO classe_entity (class_name, description, sector_id) VALUES ('L3 Info', 'Troisième année de Licence en Informatique', 1);

-- Insertion des classes pour le secteur 'Gestion' (ID 2)
INSERT INTO classe_entity (class_name, description, sector_id) VALUES ('L1 Gestion', 'Première année de Licence en Gestion', 2);
INSERT INTO classe_entity (class_name, description, sector_id) VALUES ('L2 Gestion', 'Deuxième année de Licence en Gestion', 2);

-- Insertion des classes pour le secteur 'Sciences' (ID 3)
INSERT INTO classe_entity (class_name, description, sector_id) VALUES ('L1 Sciences', 'Première année de Licence en Sciences', 3);