package cn.com.vipkid.vkdns;
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

import android.annotation.SuppressLint;
import java.lang.reflect.Field;

final class ReflectHelper {
  static Class getClass(String name) throws ClassNotFoundException {
    return Class.forName(name);
  }

  @SuppressWarnings("SameParameterValue")
  static Field getField(Class clz, String fieldName) throws NoSuchFieldException {
    Field field = clz.getField(fieldName);
    field.setAccessible(true);
    return field;
  }

  static Field getAiFlagsField() throws Exception {
    @SuppressLint("PrivateApi") Class clz = Class.forName("android.system.StructAddrinfo");
    Field field = clz.getDeclaredField("ai_flags");
    field.setAccessible(true);
    return field;
  }
}
