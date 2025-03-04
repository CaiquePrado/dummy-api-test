## Cenários de Teste

## Caso de Teste 001: Validar Processo de Login na API

### Funcionalidade: Login na API

**Como** um cliente cadastrado,  
**Eu quero** fazer login na minha conta através da API,  
**Para** poder acessar funcionalidades protegidas.

### Cenário 001: Login com sucesso

**Dado** que o usuário tem o username "kminchelle" e a password "0lelplR",  
**Quando** o usuário faz uma requisição POST para a rota "/auth/login" com o username "kminchelle" e a password "
0lelplR",  
**Então** a API deve retornar um status "201 CREATED",  
**E** a API deve retornar um token de autenticação válido.

### Cenário 002: Tentativa de Login com Username e Password Inválidos

**Dado** que o usuário insere um `<username>` e `<password>` inválidos,  
**Quando** o usuário faz uma requisição POST para a rota "/auth/login" com o `<username>` e `<password>`,  
**Então** a API deve retornar um status "400 Bad Request",  
**E** a API deve retornar a mensagem "Invalid credentials".

Exemplos:
| `<username>` | `<password>` |
| --- | --- |
| Caique | minhaSenha |
| PedroLucca | 9986632 |
| AuroraSamara | @$caijuw |

### Cenário 003: Tentativa de login com username inválido

**Dado** que o usuário insere um `<username>` inválido e `<password>` válida,  
**Quando** o usuário faz uma requisição POST para a rota "/auth/login" com o `<username>` e `<password>`,  
**Então** a API deve retornar um status "400 Bad Request",  
**E** a API deve retornar a mensagem "Invalid credentials".

Exemplos:
| `<username>` | `<password>` |
| --- | --- |
| kminchell | 0lelplR |
| kmi | 0lelplR |
| kminche | 0lelplR |

### Cenário 004: Tentativa de login com password inválida

**Dado** que o usuário insere um `<username>` e `<password>` inválida,  
**Quando** o usuário faz uma requisição POST para a rota "/auth/login" com o `<username>` e `<password>`,  
**Então** a API deve retornar um status "400 Bad Request",  
**E** a API deve retornar a mensagem "Invalid credentials".

Exemplos:
| `<username>` | `<password>` |
| --- | --- |
| kminchelle | 0lelpl |
| kminchelle | 0le |
| kminchelle | 0lel |

### Cenário 005: Tentativa de login com campo / campos vazios

**Dado** que o usuário deixa os campos `<username>` e `<password>` vazios,  
**Quando** o usuário faz uma requisição POST para a rota "/auth/login" com o `<username>` e `<password>`,  
**Então** a API deve retornar um status "400 Bad Request",  
**E** a API deve retornar a mensagem "Invalid credentials".

Exemplos:
| `<username>` | `<password>` |
| --- | --- |
| | 0lelplR |
| kminchelle | |
| | |

## Caso de Teste 002: Validar Acesso a rota Produtos autenticados

### Funcionalidade: Acesso a Produtos Autenticados na API

**Como** um usuário autenticado,  
**Eu quero** acessar a rota "/auth/products" através da API,  
**Para** visualizar e interagir com os produtos.

### Cenário 001: Tentativa de Acesso a Produtos com Token Válido

**Dado** que o usuário possui um token de autenticação válido,  
**Quando** o usuário faz uma requisição GET para a rota "/auth/products" com o token válido,  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar a lista de produtos, não vazia.

### Cenário 002: Tentativa de Busca de Produto por ID

**Dado** que o usuário possui um token de autenticação válido,  
**Quando** o usuário faz uma requisição GET para a rota "/auth/products/{id}" com um ID válido de produto,  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar o produto correspondente ao ID especificado.

Exemplos:
| `<id>` |
| --- |
| 1 |
| 10 |
| 100 |

### Cenário 003: Tentativa de Busca de Produto com ID Inválido

**Dado** que o usuário possui um token de autenticação válido,  
**Quando** o usuário faz uma requisição GET para a rota "/auth/products/{id}" com um ID de produto inválido,  
**Então** a API deve retornar um status "404 Not Found",  
**E** a API deve retornar a mensagem "Product not found".

