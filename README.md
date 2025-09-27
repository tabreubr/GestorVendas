# GestorVendas
Sistema de Gestão de Vendas e Estoque para pequenos comerciantes

# Configurações AWS

## User Data
Inserir código abaixo na User Data de uma instância EC2 da AWS.
````markdown
#!/bin/bash
# Atualiza pacotes
apt-get update -y
apt-get upgrade -y

# Instala Docker e Docker Compose
apt-get install -y docker.io docker-compose
systemctl enable docker
systemctl start docker

# Cria diretório do projeto
mkdir -p /home/ubuntu/gestorvendas
cd /home/ubuntu/gestorvendas

cat <<'EOSQL' > init.sql
-- Criação da tabela produtos
CREATE TABLE produtos (
id SERIAL PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
descricao VARCHAR(255) NOT NULL,
quantidade INT NOT NULL,
preco NUMERIC(10,2) NOT NULL
);

-- Criação da tabela usuarios
CREATE TABLE usuarios (
id SERIAL PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
login VARCHAR(50) NOT NULL UNIQUE,
senha VARCHAR(255) NOT NULL,
perfil VARCHAR(20) NOT NULL
);

-- Criação da tabela vendas
CREATE TABLE vendas (
id SERIAL PRIMARY KEY,
quantidade_vendida INT NOT NULL CHECK (quantidade_vendida >= 1),
data_hora TIMESTAMP NOT NULL,
produto_id INT NOT NULL,
usuario_id INT NOT NULL,
CONSTRAINT fk_produto FOREIGN KEY (produto_id) REFERENCES produtos(id) ON DELETE RESTRICT,
CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE RESTRICT
);
EOSQL

# Cria docker-compose.yml
cat <<EOF > docker-compose.yml

services:
  postgres:
    image: postgres:15
    restart: always
    environment:
      POSTGRES_USER: admin
      POSTGRES_PASSWORD: admin123
      POSTGRES_DB: gestordb
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data
      - ./init.sql:/docker-entrypoint-initdb.d/init.sql

  app:
    image: tabreubr/gestorvendas:1.0
    container_name: gestorvendas_app
    restart: always
    depends_on:
      - postgres
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/gestordb
      SPRING_DATASOURCE_USERNAME: admin
      SPRING_DATASOURCE_PASSWORD: admin123
    ports:
      - "8080:8080"

volumes:
  postgres_data:
EOF

# Sobe todos os containers
docker-compose up -d
````