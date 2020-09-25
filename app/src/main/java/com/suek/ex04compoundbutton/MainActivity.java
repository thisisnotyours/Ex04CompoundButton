package com.suek.ex04compoundbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    //  2)  xml 에서 만들 뷰들을 참조하는 참조변수
    CheckBox cb01, cb02, cb03;
    TextView tv;

    ToggleButton toggleButton;
    Switch sw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  3) id 를 이용해서 뷰들을 찾아와서 참조변수에 대입
        cb01= findViewById(R.id.cb01);
        cb02= findViewById(R.id.cb02);
        cb03= findViewById(R.id.cb03);
        tv= findViewById(R.id.tv);

        //  4) 체크박스의 체크상태가 변경되는 것을 듣는 리스너객체 생성
        CompoundButton.OnCheckedChangeListener changeListener= new CompoundButton.OnCheckedChangeListener() {
            // 체크 상태가 변경될 때 마다 실행되는 메소드
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                String s="";

                if(cb01.isChecked()) s += cb01.getText().toString();   // 1.1) 에서 했던 if 문의 방법과 완전 같은 것.
                if(cb02.isChecked()) s += cb02.getText().toString();
                if(cb03.isChecked()) s += cb03.getText().toString();


            }
        };

        //  5)  위에서 만든 리스너객체를 각 체크박스에 붙이기
        cb01.setOnCheckedChangeListener(changeListener);
        cb02.setOnCheckedChangeListener(changeListener);
        cb03.setOnCheckedChangeListener(changeListener);



        //  6)  토글버튼의 체크상태 변경 리스너 생성 및 설정
        toggleButton= findViewById(R.id.toggle);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tv.setText(isChecked+"");                                 //setText 문자, boolean true/ false
            }
        });

        
        //  7)  Switch 에 체크상태 변경 리스너 객체 생성 및 설정
        sw= findViewById(R.id.sw);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tv.setText( isChecked +"");
            }
        });

    }




    //  1) onClick 속성이 부여된 뷰가 클릭되면 자동으로 발동하는 콜백메소드
    public void clickBtn(View v){       //view import 해주기   //onClick 이 되었기때문에 굳이 id 는 필요없음

        String s="";             //지역변수의 기본값= 쓰레기값 이라 ""하나 넣어..

        // 1.1) 선택된 체크박스의 글씨 얻어오기
        /*if(cb01.isChecked()){                    //cb01야. 너 isChecked 되었니.
            s= cb01.getText().toString();        //cb01 야 text 를 얻어와서 문자열로 바꿔
        }*/

        if(cb01.isChecked()){
            s= s + cb01.getText().toString();     //s 에 s + "Apple" =의 값이 들어감
        }

        if(cb02.isChecked()){                     //만약 apple 과 Banana 를 선택하면,
            s= s + cb02.getText().toString();     //s 에 "s(Apple)"+ Banana =의 값이 들어감
        }

        if(cb03.isChecked()){
            s= s + cb03.getText().toString();
        }


        // 1.2) 얻어온 글씨를 TextView 에 보여주기
        tv.setText(s);                         //tv 야 위에서 얻어온 text 를 set

    }

}
