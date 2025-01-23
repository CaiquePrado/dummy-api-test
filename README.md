# Dummyjson-api-test

Este é um projeto que utiliza Rest-Assured e TestNg para testar a API dummyjson. Ele é destinado para a criação de uma suíte de testes automatizados para validar os endpoints da API.

## Documentação de Testes

Aqui estão alguns links para a documentação de teste do projeto:

- **[Planejamento de Testes](./TestPlan.md)**

- **[Cenários de testes](./TestScenarios.md)**

- **[Evidências](./Bugs.md)**

## Pré-requisitos

Certifique-se de ter os seguintes pré-requisitos instalados antes de começar:

- **Java 17**: Certifique-se de ter o JDK 17 instalado em sua máquina. Você pode baixá-lo e instalá-lo a partir do site oficial da Oracle ou de outras fontes confiáveis.

- **Gradle**: Este projeto utiliza o Gradle como sistema de build. Certifique-se de ter o Gradle instalado em sua máquina. Você pode instalá-lo seguindo as instruções disponíveis no site oficial do Gradle.

- **IDE de sua preferência**: Recomenda-se o uso de uma IDE para desenvolvimento Java, como IntelliJ IDEA, VsCode, Eclipse ou Spring Tools Suite (STS).

- **Allure**: Este projeto utiliza Allure para gerar relatórios de testes. Certifique-se de ter o Allure instalado em sua máquina. Siga as instruções abaixo para instalar o Allure:

  1. Abra o PowerShell como administrador e execute o seguinte comando para alterar a política de execução:
     ```
     Set-ExecutionPolicy RemoteSigned -Scope CurrentUser
     ```
  2. Pressione `s` para confirmar a alteração.
  3. Em seguida, instale o Scoop (um instalador de linha de comando) com o seguinte comando:
     ```
     irm get.scoop.sh | iex
     ```
  4. Por fim, instale o Allure com o comando:
     ```
     scoop install allure
     ```

## Executando os testes

Para executar os testes, você pode usar o comando `gradle test` no terminal. Os resultados dos testes serão salvos no diretório `allure-results`. Este diretório contém vários arquivos JSON que representam os resultados dos testes.

## Visualizando o relatório de testes

Depois de executar os testes, uma pasta chamada `allure-results` será gerada. Para visualizar o relatório de testes, você pode usar o seguinte comando no terminal:

```bash
allure serve
```

# Tecnologias Usadas

Este projeto utiliza várias tecnologias e bibliotecas:

- **Spring Boot**
- **TestNG**
- **Lombok**
- **Rest-Assured**
- **Allure**
- **Datafaker**
- **Hamcrest**

# Débitos Técnicos e Melhorias Futuras

- **Refatorar Arquivo AuthProductsTest.java**: Atualmente, há repetição na chamada do token em vários testes. Isso pode ser otimizado para evitar redundância e tornar o código mais limpo e eficiente.

- **Adicionar testes de carga e desempenho com JMeter**: Para garantir que o sistema possa lidar com um grande número de usuários simultâneos, planejamos adicionar testes de carga e desempenho usando JMeter.

- **Testes de regressão**: Quando as melhorias passadas pelo time de qualidade forem implementadas, planejamos realizar testes de regressão para garantir que as funcionalidades existentes não foram afetadas negativamente pelas novas alterações.

- **Pipeline**: Adicionar pipeline corretamente
