REST API example:

POST request to save message:
curl -i -X POST -H 'Content-Type: application/json' -d '{"userId":"0", "email":"vasya.pupkin@mail.ru", "message":"test message"}' http://localhost:6174/message/save


