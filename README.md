Event Management API
Este projeto é uma API RESTful para o gerenciamento de eventos. Ela permite a criação, atualização, exclusão e visualização de eventos, incluindo detalhes como data, local e descrição dos eventos.

Pré-requisitos
Certifique-se de que os seguintes requisitos estejam instalados em sua máquina:

Docker
Docker Compose (opcional, se for usar um docker-compose.yml)
Tecnologias usadas
Java: Backend da aplicação.
Spring Boot: Framework para facilitar o desenvolvimento RESTful.
MySQL: Banco de dados relacional utilizado.
Docker: Para conteinerizar a aplicação.
Instruções de configuração
1. Clone o repositório
bash
Copiar código
git clone https://github.com/seu-usuario/event-management-api.git
cd event-management-api
2. Crie o arquivo .env (opcional)
Se necessário, crie um arquivo .env para configurar variáveis de ambiente, como as credenciais do banco de dados MySQL:

bash
Copiar código
touch .env
Exemplos de variáveis de ambiente:

makefile
Copiar código
DB_HOST=localhost
DB_PORT=3306
DB_NAME=events_db
DB_USER=root
DB_PASSWORD=password
3. Build e execução com Docker
Execute o seguinte comando para construir a imagem Docker:

bash
Copiar código
docker build -t event-management-api .
Para rodar a aplicação usando Docker:

bash
Copiar código
docker run -d -p 8080:8080 --name event-management-api event-management-api
4. Usando Docker Compose (opcional)
Se você estiver usando docker-compose, certifique-se de que o arquivo docker-compose.yml esteja configurado corretamente:

yaml
Copiar código
version: '3'
services:
  api:
    build: .
    ports:
      - "8080:8080"
    environment:
      DB_HOST: db
      DB_PORT: 3306
      DB_NAME: events_db
      DB_USER: root
      DB_PASSWORD: password
  db:
    image: mysql:8.0
    environment:
      MYSQL_ROOT_PASSWORD: password
      MYSQL_DATABASE: events_db
    ports:
      - "3306:3306"
Para iniciar o projeto com Docker Compose:

bash
Copiar código
docker-compose up -d
5. Acessando a API
A API ficará disponível em http://localhost:8080. Use ferramentas como Postman ou curl para testar os endpoints.

Endpoints Principais
GET /events - Retorna todos os eventos
GET /events/{id} - Retorna um evento específico por ID
POST /events - Cria um novo evento
PUT /events/{id} - Atualiza um evento existente
DELETE /events/{id} - Exclui um evento específico por ID
Licença
Este projeto está licenciado sob a licença MIT. Para mais informações, veja o arquivo LICENSE.
