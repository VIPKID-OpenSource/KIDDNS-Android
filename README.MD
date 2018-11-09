# VKDNS介绍

VKDNS是vipkid移动端开发的基于阿里HttpDns的Java层全局替换方案。具有以下特点：

* 兼容阿里云HttpDns的全部功能
* 支持接入其他的HttpDns SDK
* 支持白名单、黑名单设置
* 支持HttpDns解析监控
* 支持自定义Host拦截
* 对原先业务零侵入，接入成本极低
* 兼容Android19以上版本


# 用法

#### Gradle接入

在项目gradle中配置阿里云maven仓库,以及jitpack maven仓库

```
        maven {
            url 'http://maven.aliyun.com/nexus/content/repositories/releases/'
        }
        maven { url 'https://jitpack.io' }
```

然后接入lib库。

```
 implementation 'com.github.VIPKID-OpenSource:KIDDNS-Android:last-release'
```

#### 使用

```
    AliHttpDnsStrategy aliHttpDnsStrategy =
        new AliHttpDnsStrategy.Builder(this, "144043")
            .securityKey("e69e5fd5bb461d2743d385eef0b85852")
            .preResolveHosts(Constants.TEST_HOSTS)
            .cachedIPEnabled(true)
            .expiredIPEnabled(true)
            .build();
    HttpDnsServiceProvider.initWithMonitor(aliHttpDnsStrategy, new HttpDnsMonitor() {
      @Override
      public void onHttpDnsParseEnd(String host, String ip) {
        Log.e("httpdns", "onHttpDnsParseEnd: host---> " + host + ";ip---->" + ip);
      }
    });

    //正则部分比配
    List<String> whiteList = new ArrayList<>();
    whiteList.add("vipkid.com.cn");
    whiteList.add("vipkidstatic.com");
    HttpDnsServiceProvider.getInstance().setBlackAndWhiteList(null,whiteList);
```

* AliHttpDnsStrategy为阿里云HttpDns SDK的实现策略，根据自己的情况，配置相应的参数即可。
* HttpDnsServiceProvider提供一下API供使用。
	* init 初始化HttpDns服务
	* initWithMonitor 初始化HttpDns服务，HttpDnsMonitor用来监控HttpDns的解析结果
	* setBlackAndWhiteList 为配置黑名单及白名单，同于对Host进行拦截降级
	* setMonitor 设置HttpDns监控器，
	* setHostIntercept 设置自定义的host拦截器，实现自定义host降级策略，设置之后，黑白名单将失效。
	

# 实现原理

1. 通过动态代理的方式，hook [Libcore.java](https://android.googlesource.com/platform/libcore/+/android-9.0.0_r3/luni/src/main/java/libcore/io/Libcore.java) 中的os字段，当java层发起DNS解析请求的时候，拦截到android_getaddrinfo(或者getaddrinfo)方法，插入HttpDns解析的过程即可。

2. 通过设置ReflectHelper的classLoader为BootClassLoader来解除Android P为非公开API的限制。



# License 

```
 Copyright (c) 2018 @vipkid

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.

```