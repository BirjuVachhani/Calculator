package com.believe.calculator;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button mone;
    Button mtwo;
    Button mthree;
    Button mfour;
    Button mfive;
    Button msix;
    Button mseven;
    Button meight;
    Button mnine;
    Button mzero;
    Button mdot;
    Button mplus;
    Button mminus;
    Button mmultiply;
    Button mdevide;
    Button mequal;
    Button mallClear;
    Button mclear;
    Button mpercent;
    Button msign;
    TextView mdisplay;
    TextView moperator;
    DecimalFormat decimalFormat = new DecimalFormat("#.##########");

    private double valueOne=Double.NaN;
    private double valueTwo=0;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char PERCENT = '%';

    private char CURRENT_ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        mdisplay=(TextView)findViewById(R.id.tv_display);
        moperator=(TextView)findViewById(R.id.tv_op);
        mone=(Button)findViewById(R.id.bt_1);
        mtwo=(Button)findViewById(R.id.bt_2);
        mthree=(Button)findViewById(R.id.bt_3);
        mfour=(Button)findViewById(R.id.bt_4);
        mfive=(Button)findViewById(R.id.bt_5);
        msix=(Button)findViewById(R.id.bt_6);
        mseven=(Button)findViewById(R.id.bt_7);
        meight=(Button)findViewById(R.id.bt_8);
        mnine=(Button)findViewById(R.id.bt_9);
        mzero=(Button)findViewById(R.id.bt_0);
        mdot=(Button)findViewById(R.id.bt_dot);
        mplus=(Button)findViewById(R.id.bt_plus);
        mminus=(Button)findViewById(R.id.bt_minus);
        mmultiply=(Button)findViewById(R.id.bt_multi);
        mdevide=(Button)findViewById(R.id.bt_device);
        mequal=(Button)findViewById(R.id.bt_equal);
        mallClear=(Button)findViewById(R.id.bt_ac);
        mclear=(Button)findViewById(R.id.bt_c);
        mpercent=(Button)findViewById(R.id.bt_percent);
        msign=(Button)findViewById(R.id.bt_sign);


        mone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp=mdisplay.getText().toString();
                if(temp.length()<9)
                mdisplay.setText(temp+"1");
            }
        });

        mtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp=mdisplay.getText().toString();
                if(temp.length()<9)
                mdisplay.setText(temp+"2");
            }
        });

        mthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp=mdisplay.getText().toString();
                if(temp.length()<9)
                mdisplay.setText(temp+"3");
            }
        });
        mfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp=mdisplay.getText().toString();
                if(temp.length()<9)
                mdisplay.setText(temp+"4");
            }
        });
        mfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp=mdisplay.getText().toString();
                if(temp.length()<9)
                mdisplay.setText(temp+"5");
            }
        });
        msix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp=mdisplay.getText().toString();
                if(temp.length()<9)
                mdisplay.setText(temp+"6");
            }
        });
        mseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp=mdisplay.getText().toString();
                if(temp.length()<9)
                mdisplay.setText(temp+"7");
            }
        });
        meight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp=mdisplay.getText().toString();
                if(temp.length()<9)
                mdisplay.setText(temp+"8");
            }
        });
        mnine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp=mdisplay.getText().toString();
                if(temp.length()<9)
                mdisplay.setText(temp+"9");
            }
        });
        mzero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp=mdisplay.getText().toString();
                if(temp.length()<9)
                mdisplay.setText(temp+"0");
            }
        });
        mdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp=mdisplay.getText().toString();
                if(temp.length()<9)
                mdisplay.setText(temp+".");
            }
        });

        mallClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdisplay.setText(null);
                moperator.setText(null);
            }
        });

        mclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp=mdisplay.getText().toString();
                if(!temp.equals(""))
                {
                    temp = temp.substring(0, temp.length() - 1);
                    mdisplay.setText(temp);
                }
            }
        });

        mplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moperator.setText(moperator.getText().toString()+mdisplay.getText().toString()+"+");
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                mdisplay.setText(null);
            }
        });
        mminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moperator.setText(moperator.getText().toString()+mdisplay.getText().toString()+"-");
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                mdisplay.setText(null);
            }
        });
        mdevide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moperator.setText(moperator.getText().toString()+mdisplay.getText().toString()+"/");
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                mdisplay.setText(null);
            }
        });
        mmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moperator.setText(moperator.getText().toString()+mdisplay.getText().toString()+"x");
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                mdisplay.setText(null);
            }
        });

        mpercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moperator.setText(moperator.getText().toString()+mdisplay.getText().toString()+"%");
                computeCalculation();
                CURRENT_ACTION = PERCENT;
                mdisplay.setText(null);
            }
        });

        mequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                mdisplay.setText(decimalFormat.format(valueOne));
                moperator.setText(null);
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });

        msign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp=mdisplay.getText().toString();
                if(temp.charAt(0)=='-')
                {
                    temp=temp.substring(1,temp.length());
                }
                else
                {
                    temp="-"+temp;
                }
                mdisplay.setText(temp);
            }
        });
    }

    private void computeCalculation() {
        if(!Double.isNaN(valueOne)) {
            if(!mdisplay.getText().toString().equals(""))
            valueTwo = Double.parseDouble(mdisplay.getText().toString());
            else
                if(CURRENT_ACTION == ADDITION || CURRENT_ACTION == SUBTRACTION)
                    valueTwo=0;
                else if(CURRENT_ACTION == DIVISION || CURRENT_ACTION == MULTIPLICATION)
                    valueTwo=1;
            mdisplay.setText(null);

            if(CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if(CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if(CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if(CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
            else if(CURRENT_ACTION == PERCENT)
                valueOne = this.valueOne % valueTwo;
        }
        else {
            try {
                valueOne = Double.parseDouble(mdisplay.getText().toString());
            }
            catch (Exception e){}
        }
    }
}
