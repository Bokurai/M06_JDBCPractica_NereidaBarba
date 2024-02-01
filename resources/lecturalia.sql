BEGIN;

-- Crear la tabla Temas
CREATE TABLE IF NOT EXISTS Temas (
    nombre_tema VARCHAR(255) PRIMARY KEY
);

-- Crear la tabla Libros
CREATE TABLE IF NOT EXISTS Libros (
    id SERIAL PRIMARY KEY,
    tema_id VARCHAR(255),
    titulo VARCHAR(255),
    autor VARCHAR(255),
    titulo_resumen VARCHAR(255),
    resumen TEXT,
    FOREIGN KEY (tema_id) REFERENCES Temas(nombre_tema)
);

COMMIT;


    