Exemplos:
| `<id>` |
| --- |
| 0 |
| 102 |
| $$@(8) |

### Cenário 004: Pesquisar por produtos com a consulta

**Dado** que o usuário possui um token de autenticação válido,  
**Quando** o usuário faz uma requisição GET para a rota "/auth/products/search?q={query}",  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar uma lista de produtos com tamanho igual a 1.

Exemplos:
| `<query>` |
| --- |
| iphone 9 |
| iphone X |
| Samsung Universe 9 |

### Cenário 006: Obter todas as categorias de produtos

**Dado** que o usuário possui um token de autenticação válido,  
**Quando** o usuário faz uma requisição GET para a rota "/auth/products/{categories}",  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar a lista de todas as categorias de produtos.

Exemplos:
| `<category>` |
| --- |
| smartphones |
| laptops |
| fragrances |
| skincare |
| groceries |
| home-decoration |
| furniture |
| tops |
| womens-dresses |
| womens-shoes |
| mens-shirts |
| mens-shoes |
| mens-watches |
| womens-watches |
| womens-bags |
| womens-jewellery |
| sunglasses |
| automotive |
| motorcycle |
| lighting |

### Cenário 007: Obter produtos na categoria `<category>`

**Dado** que o usuário possui um token de autenticação válido,  
**Quando** o usuário faz uma requisição GET para a rota "/auth/products/category/<category>",  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar uma lista de produtos da categoria `<category>`, não vazia.

Exemplos:
| `<category>` |
| --- |
| smartphones |
| laptops |
| fragrances |
| skincare |
| groceries |
| home-decoration |
| furniture |
| tops |
| womens-dresses |
| womens-shoes |
| mens-shirts |
| mens-shoes |
| mens-watches |
| womens-watches |
| womens-bags |
| womens-jewellery |
| sunglasses |
| automotive |
| motorcycle |
| lighting |

### Cenário 009: Obter produtos com o parâmetro 'skip'

**Dado** que o usuário possui um token de autenticação válido,  
**Quando** o usuário faz uma requisição GET para a rota "/auth/products?skip=<skip>",  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar uma lista de produtos, não vazia.

Exemplos:
| `<skip>` |
| --- |
| 5 |
| 10 |
| 15 |

### Cenário 010: Obter produtos com o parâmetro 'limit'

**Dado** que o usuário possui um token de autenticação válido,  
**Quando** o usuário faz uma requisição GET para a rota "/auth/products?limit=<limit>",  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar uma lista de produtos, não vazia.

Exemplos:
| `<limit>` |
| --- |
| 10 |
| 20 |
| 30 |

### Cenário 011: Obter produtos com os parâmetros 'skip' e 'limit'

**Dado** que o usuário possui um token de autenticação válido,  
**Quando** o usuário faz uma requisição GET para a rota "/auth/products?skip=<skip>&limit=<limit>",  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar uma lista de produtos, não vazia.

Exemplos:
| `<skip>` | `<limit>` |
| --- | --- |
| 5 | 10 |
| 10 | 20 |
| 15 | 30 |

### Cenário 012: Tentativa de obter produtos com o parâmetro 'skip' inválido

**Dado** que o usuário possui um token de autenticação válido,  
**Quando** o usuário faz uma requisição GET para a rota "/auth/products?skip=<skip>",  
**Então** a API deve retornar um status "400 Bad Request",  
**E** a API deve retornar a mensagem "Invalid skip parameter".

Exemplos:
| `<skip>` |
| --- |
| $$$ |
| --8 |
| !0 |

### Cenário 013: Tentativa de obter produtos com o parâmetro 'limit' inválido

**Dado** que o usuário possui um token de autenticação válido,  
**Quando** o usuário faz uma requisição GET para a rota "/auth/products?limit=<limit>",  
**Então** a API deve retornar um status "400 Bad Request",  
**E** a API deve retornar a mensagem "Invalid limit parameter".

