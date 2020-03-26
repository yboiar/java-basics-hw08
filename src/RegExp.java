import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Regular expressions.
 */
public class RegExp {
  /**
   * Get IP address from text.
   * @param text text to parse
   * @return String with IP address
   */

  public static String getIpAddress(String text) {
    final int IP_MAX_LIMIT = 255;
    String regexp = "(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)";
    // Compile the expression into a Pattern object
    Pattern pattern = Pattern.compile(regexp);
    // Construct a Matcher object
    Matcher matcher = pattern.matcher(text);
    String ipAddress = "";

    while (matcher.find()) {
      // count is used for validation of each group (except parent group) with the IP_MAX_LIMIT number;
      int count = 0;
      for (int i = 1; i <= matcher.groupCount(); i++) {
        if (Integer.parseInt(matcher.group(i)) <= IP_MAX_LIMIT) count++;
      }
      if (count == 4) ipAddress = matcher.group(0);
      }
    return ipAddress;
  }

}