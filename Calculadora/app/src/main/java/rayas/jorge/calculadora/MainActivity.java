package rayas.jorge.calculadora;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtCalc = null;
    private Button btnZero = null;
    private Button btnOne = null;
    private Button btnTwo = null;
    private Button btnThree = null;
    private Button btnFour = null;
    private Button btnFive = null;
    private Button btnSix = null;
    private Button btnSeven = null;
    private Button btnEight = null;
    private Button btnNine = null;
    private Button btnPlus = null;
    private Button btnMinus = null;
    private Button btnMultiply = null;
    private Button btnDivide = null;
    private Button btnEquals = null;
    private Button btnC = null;
    private Button btnDecimal = null;
    private Button btnMC = null;
    private Button btnMR = null;
    private Button btnMM = null;
    private Button btnMP = null;
    private Button btnPerc = null;
    private Button btnSqrRoot = null;
    private Button btnPM = null;
    private Button expEX = null;
    private Button pi = null;
    private Button sin = null;
    private Button cos = null;
    private Button tan = null;
    private Button log = null;
    private Button btnLn = null;
    private double num = 0;
    private double memNum = 0;
    private int operator = 1;
    // 0 = nothing, 1 = plus, 2 = minus, 3 =
    // multiply, 4 = divide
    private boolean readyToClear = false;
    private boolean hasChanged = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int display_mode = getResources().getConfiguration().orientation;

        if (display_mode == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main);
            initControlsPortrait();
        } else {
            setContentView(R.layout.activity_main_land);
            initControlsLandscape();
        }





        reset();
    }
    private void initControlsLandscape(){
        initControlsPortrait();
        try {
            btnSqrRoot = (Button) findViewById(R.id.btnSqrRoot);
            expEX = (Button) findViewById(R.id.expEX);
            pi = (Button) findViewById(R.id.btnPi);
            sin = (Button) findViewById(R.id.btnSin);
            cos = (Button) findViewById(R.id.btnCos);
            tan = (Button) findViewById(R.id.btnTan);
            log = (Button) findViewById(R.id.btnLog);


            pi.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    setValue(Double.toString(Math.PI));

                }

            });

            sin.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    setValue(Double.toString(Math.sin(Double.parseDouble(txtCalc
                            .getText().toString()))));

                }

            });

            cos.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    setValue(Double.toString(Math.cos(Double.parseDouble(txtCalc
                            .getText().toString()))));

                }

            });

            tan.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    setValue(Double.toString(Math.tan(Double.parseDouble(txtCalc
                            .getText().toString()))));

                }

            });

            log.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    setValue(Double.toString(Math.log10(Double.parseDouble(txtCalc
                            .getText().toString()))));

                }

            });
            expEX.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    handleEquals(6);
                }

            });

            btnSqrRoot.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    setValue(Double.toString(Math.sqrt(Double.parseDouble(txtCalc
                            .getText().toString()))));
                }
            });
            btnLn = (Button) findViewById(R.id.btnLn);
            btnLn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setValue(Double.toString(Math.log(Double.parseDouble(txtCalc
                            .getText().toString()))));
                }
            });
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }
    private void initControlsPortrait() {
        txtCalc = (EditText) findViewById(R.id.txtCalc);
        btnZero = (Button) findViewById(R.id.btnZero);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnEquals = (Button) findViewById(R.id.btnEquals);
        btnC = (Button) findViewById(R.id.btnC);
        btnPM = (Button) findViewById(R.id.btnPM);
        btnDecimal = (Button) findViewById(R.id.btnDecimal);






        btnZero.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(0);

            }

        });
        btnOne.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(1);
            }
        });
        btnTwo.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(2);
            }
        });
        btnThree.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(3);
            }
        });
        btnFour.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(4);
            }
        });
        btnFive.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(5);
            }
        });
        btnSix.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(6);
            }
        });
        btnSeven.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(7);
            }
        });
        btnEight.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(8);
            }
        });
        btnNine.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(9);
            }
        });
        btnPlus.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleEquals(1);
            }
        });
        btnMinus.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleEquals(2);
            }
        });
        btnMultiply.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleEquals(3);
            }
        });
        btnDivide.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleEquals(4);
            }
        });
        btnEquals.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleEquals(0);
            }
        });
        btnC.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                reset();
            }
        });
        btnDecimal.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleDecimal();
            }
        });
        btnPM.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handlePlusMinus();
            }
        });




        txtCalc.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int i, android.view.KeyEvent e) {
                if (e.getAction() == KeyEvent.ACTION_DOWN) {
                    int keyCode = e.getKeyCode();

                    // txtCalc.append("["+Integer.toString(keyCode)+"]");

                    switch (keyCode) {
                        case KeyEvent.KEYCODE_0:
                            handleNumber(0);
                            break;

                        case KeyEvent.KEYCODE_1:
                            handleNumber(1);
                            break;

                        case KeyEvent.KEYCODE_2:
                            handleNumber(2);
                            break;

                        case KeyEvent.KEYCODE_3:
                            handleNumber(3);
                            break;

                        case KeyEvent.KEYCODE_4:
                            handleNumber(4);
                            break;

                        case KeyEvent.KEYCODE_5:
                            handleNumber(5);
                            break;

                        case KeyEvent.KEYCODE_6:
                            handleNumber(6);
                            break;

                        case KeyEvent.KEYCODE_7:
                            handleNumber(7);
                            break;

                        case KeyEvent.KEYCODE_8:
                            handleNumber(8);
                            break;

                        case KeyEvent.KEYCODE_9:
                            handleNumber(9);
                            break;

                        case 43:
                            handleEquals(1);
                            break;

                        case KeyEvent.KEYCODE_EQUALS:
                            handleEquals(0);
                            break;

                        case KeyEvent.KEYCODE_MINUS:
                            handleEquals(2);
                            break;

                        case KeyEvent.KEYCODE_PERIOD:
                            handleDecimal();
                            break;

                        case KeyEvent.KEYCODE_C:
                            reset();
                            break;

                        case KeyEvent.KEYCODE_SLASH:
                            handleEquals(4);
                            break;

                        case KeyEvent.KEYCODE_DPAD_DOWN:
                            return false;
                    }
                }

                return true;
            }
        });
    }
    private void handleNumber(int num) {
        if (operator == 0)
            reset();

        String txt = txtCalc.getText().toString();
        if (readyToClear) {
            txt = "";
            readyToClear = false;
        } else if (txt.equals("0"))
            txt = "";

        txt = txt + Integer.toString(num);

        txtCalc.setText(txt);
        txtCalc.setKeyListener(null);
        txtCalc.setSelection(txt.length());

        hasChanged = true;
    }
    private void handleEquals(int newOperator) {
        if (hasChanged) {
            switch (operator) {
                case 1:
                    num = num + Double.parseDouble(txtCalc.getText().toString());
                    break;
                case 2:
                    num = num - Double.parseDouble(txtCalc.getText().toString());
                    break;
                case 3:
                    num = num * Double.parseDouble(txtCalc.getText().toString());
                    break;
                case 4:
                    num = num / Double.parseDouble(txtCalc.getText().toString());
                    break;
                case 5:
                    num = Math.pow(num, 2);
                    break;
                case 6:
                    num = Math.pow(num,
                            Double.parseDouble(txtCalc.getText().toString()));
                    break;
                case 7:
                    num = Math.sin(Double.parseDouble(txtCalc.getText()
                            .toString()));
                    break;
                case 8:
                    num =  Math.cos(Double.parseDouble(txtCalc.getText()
                            .toString()));
                    break;
                case 9:
                    num =  Math.tan(Double.parseDouble(txtCalc.getText()
                            .toString()));
                    break;
                case 10:
                    num = Math
                            .log10(Double.parseDouble(txtCalc.getText().toString()));
                    break;
                case 11:
                    double loge = Math.log10(Double.parseDouble(txtCalc.getText()
                            .toString()));
                    num = Math.exp(loge);
                    break;
                case 12:
                    num = Math.PI;
                    break;
                case 13:
                    num = Math.log(Double.parseDouble(txtCalc.getText().toString()));
                    break;
            }

            String txt = Double.toString(num);
            txtCalc.setText(txt);
            txtCalc.setSelection(txt.length());

            readyToClear = true;
            hasChanged = false;
        }

        operator = newOperator;
    }

    private void setValue(String value) {
        if (operator == 0)
            reset();

        if (readyToClear) {
            readyToClear = false;
        }

        txtCalc.setText(value);
        txtCalc.setSelection(value.length());

        hasChanged = true;
    }

    private void handleDecimal() {
        if (operator == 0)
            reset();

        if (readyToClear) {
            txtCalc.setText("0.");
            txtCalc.setSelection(2);
            readyToClear = false;
            hasChanged = true;
        } else {
            String txt = txtCalc.getText().toString();

            if (!txt.contains(".")) {
                txtCalc.append(".");
                hasChanged = true;
            }
        }
    }

    private void handleBackspace() {
        if (!readyToClear) {
            String txt = txtCalc.getText().toString();
            if (txt.length() > 0) {
                txt = txt.substring(0, txt.length() - 1);
                if (txt.equals(""))
                    txt = "0";

                txtCalc.setText(txt);
                txtCalc.setSelection(txt.length());
            }
        }
    }

    private void handlePlusMinus() {
        if (!readyToClear) {
            String txt = txtCalc.getText().toString();
            if (!txt.equals("0")) {
                if (txt.charAt(0) == '-')
                    txt = txt.substring(1, txt.length());
                else
                    txt = "-" + txt;

                txtCalc.setText(txt);
                txtCalc.setSelection(txt.length());
            }
        }
    }

    private void reset() {
        num = 0;
        txtCalc.setText("0");
        txtCalc.setSelection(1);
        operator = 1;
    }
}
