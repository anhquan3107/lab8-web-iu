Customer API Documentation
==========================

Base URL
--------

`http://localhost:8080/api/customers`

* * * * *

Endpoints
---------

* * * * *

1\. Get All Customers
---------------------

**GET** `/api/customers`

**Description:** Retrieve all customers.

**Response:** 200 OK


    
    {
        "id": 1,  
        "customerCode": "C001",
        "fullName": "John Doe",
        "email": "john@example.com",
        "phone": "+15550001111",
        "address": "Some Street"
    }


* * * * *

2\. Get Customer by ID
----------------------

**GET** `/api/customers/{id}`

**Description:** Retrieve a single customer by ID.

**Path Variable:**

-   `id` --- Customer ID (Long)

**Response:** 200 OK


    {
        "id": 1,
        "customerCode": "C001",
        "fullName": "John Doe",
        "email": "john@example.com",
        "phone": "+15550001111",
        "address": "Some Street"
    }

* * * * *

3\. Create Customer
-------------------

**POST** `/api/customers`

**Description:** Create a new customer.

**Request Body:**

    {
        "customerCode": "C010",
        "fullName": "New Customer",
        "email": "new.customer@example.com",
        "phone": "+155512340000",
        "address": "123 New Street"
    }

**Response:** 201 Created

    {
        "id": 10,
        "customerCode": "C010",
        "fullName": "New Customer",
        "email": "new.customer@example.com",
        "phone": "+155512340000",
        "address": "123 New Street"
    }

* * * * *

4\. Update Customer
-------------------

**PUT** `/api/customers/{id}`

**Description:** Fully update all customer fields.

**Request Body:**

    {
        "customerCode": "C001",
        "fullName": "John Updated",
        "email": "john.updated@example.com",
        "phone": "+15559999999",
        "address": "New Address"
    }

**Response:** 200 OK

    {
        "id": 1,
        "customerCode": "C001",
        "fullName": "John Updated",
        "email": "john.updated@example.com",
        "phone": "+15559999999",
        "address": "New Address"
    }

* * * * *

5\. Partially Update Customer
-----------------------------

**PATCH** `/api/customers/{id}`

**Description:** Update only specific fields of a customer.

**Request Body:**

    {
        "fullName": "John Partially Updated"
    }

**Response:** 200 OK

    {
        "id": 1,
        "customerCode": "C001",
        "fullName": "John Partially Updated",
        "email": "john@example.com",
        "phone": "+15550001111",
        "address": "Some Street"
    }

* * * * *

6\. Delete Customer
-------------------

**DELETE** `/api/customers/{id}`

**Description:** Delete a customer by ID.

**Response:** 204 No Content

* * * * *

7\. Search Customers
--------------------

**GET** `/api/customers/search?keyword={keyword}`

**Description:** Search customers by keyword (name, email, phone, etc.).

**Example Request:**\
`/api/customers/search?keyword=john`

**Response:** 200 OK

    [
        {
            "id": 1,
            "customerCode": "C001",
            "fullName": "John Doe",
            "email": "john@example.com"
        },
        {
            "id": 3,
            "customerCode": "C003",
            "fullName": "Bob Johnson",
            "email": "bob@example.com"
        }
    ]

* * * * *

8\. Filter by Status (ACTIVE)
-----------------------------

**GET** `/api/customers/status/ACTIVE`

**Response:** 200 OK


    {
        "id": 1,
        "customerCode": "C001",
        "fullName": "John Active",
        "status": "ACTIVE"
    }
    

* * * * *

9\. Filter by Status (INACTIVE)
-------------------------------

**GET** `/api/customers/status/INACTIVE`

**Response:** 200 OK


    {
        "id": 5,
        "customerCode": "C005",
        "fullName": "Jane Inactive",
        "status": "INACTIVE"
    }


* * * * *

10\. Pagination + Sorting
-------------------------

**GET** `/api/customers?page={page}&size={size}&sortBy={field}&sortDir={asc|desc}`

**Example:**\
`/api/customers?page=0&size=3&sortBy=fullName&sortDir=asc`

**Response:** 200 OK

    {
        "content": [
            {
            "id": 1,
            "customerCode": "C001",
            "fullName": "Alice"
            },
            {
            "id": 2,
            "customerCode": "C002",
            "fullName": "Bob"
            },
            {
            "id": 3,
            "customerCode": "C003",
            "fullName": "Charlie"
            }
        ],
        "page": 0,
        "size": 3,
        "totalPages": 4,
        "totalElements": 12
    }

* * * * *

11\. Advanced Search
--------------------

**GET** `/api/customers/advanced-search?name={name}&email={email}`

**Example:**\
`/api/customers/advanced-search?name=john&email=example`

**Response:** 200 OK

    {
        "id": 1,
        "customerCode": "C001",
        "fullName": "John Doe",
        "email": "john@example.com"
    }