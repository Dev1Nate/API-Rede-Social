# 🛠️ API - Rede Social

Uma API REST desenvolvida em **Java com Spring Boot** para gerenciamento de **usuários e posts**, inspirada no curso do professor **Nélio Alves**.

---

## 📚 Tecnologias utilizadas

- Java 24+
- Spring Boot
- Spring Data JPA / MongoDB
- Maven

---

## ⚙️ Instalação e execução

### Pré-requisitos
- Java SDK instalado  
- Maven instalado  
- MongoDB em execução (ou banco configurado no `application.properties`)

### Passos
```bash
# Clone o repositório
git clone https://github.com/Dev1Nate/API-Rede-Social.git

cd API-Rede-Social

# Instale as dependências
mvn clean install

# Rode a aplicação
mvn spring-boot:run
```

A aplicação sobe por padrão em:  
👉 `http://localhost:8080`

---

## 🔗 Endpoints disponíveis

### 📥 Métodos `GET`

- `GET /users`  
  Retorna **todos os usuários** cadastrados no banco de dados.

- `GET /users/{id}`  
  Retorna o **usuário com o ID especificado**.

- `GET /users/{id}/posts`  
  Retorna **todos os posts** de um usuário específico.

- `GET /posts/{id}`  
  Retorna o **post com o ID especificado**.

- `GET /posts/titlesearch?text=valor`  
  Retorna os **posts que contêm o texto** especificado no título.

- `GET /posts/fullsearch?text=valor&minDate=yyyy-MM-dd&maxDate=yyyy-MM-dd`  
  Retorna os **posts filtrados por texto e intervalo de datas**.

---

### ➕ Métodos `POST`

- `POST /users`  
  Insere **um novo usuário** no banco de dados.

---

### ✏️ Métodos `PUT`

- `PUT /users/{id}`  
  Atualiza os **atributos** do usuário com o ID informado.

---

### 🗑️ Métodos `DELETE`

- `DELETE /users/{id}`  
  Deleta o usuário com o ID especificado.

---
