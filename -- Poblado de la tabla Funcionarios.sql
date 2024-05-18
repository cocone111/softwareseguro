-- Poblado de la tabla Funcionarios
INSERT INTO Funcionarios (tipo_identificacion, numero_identificacion, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento)
VALUES
('CC', '1234567890', 'Juan', 'Perez', 'Soltero', 'M', 'Calle 123', '555-1234', '1980-05-15'),
('CC', '0987654321', 'Maria', 'Gomez', 'Casada', 'F', 'Carrera 456', '555-5678', '1985-10-25');

-- Poblado de la tabla Grupo Familiar
INSERT INTO Grupo_Familiar (id_funcionario, nombre, parentesco, fecha_nacimiento)
VALUES
('1234567890', 'Ana Perez', 'Hija', '2010-06-01'),
('1234567890', 'Carlos Perez', 'Hijo', '2012-09-15'),
('0987654321', 'Jose Ramirez', 'Esposo', '1983-03-10');

-- Poblado de la tabla Formación Académica
INSERT INTO Formacion_Academica (id_funcionario, universidad, nivel_estudio, titulo)
VALUES
('1234567890', 'Universidad Nacional', 'Pregrado', 'Ingeniería de Sistemas'),
('0987654321', 'Universidad de Antioquia', 'Maestría', 'Administración de Empresas');
