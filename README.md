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

## Aten????o
Nesta prova ser?? necess??rio implementar os m??todos das classes conforme descri????es dos Javadocs correspondentes.

Dever?? ter interfaces REST para as seguintes funcionalidades:

    * Cadastro de produtos.
    * Altera????o de pre??os.
    * Cria????o de carrinhos.

## Regras:

* Voc?? poder?? criar novos atributos, classes, m??todos e reorganizar os pacotes.
* ?? proibido mudar a assinatura dos m??todos e construtores j?? existentes, exceto o construtor da classe ShoppingCart.
* Voc?? tem liberdade de adicionar frameworks e bibliotecas.
* N??o ser?? necess??rio implementar nenhum tipo de interface gr??fica.
* A prova deve ser resolvida utilizando obrigatoriamente Java (Vers??o 8 ou superior).
* ?? opcional o uso de bancos de dados e ferramentas de persist??ncia. 
(Caso opte por utilizar, dever?? encaminhar no readme as instru????es de inicializa????o do projeto).
* ?? opcional a implementa????o de cobertura de testes.
* Sua prova precisa compilar via Maven, impreterivelmente.
* A entrega do teste dever?? ser por meio de um reposit??rio p??blico ou anexada ao email.