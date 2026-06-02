
-- 1. Crear el esquema si no existe (Equivalente al usuario DBADMIN en Oracle)
CREATE SCHEMA IF NOT EXISTS sic;

-- 2. Crear la secuencia para el autoincremental
CREATE SEQUENCE IF NOT EXISTS sic.seq_formularios
    START WITH 1
    INCREMENT BY 1;

-- 3. Crear la tabla
CREATE TABLE sic.formularios
(
    -- Usamos BIGINT para el ID.
    -- 'DEFAULT' con la secuencia asegura que funcione igual que en Oracle.
    codigoformulario      BIGINT NOT NULL DEFAULT nextval('sic.seq_formularios'),
    codigotipoformulario  VARCHAR(5) NOT NULL,
    paterno               VARCHAR(20),
    materno               VARCHAR(20),
    nombres               VARCHAR(200),
    codigoproceso         VARCHAR(22),
    responsablecreacion   VARCHAR(30),
    fechacreacion         TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    gestion               VARCHAR(4),
    estado                VARCHAR(10) NOT NULL,

    -- Definición de la llave primaria
    CONSTRAINT xpkformularios PRIMARY KEY (codigoformulario)
);

-- 4. Crear el índice adicional (Postgres gestiona los PCTFREE y STORAGE automáticamente)
CREATE INDEX idx_codigoprocesopruebaprueba
ON sic.formularios (codigoproceso);

-- 5. Comentarios (Opcional, para documentación)
COMMENT ON TABLE sic.formularios IS 'Tabla de formularios de prueba migrada de Oracle';

