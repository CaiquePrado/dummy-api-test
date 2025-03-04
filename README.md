# Dummyjson-api-test

Este é um projeto que utiliza Rest-Assured e TestNg para testar a API dummyjson. Ele é destinado para a criação de uma
suíte de testes automatizados para validar os endpoints da API.

## Documentação de Testes

Aqui estão alguns links para a documentação de teste do projeto:

- **[Planejamento de Testes](./TestPlan.md)**

- **[Cenários de testes](./TestScenarios.md)**

## Pré-requisitos

Certifique-se de ter os seguintes pré-requisitos instalados antes de começar:

- **Java 21**: Certifique-se de ter o JDK 21 instalado em sua máquina. Você pode baixá-lo e instalá-lo a partir do site
  oficial da Oracle ou de outras fontes confiáveis.

- **Gradle**: Este projeto utiliza o Gradle como sistema de build. Certifique-se de ter o Gradle instalado em sua
  máquina. Você pode instalá-lo seguindo as instruções disponíveis no site oficial do Gradle.

- **IDE de sua preferência**: Recomenda-se o uso de uma IDE para desenvolvimento Java, como IntelliJ IDEA, VsCode ou
  Eclipse.

## Executando e visualizando os testes

Para executar os testes, você pode usar o comando `gradle test` no terminal. Os resultados dos testes serão salvos no
diretório `./test-output/ExtentReport.html

Para visualizar o relatório, basta abrir o arquivo ExtentReport.html no navegador.

## Tecnologias Usadas

Este projeto utiliza várias tecnologias e bibliotecas:

- **TestNG**
- **Lombok**
- **Rest-Assured**
- **Extent Reports**
- **Datafaker**
- **Hamcrest & AssertJ**
- **Log4j**
