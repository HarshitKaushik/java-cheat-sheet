public class EnumAdvanced {

  // Enum with a variable, method and constructor
  public enum SeasonCustomized {
    WINTER(1), SPRING(2), SUMMER(3), FALL(4);

    // variable
    private int code;

    // method
    public int getCode() {
      return code;
    }

    // Constructor-only private or (default)
    // modifiers are allowed
    SeasonCustomized(int code) {
      this.code = code;
    }

    // Getting value of enum from code
    public static SeasonCustomized valueOf(int code) {
      for (SeasonCustomized season : SeasonCustomized.values()) {
        if (season.getCode() == code)
          return season;
      }
      throw new RuntimeException("value not found"); // Just for kicks
    }

    // Using switch statement on an enum
    public int getExpectedMaxTemperature() {
      switch (this) {
        case WINTER:
          return 5;
        case SPRING:
        case FALL:
          return 10;
        case SUMMER:
          return 20;
      }
      return -1; // Dummy since Java does not recognize this is possible :)
    }

  };

}

class Enums {
  // The member enum SEASON can only be defined inside a top-level class or
  // interface or in a static context
  enum SEASON {
    WINTER, SPRINT, SUMMER, FALL
  }

  public static void main(String[] args) {
    for (SEASON season : SEASON.values()) {
      System.out.println("season: " + season.name());
      System.out.println("ordinal: " + season.ordinal());
    }

    EnumAdvanced.SeasonCustomized season = EnumAdvanced.SeasonCustomized.WINTER;

    /*
     * //Enum constructor cannot be invoked directly //Below line would
     * cause COMPILER ERROR SeasonCustomized season2 = new
     * SeasonCustomized(1);
     */

    System.out.println(season.getCode()); // 1

    System.out.println(season.getExpectedMaxTemperature()); // 5

    System.out.println(EnumAdvanced.SeasonCustomized.valueOf(4)); // FALL
  }
}