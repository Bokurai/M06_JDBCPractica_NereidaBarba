BEGIN;

-- Crear la tabla Temas
CREATE TABLE IF NOT EXISTS temas (
    nombre_tema VARCHAR(255) PRIMARY KEY
);

-- Crear la tabla Libros
CREATE TABLE IF NOT EXISTS libros (
    id SERIAL PRIMARY KEY,
    id_tema VARCHAR(255) REFERENCES temas(id_tema),
    titulo VARCHAR(255),
    autor VARCHAR(255),
    titulo_resumen VARCHAR(255),
    resumen TEXT
);

COMMIT;


    
