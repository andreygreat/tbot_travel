# Telegram Bot Travel
Telegram bot to get information about the city by name

## Запуск приложения
Для запуска приложения необходимо скачать файлы
+ docker-compose.yml
+ dockerconfig\application.yml

в файле application.yml необходимо указать данные для Телеграм бота
```
tboot:
  tBotUsername: имя бота
  tBootToken: токе бота
```

раскоментировать путь к базе данных
для Windows
```
    url: jdbc:postgresql://docker.for.win.localhost:5433/resliv_travel
```
для Linux
```
    url: jdbc:postgresql://localhost:5433/resliv_travel
```

При необходимости отредактировать в файл  docker-compose.yml путь к файлу настроек application.yml

 для запуска приложения необходимо выполнить комманду

``` 
 docker-compose up
```

## Методы API
Т.к. изначально база данных пуста, необходимо ее заполнить с помощью API
Доступ к API по адресу (порт 8083 можно изменить в файле docker-compose.yml ) 
``` 
http://localhost:8083/api/cities/
``` 

Получить информацию о всех городах 
``` 
GET http://localhost:8083/api/cities/
```
Получить информацию о городе с указанным id
``` 
GET http://localhost:8083/api/cities/{ID}
``` 
Создать новый город
``` 
POST http://localhost:8083/api/cities/
```
тело запроса в формате JSON
``` 
{
    "name" : "City name",
    "info" : "City Info",    
}
```
Редактировать информацию о городе
``` 
PГЕ http://localhost:8083/api/cities/{ID}
```
тело запроса в формате JSON
``` 
{
    "name" : "New city name",
    "info" : "New city Info",    
}
```
Удалить информацию о городе
``` 
DELETE http://localhost:8083/api/cities/{ID}
```