package com.rtoexam.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView Qurstion, A, B, C, D, total;
    private CardView OptionA, OptionB, OptionC, OptionD;
    private List<QurtionModal> alldata;
    private ImageView imageView;
    private String ann;
    private Button fast, last;
    int i = 0, counter;
    private final int l = 0;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        casting();
        arrayli();
        Qurstion.setText(alldata.get(0).getQurstion());
        A.setText(alldata.get(0).getA());
        B.setText(alldata.get(0).getB());
        C.setText(alldata.get(0).getC());
        D.setText(alldata.get(0).getD());
        try {
            imageView.setImageResource(alldata.get(0).getImq());
        } catch (Exception e) {

        }
        //onetimefuntion for 0 i value
        onefun();

        OptionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                atextclick();


            }
        });
        OptionB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                btextclick();

            }
        });
        OptionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctextclick();

            }
        });
        OptionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dtextclick();

            }
        });

        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    function();

                    if (i == alldata.size()+1) {
                        startActivity(new Intent(MainActivity.this, MainActivity2.class));
                    }

//                    if (counter!=l) {
//                        fast.setVisibility(View.VISIBLE);
//                    }
//                    else if(counter==l) {
//                        fast.setVisibility(View.INVISIBLE);
//                    }


            }
        });

        fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


    }


    public void function() {

        i++;
        Qurstion.setText(alldata.get(i).getQurstion());
        A.setText(alldata.get(i).getA());
        B.setText(alldata.get(i).getB());
        C.setText(alldata.get(i).getC());
        D.setText(alldata.get(i).getD());
        try {
            imageView.setImageResource(alldata.get(i).getImq());
        } catch (Exception e) {


        }
        OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));



//        i = (i + 1) % alldata.size();

//        if (counter == (modals.length-1)) {
//            Toast.makeText(getApplicationContext(),"complate",Toast.LENGTH_SHORT).show();
//            AlertDialog.Builder alart = new AlertDialog.Builder(this);
//            alart.setTitle("YOUR SCORE");
//            alart.setMessage("You Score is "+newscore);
//            alart.setCancelable(false);
//            alart.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    startActivity(new Intent(MainActivity.this,MainActivity2.class));
//                }
//            });
//            alart.show();
//
//        }

