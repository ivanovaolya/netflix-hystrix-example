# netflix-hystrix-example
Using Spring Cloud Netflix Hystrix – the fault tolerance library.  

## REST API samples
```curl http://localhost:8080/greeting/Olya```
Expected result: **Hello Olya!**

```curl http://localhost:8080/service/Olya```
ConnectException is thrown, and then fallbackMethod is invoked.
Expected result: **Hello default user!**

## Monitoring
You can monitor your application here: ```http://localhost:8080/hystrix```

## Hystrix core
```curl localhost:8080/hystrix/Olya```
```curl -H "Content-Type: application/json" -X POST -d '"key":"hystrixdemo.sleep", "value": "145"' http://localhost:8080/hystrix/config```
