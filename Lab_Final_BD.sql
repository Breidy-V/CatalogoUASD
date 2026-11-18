
-- Creamos y usamos la base de datos para el proyecto
CREATE DATABASE CatalogoUASD;
USE CatalogoUASD;

-- Creamos las tablas que ultilizaremos 
CREATE TABLE Facultades (
    Facultadid INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL
);

CREATE TABLE Escuelas (
    Escuelaid INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Facultadid INT NOT NULL,
    FOREIGN KEY (Facultadid) REFERENCES Facultades(Facultadid)
);

CREATE TABLE Carreras (
    Carreraid INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(150) NOT NULL,
    Escuelaid INT NOT NULL,
    FOREIGN KEY (Escuelaid) REFERENCES Escuelas(Escuelaid)
);

-- Insertamos los datos a cada tabla

-- Insertamos las Facultades que son 9
USE CatalogoUASD;
INSERT INTO Facultades (Nombre) VALUES
('Facultad de Humanidades'),
('Facultad de Ciencias'),
('Facultad de Ciencias Económicas y Sociales'),
('Facultad de Ciencias Jurídicas y Políticas'),
('Facultad de Ingeniería y Arquitectura'),
('Facultad de Ciencias de la Salud'),
('Facultad de Ciencias Agronómicas y Veterinarias'),
('Facultad de Artes'),
('Facultad de Ciencias de la Educación');


-- Insertamos las escuelas de cada facultad
-- Facultad de Artes
INSERT INTO Escuelas (Nombre, Facultadid) VALUES
('Escuela de Artes Plásticas', 3),
('Escuela de Cine, TV y Fotografía', 3),
('Escuela de Crítica e Historia del Arte', 3),
('Escuela de Diseño Industrial y Modas', 3),
('Escuela de Música', 3),
('Escuela de Publicidad', 3),
('Escuela de Teatro', 3);

-- Facultad de Ciencias
INSERT INTO Escuelas (Nombre, Facultadid) VALUES
('Escuela de Biología', 7),
('Escuela de Ciencias Geográficas', 7),
('Escuela de Física', 7),
('Escuela de Informática', 7),
('Escuela de Matemática', 7),
('Escuela de Microbiología y Parasitología', 7),
('Escuela de Química', 7);

-- Facultad de Ciencias Económicas y Sociales
INSERT INTO Escuelas (Nombre, Facultadid) VALUES
('Escuela de Administración', 2),
('Escuela de Contabilidad', 2),
('Escuela de Economía', 2),
('Escuela de Estadística', 2),
('Escuela de Mercadotecnia', 2),
('Escuela de Sociología', 2),
('Escuela de Turismo y Hotelería', 2);

-- Facultad de Ciencias Jurídicas y Políticas
INSERT INTO Escuelas (Nombre, Facultadid) VALUES
('Escuela de Ciencias Políticas', 5),
('Escuela de Derecho', 5);

-- Facultad de Ciencias de la Educación
INSERT INTO Escuelas (Nombre, Facultadid) VALUES
('Escuela de Bibliotecología, Tecnología e Innovación', 9),
('Escuela de Educación Física y Ciencias del Deporte', 9),
('Escuela de Educación Infantil y Básica', 9),
('Escuela de Educación Media', 9),
('Escuela de Orientación Educativa y Psicopedagogía', 9),
('Escuela de Teoría y Gestión Educativa', 9);

-- Facultad de Ciencias de la Salud
INSERT INTO Escuelas (Nombre, Facultadid) VALUES
('Escuela de Bioanálisis', 4),
('Escuela de Enfermería', 4),
('Escuela de Farmacia', 4),
('Escuela de Medicina', 4),
('Escuela de Odontología', 4),
('Escuela de Salud Pública', 4);

-- Facultad de Ciencias Agronómicas y Veterinarias
INSERT INTO Escuelas (Nombre, Facultadid) VALUES
('Escuela de Agronomía', 8),
('Escuela de Veterinaria', 8),
('Escuela de Zootecnia', 8);

-- Facultad de Humanidades
INSERT INTO Escuelas (Nombre, Facultadid) VALUES
('Escuela de Comunicación Social', 6),
('Escuela de Filosofía', 6),
('Escuela de Historia y Antropología', 6),
('Escuela de Idiomas', 6),
('Escuela de Letras', 6),
('Escuela de Psicología', 6);

-- Facultad de Ingeniería y Arquitectura
INSERT INTO Escuelas (Nombre, Facultadid) VALUES
('Escuela de Agrimensura', 1),
('Escuela de Arquitectura', 1),
('Escuela de Electromecánica', 1),
('Escuela de Ingeniería Civil', 1),
('Escuela de Ingeniería Industrial', 1),
('Escuela de Ingeniería Química', 1);


-- Insertamos las carreras a las escuelas de la Faculta de Artes
INSERT INTO Carreras (Nombre, Escuelaid) VALUES
('Licenciatura en Artes Plásticas', 1),
('Artes Plásticas, mención Escultura', 1),
('Artes Plásticas, mención Pintura', 1),

('Cinematografía y Audiovisuales, mención Cine', 2),
('Cinematografía y Audiovisuales, mención Televisión', 2),
('Técnico en Fotografía y Medios Audiovisuales', 2),

('Historia y Crítica del Arte', 3),

('Artes Industriales, mención Diseño Artesanal', 4),
('Artes Industriales, mención Diseño Industrial', 4),
('Artes Industriales, mención Diseño de Modas', 4),

('Música', 5),
('Música, mención Teoría y Educación Musical', 5),

('Publicidad, mención Diseño', 6),
('Publicidad, mención Ilustración', 6),
('Publicidad, mención Creatividad y Gerencia', 6),

