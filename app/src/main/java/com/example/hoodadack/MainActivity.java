package com.example.hoodadack;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.support.design.widget.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText id;
    private EditText pw;
    private Button loginBtn;
    private RadioGroup lang_group;
    private RadioButton korean;
    private RadioButton english;
    private TextView wrongId;
    private TextView wrongPw;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.identity);
        pw = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);
        lang_group = findViewById(R.id.lanGroup);
        korean = findViewById(R.id.lanKorea);
        english = findViewById(R.id.lanEnglish);
        wrongId = findViewById(R.id.wrongId);
        wrongPw = findViewById(R.id.wrongPw);

        // 라디오 그룹안의 변경이 생길시 반응하는 메소드
        lang_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.lanKorea) {  // 한국어 라디오 버튼이 선택됬을 때

                    Locale locale = new Locale("ko");  // 지역을 설정해줄 수 있는 Locale을 객체화 시키는데 한국으로 초기화 한다.
                    Locale.setDefault(locale);  // setDefault는 jvm의 기본 locale(한국으로)을 설정
                    Configuration config = new Configuration();
                    config.locale = locale;
                    getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    korean.setChecked(true);

                    Toast.makeText(getApplicationContext(), "한국어", Toast.LENGTH_SHORT).show();

                } else if(checkedId == R.id.lanEnglish) {  // 영어 라디오 버튼이 선택됬을 때

                    Locale locale = new Locale("en");
                    Locale.setDefault(locale);
                    Configuration config = new Configuration();
                    config.locale = locale;
                    getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    english.setChecked(true);

                    Toast.makeText(getApplicationContext(), "영어", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 로그인 버튼 클릭시 유효성 검사를 하고 리턴값으로 분기한다.
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valid()) {
                    // 다음페이지로 넘어가는 intent
                    // 툴바 생성
                    Toolbar toolbar = findViewById(R.id.toolbar);
                    // 생성한 툴바 설정
                    setSupportActionBar(toolbar);

                    // 네비게이션 생성
                    DrawerLayout drawer = findViewById(R.id.drawer_layout);
                    NavigationView navigationView = findViewById(R.id.nav_view);

                    mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow).setDrawerLayout(drawer).build();

                    NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);

                    NavigationUI.setupActionBarWithNavController(MainActivity.this, navController, mAppBarConfiguration);

                    NavigationUI.setupWithNavController(navigationView, navController);

                    Toast.makeText(getApplicationContext(), "가즈아", Toast.LENGTH_SHORT).show();

                } else {
                    // 다음페이지로 넘어가는 intent
                    Toast.makeText(getApplicationContext(), "이또한 가즈아", Toast.LENGTH_SHORT).show();

                }

            }
        });
        // URL추가하는 페이지 테스트 중
        Button testBtn = findViewById(R.id.testBtn);
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 메뉴를 inflate 시킨다.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    // 아이디, 비밀번호 유효성 검사
    public Boolean valid() {
        wrongId.setVisibility(View.INVISIBLE);
        wrongPw.setVisibility(View.INVISIBLE);

        String getId = id.getText().toString();
        String regId = "^[a-zA-Z0-9]+@[a-z]+\\.[a-z]{2,6}$";
        String getPw = pw.getText().toString();
        String regPw = "^(?=.*[A-Za-z])(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$";

        if (getId.matches(regId)) {
            if (getPw.matches(regPw)) {
                return true;
            } else {
                wrongPw.setVisibility(View.VISIBLE);
                return false;
            }
        } else {
            wrongId.setVisibility(View.VISIBLE);
            return false;
        }
    }
}
