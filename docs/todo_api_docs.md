# Todo API

This API exposes end points for creating, reading, updating and deleting Todos. These docs give an overview of the api endpoints and what to expect them to return.

# Getting All Todos

- Endpoint : `/todos`
- Returns an array all the todos in the database
- If there aren't any todods in the database an  empty array is returned

Expected Result

``` json
[
  {
    "id": 2,
    "title": "Read the book Clean Code",
    "completed": false
  },
  {
    "id": 3,
    "title": "Watch the picky blinders",
    "completed": false
  }
]

```
<br>

# Getting A Spefic Todo By Id
- Endpoint : `/todos/{id}`
- returns a single todo pointed at by the given `id`
- if no todo with the  id `id` is found then the server will respond with a `404` error code 

- for example you would expect for `/todos/2`

Expected Result

``` json
{
    "id": 2,
    "title": "Read the book Clean Code",
    "completed": false
}
```
<br>

# Creating/Adding a new Todo

- endpoint `/todos/add`
- medthod `POST`
- takes a todo passed in the request body and adds it into the database 
- only the title is passed as the `id` is generated on the server and by default `completed` is `false`

Example Request Body
``` json
{
    "title": "Read the book Clean Code",
}
```

- the server will respond with a HTTP status code of `200` if the todo was added with no errors

<br>
# Updating A Todo
- endpoint `todos/update`
- method `POST`
- updates a todo passed in the request body

Example request body to update todo with id `5`

``` json
{
    "id": 5,
    "title": "Intergrate Angular Frontend with Spring Boot",
    "completed": false
}
```

<br>

# Delete a todo
- endpoint `todos/delete`
- method `DELETE`
- deletes a todo with the `todoId` passed in the request body
- for example to delete the todo with the `id` 5

``` json
{
    "todoId": 2,
}
```

- the server responds with HTTP status code `200` if the todo was deleted without any errors
- if the `todoId` doesn't actually point to any todo a `200` code is sent back

<br>

# Completing and Unticking Todos

- endpoint for completing  `todos/complete`
- endpoint for unticking  `todos/untick`
- method for both operations `POST`

- for both methods a `todoId` for the todo to be completed(ticked) or unticked is passed in the request body

``` json
{
    "todoId": 4,
}
```
- the server responds with HTTP status code `200` if the todo was ticked or unticked successfully
