# Plano de dummy-api-test

## Visão geral

Garantir que registro de novos produtos, logins e listagens estejam sempre funcionando e caso não estejam, sejam rapidamente identificadas e corrigidas pela equipe de desenvolvedores.

## Funcionalidades

| Funcionalidades               | Comportamento Esperado                                                                                                                                 | Verificações                                                                                                    | Critérios de Aceite                                                                             |
| ----------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------ | --------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| Listagem de usuários          | Ao acessar a rota de listagem de usuários, o sistema deve retornar uma lista com todos os usuários cadastrados.                                        | Verificar se a lista de usuários é retornada corretamente.                                                      | A lista de usuários deve ser exibida corretamente.                                              |
| Listagem de produtos          | Ao acessar a rota de listagem de produtos, o sistema deve retornar uma lista com todos os produtos cadastrados.                                        | Verificar se a lista de produtos é retornada corretamente.                                                      | A lista de produtos deve ser exibida corretamente.                                              |
| Login                         | Ao fornecer um `<username>` e `<password>` válidos, o usuário deve ser capaz de se autenticar no sistema.                                              | Verificar se a autenticação é processada com sucesso. Verificar se um token de autenticação válido é retornado. | O usuário deve ser autenticado com sucesso. Um token de autenticação válido deve ser retornado. |
| Adição de produtos            | Ao fornecer detalhes válidos de um produto (como nome, descrição, preço, etc.), o usuário deve ser capaz de adicionar um novo produto ao sistema.      | Verificar se o produto é adicionado com sucesso.                                                                | O produto deve ser adicionado com sucesso.                                                      |
| Listagem de produtos          | Ao acessar a rota de listagem de produtos, o sistema deve retornar uma lista com todos os produtos cadastrados.                                        | Verificar se a lista de produtos é retornada corretamente.                                                      | A lista de produtos deve ser exibida corretamente.                                              |
| Listagem de produtos por ID   | Ao fornecer um ID de produto válido, o usuário deve ser capaz de visualizar os detalhes do produto correspondente.                                     | Verificar se os detalhes do produto são retornados corretamente.                                                | Os detalhes do produto devem ser exibidos corretamente.                                         |
| Criação de usuário            | Ao fornecer detalhes válidos de um usuário (como nome, email, senha, etc.), o usuário deve ser capaz de criar uma nova conta no sistema.               | Verificar se a conta do usuário é criada com sucesso.                                                           | A conta do usuário deve ser criada com sucesso.                                                 |
| Exclusão de usuário por ID    | Ao fornecer um ID de usuário válido, o usuário deve ser capaz de excluir a conta do usuário correspondente.                                            | Verificar se a conta do usuário é excluída com sucesso.                                                         | A conta do usuário deve ser excluída com sucesso.                                               |
| Atualização de usuário por ID | Ao fornecer um ID de usuário válido e novos detalhes do usuário, o usuário deve ser capaz de atualizar os detalhes da conta do usuário correspondente. | Verificar se os detalhes da conta do usuário são atualizados com sucesso.                                       | Os detalhes da conta do usuário devem ser atualizados com sucesso.                              |
| Criação de produto            | Ao fornecer detalhes válidos de um produto (como nome, descrição, preço, etc.), o usuário deve ser capaz de adicionar um novo produto ao sistema.      | Verificar se o produto é adicionado com sucesso.                                                                | O produto deve ser adicionado com sucesso.                                                      |
| Exclusão de produto por ID    | Ao fornecer um ID de produto válido, o usuário deve ser capaz de excluir o produto correspondente.                                                     | Verificar se o produto é excluído com sucesso.                                                                  | O produto deve ser excluído com sucesso.                                                        |
| Atualização de produto por ID | Ao fornecer um ID de produto válido e novos detalhes do produto, o usuário deve ser capaz de atualizar os detalhes do produto correspondente.          | Verificar se os detalhes do produto são atualizados com sucesso.                                                | Os detalhes do produto devem ser atualizados com sucesso.                                       |

## Estratégia de Teste

### Escopo de Testes

Serão executados testes em todos os níveis conforme a descrição abaixo.

- Testes Unitários: o código terá uma cobertura de 80% de testes unitários, que são de responsabilidade dos desenvolvedores.
- Testes de Integração: Serão executados testes de integração em todos os endpoints, e esses testes serão de responsabilidade do time de desenvolvimento.
- Testes Automatizados de API: Serão realizados testes automatizados de API usando Rest Assured, e esses testes serão de responsabilidade do time de qualidade.
- Testes de Carga e Desempenho: Serão realizados testes de carga e desempenho usando JMeter, e esses testes serão de responsabilidade do time de qualidade.
- Testes Manuais: Todas as funcionalidades serão testadas manualmente pelo time de qualidade seguindo a documentação de Cenários de teste e deste plano de testes.

### Ambiente e Ferramentas

Os testes serão feitos do ambiente de homologação, e contém as mesmas configurações do ambiente de produção com uma massa de dados gerada previamente pelo time de qualidade.

| Ferramenta | Time                        | Descrição                                                      |
| ---------- | --------------------------- | -------------------------------------------------------------- |
| TestNG     | Desenvolvimento / Qualidade | Ferramenta para realização de testes                           |
| Mockito    | Desenvolvimento             | Ferramenta para simular objetos da aplicação                   |
| MockMvc    | Desenvolvimento             | Ferramenta para realização de testes de integração             |
| JMeter     | Qualidade                   | Ferramenta para realizar testes de carga e desempenho          |
| Faker      | Desenvolvimento / Qualidade | Biblioteca para gerar dados falsos para testes                 |
| Allure     | Qualidade                   | Ferramenta para gerar relatórios sobre os resultados de testes |

### Classificação de Bugs

Os Bugs serão classificados com as seguintes severidades:

| ID  | Nivel de Severidade | Descrição                                                                                                                                                        |
| --- | ------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 1   | Blocker             | Bug que bloqueia o teste de uma função ou feature causa crash na aplicação. O Botão não funciona impedindo o uso completo da funcionalidade. Bloqueia a entrega. |
| 2   | Grave               | Funcionalidade não funciona como o esperado. Input incomum causa efeitos irreversíveis                                                                           |
| 3   | Moderada            | Funcionalidade não atinge certos critérios de aceitação, mas sua funcionalidade em geral não é afetada. Mensagem de erro ou sucesso não é exibida                |
| 4   | Pequena             | Quase nenhum impacto na funcionalidade porém atrapalha a experiência. Erro ortográfico. Pequenos erros de UI                                                     |

### Definição de Pronto

Será considerada pronta as funcionalidades que passarem pelas verificações e testes descritas nestes plano de testes, não apresentarem bugs com a severidade acima de Minor, e passarem por uma validação de negócio de responsabilidade do time de produto.
