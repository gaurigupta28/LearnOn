package com.example.learnon.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.learnon.Modal.AdminModal;
import com.example.learnon.Modal.UsersModal;
import com.example.learnon.R;
import com.example.learnon.Utilts.SharedPrefManager;

public class AdminProfile extends AppCompatActivity {
    TextView id,name,phone,email,password;
    Button btn_logout,btn_edit;
DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);
        drawerLayout = findViewById(R.id.drawer_layout_admin);
        btn_logout = findViewById(R.id.idbtnLogout);
        btn_edit = findViewById(R.id.idbtnEdit);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(view.equals(btn_logout)){
                    SharedPrefManager.getInstance(getApplicationContext()).logout();
                }
            }
        });

        if(SharedPrefManager.getInstance(this).isLoggedIn()) {
            id = findViewById(R.id.id);
            name = findViewById(R.id.idTVName);
            phone = findViewById(R.id.idTVPhone);
            email = findViewById(R.id.idTVEmail);
            password = findViewById(R.id.idTVPassword);
            AdminModal adminModal = SharedPrefManager.getInstance(this).getAdmin();

            id.setText(String.valueOf(adminModal.getID()));
            name.setText(adminModal.getNAME());
            phone.setText(adminModal.getPHONE());
            email.setText(adminModal.getEMAIL());
            password.setText(adminModal.getPASSWORD());
        }else{

            Intent intent = new Intent(AdminProfile.this,LoginActivity.class);
            startActivity(intent);
            finish();

        }


    }
    public  void  ClickMenu(View view ){
        AdminDashboardActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){

        AdminDashboardActivity.closeDrawer(drawerLayout);
    }

    public  void ClickHome(View view){
        AdminDashboardActivity.redirectActivity(this,AdminDashboardActivity.class);
    }

    public void ClickAdminProfile(View view){
       recreate();

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
      AdminDashboardActivity.redirectActivity(this,AdminOthers.class);
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
