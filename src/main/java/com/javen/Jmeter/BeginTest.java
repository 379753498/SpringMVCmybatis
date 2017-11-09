package com.javen.Jmeter;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;

public class BeginTest  extends AbstractJavaSamplerClient {


	   private static long start = 0;
	    private static long end = 0;

	    public void setupTest(JavaSamplerContext arg0) {
	    
	    	
	    	
	        start = System.currentTimeMillis();//获取当前系统时间
	         System.out.println(start);
	    }

	    public SampleResult runTest(JavaSamplerContext arg0) {
	        SampleResult sr = new SampleResult();
	       String  string=sr.DEFAULT_HTTP_ENCODING;
	       
	       System.out.println(string);
	        sr.sampleStart();// jmeter 开始统计响应时间标记
	        try {
	        	HttpConfig custon=HttpConfig.custom().url(arg0.getParameter("URL")).encoding("utf-8");
	        	String post = HttpClientUtil.post(custon);
	        	
	        	System.err.println(post);
	//被测对象调用
	        } catch (Throwable e) {
	            sr.setSuccessful(false);
	        } finally {
	            sr.sampleEnd();//jmeter 结束统计响应时间标记
	        }
	        return sr;
	    }

	    private void sum(int i, int j) {
			// TODO Auto-generated method stub
			
		}

		public void teardownTest(JavaSamplerContext arg0) {
	        end = System.currentTimeMillis();
	        // System.out.println(end);
	         System.out.println("The cost is"+(end-start)/1000);
	    }

	//测试本地调试
	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	    	
	    	Arguments arguments = new Arguments();
	    	arguments.addArgument("URL", "https://www.panda.tv/66666");
//	    	arguments.addArgument("URL", "http://192.168.62.254:7030/ams/ams_weekly/AnaphaseTreatmentBrowse.do");

	        JavaSamplerContext arg0 = new JavaSamplerContext(arguments);
	        
	        BeginTest test = new BeginTest();
	        test.setupTest(arg0);
	        test.runTest(arg0);
	        test.teardownTest(arg0);
	    }
}
