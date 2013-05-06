package assert_json_client;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static assert_json.java.AssertJson.assertJson;
import static assert_json.java.AssertJson.createJson;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SmokeTest {
  @Test
  public void shouldAssertJsonProperties() {
    assertJson("{\"ciao\":1," +
        "\"list\":[1,\"something\"]," +
        "\"other\":{\"sub\":[42]}}", new HashMap<String, Object>() {
      {
        put("ciao", 1);
        put("list", Arrays.asList(1, "something"));
        put("other", new HashMap<String, Object>() {
          {
            put("sub", Arrays.asList(42));
          }
        });
      }
    });
  }

  @Test
  public void shouldCreateJsonFromSourceMap() {
    assertThat(createJson(new HashMap<String, Object>() {
      {
        put("a", 1);
        put("b", Arrays.asList(1, "ciao"));
        put("c", new HashMap<String, Object>() {
          {
            put("sub", 3);
          }
        });
      }
    }), is("{\"b\":[1,\"ciao\"],\"c\":{\"sub\":3},\"a\":1}"));
  }
}
