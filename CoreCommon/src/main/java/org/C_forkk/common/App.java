package org.C_forkk.common;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	
    	String beanDefInfo = "public class {0} extends ITemplateBean \\\\{";
    	System.out.println(MessageFormat.format(beanDefInfo, "TestNew"));
    	
    	/*
    	// <dataSourceExpression><![CDATA[new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource($F{items})]]></dataSourceExpression>
    	String constStr = "<dataSourceExpression><![CDATA[new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource($F{items})]]></dataSourceExpression>				<subreportExpression><![CDATA[$P{SUBREPORT_DIR} + \"GNNormalCargoItem.jasper\"]]></subreportExpression>";
    	
		Pattern attrReg = Pattern
				.compile("<dataSourceExpression><!\\[CDATA\\[new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource\\(\\$F\\{items}\\)\\]\\]></dataSourceExpression>\\s+<subreportExpression><!\\[CDATA\\[\\$P\\{SUBREPORT_DIR\\}\\s+\\+\\s+\"(\\w+).jasper\"\\]\\]></subreportExpression>");
		Matcher attrMat = attrReg.matcher(constStr);
		while (attrMat.find()) {
			String attrName = attrMat.group(1);
			System.out.println(attrName);
		}
    	*/
        System.out.println( "Hello World!" );
        
        System.out.println(System.getProperties());
    }
}
