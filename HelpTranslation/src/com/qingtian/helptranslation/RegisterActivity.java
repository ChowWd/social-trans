package com.qingtian.helptranslation;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;

import com.qingtian.helptranslation.Bean.RegisterBean;
import com.qingtian.helptranslation.base.BaseActivity;

public class RegisterActivity extends BaseActivity {

	private EditText register_name;
	private EditText register_password;
	private EditText register_password1;
	private Button btn_register;

	@Override
	public void initView() {
		// ��ʼ��bmob
		Bmob.initialize(this, "cedc31a80814444195731ecf60f87627");
		setContentView(R.layout.register);
		register_name = (EditText) findViewById(R.id.register_name);
		register_password = (EditText) findViewById(R.id.register_password);
		register_password1 = (EditText) findViewById(R.id.register_password1);
		btn_register = (Button) findViewById(R.id.btn_register);
	}

	@Override
	public void initListener() {
		btn_register.setOnClickListener(this);
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void processClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_register:
			Register();
			break;

		default:
			break;
		}
	}

	public void Register() {
		String user_name = register_name.getText().toString().trim();
		String user_password = register_password.getText().toString().trim();
		String user_password1 = register_password1.getText().toString().trim();
		if (TextUtils.isEmpty(user_name) || TextUtils.isEmpty(user_password)
				|| TextUtils.isEmpty(user_password1)) {
			Toast.makeText(getApplicationContext(), "�û��������벻��Ϊ��", 0).show();
		} else if (!user_password.equals(user_password1)) {
			Toast.makeText(getApplicationContext(), "��������벻һ��", 0).show();
		} else {
			RegisterBean registerBean = new RegisterBean();
			registerBean.setUsername(user_name);
			registerBean.setPassword(user_password);
			registerBean.signUp(getApplicationContext(), new SaveListener() {

				@Override
				public void onSuccess() {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "ע��ɹ�", 0).show();
				}

				@Override
				public void onFailure(int arg0, String arg1) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "ע��ʧ��", 0).show();
				}
			});
		}

	}

}