//        progressBar.incrementProgressBy(prograssbar);

    }

    private void onefun() {
        Qurstion.setText(alldata.get(0).getQurstion());
        A.setText(alldata.get(0).getA());
        B.setText(alldata.get(0).getB());
        C.setText(alldata.get(0).getC());
        D.setText(alldata.get(0).getD());
        try {
            imageView.setImageResource(alldata.get(0).getImq());
        } catch (Exception e) {


        }
        OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
        OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
    }


    private void atextclick() {


        if (A.getText().toString().equals(alldata.get(i).getAns())) {

            OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Green));
            OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            Toast.makeText(getApplicationContext(), "Answer A is right", Toast.LENGTH_SHORT).show();
        } else {


            if(B.getText().toString().equals(alldata.get(i).ans)){
                Toast.makeText(getApplicationContext(), "This is wrong ans", Toast.LENGTH_SHORT).show();
                vibrator.vibrate(700);
                OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Red));
                OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Green));
                OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
                OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            }else if (C.getText().toString().equals(alldata.get(i).ans)){
                Toast.makeText(getApplicationContext(), "This is wrong ans", Toast.LENGTH_SHORT).show();
                vibrator.vibrate(700);
                OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Red));
                OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
                OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Green));
                OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));

            }
            else if (D.getText().toString()==alldata.get(i).ans){
                Toast.makeText(getApplicationContext(), "This is wrong ans", Toast.LENGTH_SHORT).show();
                vibrator.vibrate(700);
                OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Red));
                OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
                OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
                OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Green));

            }
        }

    }

    private void btextclick() {
        if (B.getText().toString().equals(alldata.get(i).getAns())) {

            OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Green));
            OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));

            Toast.makeText(getApplicationContext(), "Answer is right", Toast.LENGTH_SHORT).show();
        }  else {


            if(A.getText().toString().equals(alldata.get(i).ans)){
                Toast.makeText(getApplicationContext(), "This is wrong ans", Toast.LENGTH_SHORT).show();
                vibrator.vibrate(700);
                OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Green));
                OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Red));
                OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
                OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            }else if (C.getText().toString().equals(alldata.get(i).ans)){
                Toast.makeText(getApplicationContext(), "This is wrong ans", Toast.LENGTH_SHORT).show();
                vibrator.vibrate(700);
                OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Red));
                OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
                OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Green));
                OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));

            }
            else if (D.getText().toString()==alldata.get(i).ans){
                Toast.makeText(getApplicationContext(), "This is wrong ans", Toast.LENGTH_SHORT).show();
                vibrator.vibrate(700);
                OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Red));
                OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
                OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
                OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Green));

        }
        }

    }

    private void ctextclick() {
        if (C.getText().toString().equals(alldata.get(i).getAns())) {

            OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Green));
            OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));

            Toast.makeText(getApplicationContext(), "Answer is right", Toast.LENGTH_SHORT).show();
        }else {


            if (A.getText().toString().equals(alldata.get(i).ans)) {
                Toast.makeText(getApplicationContext(), "This is wrong ans", Toast.LENGTH_SHORT).show();
                vibrator.vibrate(700);
                OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Green));
                OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
                OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Red));
                OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            } else if (B.getText().toString().equals(alldata.get(i).ans)) {
                Toast.makeText(getApplicationContext(), "This is wrong ans", Toast.LENGTH_SHORT).show();
                vibrator.vibrate(700);
                OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Green));
                OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
                OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Red));
                OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));

            } else if (D.getText().toString() == alldata.get(i).ans) {
                Toast.makeText(getApplicationContext(), "This is wrong ans", Toast.LENGTH_SHORT).show();
                vibrator.vibrate(700);
                OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
                OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
                OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Red));
                OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Green));

            }
        }


    }

    private void dtextclick() {
        if (D.getText().toString().equals(alldata.get(i).getAns())) {
            OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Green));
            OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));

            Toast.makeText(getApplicationContext(), "Answer is right", Toast.LENGTH_SHORT).show();
        } else {


            if (A.getText().toString().equals(alldata.get(i).ans)) {
                Toast.makeText(getApplicationContext(), "This is wrong ans", Toast.LENGTH_SHORT).show();
                vibrator.vibrate(700);
                OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Green));
                OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
                OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
                OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Red));
            } else if (B.getText().toString().equals(alldata.get(i).ans)) {
                Toast.makeText(getApplicationContext(), "This is wrong ans", Toast.LENGTH_SHORT).show();
                vibrator.vibrate(700);
                OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Green));
                OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
                OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
                OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Red));

            } else if (C.getText().toString() == alldata.get(i).ans) {
                Toast.makeText(getApplicationContext(), "This is wrong ans", Toast.LENGTH_SHORT).show();
                vibrator.vibrate(700);
                OptionB.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
                OptionA.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
                OptionC.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Green));
                OptionD.setCardBackgroundColor(ContextCompat.getColor(this, R.color.Red));

            }
        }

    }


    //list of qurtion and an
    private void arrayli() {
        alldata = new ArrayList<>();

        QurtionModal Q1 = new QurtionModal();
        Q1.setQurstion("This is my first qurstion");
        Q1.setA("this is a");
        Q1.setB("this is b");
        Q1.setC("this is c");
        Q1.setD("this is d");

        Q1.setAns("this is c");
        alldata.add(Q1);

        QurtionModal Q2 = new QurtionModal();
        Q2.setQurstion("This is my 2nd qurstion");
        Q2.setA("tora");
        Q2.setB("this is b");
        Q2.setC("this is c");
        Q2.setD("this is d");
        Q2.setImq(R.drawable.ic_launcher_foreground);
        Q2.setAns("this is b");
        alldata.add(Q2);

        QurtionModal Q3 = new QurtionModal();
        Q3.setQurstion("This is my trid qurstion");
        Q3.setA("a");
        Q3.setB("this is b");
        Q3.setC("this is c");
        Q3.setD("this is d");
        Q3.setImq(R.drawable.ic_launcher_foreground);
        Q3.setAns("this is c");
        alldata.add(Q3);

        QurtionModal Q4 = new QurtionModal();
        Q4.setQurstion("This is my four qurstion");
        Q4.setA("a");
        Q4.setB("this is b");
        Q4.setC("this is c");
        Q4.setD("this is d");
        Q4.setImq(R.drawable.ic_launcher_foreground);
        Q4.setAns("this is d");
        alldata.add(Q4);
    }


    private void casting() {
        OptionA = (CardView) findViewById(R.id.opationA);
        OptionB = (CardView) findViewById(R.id.opationB);
        OptionC = (CardView) findViewById(R.id.opationC);
        OptionD = (CardView) findViewById(R.id.opationD);

        Qurstion = (TextView) findViewById(R.id.qurtion);
        A = (TextView) findViewById(R.id.A);
        B = (TextView) findViewById(R.id.B);
        C = (TextView) findViewById(R.id.C);
        D = (TextView) findViewById(R.id.D);
        imageView = (ImageView) findViewById(R.id.imq);
        total = (TextView) findViewById(R.id.total);

        fast = (Button) findViewById(R.id.Previous);
        last = (Button) findViewById(R.id.next);
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);



    }


}