# API SPEC

## Create Product

Request: 
- Method: POST
- Endpoint: `/api/v1/products`
- Body: 

```json
{
    "id":  "string, unique",
    "name": "string",
    "price": "long",
    "quantity": "int"
}
```

- Response:
```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "id":  "string, unique",
    "name": "string",
    "price": "long",
    "quantity": "int",
    "createdAt": "Date"
  }
}
```

## Get Product

Request:
- Method: GET
- Endpoint: `/api/v1/products`
- Response:

```json
{
  "code": 200,
  "message": "Success",
  "data": [
    {
      "id": "string, unique",
      "name": "string",
      "price": "long",
      "quantity": "int",
      "createdAt": "Date"
    },
    {
      "id": "string, unique",
      "name": "string",
      "price": "long",
      "quantity": "int",
      "createdAt": "Date"
    }
  ]
}
```

## Get Product By Id

Request:
- Method: GET
- Endpoint: `/api/v1/products/:id`
- Response:

```json
{
  "code": 200,
  "message": "Success",
  "data": {
      "id": "string, unique",
      "name": "string",
      "price": "long",
      "quantity": "int",
      "createdAt": "Date"
    }
}
```

## Edit Product


Request:
- Method: PUT
- Endpoint: `/api/v1/products/:id`
- Body:

```json
{
    "id":  "string, unique",
    "name": "string",
    "price": "long",
    "quantity": "int"
}
```

- Response:
```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "id":  "string, unique",
    "name": "string",
    "price": "long",
    "quantity": "int",
    "createdAt": "Date"
  }
}
```

## Delete Product

Response:
- Method: DELETE
- Endpoint: `/api/v1/products/:id`
- Response:
```json
{
  "code": 200,
  "message": "Product deleted successfully"
}
```