Exemplos:
| `<limit>` |
| --- |
| !d28 |
| --8 |
| 200 |

### Cenário 014: Tentativa de obter produtos com os parâmetros 'skip' e 'limit' inválidos

**Dado** que o usuário possui um token de autenticação válido,  
**Quando** o usuário faz uma requisição GET para a rota "/auth/products?skip=<skip>&limit=<limit>",  
**Então** a API deve retornar um status "400 Bad Request",  
**E** a API deve retornar a mensagem "Invalid limit parameter".

Exemplos:
| `<skip>` | `<limit>` |
| --- | --- |
| $$$ | -!d28 |
| --8 | --8 |
| !0 | !0 |

### Cenário 016: Tentativa de acesso com token expirado

**Dado** que o usuário possui um token de autenticação expirado,  
**Quando** o usuário tenta acessar uma rota protegida da API,  
**Então** a API deve retornar um status "401 Unauthorized",  
**E** a API deve retornar a mensagem "Token de autenticação expirado".

Exemplos:
| Rota |
| --- |
| /auth/products |
| /auth/products?skip=5&limit=10 |
| /auth/products?limit=10 |
| /auth/products?skip=5 |
| /auth/products/category/smartphones |
| /auth/products/categories |
| /auth/products/search?q=iphone 9 |

### Cenário 017: Tentativa de acesso com token inválido

**Dado** que o usuário possui um token de autenticação inválido,  
**Quando** o usuário tenta acessar uma rota protegida da API,  
**Então** a API deve retornar um status "401 Unauthorized",  
**E** a API deve retornar a mensagem "Token de autenticação inválido".

Exemplos:
| Rota |
| --- |
| /auth/products |
| /auth/products?skip=5&limit=10 |
| /auth/products?limit=10 |
| /auth/products?skip=5 |
| /auth/products/category/smartphones |
| /auth/products/categories |
| /auth/products/search?q=iphone 9 |

## Caso de Teste 003: Validar processo de criar produto

### Funcionalidade: Adicionar produto

**Como** um usuário,  
**Eu quero** acessar a rota "/products/add" através da API,  
**Para** cria um novo produto.

### Cenário 001: Criar um produto válido

**Dado** que o usuário possui um token de autenticação válido e um produto válido,  
**Quando** o usuário faz uma requisição POST para a rota "/products/add" com o corpo da requisição contendo o produto
válido,  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar o produto criado.

### Cenário 002: Criar um produto com um atributo de cada vez

**Dado** que o usuário possui um token de autenticação válido e um produto com apenas um atributo preenchido,  
**Quando** o usuário faz uma requisição POST para a rota "/products/add" com o corpo da requisição contendo o produto,  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar o produto criado.

Exemplos:
| `<product>` |
| --- |
| Product with title only |
| Product with description only |
| Product with price only |
| Product with discount percentage only |
| Product with rating only |
| Product with stock only |
| Product with brand only |
| Product with category only |
| Product with thumbnail only |

## Caso de Teste 004: Validar processo de excluir produto

### Funcionalidade: Excluir produto

**Como** um usuário,  
**Eu quero** acessar a rota "/products/{id}" através da API,  
**Para** excluir um produto existente.

### Cenário 001: Excluir um produto por id válido

**Dado** que o usuário possui um token de autenticação válido e o id de um produto existente,  
**Quando** o usuário faz uma requisição DELETE para a rota "/products/{id}" com o id do produto,  
**Então** a API deve retornar um status "200 OK".

### Cenário 002: Excluir um produto por id inválido

**Dado** que o usuário possui um token de autenticação válido e um id de produto inválido,  
**Quando** o usuário faz uma requisição DELETE para a rota "/products/{id}" com o id inválido,  
**Então** a API deve retornar um status "404 Not Found".

Exemplos para ids inválidos:
| `<id>` |
| --- |
| -1 |
| 0 |
| 999999 |

### Cenário 003: Excluir um produto sem fornecer id

