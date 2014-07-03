/**
 * 
 */
package test.string;

import java.net.URL;




import org.apache.commons.lang.StringUtils;

/**
 * @author texu
 *
 */
public class TestString {
  private String s;
  private int i;
  private float f;
  private double d;
  private boolean b;
  private long l;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (b ? 1231 : 1237);
    long temp;
    temp = Double.doubleToLongBits(d);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + Float.floatToIntBits(f);
    result = prime * result + i;
    result = prime * result + (int) (l ^ (l >>> 32));
    result = prime * result + ((s == null) ? 0 : s.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TestString other = (TestString) obj;
    if (b != other.b)
      return false;
    if (Double.doubleToLongBits(d) != Double.doubleToLongBits(other.d))
      return false;
    if (Float.floatToIntBits(f) != Float.floatToIntBits(other.f))
      return false;
    if (i != other.i)
      return false;
    if (l != other.l)
      return false;
    if (s == null) {
      if (other.s != null)
        return false;
    } else if (!s.equals(other.s))
      return false;
    return true;
  }

  public static void main(String[] args) {
    TestString t = new TestString();
    
    /**************testEquals****************************/
    boolean result1 = t.testEquals(null);
    System.out.println("result1="+result1);
    
    URL url =TestString.class.getProtectionDomain().getCodeSource().getLocation();
    System.out.println("url="+url);
    
    
    String result = t.testResplaceAndSplit("permit out 1 from 1.2.3.4 to 5.6.7.8 20");
//    permit in 1 from 1.2.3.4 to 5.6.7.8 20
//    permit out 1 from 5.6.7.8 to 1.2.3.4 10
//    permit in 5 from ip to ip
    System.out.println("result="+result);
  }
  
  private String testResplaceAndSplit(String src) {
    if(!StringUtils.isEmpty(src)) {
    String[] parts = src.split("from");
    String[] subParts = parts[1].split("to");
    StringBuffer result = new StringBuffer(src.length());
    String newDirec = parts[0].replaceFirst("in", "out");
    result.append(newDirec).append("from").append(subParts[1]).append(" to").append(subParts[0]);
    return result.toString().trim();
    }
    return "";
  }
  
  private boolean testEquals(Object o) {
    if (!(o instanceof TestString)) {
      return false;
    }
    return false;
  }
}
