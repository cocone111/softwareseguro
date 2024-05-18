-- Creación de la base de datos
CREATE DATABASE gestion_personal;

-- Uso de la base de datos
\c gestion_personal;

-- Creación de la tabla de Funcionarios
CREATE TABLE Funcionarios (
    tipo_identificacion VARCHAR(10) NOT NULL,
    numero_identificacion VARCHAR(20) PRIMARY KEY,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    estado_civil VARCHAR(20),
    sexo CHAR(1),
    direccion VARCHAR(200),
    telefono VARCHAR(20),
    fecha_nacimiento DATE
);

-- Creación de la tabla Grupo Familiar
CREATE TABLE Grupo_Familiar (
    id_grupo_familiar SERIAL PRIMARY KEY,
    id_funcionario VARCHAR(20) REFERENCES Funcionarios(numero_identificacion),
    nombre VARCHAR(100) NOT NULL,
    parentesco VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE
);

-- Creación de la tabla Formación Académica
CREATE TABLE Formacion_Academica (
    id_formacion SERIAL PRIMARY KEY,
    id_funcionario VARCHAR(20) REFERENCES Funcionarios(numero_identificacion),
    universidad VARCHAR(100),
    nivel_estudio VARCHAR(50),
    titulo VARCHAR(100)
);

