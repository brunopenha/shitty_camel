CREATE DATABASE demo;

USE demo;

CREATE TABLE `atendimento` (
  `idatendimento` int(11) NOT NULL,
  `idpaciente` int(11) DEFAULT NULL,
  `idmedico` int(11) DEFAULT NULL,
  `idunidhospitalar` int(11) DEFAULT NULL,
  `tipoatendimento` varchar(45) DEFAULT NULL,
  `dataatendimento` timestamp NULL DEFAULT NULL,
  `dataatualizacao` timestamp default CURRENT_TIMESTAMP NOT NULL,
  INDEX `modified_index` (`dataatualizacao`),
  PRIMARY KEY (`idatendimento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `prescricao` (
  `idprescricao` int(11) NOT NULL,
  `idpaciente` int(11) DEFAULT NULL,
  `idmedico` int(11) DEFAULT NULL,
  `idatendimento` int(11) DEFAULT NULL,
  `tipoprescricao` varchar(80) DEFAULT NULL,
  `idresultado` int(11) DEFAULT NULL,
  `dataprescricao` timestamp NULL DEFAULT NULL,
  `dataatualizacao` timestamp default CURRENT_TIMESTAMP NOT NULL,
  INDEX `modified_index` (`dataatualizacao`),
  PRIMARY KEY (`idprescricao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `resultado` (
  `idresultado` int(11) NOT NULL,
  `idprescricao` int(11) DEFAULT NULL,
  `idmedico_solicitante` int(11) DEFAULT NULL,
  `idmedico_laudo` int(11) DEFAULT NULL,
  `idatendimento` int(11) DEFAULT NULL,
  `dataresultado` timestamp NULL DEFAULT NULL,
  `dataatualizacao` timestamp default CURRENT_TIMESTAMP NOT NULL,
  INDEX `modified_index` (`dataatualizacao`),
  PRIMARY KEY (`idresultado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `mdm_medico` (
  `idmedico` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `sobrenome` varchar(45) DEFAULT NULL,
  `dataatualizacao` timestamp default CURRENT_TIMESTAMP NOT NULL,
  INDEX `modified_index` (`dataatualizacao`),
  PRIMARY KEY (`idmedico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `mdm_paciente` (
  `idpaciente` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `sobrenome` varchar(45) DEFAULT NULL,
  `dataatualizacao` timestamp default CURRENT_TIMESTAMP NOT NULL,
  INDEX `modified_index` (`dataatualizacao`),
  PRIMARY KEY (`idpaciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-----------------------------------------------------------------------------------------------------------------------
# ATENDIMENTO

INSERT INTO atendimento (idatendimento, idpaciente, idmedico, idunidhospitalar, tipoatendimento, dataatendimento)
VALUES (1, 1, 2, 15, 'Emergencia', '2008-01-01 00:00:01');

INSERT INTO atendimento (idatendimento, idpaciente, idmedico, idunidhospitalar, tipoatendimento, dataatendimento)
VALUES (2, 1, 4, 15, 'Externo', '2020-07-03 16:45:41');

INSERT INTO atendimento (idatendimento, idpaciente, idmedico, idunidhospitalar, tipoatendimento, dataatendimento)
VALUES (3, 2, 1, 15, 'Emergencia', '2020-07-04 01:35:22');

INSERT INTO atendimento (idatendimento, idpaciente, idmedico, idunidhospitalar, tipoatendimento, dataatendimento)
VALUES (4, 2, 3, 15, 'Ambulatorial', '2020-07-03 20:01:43');

INSERT INTO atendimento (idatendimento, idpaciente, idmedico, idunidhospitalar, tipoatendimento, dataatendimento)
VALUES (5, 2, 1, 10, 'Externo', '2020-07-03 20:02:43');

INSERT INTO atendimento (idatendimento, idpaciente, idmedico, idunidhospitalar, tipoatendimento, dataatendimento)
VALUES (6, 1, 2, 15, 'Externo', '2020-07-03 22:42:01');


-----------------------------------------------------------------------------------------------------------------------
# PRESCRICAO

INSERT INTO prescricao (idprescricao, idpaciente, idmedico, idatendimento, tipoprescricao, idresultado, dataprescricao)
VALUES (1,1,2,1,'Exame',null,'2020-07-03 20:01:43');

INSERT INTO prescricao (idprescricao, idpaciente, idmedico, idatendimento, tipoprescricao, idresultado, dataprescricao)
VALUES (2,1,4,2,'Exame',null,'2020-07-03 20:34:19');

INSERT INTO prescricao (idprescricao, idpaciente, idmedico, idatendimento, tipoprescricao, idresultado, dataprescricao)
VALUES (156,2,1,3,'Exame',null,'2020-07-03 16:45:41');

INSERT INTO prescricao (idprescricao, idpaciente, idmedico, idatendimento, tipoprescricao, idresultado, dataprescricao)
VALUES (251,2,1,4,'Exame',null,'2020-07-03 22:08:39');

-----------------------------------------------------------------------------------------------------------------------
# PACIENTE

INSERT INTO mdm_paciente (idpaciente, nome, sobrenome)
VALUES (1, 'Higor', 'Grilo');

INSERT INTO mdm_paciente (idpaciente, nome, sobrenome)
VALUES (2, 'Luiz Inácio', 'Silva');

INSERT INTO mdm_paciente (idpaciente, nome, sobrenome)
VALUES (3, 'Dilma', 'Roussef');

INSERT INTO mdm_paciente (idpaciente, nome, sobrenome)
VALUES (4, 'Michel', 'Temer');

-----------------------------------------------------------------------------------------------------------------------
# RESULTADO

INSERT INTO resultado (idresultado, idprescricao, idmedico_solicitante, idmedico_laudo, idatendimento, dataresultado)
VALUES (1, 1, 2, 10, 1, '2020-07-04 01:35:22');

INSERT INTO resultado (idresultado, idprescricao, idmedico_solicitante, idmedico_laudo, idatendimento, dataresultado)
VALUES (2, 2, 4, 10, 2, '2020-07-04 01:35:22');

INSERT INTO resultado (idresultado, idprescricao, idmedico_solicitante, idmedico_laudo, idatendimento, dataresultado)
VALUES (1, 1, 2, 10, 1, '2020-07-04 01:35:22');

INSERT INTO resultado (idresultado, idprescricao, idmedico_solicitante, idmedico_laudo, idatendimento, dataresultado)
VALUES (1, 1, 2, 10, 1, '2020-07-04 01:35:22');
