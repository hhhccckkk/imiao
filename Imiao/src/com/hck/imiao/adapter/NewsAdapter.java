package com.hck.imiao.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hck.imiao.R;
import com.hck.imiao.bean.NewsBean;

public class NewsAdapter extends BaseAdapter {
	private List<NewsBean> newsBeans;
	private Context context;

	public NewsAdapter(Context context, List<NewsBean> beans) {
		this.context = context;
		this.newsBeans = beans;
	}

	@Override
	public int getCount() {
		return newsBeans.size();
	}

	@Override
	public Object getItem(int arg0) {
		return newsBeans.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View view, ViewGroup arg2) {
		ViewHolder viewHolder = null;
		if (view == null) {
			view=LayoutInflater.from(context).inflate(R.layout.list_new_item, null);
			viewHolder = new ViewHolder();
			viewHolder.contentTextView=(TextView) view.findViewById(R.id.new_content);
			view.setTag(viewHolder);
		}
		else {
			viewHolder=(ViewHolder) view.getTag();
		}
		viewHolder.contentTextView.setText(newsBeans.get(arg0).getContent());
		return view;
	}

	class ViewHolder {
		TextView contentTextView;
	}

}
