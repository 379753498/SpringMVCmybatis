package com.javen.Jmeter;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class BeginTest  extends AbstractJavaSamplerClient {


	   private static long start = 0;
	    private static long end = 0;

	    public void setupTest(JavaSamplerContext arg0) {
	        start = System.currentTimeMillis();//获取当前系统时间
	        // System.out.println(start);
	    }

	    public SampleResult runTest(JavaSamplerContext arg0) {
	        SampleResult sr = new SampleResult();
	        
	        sr.sampleStart();// jmeter 开始统计响应时间标记
	        try {

	        	System.out.println("aaa");
	        
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
	        // System.out.println("The cost is"+(end-start)/1000);
	    }

	//测试本地调试
	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        JavaSamplerContext arg0 = new JavaSamplerContext(new Arguments());
	        BeginTest test = new BeginTest();
	        test.setupTest(arg0);
	        test.runTest(arg0);
	        test.teardownTest(arg0);
	    }
}
