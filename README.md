# AutoService System

Sistema de gerenciamento para oficinar mecânicas e rtíficas, desenvolvido em Java como foco em organização de clientes, veículos e Ordens de Serviço.

O projeto foi criado com o objetivo de praticar conceitode Programação Orientada a Objetos (POO) CRUD, relacionamento entre classes e lógica de sistemas reais.

---

## Funcionalidades

### CLientes
- Cadastro de clientes
- Listagem de clientes
- Busca de clientes por ID
- Edição de clientes por ID
- Exclusão de clientes

### Ordens de Serviço (O.S.)
- Croação de Ordens de serviço
- VInculação da O.S. ao veículo
- Listagem de veículos
- Edição de Veículos
- Exclusão de veículos

### ORdens de Serviço (O.S.)
- Criação de Ordens de serviço
- Vinculação da O.S. ao veículo
- Identificação automática do cliente através do veículo
- Seleção de categorias de serviço
- Status inicial da O.S. como "Aberta"
- Listagem de Ordens de Serviço

  ---

## Estrutura do Sistema

O sistema funciona utilizando relacionamento entre objetos:
```bash
cliente
↓
Veículo
↓
Ordem de Serviço
```

### Relacionamentos
- Um cliente pode possuir vários veículos
- Um cliente pertence a apenas um cliente
- Um veículo pode possuir várias Ordens de Serviço


---

## Tecnologias Utilizadas
- Java
- IntelliJ IDEA
- Git
- Github
- Porgramação Orientada a Objetos (POO)


---

## COnceitos aplicados no Porjeto

Durante o desenvolvimento do sistema foram utilizados conceitos como:

- Classes e objetos
- ArrayList
- Estrutura de repetição
- Estrutura condicionais
- Relacionamento entre classes
- Encadeamento de objetos
- Validação de dados
- Organização de fluxo de sistema

---

## Exemplo

```bash
========== MENU ==========

1 - Cadastrar Cliente
2 - Listar Clientes
3 - Buscar Cliente
4 - Editar CLiente
5 - Excluir Cliente

6 - Cadastrar Veículo
7 - Listar Veículo
8 - Editar Veículo
9 - Excluir Veículo

10 - Exibir menu de serviços
11 - Listar Ordens de Serviço
12 - Sair
```

---

## Estrutura atual do projeto

```bash
src/
├── Main.java
├── Cliente.java
├── Veiculo.java
└── OrdemServico.java
```

---

## Melhorias futuras

### Persistência e dados
- Persistência de dados em arquivo
- Integração com banco de dados
- Interface gráfica
- Integração com notificações

### Segurança e controle 
- Sistema de autenticação de usuários
- Controle de permissões por funcionários

### Funcionalidades da Oficina
- Cadastro de ordens de serviço
- Integração com notificações
- Geração automática de QR code Pix
- Envio de cobranças via WhatsApp

### Interface e usabilidade
- Interface gráfica
- Melhorias na experiência do usuário

---

## Objetivo do Projeto

Este projeto faz parte dos meus estudos em desenvolvimento backend com Java, buscando aplicar lógica de programação e modelagem de sistemas reais.

---

## Autor

Patrick Pepineli













