package com.vipkid.vkdns;
//       _       _    _     _
//__   _(_)_ __ | | _(_) __| |
//\ \ / / | '_ \| |/ / |/ _` |
// \ V /| | |_) |   <| | (_| |
//  \_/ |_| .__/|_|\_\_|\__,_|
//        |_|

/* guolei2@vipkid.com.cn
 *
 *2018/11/2
 */

import android.app.Application;
import android.util.Log;
import cn.com.vipkid.vkdns.AliHttpDnsStrategy;
import cn.com.vipkid.vkdns.HttpDnsMonitor;
import cn.com.vipkid.vkdns.HttpDnsServiceProvider;
import java.util.ArrayList;
import java.util.List;


public class VKApplication extends Application {


  @Override
  public void onCreate() {
    super.onCreate();
    //这里是测试的账号
    AliHttpDnsStrategy aliHttpDnsStrategy =
        new AliHttpDnsStrategy.Builder(this, Constants.TEST_ACCOUNT_ID)
            .securityKey(Constants.TEST_SECURITY_KEY)
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

  }


}
