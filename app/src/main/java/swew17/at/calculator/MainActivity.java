package swew17.at.calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity /* implements View.OnClickListener */ {

    static enum OperationType {
        Add,
        Sub,
        Mul,
        Div,
        //None
    }

    OperationType opType = null;
    //Integer firstValue = null, secondValue = null;

    int firstValue = 0, secondValue = 0;
    int result = 0;


    StringBuilder numberBuilder = new StringBuilder(16);
    TextView resultView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        //final TextView resultView = (TextView) findViewById(R.id.resultView);
        resultView = (TextView) findViewById(R.id.resultView);


        Button clearButton = (Button) findViewById(R.id.btClear);
        clearButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                opType = null;
                numberBuilder.setLength(0);
                resultView.setText("");
            }
        });

        Button eqButton = (Button) findViewById(R.id.btEq);
        eqButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if (opType != null) {

                    secondValue = 0;
                    //int result = 0;

                    if (numberBuilder.length() > 0) {
                        secondValue = Integer.parseInt(numberBuilder.toString());
                    }


                    switch (opType) {
                        case Add: {
                            firstValue = Calculator.add(firstValue, secondValue);
                            break;
                        }
                        case Sub: {
                            firstValue = Calculator.sub(firstValue, secondValue);
                            //firstValue -= secondValue;
                            break;
                        }
                        case Mul: {
                            //firstValue *= secondValue;
                            firstValue = Calculator.mul(firstValue, secondValue);
                            break;
                        }
                        case Div: {

                            if (secondValue == 0) {
                                resultView.setText("NaN");
                                return;
                            }
                            
                            firstValue = Calculator.div(firstValue, secondValue);

                            break;
                        }
                    }

                    resultView.setText(Integer.toString(firstValue));
                    numberBuilder.setLength(0);


                    opType = null;
                }

            }
        });

        // Numpad: 0
        ((Button) findViewById(R.id.btZero)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String s = "0";

                resultView.append(s);
                numberBuilder.append(s);
            }
        });

        // Numpad: 1
        ((Button) findViewById(R.id.btOne)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String s = "1";

                resultView.append(s);
                numberBuilder.append(s);
            }
        });

        // Numpad: 2
        ((Button) findViewById(R.id.btTwo)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String s = "2";

                resultView.append(s);
                numberBuilder.append(s);
            }
        });

        // Numpad: 3
        ((Button) findViewById(R.id.btThree)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String s = "3";

                resultView.append(s);
                numberBuilder.append(s);
            }
        });

        // Numpad: 4
        ((Button) findViewById(R.id.btFour)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String s = "4";

                resultView.append(s);
                numberBuilder.append(s);
            }
        });

        // Numpad: 5
        ((Button) findViewById(R.id.btFive)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String s = "5";

                resultView.append(s);
                numberBuilder.append(s);
            }
        });

        // Numpad: 6
        ((Button) findViewById(R.id.btSix)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String s = "6";

                resultView.append(s);
                numberBuilder.append(s);
            }
        });

        // Numpad: 7
        ((Button) findViewById(R.id.btSeven)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String s = "7";

                resultView.append(s);
                numberBuilder.append(s);
            }
        });

        // Numpad: 8
        ((Button) findViewById(R.id.btEight)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String s = "8";

                resultView.append(s);
                numberBuilder.append(s);
            }
        });

        // Numpad: 9
        ((Button) findViewById(R.id.btNine)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String s = "9";

                resultView.append(s);
                numberBuilder.append(s);
            }
        });



        // Numpad: +
        // will store the input value in our firstValue
        //((Button) findViewById(R.id.btAdd)).setOnClickListener(this);



        Button addButton = (Button) findViewById(R.id.btAdd);
        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (opType == null) {

                    if (resultView.getText().length() > 0) {

                        firstValue = Integer.parseInt(resultView.getText().toString());
                    } else {
                        if (numberBuilder.length() > 0) {
                            firstValue = Integer.parseInt(numberBuilder.toString());
                        } else {
                            firstValue = 0;
                        }
                    }

                    opType = OperationType.Add;

                    numberBuilder.setLength(0);
                    resultView.setText("");
                }

            }
        });

        // Numpad: -
        Button subButton = (Button) findViewById(R.id.btSub);
        subButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (opType == null) {

                    if (resultView.getText().length() > 0) {

                        firstValue = Integer.parseInt(resultView.getText().toString());
                    } else {
                        if (numberBuilder.length() > 0) {
                            firstValue = Integer.parseInt(numberBuilder.toString());
                        } else {
                            firstValue = 0;
                        }
                    }

                    opType = OperationType.Sub;

                    numberBuilder.setLength(0);
                    resultView.setText("");
                }





            }
        });

        Button mulButton = (Button) findViewById(R.id.btMul);
        mulButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (opType == null) {

                    if (resultView.getText().length() > 0) {

                        firstValue = Integer.parseInt(resultView.getText().toString());
                    } else {
                        if (numberBuilder.length() > 0) {
                            firstValue = Integer.parseInt(numberBuilder.toString());
                        } else {
                            firstValue = 0;
                        }
                    }

                    opType = OperationType.Mul;

                    numberBuilder.setLength(0);
                    resultView.setText("");
                }



            }
        });

        Button divButton = (Button) findViewById(R.id.btDiv);
        divButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (opType == null) {

                    if (resultView.getText().length() > 0) {

                        firstValue = Integer.parseInt(resultView.getText().toString());
                    } else {
                        if (numberBuilder.length() > 0) {
                            firstValue = Integer.parseInt(numberBuilder.toString());
                        } else {
                            firstValue = 0;
                        }
                    }

                    opType = OperationType.Div;

                    numberBuilder.setLength(0);
                    resultView.setText("");
                }



            }
        });


    }

    /*
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btAdd:
            {
                if (resultView.getText().length() > 0) {


                    opType = OperationType.Add;

                    int tmp = Integer.parseInt(resultView.getText().toString());
                    resultView.setText("");


                    result = Calculator.add(result, tmp);
                }

                if (opType != OperationType.None) {

                    resultView.setText(Integer.toString(result));


                }


                break;
            }
        }
    }
    */


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
