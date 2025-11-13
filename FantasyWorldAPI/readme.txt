
docker network create netCSC280
docker run -p 3306:3306 --name CSC280FantasyWorldDBMySQL --net netCSC280 -e MYSQL_ROOT_PASSWORD=abc123 -e MYSQL_DATABASE=fantasy_world -d mysql:latest

