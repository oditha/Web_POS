package Interceptor;

import Actions.LoginPage.LoginAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.Map;

public class LoginAuthentication implements Interceptor {


    @Override
    public void destroy() {

//        System.out.println("DESTROID");

    }

    @Override
    public void init() {

//        System.out.println("START INTERCEPTER");

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {

//        System.out.println("CHECKING");

        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
//        System.out.println(session);

        if (session.isEmpty()) {
//            System.out.println("INVLID USER");
            if (actionInvocation.getAction().getClass().equals(LoginAction.class)) {
//                System.out.println("Tring to login");
                return actionInvocation.invoke();
            }
            return "login";


        } else {

            return actionInvocation.invoke();

        }


    }
}
