class ConstructorFirst {
  int code;

  public ConstructorFirst() {
    this.code = 200;
  }

  public ConstructorFirst(int code) {
    this.code = code;
  }

  public int getCode() {
    return this.code;
  }

  public static void main(String[] args) {
    ConstructorFirst first = new ConstructorFirst(422);
    System.out.println(first.getCode());
  }
}