package com.example.learnon.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learnon.R;

public class AdminOthers extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Button btn_add_notice,btn_details_notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_others);
        drawerLayout = findViewById(R.id.drawer_layout_admin);

        btn_add_notice=findViewById(R.id.btn_add_notice);
        btn_details_notice = findViewById(R.id.btn_detail_notice);
        btn_add_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminOthers.this,AddNotice.class);
                startActivity(i);
            }
        });

        btn_details_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(AdminOthers.this,NoticeDetails.class);
                startActivity(i);
            }
        });

    }
    public  void  ClickMenu(View view ){
        AdminDashboardActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){

        AdminDashboardActivity.closeDrawer(drawerLayout);
    }

    public  void ClickHome(View view){
        AdminDashboardActivity.redirectActivity(this,UserDashboardActivity.class);
    }

    public void ClickAdminProfile(View view){
        AdminDashboardActivity.redirectActivity(this,AdminProfile.class);

    }
    public  void ClickStudent(View view){
        AdminDashboardActivity.redirectActivity(this,AdminStudent.class);

    }
    public void ClickTeacher(View view){
        AdminDashboardActivity.redirectActivity(this,AdminTeacher.class);

    }
    public  void ClickStudyWork(View view){
        AdminDashboardActivity.redirectActivity(this,AdminStudyWork.class);

    }
    public void ClickParents(View view){
        AdminDashboardActivity.redirectActivity(this,AdminParents.class);

    }
    public  void ClickOthers(View view){
       recreate();
    }
    public  void ClickLogout(View view){
        AdminDashboardActivity.logout(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        AdminDashboardActivity.closeDrawer(drawerLayout);
    }

}
