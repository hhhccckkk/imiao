package com.hck.imiao.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hck.imiao.R;
import com.hck.imiao.bean.UserBean;

public class PeopleAdapter extends BaseAdapter {
	private List<UserBean> userBeans;
	private Context context;

	public PeopleAdapter(List<UserBean> userBeans, Context context) {
		this.userBeans = userBeans;
		this.context = context;
	}

	@Override
	public int getCount() {
		return userBeans.size();
	}

	@Override
	public Object getItem(int arg0) {
		return userBeans.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View view, ViewGroup arg2) {
		ViewHolder viewHolder = null;
		if (view == null) {
			view = LayoutInflater.from(context).inflate(
					R.layout.list_people_item, null);
			viewHolder = new ViewHolder();
			viewHolder.numTextView = (TextView) view
					.findViewById(R.id.people_num);
			viewHolder.idTextView = (TextView) view
					.findViewById(R.id.people_id);
			viewHolder.nameTextView = (TextView) view
					.findViewById(R.id.people_name);
			viewHolder.phoneTextView = (TextView) view
					.findViewById(R.id.people_phone);
			viewHolder.imageView = (ImageView) view
					.findViewById(R.id.people_img);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.nameTextView.setText(arg0 + "");
		viewHolder.idTextView.setText(userBeans.get(arg0).getId());
		viewHolder.nameTextView.setText(userBeans.get(arg0).getUserName());
		viewHolder.phoneTextView.setText(userBeans.get(arg0).getPhone());
		return view;
	}

	class ViewHolder {
		TextView numTextView, idTextView, nameTextView, phoneTextView;
		ImageView imageView;
	}

}
