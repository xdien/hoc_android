package com.example.c5_contentprovide;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class SquareImageView extends ImageView {

	public SquareImageView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public SquareImageView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public SquareImageView(Context context, AttributeSet attrs, int def)
	{
		super(context, attrs, def);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		// định lại kích thướt scale của ảnh
		setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
	}
}
