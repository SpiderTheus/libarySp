# 📚 LibarySp – API de Biblioteca em Spring Boot

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3-green)
![Status](https://img.shields.io/badge/Status-Em%20desenvolvimento-yellow)
![Versão](https://img.shields.io/badge/vers%C3%A3o-0.1-orange)

API em **Java** utilizando o framework **Spring Boot 3** para manipulação de livros de uma biblioteca.  

---

## 📂 Estrutura do Projeto

<img width="982" height="355" alt="gerenciadorLivro-diagrama de entidades drawio" src="https://github.com/user-attachments/assets/cc74c1ec-2ec6-4037-b111-7b0057ff2408" />

Nesta primeira versão foi utilizado o **H2-Console** (banco em memória).  
> 🔮 Em futuras atualizações será integrado um banco de dados persistente (ex: MySQL ou PostgreSQL).  

A entidade **Book** foi a mais desafiadora, por possuir vários relacionamentos.  
- Para facilitar sua criação, foi criada a classe `BookBuilder`.  
- Como o `BookBuilder` precisa dos *services* das entidades relacionadas, foi criada também a classe `BookBuilderFactory`, abstraindo ainda mais a lógica e deixando a construção mais limpa.

<img width="1139" height="627" alt="image" src="https://github.com/user-attachments/assets/0bb09351-ba4a-4fa7-92d0-c796b7b8280d" />

---

## ⚙️ Funcionalidades

<img width="745" height="276" alt="gerenciadorLivro-recursos drawio (2)" src="https://github.com/user-attachments/assets/6baf4944-c33d-4e45-be13-c4e6f3d13433" />

### 🔄 Métodos Padrões (CRUD)
A API implementa o CRUD completo para todas as entidades.  

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| **GET** | `/entities` | Lista todas as entidades |
| **GET** | `/entities/{id}` | Busca uma entidade pelo ID |
| **POST** | `/entities` | Cria uma nova entidade |
| **PUT** | `/entities/{id}` | Atualiza uma entidade existente |
| **DELETE** | `/entities/{id}` | Remove uma entidade existente |

> Toda a lógica de negócio fica na **camada de serviço**, que conversa diretamente com os repositórios.  
> A **camada de recurso** apenas chama os serviços.  

📌 Obs: A entidade **Book** é responsável por inserir a entidade **Loan** no repositório.

---

### 🧩 Métodos Singulares

Além dos métodos CRUD, algumas funcionalidades específicas foram implementadas:

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| **GET** | `/users/{id}/loans` | Retorna os empréstimos atrelados a um usuário |
| **GET** | `/books/{title}` | Busca livros pelo título |
| **POST** | `/books/loan/{bookId}/user/{userId}` | Realiza o empréstimo de um livro, verificando disponibilidade |
| **PUT** | `/returnBook/{loanId}` | Realiza a devolução de um livro |

---

## 🚀 Como Executar

1. Clone o repositório  
   ```bash
   git clone https://github.com/seu-usuario/libarySp.git
Entre na pasta do projeto

  ```bash
cd libarySp
```
Execute a aplicação
  ```bash
./mvnw spring-boot:run
```
Acesse no navegador:
http://localhost:8080

## 🌐 Deploy
A aplicação está disponível em produção pelo Render:
🔗 <a href="libarySphttps://libarysp-deploy.onrender.com">libarySp</a>

⚠️ Obs: Por enquanto não existe página inicial, apenas os endpoints.

👨‍💻 Autor
Matheus Moraes Dias
### Intagram: https://www.instagram.com/spidertheus.java/#
