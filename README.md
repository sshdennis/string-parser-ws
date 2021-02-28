# String parser web service

## Web page

```
http://{host}:{port}/string-parser-ws/
```

## API list

### Parse string

* Path: */api/parse/string*
* Request:
  ```
  {
    "input_string": "22,44,11",  // the input string with comma.
    "limit": 5                   // the return list size.
  }
  ```
* Response:
  ```
  {
    "success": true,
    "body": {
      "string_result_list": [
        12334623462346,
        9527,
        5566
      ]
    }
  ```
