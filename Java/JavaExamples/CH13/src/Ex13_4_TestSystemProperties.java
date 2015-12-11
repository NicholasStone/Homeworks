import java.util.Properties;
import java.util.Enumeration;
public class Ex13_4_TestSystemProperties {
	public static void main(String[] args) {
		Properties ps = System.getProperties();
		ps.setProperty("------Name------","------Value------");		
		Enumeration pn = ps.propertyNames();
		while ( pn.hasMoreElements() ) {
			String pName = (String) pn.nextElement();
			String pValue = ps.getProperty(pName);
			System.out.println(pName + "----" + pValue);
		}
	}
}


