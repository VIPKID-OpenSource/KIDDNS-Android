package cn.com.vipkid.vkdns;
//       _       _    _     _
//__   _(_)_ __ | | _(_) __| |
//\ \ / / | '_ \| |/ / |/ _` |
// \ V /| | |_) |   <| | (_| |
//  \_/ |_| .__/|_|\_\_|\__,_|
//        |_|

/*
 *
 *2018/11/2
 */

public interface HttpDnsMonitor {
  void onHttpDnsParseEnd(String host,String ip);
}
