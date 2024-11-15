package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import jdk.internal.org.jline.utils.Log;

public class DataProvidersStore 
{
	@DataProvider(name="Data1")
	public String[][] getAllData1() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//Store_DDT.xlsx";
		XLUtility xl= new XLUtility(path);
		
		int rownum=xl.getRowCount("Sheet1");
		int colcount=xl.getCellCount("Sheet1", 1);
		
		String apidata[][]=new String[rownum][colcount];
		
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j]=xl.getCelldata("Sheet1", i, j);
			}
		}
		
		return apidata;	
		
	}
	
	
	@DataProvider(name="OrderId")
	public String[] getOrderId() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//Store_DDT.xlsx";
		XLUtility xl=new XLUtility(path);
		
		int rownum=xl.getRowCount("Sheet1");
		
		String apidata[]=new String[rownum];
		
		
		for(int i=1;i<=rownum;i++)
		{
			apidata[i-1]=xl.getCelldata("Sheet1", i, 0);
		}
		
		return apidata;
			
	}
	
	

}