**Dado** que o usuário possui um token de autenticação válido,  
**Quando** o usuário faz uma requisição DELETE para a rota "/products/{id}" sem fornecer um id,  
**Então** a API deve retornar um status "404 Not Found".

## Caso de Teste 006: Validar processo de acesso e busca de produtos

### Funcionalidade: Acessar e buscar produtos

**Como** um usuário,  
**Eu quero** acessar a rotas de produto através da API,  
**Para** acessar a lista de produtos e buscar um produto específico.

### Cenário 001: Acessar produtos

**Dado** que o usuário acessa a rota "/products",  
**Quando** o usuário faz uma requisição GET para a rota "/products",  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar a lista de produtos.

### Cenário 002: Tentativa de Busca de Produto por ID

**Dado** que o usuário acessa a rota "/products/{id}",  
**Quando** o usuário faz uma requisição GET para a rota "/products/{id}" com o id do produto,  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar o produto correspondente ao id.

Exemplos:
| `<id>` |
| --- |
| 1 |
| 10 |
| 100 |

### Cenário 003: Tentativa de Busca de Produto com ID Inválido

**Dado** que o usuário acessa a rota "/products/{id}",  
**Quando** o usuário faz uma requisição GET para a rota "/products/{id}" com o id inválido,  
**Então** a API deve retornar um status "404 Not Found".

Exemplos:
| `<id>` |
| --- |
| 0 |
| 102 |
| $$@(8) |

### Cenário 004: Pesquisar por produtos com a consulta

**Dado** que o usuário acessa a rota "/products/search?q={query}",  
**Quando** o usuário faz uma requisição GET para a rota "/products/search?q={query}",  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar uma lista de produtos com tamanho igual a 1.

Exemplos:
| `<query>` |
| --- |
| iphone 9 |
| iphone X |
| Samsung Universe 9 |

### Cenário 005: Pesquisar por produtos com a consulta inválida

**Dado** que o usuário acessa a rota "/products/search?q={query}",  
**Quando** o usuário faz uma requisição GET para a rota "/products/search?q={query}",  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar uma lista de produtos vazia.

Exemplos:
| `<query>` |
| --- |
| galinha |
| pc gamer |
| !@#$%^&\_() |

### Cenário 006: Obter todas as categorias de produtos

**Dado** que o usuário acessa a rota "/products/{categories}",  
**Quando** o usuário faz uma requisição GET para a rota "/products/{categories}",  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar a lista de todas as categorias de produtos.

Exemplos:
| `<category>` |
| --- |
| smartphones |
| laptops |
| fragrances |
| skincare |
| groceries |
| home-decoration |
| furniture |
| tops |
| womens-dresses |
| womens-shoes |
| mens-shirts |
| mens-shoes |
| mens-watches |
| womens-watches |
| womens-bags |
| womens-jewellery |
| sunglasses |
| automotive |
| motorcycle |
| lighting |

### Cenário 007: Obter produtos na categoria `<category>`

**Dado** que o usuário acessa a rota "/products/category/<category>",  
**Quando** o usuário faz uma requisição GET para a rota "/products/category/<category>",  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar uma lista de produtos da categoria `<category>`, não vazia.

Exemplos:
| `<category>` |
| --- |
| smartphones |
| laptops |
| fragrances |
| skincare |
| groceries |
| home-decoration |
| furniture |
| tops |
| womens-dresses |
| womens-shoes |
| mens-shirts |
| mens-shoes |
| mens-watches |
| womens-watches |
| womens-bags |
| womens-jewellery |
| sunglasses |
| automotive |
| motorcycle |
| lighting |

### Cenário 008: Tentativa de obter produtos na categoria `<category>` inválida

**Dado** que o usuário acessa a rota "/products/category/<category>",  
**Quando** o usuário faz uma requisição GET para a rota "/products/category/<category>",  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar uma lista de produtos vazia.

Exemplos:
| `<category>` |
| --- |
| airline |
| abcdef |
| 12345 |

### Cenário 009: Obter produtos com o parâmetro 'skip'

