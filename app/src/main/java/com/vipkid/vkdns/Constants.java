package com.vipkid.vkdns;
//       _       _    _     _
//__   _(_)_ __ | | _(_) __| |
//\ \ / / | '_ \| |/ / |/ _` |
// \ V /| | |_) |   <| | (_| |
//  \_/ |_| .__/|_|\_\_|\__,_|
//        |_|

/* guolei2@vipkid.com.cn
 *
 *2018/11/6
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {

  public static final String TEST_ACCOUNT_ID = "144043";
  public static final String TEST_SECURITY_KEY = "e69e5fd5bb461d2743d385eef0b85852";
  public static List<String> TEST_HOSTS =
      new ArrayList<>(Arrays.asList(
          "192.168.0.1",
          "www.baidu.com",
          "www.aliyun.com",
          "www.zhihu,com",
          "parent-app.vipkid.com.cn",
          "parent-app-fast.vipkid.com.cn",
          "api-student-classroom.vipkid.com.cn",
          "api-student-classroom.vipkidteachers.com",
          "gossip.vipkid.com.cn",
          "resource.vipkid.com.cn",
          "s.vipkidstatic.com"));

}
