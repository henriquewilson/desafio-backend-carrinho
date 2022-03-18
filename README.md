## Notas do dev
Antes de executar, edite o arquivo `src/main/resources/application.properties` alterado com as credenciais para acesso ao MySQL


### Executar o projeto

execute no terminal o arquivo presente na raiz do projeto `sh run.sh`


#REST Paths

### `GET` /api/product/all-products

Retorna  lista com todos produtos

### Request:


+ Body:
  No specific body attributes needed.

***

### Response:

+ Status: **200**

+ Body:
```
[
    {
        "code": 1,
        "description": "ssdasd"
    }
]
```
***




### `POST` /api/product/add-product

Cria novo produto

### Request:

+ Body:
```
{
    "description": "Produto 1"
}
```

***


### Response:

+ Status: **200**

+ Body:
```
{
    "code": 43,
    "description": "Produto 1"
}
```
***


### `POST` /api/cart/{clientId}/remove-item

Remove item da lista. Retorna o carrinho atualizado

### Request:


+ Body:
```
{
    "product": {
        "code": "1"
    },
    "unitPrice": 10,
    "quantity": 2
}
```

***


### Response:

+ Status: **200**

+ Body:
```
{
    "id": 10,
    "clientId": "{clientId}",
    "items": [
        {
            "id": 39,
            "product": {
                "code": 3,
                "description": "Produto Teste"
            },
            "unitPrice": 3,
            "quantity": 3,
            "amount": 9
        }
    ],
    "amount": 9
}
```


### `POST` /api/cart/{clientId}/add-item

Atualiza ou adicionar item na carrinho

### Request:


+ Body:
```
{
    "product": {
        "code": "1"
    },
    "unitPrice": 10,
    "quantity": 2
}
```

***


### Response:

+ Status: **200**

+ Body:
```
{
    "id": 10,
    "clientId": "{clientId}",
    "items": [
        {
            "id": 39,
            "product": {
                "code": 3,
                "description": "Produto Teste"
            },
            "unitPrice": 3,
            "quantity": 3,
            "amount": 9
        }
    ],
    "amount": 9
}
```

# `GET` /api/cart/{clientId}

Cria novo ou retorna carrinho do cliente

### Request:

+ Body:
  No specific body attributes needed.

### Response:

+ Status: **200**

+ Body:
```
{
    "id": 10,
    "clientId": "{clientId}",
    "items": [
        {
            "id": 39,
            "product": {
                "code": 3,
                "description": "Produto Teste"
            },
            "unitPrice": 3,
            "quantity": 3,
            "amount": 9
        }
    ],
    "amount": 9
}
```
***
# `GET` /api/cart/{clientId}/logout

Exclui carrinho

### Request:

+ Body:
  No specific body attributes needed.

### Response:

+ Status: **200**

+ Body:
```
true | false
```
***

# `GET` /api/cart/{clientId}/items

Retorna itens do carrinho

### Request:

+ Headers:
  No specific headers needed.

+ Url Params:
  No specific query parameters needed.

+ Body:
```
{
    "product": {
        "code": "1"
    },
    "unitPrice": 10,
    "quantity": 2
}
```

***


### Response:

+ Status: **200**

+ Body:
```
[
    {
        "id": 45,
        "product": {
            "code": 1,
            "description": "Produto Teste"
        },
        "unitPrice": 123,
        "quantity": 12,
        "amount": 1476
    },
    {
        "id": 46,
        "product": {
            "code": 41,
            "description": "Novo"
        },
        "unitPrice": 22,
        "quantity": 12,
        "amount": 264
    }
]
```
***

# `GET` /api/cart/{clientId}/total

Total do carrinho

### Request:

+ Headers:
  No specific headers needed.

+ Url Params:
  No specific query parameters needed.

+ Body:
  No specific body attributes needed.

***


### Response:

+ Status: **200**

+ Body:
```
1740
```
***

# `GET` /api/cart/average

**

### Request:

+ Headers:
  No specific headers needed.

+ Url Params:
  No specific query parameters needed.

+ Body:
  No specific body attributes needed.

***


### Response:

+ Status: **200**

+ Body:
```
580
```
***

## Atenção
Nesta prova será necessário implementar os métodos das classes conforme descrições dos Javadocs correspondentes.

Deverá ter interfaces REST para as seguintes funcionalidades:

    * Cadastro de produtos.
    * Alteração de preços.
    * Criação de carrinhos.

## Regras:

* Você poderá criar novos atributos, classes, métodos e reorganizar os pacotes.
* É proibido mudar a assinatura dos métodos e construtores já existentes, exceto o construtor da classe ShoppingCart.
* Você tem liberdade de adicionar frameworks e bibliotecas.
* Não será necessário implementar nenhum tipo de interface gráfica.
* A prova deve ser resolvida utilizando obrigatoriamente Java (Versão 8 ou superior).
* É opcional o uso de bancos de dados e ferramentas de persistência. 
(Caso opte por utilizar, deverá encaminhar no readme as instruções de inicialização do projeto).
* É opcional a implementação de cobertura de testes.
* Sua prova precisa compilar via Maven, impreterivelmente.
* A entrega do teste deverá ser por meio de um repositório público ou anexada ao email.