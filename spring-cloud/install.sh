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
docker stop sc-rabbitmq sc-redis sc-mysql
docker rm sc-rabbitmq sc-redis sc-mysql
docker image rm rabbitmq:alpine redis:alpine mysql:5.6

docker stop sc-eureka sc-bus sc-config sc-organization
docker rm sc-eureka sc-bus sc-config sc-organization
docker image rm cike/eureka-server:latest cike/bus-server:latest cike/config-server:latest cike/organization:latest

echo '==================2.1安装认证公共包到本地maven仓库=================='
#安装认证公共包到本地maven仓库
cd common && mvn install
echo '当前目录:' && pwd

#回到根目录
cd -

echo '=====================3.启动基础服务=========================='
cd docker-compose
#docker-compose -f docker-compose.yml up -d mysql
docker-compose -f docker-compose.yml up -d redis
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
cd -
pwd

echo '=====================5.1构建sysadmin镜像=========================='
cd ./sysadmin/organization/
mvn clean package && mvn docker:build
cd -

echo '=====================5.2启动sysadmin=========================='
cd docker-compose
docker-compose -f docker-compose.yml -f docker-compose.oauth.yml up -d organization
cd -

echo '=====================查询服务是否启动 docker logs sc-eureka=========================='
