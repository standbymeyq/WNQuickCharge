package com.optimumnano.quickcharge.manager;

import com.optimumnano.quickcharge.net.HttpApi;
import com.optimumnano.quickcharge.net.HttpCallback;
import com.optimumnano.quickcharge.net.ManagerCallback;
import com.optimumnano.quickcharge.net.MyHttpUtils;
import com.optimumnano.quickcharge.utils.StringUtils;

import org.xutils.http.RequestParams;

/**
 * Created by ds on 2017/4/1.
 */
public class LoginManager {
    public void login(String username, String pwd, final ManagerCallback callback){
        if (StringUtils.isEmpty(username)){
            callback.onFailure("用户名不能为空");
            return;
        }
        else if (StringUtils.isEmpty(pwd)){
            callback.onFailure("密码不能为空");
            return;
        }
        else {
            String url = HttpApi.getInstance().getUrl(HttpApi.login_url);
            RequestParams params = new RequestParams(url);
            params.addBodyParameter("mobile",username);
            params.addBodyParameter("pwd",pwd);
            params.addBodyParameter("type",1+"");
            MyHttpUtils.getInstance().post(params, new HttpCallback<String>() {
                @Override
                public void onSuccess(String result, int httpCode) {
                    super.onSuccess(result, httpCode);
                    callback.onSuccess(result);
                }

                @Override
                public void onFailure(String msg, String errorCode, int httpCode) {
                    super.onFailure(msg, errorCode, httpCode);
                    callback.onFailure(msg);
                }
            });
        }
    }
}
