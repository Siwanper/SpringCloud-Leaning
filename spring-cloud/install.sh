#!/usr/bin/env bash
echo '==================1.开发环境准备================================'
echo '1.1请确保安装并java8, git, maven并设置好环境变量'
echo '1.2请确保安装并docker,docker-compose并设置好环境变量'

read -r -p "开发环境准备好了吗? [Y/n]" envConfirm
case $envConfirm in
    [yY][eE][sS]|[yY])
        echo "Yes 继续执行"
        ;;
     [nN][oO]|[nN])
        echo "No 退出"
        exit 1
        ;;
      *)
        echo "Invalid input ...终止执行"
        exit 1
        ;;
esac

echo '=====================2.清理启动的容器和产生的镜像=========================='
docker stop sc-rabbitmq
docker rm sc-rabbitmq
docker image rm rabbitmq:alpine

docker stop sc-eureka sc-bus sc-config
docker rm sc-eureka sc-bus sc-config
docker image rm cike/eureka-server:latest cike/bus-server:latest cike/config-server:latest

echo '=====================3.启动基础服务=========================='
cd docker-compose
docker-compose -f docker-compose.yml up -d rabbitmq
cd -
pwd

echo '=====================4.1构建center镜像=========================='
cd ./center/eureka
mvn clean package && mvn docker:build
cd -

cd ./center/bus
mvn clean package && mvn docker:build
cd -

cd ./center/config
mvn clean package && mvn docker:build
cd -

echo '=====================4.2启动center=========================='
cd docker-compose
docker-compose -f docker-compose.yml -f docker-compose.center.yml up -d eureka-server
docker-compose -f docker-compose.yml -f docker-compose.center.yml up -d bus-server
docker-compose -f docker-compose.yml -f docker-compose.center.yml up -d config-server

echo '=====================查询服务是否启动 docker logs sc-eureka=========================='
docker logs sc-eureka
docker logs sc-bus
docker logs sc-config