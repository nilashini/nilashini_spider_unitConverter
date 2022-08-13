package com.example.unitconvertor;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Arrays;

public class temp_cal extends AppCompatActivity {

    final String[] values = new String[]{"Celsius", "Fahrenheit", "Rankine", "Reaumur", "Kelvin"};
    CardView cv_fromUnit, cv_toUnit, cv_convert, cv_check;
    RelativeLayout mCLayout;
    String fromUnit = "Celsius";
    String toUnit = "Fahrenheit";
    String toUnitCheck = "Fahrenheit";
    TextView tv_fromUnit, tv_toUnit, tv_toUnitCheck;
    EditText et_fromUnit, et_toUnit, et_toUnitCheck;

    public static boolean isnotNumeric(String tempInput) {
        if (tempInput == null) {
            return true;
        }
        try {
            double d = Double.parseDouble(tempInput);
        } catch (NumberFormatException
                nfe) {
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_cal);
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        cv_fromUnit = findViewById(R.id.fromUnit);
        cv_toUnit = findViewById(R.id.toUnit);
        cv_convert = findViewById(R.id.cv_convert);
        cv_check = findViewById(R.id.cv_check);

        mCLayout = findViewById(R.id.temp_relativeLayout);

        tv_fromUnit = findViewById(R.id.tv_fromUnit);
        tv_toUnit = findViewById(R.id.tv_toUnit);
        tv_toUnitCheck = findViewById(R.id.tv_toUnitCheck);

        tv_fromUnit.setText(values[0]);
        tv_toUnit.setText(values[1]);
        tv_toUnitCheck.setText(values[1]);

        et_fromUnit = findViewById(R.id.et_fromUnit);
        et_toUnit = findViewById(R.id.et_toUnit);
        et_toUnitCheck = findViewById(R.id.et_toUnitCheck);

        cv_convert.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                et_toUnitCheck.setText("");
                mCLayout.setBackgroundColor(Color.BLACK);
                String tempInput = et_fromUnit.getText().toString();
                if (tempInput.equals("") || isnotNumeric(tempInput)) {
                    if (tempInput == null || tempInput.equals("")) {
                        et_fromUnit.setError("Please enter some value");
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (tv_fromUnit.getText().toString().equals(values[0])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(celsiusToFahrenheit(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(celsiusToRankine(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(celsiusToReaumur(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(celsiusToKelvin(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[1])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(fahrenheitToCelsius(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(fahrenheitToRankine(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(fahrenheitToReaumur(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(fahrenheitToKelvin(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[2])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(rankineToCelsius(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(rankineToFahrenheit(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(rankineToReaumur(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(rankineToKelvin(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[3])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(reaumurToCelsius(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(reaumurToFahrenheit(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(reaumurToRankine(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(reaumurToKelvin(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[4])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(kelvinToCelsius(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(kelvinToFahrenheit(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(kelvinToRankine(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(kelvinToReaumur(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(tempInput);
                        }
                    }
                }
            }
        });
        cv_toUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(temp_cal.this);
                builder.setTitle("Choose Unit");
                final String[] temp2 = new String[]{
                        "Celsius",
                        "Fahrenheit",
                        "Rankine",
                        "Reaumur",
                        "Kelvin"
                };
                builder.setSingleChoiceItems(
                        temp2,
                        -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String selectedItem = Arrays.asList(temp2).get(i);
                                toUnit = selectedItem;
                                tv_toUnit.setText(toUnit);
                                tv_toUnitCheck.setText(toUnit);
                            }
                        });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        cv_fromUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(temp_cal.this);
                builder.setTitle("Choose Unit");
                final String[] temp2 = new String[]{
                        "Celsius",
                        "Fahrenheit",
                        "Rankine",
                        "Reaumur",
                        "Kelvin"
                };
                builder.setSingleChoiceItems(
                        temp2,
                        -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String selectedItem = Arrays.asList(temp2).get(i);
                                fromUnit = selectedItem;
                                tv_fromUnit.setText(fromUnit);
                            }
                        });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        cv_check.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempInput = et_fromUnit.getText().toString();
                String tempInput2 = et_toUnitCheck.getText().toString();
                if (tempInput.equals("") || isnotNumeric(tempInput) || tempInput2.equals("") || isnotNumeric(tempInput2)) {
                    if (tempInput.equals("")) {
                        et_fromUnit.setError("Please enter some value");
                    } else if (tempInput2.equals("")) {
                        et_toUnitCheck.setError("Please enter some value");
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (tv_fromUnit.getText().toString().equals(values[0])) {
                        if (tv_toUnitCheck.getText().toString().equals(values[0])) {
                            celsiusToCelsiusCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[1])) {
                            celsiusToFahrenheitCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[2])) {
                            celsiusToRankineCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[3])) {
                            celsiusToReaumurCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[4])) {
                            celsiusToKelvinCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[1])) {
                        if (tv_toUnitCheck.getText().toString().equals(values[0])) {
                            fahrenheitToCelsiusCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[1])) {
                            fahrenheitToFahrenheitCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[2])) {
                            fahrenheitToRankineCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[3])) {
                            fahrenheitToReaumurCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[4])) {
                            fahrenheitToKelvinCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[2])) {
                        if (tv_toUnitCheck.getText().toString().equals(values[0])) {
                            rankineToCelsiusCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[1])) {
                            rankineToFahrenheitCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[2])) {
                            rankineToRankineCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[3])) {
                            rankineToReaumurCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[4])) {
                            rankineToKelvinCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[3])) {
                        if (tv_toUnitCheck.getText().toString().equals(values[0])) {
                            reaumurToCelsiusCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[1])) {
                            reaumurToFahrenheitCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[2])) {
                            reaumurToRankineCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[3])) {
                            reaumurToReaumurCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[4])) {
                            reaumurToKelvinCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[4])) {
                        if (tv_toUnitCheck.getText().toString().equals(values[0])) {
                            kelvinToCelsiusCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[1])) {
                            kelvinToFahrenheitCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[2])) {
                            kelvinToRankineCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[3])) {
                            kelvinToReaumurCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[4])) {
                            kelvinToKelvinCheck(Double.parseDouble(tempInput), Double.parseDouble(tempInput2));
                        }
                    }

                }
            }

            //celsius check
            private void celsiusToCelsiusCheck(double celsius, double celsius2) {
                if (String.format("%.3f", celsius).equals(String.format("%.3f", celsius2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", celsius));
                    vibe.vibrate(80);
                }
            }

            private void celsiusToFahrenheitCheck(double celsius, double fahrenheit2) {
                double fahrenheit = (celsius * 9 / 5) + 32;
                if (String.format("%.3f", fahrenheit).equals(String.format("%.3f", fahrenheit2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", fahrenheit));
                    vibe.vibrate(80);
                }
            }

            private void celsiusToRankineCheck(double celsius, double rankine2) {
                double rankine = celsius * 1.8 + 32 + 459.67;
                if (String.format("%.3f", rankine).equals(String.format("%.3f", rankine2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", rankine));
                    vibe.vibrate(80);
                }
            }

            private void celsiusToReaumurCheck(double celsius, double reaumur2) {
                double reaumur = celsius * 0.8;
                if (String.format("%.3f", reaumur).equals(String.format("%.3f", reaumur2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", reaumur));
                    vibe.vibrate(80);
                }
            }

            private void celsiusToKelvinCheck(double celsius, double kelvin2) {
                double kelvin = celsius + 273.15;
                if (String.format("%.3f", kelvin).equals(String.format("%.3f", kelvin2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", kelvin));
                    vibe.vibrate(80);
                }
            }

            //fahrenheit check
            private void fahrenheitToCelsiusCheck(double fahrenheit, double celsius2) {
                double celsius = (fahrenheit - 32) * 5 / 9;
                if (String.format("%.3f", celsius).equals(String.format("%.3f", celsius2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", celsius));
                    vibe.vibrate(80);
                }
            }

            private void fahrenheitToFahrenheitCheck(double fahrenheit, double fahrenheit2) {
                if (String.format("%.3f", fahrenheit).equals(String.format("%.3f", fahrenheit2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", fahrenheit));
                    vibe.vibrate(80);
                }
            }

            private void fahrenheitToRankineCheck(double fahrenheit, double rankine2) {
                double rankine = fahrenheit + 459.67;
                if (String.format("%.3f", rankine).equals(String.format("%.3f", rankine2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", rankine));
                    vibe.vibrate(80);
                }
            }

            private void fahrenheitToReaumurCheck(double fahrenheit, double reaumur2) {
                double reaumur = (fahrenheit - 32) * 0.44444;
                if (String.format("%.3f", reaumur).equals(String.format("%.3f", reaumur2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    //mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", reaumur));
                    vibe.vibrate(80);
                }
            }

            private void fahrenheitToKelvinCheck(double fahrenheit, double kelvin2) {
                double kelvin = 273.5 + ((fahrenheit - 32.0) * (5.0 / 9.0));
                if (String.format("%.3f", kelvin).equals(String.format("%.3f", kelvin2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", kelvin));
                    vibe.vibrate(80);
                }
            }

            //Rankine check
            private void rankineToCelsiusCheck(double rankine, double celsius2) {
                double celsius = (rankine - 491.67) * 5 / 9;
                if (String.format("%.3f", celsius).equals(String.format("%.3f", celsius2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", celsius));
                    vibe.vibrate(80);
                }
            }

            private void rankineToFahrenheitCheck(double rankine, double fahrenheit2) {
                double fahrenheit = rankine - 459.67;
                if (String.format("%.3f", fahrenheit).equals(String.format("%.3f", fahrenheit2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", fahrenheit));
                    vibe.vibrate(80);
                }
            }

            private void rankineToRankineCheck(double rankine, double rankine2) {
                if (String.format("%.3f", rankine).equals(String.format("%.3f", rankine2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", rankine));
                    vibe.vibrate(80);
                }
            }

            private void rankineToReaumurCheck(double rankine, double reaumur2) {
                double reaumur = (rankine - 491.67) * 0.44444;
                if (String.format("%.3f", reaumur).equals(String.format("%.3f", reaumur2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", reaumur));
                    vibe.vibrate(80);
                }
            }

            private void rankineToKelvinCheck(double rankine, double kelvin2) {
                double kelvin = rankine * 5 / 9;
                if (String.format("%.3f", kelvin).equals(String.format("%.3f", kelvin2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", kelvin));
                    vibe.vibrate(80);
                }
            }

            //Reaumur check
            private void reaumurToCelsiusCheck(double reaumur, double celsius2) {
                double celsius = reaumur * 1.25;
                if (String.format("%.3f", celsius).equals(String.format("%.3f", celsius2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", celsius));
                    vibe.vibrate(80);
                }
            }

            private void reaumurToFahrenheitCheck(double reaumur, double fahrenheit2) {
                double fahrenheit = reaumur * 2.2500 + 32;
                if (String.format("%.3f", fahrenheit).equals(String.format("%.3f", fahrenheit2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", fahrenheit));
                    vibe.vibrate(80);
                }
            }

            private void reaumurToRankineCheck(double reaumur, double rankine2) {
                double rankine = reaumur * 2.2500 + 491.67;
                if (String.format("%.3f", rankine).equals(String.format("%.3f", rankine2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", rankine));
                    vibe.vibrate(80);
                }
            }

            private void reaumurToReaumurCheck(double reaumur, double reaumur2) {
                if (String.format("%.3f", reaumur).equals(String.format("%.3f", reaumur2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", reaumur));
                    vibe.vibrate(80);
                }
            }

            private void reaumurToKelvinCheck(double reaumur, double kelvin2) {
                double kelvin = reaumur * 5 / 4 + 273.15;
                if (String.format("%.3f", kelvin).equals(String.format("%.3f", kelvin2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", kelvin));
                    vibe.vibrate(80);
                }
            }

            //Kelvin
            private void kelvinToCelsiusCheck(double kelvin, double celsius2) {
                double celsius = kelvin - 273.15;
                if (String.format("%.3f", celsius).equals(String.format("%.3f", celsius2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", celsius));
                    vibe.vibrate(80);
                }
            }

            private void kelvinToFahrenheitCheck(double kelvin, double fahrenheit2) {
                double fahrenheit = (kelvin - 273.15) * 1.8 + 32;
                if (String.format("%.3f", fahrenheit).equals(String.format("%.3f", fahrenheit2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", fahrenheit));
                    vibe.vibrate(80);
                }
            }

            private void kelvinToRankineCheck(double kelvin, double rankine2) {
                double rankine = kelvin * 9 / 5;
                if (String.format("%.3f", rankine).equals(String.format("%.3f", rankine2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", rankine));
                    vibe.vibrate(80);
                }
            }

            private void kelvinToReaumurCheck(double kelvin, double reaumur2) {
                double reaumur = (kelvin - 273.15) * 0.80000;
                if (String.format("%.3f", reaumur).equals(String.format("%.3f", reaumur2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", reaumur));
                    vibe.vibrate(80);
                }
            }

            private void kelvinToKelvinCheck(double kelvin, double kelvin2) {
                if (String.format("%.3f", kelvin).equals(String.format("%.3f", kelvin2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", kelvin));
                    vibe.vibrate(80);
                }
            }


        });


    }


    //celsius
    private String celsiusToFahrenheit(double celsius) {
        double fahrenheit = (celsius * 9 / 5) + 32;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", fahrenheit);
    }

    private String celsiusToRankine(double celsius) {
        double rankine = celsius * 1.8 + 32 + 459.67;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", rankine);
    }

    private String celsiusToReaumur(double celsius) {
        double reaumur = celsius * 0.8;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", reaumur);
    }

    private String celsiusToKelvin(double celsius) {
        double kelvin = celsius + 273.15;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", kelvin);
    }

    //        fahrenheit
    private String fahrenheitToCelsius(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5 / 9;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", celsius);
    }

    private String fahrenheitToRankine(double fahrenheit) {
        double rankine = fahrenheit + 459.67;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", rankine);
    }

    private String fahrenheitToReaumur(double fahrenheit) {
        double reaumur = (fahrenheit - 32) * 0.44444;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", reaumur);
    }

    private String fahrenheitToKelvin(double fahrenheit) {
        double kelvin = 273.5 + ((fahrenheit - 32.0) * (5.0 / 9.0));
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", kelvin);
    }

    //Rankine
    private String rankineToCelsius(double rankine) {
        double celsius = (rankine - 491.67) * 5 / 9;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", celsius);
    }

    private String rankineToFahrenheit(double rankine) {
        double fahrenheit = rankine - 459.67;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", fahrenheit);
    }

    private String rankineToReaumur(double rankine) {
        double reaumur = (rankine - 491.67) * 0.44444;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", reaumur);
    }

    private String rankineToKelvin(double rankine) {
        double kelvin = rankine * 5 / 9;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", kelvin);
    }

    //Reaumur
    private String reaumurToCelsius(double reaumur) {
        double celsius = reaumur * 1.25;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", celsius);
    }

    private String reaumurToFahrenheit(double reaumur) {
        double fahrenheit = reaumur * 2.2500 + 32;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", fahrenheit);
    }

    private String reaumurToRankine(double reaumur) {
        double rankine = reaumur * 2.2500 + 491.67;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", rankine);
    }

    private String reaumurToKelvin(double reaumur) {
        double kelvin = reaumur * 5 / 4 + 273.15;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", kelvin);
    }

    //Kelvin
    private String kelvinToCelsius(double kelvin) {
        double celsius = kelvin - 273.15;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", celsius);
    }

    private String kelvinToFahrenheit(double kelvin) {
        double fahrenheit = (kelvin - 273.15) * 1.8 + 32;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", fahrenheit);
    }

    private String kelvinToRankine(double kelvin) {
        double rankine = kelvin * 9 / 5;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", rankine);
    }

    private String kelvinToReaumur(double kelvin) {
        double reaumur = (kelvin - 273.15) * 0.80000;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", reaumur);
    }
}

