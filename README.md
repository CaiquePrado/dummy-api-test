Sicredi-api-test
Este é um projeto que utiliza Rest-Assured e TestNg para testar uma API da sicredi. Ele é destinado para a criação de uma suíte de testes automatizados para validar os endpoints da API.

Documentação de Testes
Aqui estão alguns links para a documentação de teste do projeto:


Planejamento de Testes


Cenários de testes


Evidências



Pré-requisitos
Certifique-se de ter os seguintes pré-requisitos instalados antes de começar:


Java 17: Certifique-se de ter o JDK 17 instalado em sua máquina. Você pode baixá-lo e instalá-lo a partir do site oficial da Oracle ou de outras fontes confiáveis.


Gradle: Este projeto utiliza o Gradle como sistema de build. Certifique-se de ter o Gradle instalado em sua máquina. Você pode instalá-lo seguindo as instruções disponíveis no site oficial do Gradle.


IDE de sua preferência: Recomenda-se o uso de uma IDE para desenvolvimento Java, como IntelliJ IDEA, VsCode, Eclipse ou Spring Tools Suite (STS).


Allure: Este projeto utiliza Allure para gerar relatórios de testes. Certifique-se de ter o Allure instalado em sua máquina. Siga as instruções abaixo para instalar o Allure:

Abra o PowerShell como administrador e execute o seguinte comando para alterar a política de execução:

Set-ExecutionPolicy RemoteSigned -Scope CurrentUser



Pressione s para confirmar a alteração.
Em seguida, instale o Scoop (um instalador de linha de comando) com o seguinte comando:

irm get.scoop.sh | iex



Por fim, instale o Allure com o comando:

scoop install allure







Executando os testes
Para executar os testes, você pode usar o comando gradle test no terminal. Os resultados dos testes serão salvos no diretório allure-results. Este diretório contém vários arquivos JSON que representam os resultados dos testes.

Visualizando o relatório de testes
Depois de executar os testes, uma pasta chamada allure-results será gerada. Para visualizar o relatório de testes, você pode usar o seguinte comando no terminal:

allure serve



Tecnologias Usadas
Este projeto utiliza várias tecnologias e bibliotecas:

Spring Boot
TestNG
Lombok
Rest-Assured
Allure
Datafaker
Hamcrest
