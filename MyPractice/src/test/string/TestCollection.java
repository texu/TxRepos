package test.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestCollection {
  public static void main(String[] args) {
    TestCollection test = new TestCollection();
//    test.testArrayListRemove();
//    test.testList();
//    test.testIterator();
    test.testSetAddAll();
  }
  
  public void testArrayListRemove() {
    List<String> list = new ArrayList<String>();
    list.addAll(Arrays.asList("a", "b", "c", "d", "e", "f"));
    System.out.println("list="+list);
    
    list.remove("a");    
    System.out.println("list after remove 'a', list="+list);
    
    for(int i=0; i<list.size()-1; i++) {
      String temp = list.get(i);
      list.remove(i);
      System.out.println("list after remove '"+temp+"', list="+list);
    }
  }
  
  public void testList() {
    List<List<String>> list = new ArrayList<List<String>>();
    list.add(Arrays.asList("1", "2", "3", "exit", "5"));
    list.add(Arrays.asList("6", "7", "exit", "9", "10"));
    list.add(Arrays.asList("11", "12", "13", "14", "15"));
    
//    boolean result = false;
//    for(List<String> subList : list) {
//      if(!result) {
//        result = true;
//        for(String s : subList) {
//          if("exit".equals(s)) {
//            result = false;
//            continue;
//          }
//          System.out.print(s+" ");
//        }
//        System.out.println();
//      }
//    }
    
    boolean[] result = new boolean[list.size()];
    for(int i=0; i<list.size(); i++) {
      result[i] = true;
      for(String s : list.get(i)) {
        if("exit".equals(s)) {
          result[i] = false;
          break;
        }
        System.out.print(s + " ");
      }
      System.out.println(result[i]);
      System.out.println();
    }
  }
  
  public void testIterator() {
    List<String> list = new ArrayList<String>();
    list.addAll(Arrays.asList("1", "2", "3", "exit", "5"));
    
    Iterator<String> it = list.iterator();
    while(it.hasNext()) {
      System.out.println(it.next());
    }
  }
  
  public void testSetAddAll() {
    List<List<String>> list = new ArrayList<List<String>>();
    list.add(Arrays.asList("1", "2", "3", "exit", "5"));
    list.add(Arrays.asList("6", "7", "exit", "9", "10"));
    list.add(Arrays.asList("11", "12", "13", "14", "15"));
    
    Set<String> set = new HashSet<String>();
    
    for(List<String> subList : list) {
      set.addAll(subList);
    }
    
    System.out.println(set);
    System.out.println("set.size()=" + set.size());
  }
}
