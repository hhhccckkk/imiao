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
import com.hck.imiao.bean.DeviceBean;

public class DeviceAdapter extends BaseAdapter {
	private List<DeviceBean> deviceBeans;
	public Context context;
	private int tag;

	public DeviceAdapter(List<DeviceBean> deviceBeans, int tag,
			Context context) {
		this.deviceBeans = deviceBeans;
		this.context = context;
		this.tag=tag;
	}

	@Override
	public int getCount() {
		return deviceBeans.size();
	}

	@Override
	public Object getItem(int arg0) {
		return deviceBeans.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		ViewHolder viewHolder = null;
		if (tag==1) {
			if (arg1 == null) {
				arg1 = LayoutInflater.from(context).inflate(
						R.layout.list_device_item, null);
				viewHolder = new ViewHolder();
				viewHolder.titleTextView = (TextView) arg1
						.findViewById(R.id.device_title);
				viewHolder.contentTextView = (TextView) arg1
						.findViewById(R.id.device_content);
				viewHolder.touxiangImageView = (ImageView) arg1
						.findViewById(R.id.device_touxiang);
				arg1.setTag(viewHolder);
			} else {
				viewHolder = (ViewHolder) arg1.getTag();
			}
			viewHolder.titleTextView.setText(deviceBeans.get(arg0).getTitle());
			viewHolder.contentTextView.setText(deviceBeans.get(arg0).getContent());
			// ImageLoader.getInstance().displayImage(deviceBeans.get(arg0).getTouxiang(),
			// viewHolder.touxiangImageView);
		}
		else {
			if (arg1 == null) {
				arg1 = LayoutInflater.from(context).inflate(
						R.layout.list_device_item2, null);
				viewHolder = new ViewHolder();
				viewHolder.titleTextView = (TextView) arg1
						.findViewById(R.id.device_title);
				viewHolder.contentTextView = (TextView) arg1
						.findViewById(R.id.device_content);
				viewHolder.touxiangImageView = (ImageView) arg1
						.findViewById(R.id.device_touxiang);
				arg1.setTag(viewHolder);
			} else {
				viewHolder = (ViewHolder) arg1.getTag();
			}
			viewHolder.titleTextView.setText(deviceBeans.get(arg0).getTitle());
			viewHolder.contentTextView.setText(deviceBeans.get(arg0).getContent());
			// ImageLoader.getInstance().displayImage(deviceBeans.get(arg0).getTouxiang(),
			// viewHolder.touxiangImageView);
		}
		return arg1;
	}

	class ViewHolder {
		TextView titleTextView, contentTextView;
		ImageView touxiangImageView;
	}

}
