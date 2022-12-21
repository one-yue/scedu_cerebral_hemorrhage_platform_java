# scedu_cerebral_hemorrhage_platform_java

## 环境要求：

```
JDK8（不能用最新的，因为章老师的服务器上java环境是JDK8）

IDEA

maven3.8.6（版本要求不高）
```

## 需要了解的背景知识：

```
java

springboot

maven

html+css+js
```

## 目录文件含义：

```
- /src
    - /main
        - /resources
            - application.yml(配置文件)
            - xxx.json(实验数据)
            - /templates(前端页面代码)
            - /static(前端页面所需的静态文件)
        - java/com/scu/scedu_cerebral_hemorrhage_platform_java(后端代码)
            - /controller(接口层)
            - /data(实验数据，并加载到内存)
            - /model(实体类)
            - /service(业务处理层)
            - /tool(一些工具类)
- pom.xml(maven配置文件，管理依赖)
```
