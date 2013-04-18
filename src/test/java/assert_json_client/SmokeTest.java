package assert_json_client;

import assert_json.java.AssertJson;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static assert_json.java.AssertJson.assertJson;

public class SmokeTest {
  @Test
  public void shouldAssertJsonProperties() {
    assertJson("{\"ciao\":1,\"list\":[1,\"something\"]}", new HashMap<String, Object>() {
      {
        put("ciao", 1);
        put("list", Arrays.asList(1, "something"));
      }
    });
  }

}
