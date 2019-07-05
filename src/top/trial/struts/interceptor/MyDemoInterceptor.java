package top.trial.struts.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyDemoInterceptor implements Interceptor {

	

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("进入拦截器");
		if(1 == 1) {
			//处理后续动作
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