('Teatro', 7),
('Teatro, mención Actuación', 7),
('Teatro, mención Dirección', 7),
('Teatro, mención Dramaturgia', 7);

-- Insertamos las carreras a las escuelas de la Facultad de Ciencias
INSERT INTO Carreras (Nombre, Escuelaid) VALUES
('Licenciatura en Biología', 8),

('Geografía', 9),
('Geografía, mención Recursos Naturales y Ecoturismo', 9),
('Geografía, mención Representación Espacial', 9),

('Licenciatura en Física', 10),

('Licenciatura en Informática', 11),

('Licenciatura en Matemáticas', 12),

('Licenciatura en Microbiología', 13),

('Licenciatura en Química', 14),
('Tecnólogo Superior en Alimentos', 14);

-- Insertamos las carreras a las escuelas de la Facultad de Ciencias Economicas y sociales
INSERT INTO Carreras (Nombre, Escuelaid) VALUES
('Administración de Empresas', 15),
('Administración Pública', 15),

('Contabilidad', 16),

('Aduanas y Comercio Exterior', 17),
('Economía', 17),

('Estadística, mención Informática', 18),
('Estadística, mención Socioeconómica', 18),

('Mercadotecnia', 19),

('Sociología', 20),
('Trabajo Social', 20),

('Turismo y Hotelería', 21);

-- Insertamos las carreras a las escuelas de la Facultad de Ciencias Juridicas y politicas
INSERT INTO Carreras (Nombre, Escuelaid) VALUES
('Licenciatura en Ciencias Políticas', 22),
('Licenciatura en Derecho', 23);

-- Insertamos las carreras a las escuelas de la Facultad de Ciencias de la Educación
INSERT INTO Carreras (Nombre, Escuelaid) VALUES
('Bibliotecología y Ciencias de la Información', 24),
('Educación, mención Bibliotecología', 24),
('Educación, mención Informática Educativa', 24),

('Educación Física', 25),
('Educación Física y Deporte', 25),

('Educación Básica', 26),
('Educación Infantil', 26),
('Educación Inicial', 26),
('Educación, mención Arte Escolar', 26),

('Educación, mención Filosofía y Letras', 27),
('Educación Media, mención Biología y Química', 27),
('Educación Media, mención Ciencias Sociales', 27),
('Educación Media, mención Física y Matemáticas', 27),
('Educación Media, mención Francés', 27),
('Educación Media, mención Inglés', 27),
('Educación Media, mención Letras', 27),

('Educación Especial', 28),
('Educación, mención Orientación Académica', 28),
('Educación, mención Orientación Socio-Comunitaria', 28),
('Educación, mención Orientación para el Desarrollo de Recursos Humanos', 28),
('Educación, mención Orientación Psicopedagógica', 28),

('Educación, mención Gestión Educativa', 29),
('Educación para Personas Jóvenes y Adultas', 29);

-- Insertar las carreras a las escuelas de la Facultad de Ciencias de la Salud
INSERT INTO Carreras (Nombre, Escuelaid) VALUES
('Licenciatura en Bioanálisis', 30),
('Licenciatura en Imagenología', 30),
('Técnico Radiólogo', 30),

('Licenciatura en Enfermería', 31),

('Licenciatura en Farmacia', 32),

('Doctor en Medicina', 33),
('Premédica', 33),

('Doctor en Odontología', 34),

('Técnico Superior en Atención Prehospitalaria', 35);

-- Insertamos las carreras a las escuelas de la Facultad de Agronomicas y veterinarias
INSERT INTO Carreras (Nombre, Escuelaid) VALUES
('Ingeniería Agronómica, mención Desarrollo Agrícola', 36),
('Ingeniería Agronómica, mención Producción de Cultivos', 36),
('Ingeniería Agronómica, mención Suelo y Riego', 36),

('Licenciatura en Medicina Veterinaria', 37),

('Ingeniería Lácteo Alimentaria', 38),
('Ingeniería en Zootecnia', 38),
('Tecnología en Procesos Lácteo Alimentarios', 38);

-- Insertar las carreras a las escuelas de la Facultad de Humanidades
INSERT INTO Carreras (Nombre, Escuelaid) VALUES
('Comunicación Social, mención Comunicación Gráfica', 39),
('Comunicación Social, mención Periodismo', 39),
('Comunicación Social, mención Relaciones Públicas', 39),

('Licenciatura en Filosofía', 40),

('Licenciatura en Antropología', 41),
('Licenciatura en Historia', 41),

('Lenguas Modernas, mención Francés', 42),
('Lenguas Modernas, mención Inglés', 42),

('Licenciatura en Letras', 43),

('Psicología, mención Psicología del Desarrollo Humano', 44),
('Psicología, mención Psicología Clínica', 44),
('Psicología, mención Psicología Escolar', 44),
('Psicología, mención Psicología Industrial', 44),
('Psicología, mención Psicología Social', 44);

-- Insertamos las carreras a las escuelas de la Facultad de Ingenieria y Arquitectura 
INSERT INTO Carreras (Nombre, Escuelaid) VALUES
('Agrimensura', 45),
('Ingeniería Geomática', 45),
('Licenciatura en Agrimensura', 45),
('Técnico Superior en Agrimensura', 45),

('Arquitectura', 46),

('Ingeniería Electromecánica, mención Eléctrica', 47),
('Ingeniería Electromecánica, mención Mecánica', 47),
('Ingeniería Electromecánica, mención Electrónica', 47),
('Ingeniería en Mecatrónica', 47),

('Ingeniería Civil', 48),

('Ingeniería Industrial', 49),

('Ingeniería Química', 50);