**Dado** que o usuário acessa a rota "/products?skip=<skip>",  
**Quando** o usuário faz uma requisição GET para a rota "/products?skip=<skip>",  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar uma lista de produtos, não vazia.

Exemplos:
| `<skip>` |
| --- |
| 5 |
| 10 |
| 15 |

### Cenário 010: Obter produtos com o parâmetro 'limit'

**Dado** que o usuário acessa a rota "/products?limit=<limit>",  
**Quando** o usuário faz uma requisição GET para a rota "/products?limit=<limit>",  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar uma lista de produtos, não vazia.

Exemplos:
| `<limit>` |
| --- |
| 10 |
| 20 |
| 30 |

### Cenário 011: Obter produtos com os parâmetros 'skip' e 'limit'

**Dado** que o usuário acessa a rota "/products?skip=<skip>&limit=<limit>",  
**Quando** o usuário faz uma requisição GET para a rota "/products?skip=<skip>&limit=<limit>",  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar uma lista de produtos, não vazia.

Exemplos:
| `<skip>` | `<limit>` |
| --- | --- |
| 5 | 10 |
| 10 | 20 |
| 15 | 30 |

### Cenário 012: Tentativa de obter produtos com o parâmetro 'skip' inválido

**Dado** que o usuário acessa a rota "/products?skip=<skip>",  
**Quando** o usuário faz uma requisição GET para a rota "/products?skip=<skip>",  
**Então** a API deve retornar um status "400 Bad Request",  
**E** a API deve retornar a mensagem "Invalid skip parameter".

Exemplos:
| `<skip>` |
| --- |
| $$$ |
| --8 |
| !0 |

### Cenário 013: Tentativa de obter produtos com o parâmetro 'limit' inválido

**Dado** que o usuário acessa a rota "/products?limit=<limit>",  
**Quando** o usuário faz uma requisição GET para a rota "/products?limit=<limit>",  
**Então** a API deve retornar um status "400 Bad Request",  
**E** a API deve retornar a mensagem "Invalid limit parameter".

Exemplos:
| `<limit>` |
| --- |
| !d28 |
| --8 |
| 200 |

### Cenário 014: Tentativa de obter produtos com os parâmetros 'skip' e 'limit' inválidos

**Dado** que o usuário acessa a rota "/products?skip=<skip>&limit=<limit>",  
**Quando** o usuário faz uma requisição GET para a rota "/products?skip=<skip>&limit=<limit>",  
**Então** a API deve retornar um status "400 Bad Request",  
**E** a API deve retornar a mensagem "Invalid limit parameter".

Exemplos:
| `<skip>` | `<limit>` |
| --- | --- |
| $$$ | -!d28 |
| --8 | --8 |
| !0 | !0 |

## Caso de Teste 007: Validar processo de acesso e busca de usuários

**Funcionalidade**: Acessar e buscar usuários  
**Como** um usuário,  
**Eu quero** acessar a rota de usuários através da API,  
**Para** acessar a lista de usuários e buscar um usuário específico.

**Cenário**: Obter todos os usuários  
**Dado** que o usuário acessa a rota "/users",  
**Quando** o usuário faz uma requisição GET para a rota "/users",  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar a lista de usuários.

**Cenário**: Obter um usuário com ID válido  
**Dado** que o usuário acessa a rota "/users/{id}",  
**Quando** o usuário faz uma requisição GET para a rota "/users/{id}" com um id válido,  
**Então** a API deve retornar um status "200 OK",  
**E** a API deve retornar as informações do usuário correspondente ao id fornecido.

Exemplos:
| `<id>` |
| --- |
| 1 |
| 50 |
| 100 |

**Cenário**: Obter um usuário com ID inválido  
**Dado** que o usuário acessa a rota "/users/{id}",  
**Quando** o usuário faz uma requisição GET para a rota "/users/{id}" com um id inválido,  
**Então** a API deve retornar um status "404 Not Found",  
**E** a API deve retornar uma mensagem de erro indicando que o usuário não foi encontrado.

Exemplos:
| `<id>` |
| --- |
| 0 |
| 102 |
| $$@(8) |

