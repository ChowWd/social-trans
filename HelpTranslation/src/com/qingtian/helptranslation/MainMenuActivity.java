package com.qingtian.helptranslation;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nineoldandroids.view.ViewPropertyAnimator;
import com.qingtian.helptranslation.Adapter.MainPagerAdapter;
import com.qingtian.helptranslation.base.BaseActivity;
import com.qingtian.helptranslation.ui.fragment.ResultFragment;
import com.qingtian.helptranslation.ui.fragment.TaskFragment;
import com.qingtian.helptranslation.ui.fragment.TranslateFragment;


public class MainMenuActivity extends BaseActivity{

	private ViewPager viewPager;
	private List<Fragment> fragments;
	private MainPagerAdapter mainPageradapter;
	private LinearLayout ll_task;
	private LinearLayout ll_translate;
	private LinearLayout ll_result;
	private TextView menu_tv_task;
	private TextView menu_tv_translate;
	private TextView menu_tv_result;

	@Override
	public void initView() {
		setContentView(R.layout.menu);
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		ll_task = (LinearLayout) findViewById(R.id.ll_task);
		ll_translate = (LinearLayout) findViewById(R.id.ll_translate);
		ll_result = (LinearLayout) findViewById(R.id.ll_result);
		menu_tv_task = (TextView) findViewById(R.id.menu_tv_task);
		menu_tv_translate = (TextView) findViewById(R.id.menu_tv_translate);
		menu_tv_result = (TextView) findViewById(R.id.menu_tv_result);
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		ll_task.setOnClickListener(this);
		ll_translate.setOnClickListener(this);
		ll_result.setOnClickListener(this);
		
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			//�л���ɺ����
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				textLightAndScale();
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		//����fragment������ӵ�������
		fragments=new ArrayList<Fragment>();
		TaskFragment taskFragment=new TaskFragment();
		TranslateFragment translateFragment=new TranslateFragment();
		ResultFragment resultFragment=new ResultFragment();
		fragments.add(taskFragment);
		fragments.add(translateFragment);
		fragments.add(resultFragment);
		mainPageradapter=new MainPagerAdapter(getSupportFragmentManager(), fragments);
		viewPager.setAdapter(mainPageradapter);
		textLightAndScale();
	}

	@Override
	public void processClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.ll_task:
			viewPager.setCurrentItem(0);
			break;
		case R.id.ll_translate:
			viewPager.setCurrentItem(1);
			break;
		case R.id.ll_result:
			viewPager.setCurrentItem(2);
			break;

		default:
			viewPager.setCurrentItem(0);
			break;
		}
	}
	
	//��ѡ���������Ӷ���
	public void textLightAndScale() {
		// ��ȡ��ǰviewPager��ǰ��ʾ���������
		int item = viewPager.getCurrentItem();
		// ��������������ѡ�����ɫ
		menu_tv_task.setTextColor(item == 0 ? Color.WHITE : 0xaa666666);
		menu_tv_translate.setTextColor(item == 1 ? Color.WHITE : 0xaa666666);
		menu_tv_result.setTextColor(item == 2 ? Color.WHITE : 0xaa666666);

		// Ҫ�����Ķ��� �ı���ָ������
		ViewPropertyAnimator.animate(menu_tv_task)
				.scaleX(item == 0 ? 1.2f : 1).setDuration(200);
		ViewPropertyAnimator.animate(menu_tv_translate).scaleX(item == 1 ? 1.2f : 1)
				.setDuration(200);
		ViewPropertyAnimator.animate(menu_tv_result)
				.scaleX(item == 2 ? 1.2f : 1).setDuration(200);
		ViewPropertyAnimator.animate(menu_tv_task)
				.scaleY(item == 0 ? 1.2f : 1).setDuration(200);
		ViewPropertyAnimator.animate(menu_tv_translate).scaleY(item == 1 ? 1.2f : 1)
				.setDuration(200);
		ViewPropertyAnimator.animate(menu_tv_result)
				.scaleY(item == 2 ? 1.2f : 1).setDuration(200);

	}
}
