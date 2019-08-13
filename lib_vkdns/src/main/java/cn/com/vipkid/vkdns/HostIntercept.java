package cn.com.vipkid.vkdns;
//       _       _    _     _
//__   _(_)_ __ | | _(_) __| |
//\ \ / / | '_ \| |/ / |/ _` |
// \ V /| | |_) |   <| | (_| |
//  \_/ |_| .__/|_|\_\_|\__,_|
//        |_|

/* 
 *
 *2018/11/6
 */

public interface HostIntercept {
  boolean shouldUseHttpDns(String host);
}
