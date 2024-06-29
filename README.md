
# TaskAPI_Desafio

O projeto de gerenciamento de tarefas em Java tem como principal objetivo oferecer uma aplicação robusta e intuitiva para cadastro, atualização e exclusão de tarefas. Desenvolvido utilizando conceitos de programação orientada a objetos e padrões de design, o sistema visa proporcionar uma experiência eficiente e organizada para o usuário.

## 📌 Funcionalidades

### Cadastro de Tarefas:
 `http://localhost:8080/tasks`
- Permite ao usuário adicionar novas tarefas especificando título, descrição, data de vencimento, prioridade, e outras informações relevantes.
- Validação de dados para garantir que todas as informações necessárias sejam fornecidas de forma correta.

### Atualização de Tarefas:
`http://localhost:8080/tasks`
- Permite ao usuário modificar informações de tarefas existentes, como alteração de título, descrição, data de vencimento, e prioridade.

### Exclusão de Tarefas:
`http://localhost:8080/tasks/{id}` 
- utilize o numero que corresponde ao ID da task, por exemplo: `http://localhost:8080/tasks/5`
- Possibilidade de remover tarefas que não são mais necessárias ou que foram concluídas.

### Listagem e Visualização:
`http://localhost:8080/tasks`
- Apresentação das tarefas em uma lista organizada por data de vencimento ou prioridade.

### Persistência de Dados:
- Utilização de banco de dados (H2-Console) ou armazenamento em arquivo para persistir as informações das tarefas de forma segura e eficiente.

## 🔑 Acessos

- Para acessar o banco de dados h2-console, utilize:
    - http:localhost:8080/h2-console
    - username: user
    - password: user
- Utilize Postman ou Insominia para fazer as requisções com suas respectivas rotas.

## Autores

- [@Elias](https://www.github.com/EliasBRodrigues)