**Dado** que o usuário faz uma requisição para buscar usuários com um limite de página válido  
**Quando** o usuário faz uma requisição GET para a rota "/users?page=1&limit={limit}"  
**Então** a API deve retornar status "200 OK"  
**E** o corpo da resposta deve conter uma lista de usuários com tamanho maior que 0  
**E** o valor do "limit" deve ser retornado

**Exemplos:**
| `<limit>` |
| --- |
| 10 |
| 20 |
| 50 |

**Dado** que o usuário faz uma requisição para buscar usuários com um limite inválido  
**Quando** o usuário faz uma requisição GET para a rota "/users?page=1&limit={limit}"  
**Então** a API deve retornar status "400 Bad Request"  
**E** a API deve retornar uma mensagem de erro indicando que o valor de "limit" é inválido

**Dado** que o usuário faz uma requisição para buscar usuários com um valor de "skip" válido  
**Quando** o usuário faz uma requisição GET para a rota "/users?skip={skip}"  
**Então** a API deve retornar status "200 OK"  
**E** o corpo da resposta deve conter uma lista de usuários com tamanho maior que 0  
**E** o valor de "skip" deve ser retornado

**Exemplos:**
| `<skip>` |
| --- |
| 5 |
| 10 |
| 15 |

**Dado** que o usuário faz uma requisição para buscar usuários com um valor de "skip" inválido  
**Quando** o usuário faz uma requisição GET para a rota "/users?skip={skip}"  
**Então** a API deve retornar status "400 Bad Request"  
**E** a API deve retornar uma mensagem de erro indicando que o valor de "skip" é inválido

**Dado** que o usuário faz uma requisição para buscar usuários e deseja selecionar um atributo específico  
**Quando** o usuário faz uma requisição GET para a rota "/users?select={select}"  
**Então** a API deve retornar status "200 OK"  
**E** o corpo da resposta deve conter uma lista de usuários com tamanho maior que 0

**Exemplos:**
| `<select>` |
| -------------- |
| firstName |
| lastName |
| email |
| phone |

**Dado** que o usuário faz uma requisição para buscar usuários com "limit" e "skip"  
**Quando** o usuário faz uma requisição GET para a rota "/users?limit={limit}&skip={skip}"  
**Então** a API deve retornar status "200 OK"  
**E** o corpo da resposta deve conter uma lista de usuários com tamanho maior que 0  
**E** o valor de "limit" e "skip" deve ser retornado

**Dado** que o usuário faz uma requisição para buscar usuários com uma ordem específica  
**Quando** o usuário faz uma requisição GET para a rota "/users?order={order}"  
**Então** a API deve retornar status "200 OK"  
**E** o corpo da resposta deve conter uma lista de usuários com tamanho maior que 0

**Exemplos:**
| `<order>` |
| ----- |
| asc |
| desc |

**Dado** que o usuário faz uma requisição para buscar usuários com uma ordem inválida  
**Quando** o usuário faz uma requisição GET para a rota "/users?order={order}"  
**Então** a API deve retornar status "400 Bad Request"  
**E** a API deve retornar uma mensagem de erro indicando que a ordem é inválida  
**E** a mensagem de erro deve ser "Order can be: 'asc' or 'desc'"

**Exemplos:**
| `<order>` |
| ------- |
| up |
| reverse |

## Caso de Teste 008: Validar processo de criação de usuário

**Funcionalidade**: Criar novo usuário  
**Como** um administrador do sistema,  
**Eu quero** ser capaz de criar novos usuários através da API,  
**Para** permitir o registro de novos usuários no sistema.

**Cenário**: Criar um usuário válido  
**Dado** que o administrador deseja criar um novo usuário válido,  
**Quando** o administrador faz uma requisição POST para a rota "/users/add" com os dados do usuário válido,  
**Então** a API deve retornar um status "200 OK" indicando que o usuário foi criado com sucesso.

