# String parser web service

## Web page

```
http://{host}:{port}/string-parser-ws/
```

### Page sample

#### parsing success

<img width="760" src="https://user-images.githubusercontent.com/4490346/109423869-3746ec80-7a1c-11eb-92b8-0e528ced9670.png">

#### parsing failed

<img width="760" src="https://user-images.githubusercontent.com/4490346/109423932-737a4d00-7a1c-11eb-9281-6e62002f0545.png">


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
