package com.example.campusassist12.chuxing;

import com.baidu.mapapi.GeoPoint;
import com.baidu.mapapi.MapView;
import com.baidu.mapapi.Overlay;
import com.example.campusassist12.R;
import com.example.campusassist12.R.layout;
import com.example.campusassist12.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.Menu;

public class MyOverLayActivity extends Overlay {
	Bitmap locBitmap;
	GeoPoint gPoint;

	public MyOverLayActivity(GeoPoint gPoint, Bitmap locBitmap) {
		this.gPoint = gPoint;
		this.locBitmap = locBitmap;
	}

	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		super.draw(canvas, mapView, shadow);
		Point point = mapView.getProjection().toPixels(gPoint, null);		
		canvas.drawBitmap(locBitmap, point.x - locBitmap.getWidth() / 2,
				point.y - locBitmap.getHeight(), null);

	}
}
