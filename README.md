**Инструкция по запуску (необходим докер)**
1) Зайти в директорию с проектом и выполнить команду 'docker build -t webapp .' для сборки образа проекта
2) Далее выполнить команду 
'''
docker run -d -p 5433:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=admin -e POSTGRES_DB=mobile postgres:latest
'''
для запуска postgres бд
3) и наконец выполнить команду 'docker run -it -p 8080:8080 webapp:latest' для запуска самого приложения 
Теперь оно работает по вот этому [адресу](http://localhost:8080/Mobile-1.0-SNAPSHOT/Menu) или (http://localhost:8080/Mobile-1.0-SNAPSHOT/Menu)
