# Sistema de gestão de pedidos de restaurante

Backend simples do sistema de gestão de pedidos de um restaurante fictício. Esta API utiliza STOMP (Simple Text Orientated Messaging Protocol) e SockJS para se comunicar via WebSockets com o frontend. O sistema também oferece endpoints no estilo REST para realizar operações CRUD com as entidades do aplicativo, como clientes, pedidos e pratos.

## Tecnologias

- Java Spring Boot
- SockJS e STOMP para comunicação via WebSockets com o servidor
- Banco de dados PostgreSQL

## Instalação

Para instalar, basta clonar o repositório

```bash
git clone https://github.com/GShadowBroker/Restaurant-Order-Management-System
```

Acessar a pasta

```bash
cd Restaurant-Order-Management-System
```

Instalar dependências descritas no pom.xml e iniciar o servidor com as seguintes variáveis do ambiente:

- ALLOWED_ORIGIN_URL: URL do front-end.
- DATABASE_URL
- DATABASE_USERNAME
- DATABASE_PASSWORD

## WebSockets

O app que consumirá a API poderá se inscrever em "/topic/order" para receber atualizações quando os pedidos forem atualizados. Dessa forma, o cliente poderá atualizar automaticamente a interface de usuário em tempo real.

Para notificar quanto a mudanças na lista de pedidos, basta publicar uma mensagem no endpoint "/app/order/notify".

## API (REST)

| Método | Recurso          |
| ------ | ---------------- |
| GET    | /api/v1/customer |

Retorna a lista de clientes cadastrados.

| Parâmetro | Tipo |
| --------- | ---- |
| limit     | int  |
| offset    | int  |

Ex: /api/v1/customer?limit=10&offset=0

---

| Método | Recurso                                 |
| ------ | --------------------------------------- |
| GET    | /api/v1/customer/{{ customerId }}/order |

Retorna os pedidos do cliente de id customerId.
| Parâmetro | Tipo |
| ------------- | ------------------------------ |
| customerId | String (UUID) |

---

| Método | Recurso       |
| ------ | ------------- |
| GET    | /api/v1/order |

Retorna todos os pedidos cadastrados.

---

| Método | Recurso       |
| ------ | ------------- |
| POST   | /api/v1/order |

Cria novo pedido.

Body:

```
{
    customerId: String (UUID),
    items: List<Item>,
    observation: String
}
```

---

| Método | Recurso                     |
| ------ | --------------------------- |
| PUT    | /api/v1/order/{{ orderId }} |

Atualiza o status do pedido de id orderId.

| Parâmetro | Tipo                                                              |
| --------- | ----------------------------------------------------------------- |
| orderId   | int                                                               |
| status    | Enum (PENDING, IN_QUEUE, PREPARING, AWAITING_DELIVERY, DELIVERED) |

Ex: PUT /api/v1/order/2?status=IN_QUEUE

---

| Método | Recurso                     |
| ------ | --------------------------- |
| DELETE | /api/v1/order/{{ orderId }} |

Remove o pedido do banco de dados.

| Parâmetro | Tipo |
| --------- | ---- |
| orderId   | int  |

---

| Método | Recurso      |
| ------ | ------------ |
| GET    | /api/v1/item |

Retorna todos os pratos cadastrados.

---

| Método | Recurso      |
| ------ | ------------ |
| POST    | /api/v1/item |

Salva um novo item no banco de dados.

Body:

```
{
    code: String,
    name: String,
    description: String,
    imageUrl: String,
    price: Integer
}
```

---

| Método | Recurso           |
| ------ | ----------------- |
| GET    | /api/v1/item/some |

Retorna alguns pratos.

| Parâmetro | Tipo |
| --------- | ---- |
| limit     | int  |
| offset    | int  |

Ex: /api/v1/item/some?limit=5&offset=0

---

| Método | Recurso             |
| ------ | ------------------- |
| GET    | /api/v1/item/search |

Retorna uma lista de pratos cadastrados que correspondem ao termo de busca informado.

| Parâmetro | Tipo   |
| --------- | ------ |
| term      | String |
| limit     | int    |
| offset    | int    |

Ex: /api/v1/item/search?term=frango&limit=10&offset=0

## License

[MIT](https://choosealicense.com/licenses/mit/)
