playing without Spring... :D



### reminder...


- starting local database (mssqlserver). User=SA 

```shell
# start MSSQLSERVER DEV
sudo docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=adminTest123' -p 1433:1433 --name mssql_local  -v /app/mssql:/var/opt/mssql -d microsoft/mssql-server-linux
```

- test

```shell
curl -v  http://localhost:8089/email/1

```

trying develop a very very lightweight application...