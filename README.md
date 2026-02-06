# GestorVendas
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

> Projeto acadêmico desenvolvido como parte do **TCC**, com foco em **aprendizado prático de desenvolvimento back-end**.
> O sistema simula um **controle de vendas e estoque** para pequenos comerciantes,
> aplicando conceitos fundamentais de **Java, Spring Boot, JPA e banco de dados relacional**.

---

## Funcionalidades

* 📦 **Cadastro e Controle de Produtos**: gerenciamento de produtos e quantidade em estoque.
* 🧾 **Registro de Vendas**: criação de vendas com múltiplos itens.
* 🔄 **Atualização Automática de Estoque**: o estoque é ajustado conforme as vendas realizadas.
* 🗂️ **Persistência com JPA**: mapeamento das entidades e relacionamentos no banco de dados.
* 🧱 **Arquitetura em Camadas**: separação entre controller, regras de negócio e repositórios.
* 🐳 **Banco de Dados em Docker**: ambiente local simples e reproduzível.

---

## 🚀 Tecnologias Utilizadas
| Ferramenta | Descrição |
| :--- | :--- |
| **Java** | Linguagem principal utilizada no projeto. |
| **Spring Boot** | Framework para criação de aplicações Java com configuração simplificada. |
| **Spring Data JPA** | Persistência de dados e operações CRUD. |
| **Hibernate** | Implementação JPA para mapeamento objeto-relacional. |
| **PostgreSQL** | Banco de dados relacional para armazenamento dos dados. |
| **Lombok** | Redução de código repetitivo (getters, setters, construtores). |
| **Docker / Docker Compose** | Execução do banco de dados em ambiente isolado. |

---

## 🧠 Arquitetura do Projeto

O projeto foi estruturado de forma simples e organizada, seguindo boas práticas:
1. **Model (Entidades)**  
   Representa as classes do domínio, como Produto, Venda, ItemVenda e Usuário.

2. **Repository**  
   Responsável pelo acesso ao banco de dados utilizando Spring Data JPA.

3. **Use Cases**  
   Implementa as regras de negócio principais, como o registro de vendas.

4. **Controller**  
   Camada de entrada preparada para integração com front-end ou consumo via API.

Essa estrutura facilita o entendimento do código e a evolução do projeto.

---

## 🎯 Objetivo do Projeto

> Este projeto tem como objetivo demonstrar conhecimento prático em desenvolvimento back-end com Java e Spring Boot, incluindo:

* Modelagem de domínio
* Persistência com JPA
* Arquitetura de software
* Boas práticas aplicadas a um sistema realista

Serve como base sólida para expansão em uma API REST completa ou integração com um front-end desacoplado.
