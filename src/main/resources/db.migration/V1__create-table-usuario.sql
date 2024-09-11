CREATE TABLE usuario{
    id CHAR(36) PRIMARY KEY UUID(),
    nome_completo VARCHAR(150) NOT NULL,
    email VARCHAR(250) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    tipo INT NOT NULL,
    created_at DATETIME() NOT NULL,
    updated_at DATETIME() NOT NULL
}