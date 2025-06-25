class PeopleEnum {
  public enum People {
    RAMESH("engineer", 32), SURESH("analyst", 28), PRAKESH("devops", 27);

    private String designation;
    private int age;

    People(String designation, int age) {
      this.designation = designation;
      this.age = age;
    }

    public String getDesignation() {
      return this.designation;
    }

    public int getAge() {
      return this.age;
    }
  }

  public static void main(String[] args) {
    People p = People.RAMESH;
    System.out.println("Designation: " + p.getDesignation() + " Age: " + p.getAge());
  }
}