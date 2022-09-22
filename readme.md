# AWS SDK V2 如何设置代理服务器

## 系统级别的设定

http代理
```java
System.setProperty("http.proxyHost", "119.29.178.64");
System.setProperty("http.proxyPort", "1087");
```

socks代理
```java
System.setProperty("socksProxyHost", "119.29.178.64");
System.setProperty("socksProxyPort", "1087");
```

## SDK Client级别的代理

参考： https://github.com/aws/aws-sdk-java-v2/blob/master/docs/LaunchChangelog.md#132-client-http-proxy-configuration

```java
ProxyConfiguration.Builder proxyConfig =
        ProxyConfiguration.builder()
                .endpoint(URI.create("http://119.29.178.64:1087"));

return ApacheHttpClient.builder()
        .proxyConfiguration(proxyConfig.build());
```

> 注意pom文件apache client的依赖， 非常重要；