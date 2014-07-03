package test.string;

public class TestReflect {
  public static void main(String [] args) {
    TestReflect test = new TestReflect();
    test.getClassName(new String());
  }
  
  private void getClassName(Object obj) {
    System.out.println("classSimpleName="+obj.getClass().getSimpleName());
  }
}
