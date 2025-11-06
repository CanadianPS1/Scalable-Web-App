docker network create netCSC280
docker run -p 3306:3306 --name CSC280StoreBookDBMySQL --net netCSC280 -e MYSQL_ROOT_PASSWORD=abc123 -e MYSQL_DATABASE=CSC280StoreBookDB -d mysql:latest

docker build -t csc280storebookapi:1 .
docker run -d -p 8081:8080 --name CSC280StoreBookDBAPI --net netCSC280 csc280storebookapi:1

