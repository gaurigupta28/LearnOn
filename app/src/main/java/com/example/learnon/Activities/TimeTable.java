package com.example.learnon.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.learnon.Adapter.StudentAdapter;
import com.example.learnon.Adapter.TimeTableAdapter;
import com.example.learnon.Modal.TimeTableModal;
import com.example.learnon.Modal.UsersModal;
import com.example.learnon.R;
import com.example.learnon.Utilts.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TimeTable extends AppCompatActivity {

    RecyclerView recyclerView;
    TimeTableAdapter timeTableAdapter;
    List<TimeTableModal> timeTableModalList = new ArrayList<>();
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        drawerLayout = findViewById(R.id.drawer_layout_user);

        recyclerView = findViewById(R.id.rvtimetable);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TimeTableDataLoadingProcess();

    }

    private void TimeTableDataLoadingProcess() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLs.TIMETABLE_SELECT_ALL,
                response -> {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String FILENAME = jsonObject.getString("FILENAME");
                            String FILE = jsonObject.getString("FILE");
                            TimeTableModal timeTableModal = new TimeTableModal(FILENAME,FILE);
                            timeTableModalList.add(timeTableModal);
                        }
                        timeTableAdapter = new TimeTableAdapter(TimeTable.this, timeTableModalList);
                        recyclerView.setAdapter(timeTableAdapter);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }, error -> Toast.makeText(TimeTable.this,error.getMessage(), Toast.LENGTH_SHORT).show());
        Volley.newRequestQueue(this).add(stringRequest);
    }

    public  void  ClickMenu(View view ){
        UserDashboardActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){

        UserDashboardActivity.closeDrawer(drawerLayout);
    }

    public  void ClickHome(View view){
        UserDashboardActivity.redirectActivity(this,UserDashboardActivity.class);
    }

    public void ClickAttendance(View view){
      UserDashboardActivity.redirectActivity(this,Attendance.class);

    }
    public  void ClickNotice(View view){
        UserDashboardActivity.redirectActivity(this,Notice.class);

    }
    public void ClickFee(View view){
        UserDashboardActivity.redirectActivity(this,Fee.class);

    }
    public  void ClickSchoolBus(View view){
        UserDashboardActivity.redirectActivity(this,SchoolBus.class);

    }
    public void ClickExamResults(View view){
        UserDashboardActivity.redirectActivity(this,ExamResults.class);

    }
    public  void ClickAssignments(View view){
        UserDashboardActivity.redirectActivity(this,Assignments.class);
    }
    public void ClickTimeTable(View view){
       recreate();

    }
    public  void ClickLibrary(View view){
        UserDashboardActivity.redirectActivity(this,Library.class);

    }
    public  void ClickContactUs(View view){
        UserDashboardActivity.redirectActivity(this,ContactUs.class);
    }
    public  void ClickLogout(View view){
        UserDashboardActivity.logout(this);

    }
    public  void ClickUserProfile(View view){
        UserDashboardActivity.redirectActivity(this,UserProfile.class);
    }
    @Override
    protected void onPause() {
        super.onPause();
        UserDashboardActivity.closeDrawer(drawerLayout);
    }

}