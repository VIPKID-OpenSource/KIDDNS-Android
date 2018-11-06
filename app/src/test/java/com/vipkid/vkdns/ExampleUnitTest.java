package com.vipkid.vkdns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

  @Test
  public void addition_isCorrect() {
    assertEquals(4, 2 + 2);
    Pattern pattern = Pattern.compile("\\\\*vipkid.com.cn",Pattern.MULTILINE);
    Matcher matcher = pattern.matcher("parent-app.vipkid.com.cn");
    if (matcher.matches()) {
      System.err.println("匹配");
    }
  }


}