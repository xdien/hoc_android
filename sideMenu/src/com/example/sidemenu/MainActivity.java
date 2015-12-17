package com.example.sidemenu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	String[] danhsach = { "Đăng nhập", "Nhạc hot", "Album", "Video clip",
			"Ca sĩ", "Bảng xếp hạng", "Top 100" };
	DrawerLayout drawerlayout;
	ListView mDrawerList;
	String ActionBarTitle, DrawerTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
		// Tham chiếu tới layout chính của ứng dụng 
		drawerlayout = (DrawerLayout) findViewById(R.id.drawer_layout); 
		mDrawerList = (ListView) findViewById(R.id.left_drawer); 
		mDrawerList.setAdapter(new ArrayAdapter<String>(this, 
		    android.R.layout.simple_list_item_1, danhsach)); 
		ActionBarTitle = getTitle().toString(); 
		DrawerTitle = "Chọn nội dung"; 
		ActionBarDrawerToggle navButton = new ActionBarDrawerToggle( 
		    this, // ap vao activity đang thực hiện 
		    drawerlayout, // drawerlayout 
		    R.drawable.ic_launcher,// icon 
		    R.string.drawer_open, // chuoi mo 
		    R.string.drawer_close /* chuoidong */ 
		)	 { 
			  // goi khi drawer da hoan tat close 
			  @Override 
			  public void onDrawerClosed(View drawerView) { 
			    super.onDrawerClosed(drawerView); 
			    getActionBar().setTitle(ActionBarTitle); 
			  } 
			  // goi khi drawer da hoan tat open 
			  @Override 
			  public void onDrawerOpened(View drawerView) { 
			    super.onDrawerOpened(drawerView); 
			    getActionBar().setTitle(DrawerTitle); 
			  } 
			}; 
			// co lenh nay moi thuc hien duoc ham onDrawerClosed va onDrawerOpened 
			drawerlayout.setDrawerListener(navButton); 
			//hiện nút home lên gốc trái cửa ActionBar 
			getActionBar().setHomeButtonEnabled(true); 
			//nhấn nút home trả về 1 level chứ không về top lev
			getActionBar().setDisplayHomeAsUpEnabled(true); 
		}
	}
}
