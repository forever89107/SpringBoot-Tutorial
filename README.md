
## ＥＮＶ
* springboot http-server (oracle 8)
* Mariadb(10.7.1)
* mybatis

### DataSource notify 
1. > src -> main -> resource -> application.properties
2. > spring.datasource.url -> jdbc:mysql://urdb:port/database?....
3. > spring.datasource.username=username
   > spring.datasource.password=password

### 打包取得新jar檔，取代「demo-0.0.1-snapshot.jar」

###  Blog_Repository tag
#### [【建立專案&啟動】_(01) ](https://medium.com/@conqueror89107/spring-boot-%E6%89%8B%E6%8A%8A%E6%89%8B-%E7%9B%B4%E5%88%B0%E4%BD%A0%E6%93%81%E6%9C%89-01-%E5%BB%BA%E7%AB%8B%E5%B0%88%E6%A1%88-%E5%95%9F%E5%8B%95-fea127ed92b8)
#### [【認識Rsetful 風格 API】_(02)](https://medium.com/@conqueror89107/spring-boot-%E6%89%8B%E6%8A%8A%E6%89%8B-%E7%9B%B4%E5%88%B0%E4%BD%A0%E6%93%81%E6%9C%89-02-1-%E8%AA%8D%E8%AD%98rsetful-%E9%A2%A8%E6%A0%BC-api-796116107851)
#### [【實戰 Rsetful 風格 API】_(03–1)](https://medium.com/@conqueror89107/spring-boot-%E6%89%8B%E6%8A%8A%E6%89%8B-%E7%9B%B4%E5%88%B0%E4%BD%A0%E6%93%81%E6%9C%89-02-2-%E5%AF%A6%E6%88%B0-rsetful-%E9%A2%A8%E6%A0%BC-api-f63758a9fe94)
#### [【實戰 Rsetful 風格 API】_(03–2)](https://medium.com/@conqueror89107/spring-boot-%E6%89%8B%E6%8A%8A%E6%89%8B-%E7%9B%B4%E5%88%B0%E4%BD%A0%E6%93%81%E6%9C%89-03-%E5%AF%A6%E6%88%B0-rsetful-%E9%A2%A8%E6%A0%BC-api-ch3-2-7f4e47f09342)
#### [【實戰 Rsetful 風格 API】_(03–3)](https://medium.com/@conqueror89107/spring-boot-%E6%89%8B%E6%8A%8A%E6%89%8B-%E7%9B%B4%E5%88%B0%E4%BD%A0%E6%93%81%E6%9C%89-03-%E5%AF%A6%E6%88%B0-rsetful-%E9%A2%A8%E6%A0%BC-api-ch3-3-19948554addc)
#### [【JAVA WEBの三層式架構】_04](https://medium.com/@conqueror89107/spring-boot-%E6%89%8B%E6%8A%8A%E6%89%8B-%E7%9B%B4%E5%88%B0%E4%BD%A0%E6%93%81%E6%9C%89-java-web%E3%81%AE%E4%B8%89%E5%B1%A4%E5%BC%8F%E6%9E%B6%E6%A7%8B-04-37c80e555f1d)
#### [【DI(依賴注入)、IOC(控制反轉)、常見之註解】_05](https://medium.com/@conqueror89107/spring-boot-%E6%89%8B%E6%8A%8A%E6%89%8B-%E7%9B%B4%E5%88%B0%E4%BD%A0%E6%93%81%E6%9C%89-di-%E4%BE%9D%E8%B3%B4%E6%B3%A8%E5%85%A5-ioc-%E6%8E%A7%E5%88%B6%E5%8F%8D%E8%BD%89-%E5%B8%B8%E8%A6%8B%E4%B9%8B%E8%A8%BB%E8%A7%A3-05-c90e247a387e)
#### [【MyBatis & MariaDB】_06](https://medium.com/@conqueror89107/spring-boot-%E6%89%8B%E6%8A%8A%E6%89%8B-%E7%9B%B4%E5%88%B0%E4%BD%A0%E6%93%81%E6%9C%89-mybatis-mariadb-06-e810c2284125)
#### [【MyBatis Generator】_07](https://medium.com/@conqueror89107/spring-boot-%E6%89%8B%E6%8A%8A%E6%89%8B-%E7%9B%B4%E5%88%B0%E4%BD%A0%E6%93%81%E6%9C%89-mybatis-generator-07-c60fb283c6d2)
#### API Test
```
post -- http://url:8890/player 
header:
[{"key":"Content-type","value":"application/json","description":""}]
body:
    {
     "id":"A0009",
     "playerName":"nickname",
     "job":"jobName",
     "level":9
    }
```
```
GET -- http://url:8890/player/A0008
header:
[{"key":"Content-type","value":"application/json","description":""}]
```
```
GET -- http://url:8890/player/
header:
[{"key":"Content-type","value":"application/json","description":""}]
```
