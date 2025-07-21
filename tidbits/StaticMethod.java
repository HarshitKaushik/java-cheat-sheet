class OuterClass {
  private int outerClassInstanceVariable;

  public static class StaticNestedClass {
    private int staticNestedClassVariable;

    public int getStaticNestedClassVariable() {
      return staticNestedClassVariable;
    }

    public void setStaticNestedClassVariable(
        int staticNestedClassVariable) {
      this.staticNestedClassVariable = staticNestedClassVariable;
    }

    public void privateVariablesOfOuterClassAreNOTAvailable() {
      // outerClassInstanceVariable = 5; //COMPILE ERROR
    }
  }
}

public class StaticMethod {

  public static void staticMethod() {
    System.out.println("Inside static method!");
    // System.out.println(this);
    // Cannot use in a static context

  }

  public static void main(String[] args) {
    StaticMethod.staticMethod();
  }
}
