package top.trial.struts.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyDemoInterceptor implements Interceptor {

	

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("����������");
		if(1 == 1) {
			//�����������
			return invocation.invoke();
		}
		return null;
	}
	
	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

}
