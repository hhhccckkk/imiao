package com.hck.imiao.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.hck.imiao.R;
import com.hck.imiao.adapter.PeopleAdapter;
import com.hck.imiao.bean.UserBean;

public class PeopleFragment extends Fragment {
	private ListView peopleListView;
	private PeopleAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_people, null);
		
		peopleListView=(ListView) view.findViewById(R.id.people_lv);
		setData();
		return view;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}
	private void setData(){
		List<UserBean> userBeans=new ArrayList<UserBean>();
		UserBean userBean=null;
		for (int i = 0; i < 10; i++) {
			userBean=new UserBean();
			userBean.setId("1111"+i);
			userBean.setPhone("12344533"+i);
			userBean.setUserName("黄成科"+i);
			userBeans.add(userBean);
		}
		adapter=new PeopleAdapter(userBeans, this.getActivity());
		peopleListView.setAdapter(adapter);
	}

}
