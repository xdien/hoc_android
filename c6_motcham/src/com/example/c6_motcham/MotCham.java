package com.example.c6_motcham;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MotCham extends View {
	Paint paint;
	Path path;
	Float x, y;
	Float xFloat, yFloat;

	public MotCham(Context context,AttributeSet attrs) {
		super(context);
		// TODO Auto-generated constructor stub
		paint = new Paint();
		path = new Path();
		paint.setAntiAlias(true);
		paint.setColor(Color.CYAN);
		paint.setStrokeWidth(6f);// ddo day cua net
		paint.setStrokeJoin(Join.ROUND);
		paint.setStyle(Style.STROKE);
		y = (float) 0;
		x = (float) 0;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawPath(path, paint);
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		x = event.getX();
		y = event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			path.moveTo(x, y);
			xFloat = x ;
			yFloat = y;
			break;
		case MotionEvent.ACTION_UP:
			path.lineTo(xFloat, yFloat);
			break;
		case MotionEvent.ACTION_MOVE:
			path.lineTo(x, y);
			
			break;
		default:
			return false;
		}
		invalidate();

		return true;

	}
}