**Cenário**: Criar um usuário com email existente  
**Dado** que o administrador deseja criar um novo usuário com um email que já existe no sistema,  
**Quando** o administrador faz uma requisição POST para a rota "/users/add" com os dados do usuário com email
existente,  
**Então** a API deve retornar um status "400 Bad Request" indicando que o email já está em uso.

**Cenário**: Criar um usuário inválido  
**Dado** que o administrador deseja criar um novo usuário com dados inválidos,  
**Quando** o administrador faz uma requisição POST para a rota "/users/add" com dados inválidos do usuário,  
**Então** a API deve retornar um status "400 Bad Request" indicando que os dados do usuário são inválidos.

**Cenário**: Criar um usuário com firstName vazio  
**Dado** que o administrador deseja criar um novo usuário com o campo "firstName" vazio,  
**Quando** o administrador faz uma requisição POST para a rota "/users/add" com o campo "firstName" vazio,  
**Então** a API deve retornar um status "400 Bad Request" indicando que o campo "firstName" é obrigatório.

**Cenário**: Criar um usuário com lastName vazio  
**Dado** que o administrador deseja criar um novo usuário com o campo "lastName" vazio,  
**Quando** o administrador faz uma requisição POST para a rota "/users/add" com o campo "lastName" vazio,  
**Então** a API deve retornar um status "400 Bad Request" indicando que o campo "lastName" é obrigatório.

**Cenário**: Criar um usuário com todos os campos vazios  
**Dado** que o administrador deseja criar um novo usuário com todos os campos vazios,  
**Quando** o administrador faz uma requisição POST para a rota "/users/add" com todos os campos vazios,  
**Então** a API deve retornar um status "400 Bad Request" indicando que todos os campos são obrigatórios.

## Caso de Teste 009: Validar processo de exclusão de usuário

**Funcionalidade**: Excluir usuário  
**Como** um administrador do sistema,  
**Eu quero** ser capaz de excluir usuários existentes através da API,  
**Para** remover usuários do sistema conforme necessário.

**Cenário**: Excluir um usuário com ID válido  
**Dado** que o administrador deseja excluir um usuário com um ID válido,  
**Quando** o administrador faz uma requisição DELETE para a rota "/users/{id}" com um ID válido,  
**Então** a API deve retornar um status "200 OK" indicando que o usuário foi excluído com sucesso.

Exemplos:
| `<id>` |
| --- |
| 1 |
| 50 |
| 100 |

**Cenário**: Excluir um usuário com ID não numérico  
**Dado** que o administrador deseja excluir um usuário com um ID não numérico,  
**Quando** o administrador faz uma requisição DELETE para a rota "/users/{id}" com um ID não numérico,  
**Então** a API deve retornar um status "400 Bad Request" indicando que o ID não é válido.

Exemplos:
| `<id>` |
| --- |
| $$@(8) |
| ABC |
| XYZ |

## Caso de Teste 010: Validar processo de atualização de usuário

**Funcionalidade**: Atualizar informações do usuário  
**Como** um administrador do sistema,  
**Eu quero** ser capaz de atualizar as informações de um usuário existente através da API,  
**Para** manter os dados dos usuários precisos e atualizados.

**Cenário**: Atualizar um usuário com dados válidos usando PUT  
**Dado** que o administrador deseja atualizar um usuário com dados válidos,  
**Quando** o administrador faz uma requisição PUT para a rota "/users/{id}" com dados válidos do usuário,  
**Então** a API deve retornar um status "200 OK" indicando que as informações do usuário foram atualizadas com sucesso.

**Cenário**: Tentativa de atualizar um usuário com dados inválidos usando PUT  
**Dado** que o administrador deseja atualizar um usuário com dados inválidos,  
**Quando** o administrador faz uma requisição PUT para a rota "/users/{id}" com dados inválidos do usuário,  
**Então** a API deve retornar um status "400 Bad Request" indicando que os dados do usuário são inválidos.

**Cenário**: Tentativa de atualizar um usuário com campos vazios usando PUT  
**Dado** que o administrador deseja atualizar um usuário com campos vazios,  
**Quando** o administrador faz uma requisição PUT para a rota "/users/{id}" com campos
