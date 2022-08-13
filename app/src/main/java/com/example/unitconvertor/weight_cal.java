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

public class weight_cal extends AppCompatActivity {

    final String[] values = new String[]{"Kilogram", "Quintal", "Carat", "Ounce", "Pound"};
    CardView cv_fromUnit, cv_toUnit, cv_convert, cv_check;
    RelativeLayout mCLayout;
    String fromUnit = "Kilogram";
    String toUnit = "Quintal";
    String toUnitCheck = "Quintal";
    TextView tv_fromUnit, tv_toUnit, tv_toUnitCheck;
    EditText et_fromUnit, et_toUnit, et_toUnitCheck;

    public static boolean isnotNumeric3(String weightInput) {
        if (weightInput == null) {
            return true;
        }
        try {
            double d = Double.parseDouble(weightInput);
        } catch (NumberFormatException
                nfe) {
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_cal);
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        cv_fromUnit = findViewById(R.id.fromUnit);
        cv_toUnit = findViewById(R.id.toUnit);
        cv_convert = findViewById(R.id.cv_convert);
        cv_check = findViewById(R.id.cv_check);

        mCLayout = findViewById(R.id.weight_relativeLayout);

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
                String weightInput = et_fromUnit.getText().toString();
                if (weightInput.equals("") || isnotNumeric3(weightInput)) {
                    if (weightInput == null || weightInput.equals("")) {
                        et_fromUnit.setError("Please enter some value");
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (tv_fromUnit.getText().toString().equals(values[0])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(weightInput);
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(kilogramToQuintal(Double.parseDouble(weightInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(kilogramToCarat(Double.parseDouble(weightInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(kilogramToOunce(Double.parseDouble(weightInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(kilogramToPound(Double.parseDouble(weightInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[1])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(quintalToKilogram(Double.parseDouble(weightInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(weightInput);
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(quintalToCarat(Double.parseDouble(weightInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(quintalToOunce(Double.parseDouble(weightInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(quintalToPound(Double.parseDouble(weightInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[2])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(caratToKilogram(Double.parseDouble(weightInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(caratToQuintal(Double.parseDouble(weightInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(weightInput);
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(caratToOunce(Double.parseDouble(weightInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(caratToPound(Double.parseDouble(weightInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[3])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(ounceToKilogram(Double.parseDouble(weightInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(ounceToQuintal(Double.parseDouble(weightInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(ounceToCarat(Double.parseDouble(weightInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(weightInput);
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(ounceToPound(Double.parseDouble(weightInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[4])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(poundToKilogram(Double.parseDouble(weightInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(poundToQuintal(Double.parseDouble(weightInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(poundToCarat(Double.parseDouble(weightInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(poundToOunce(Double.parseDouble(weightInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(weightInput);
                        }
                    }
                }
            }
        });
        cv_toUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(weight_cal.this);
                builder.setTitle("Choose Unit");
                final String[] weight2 = new String[]{
                        "Kilogram",
                        "Quintal",
                        "Carat",
                        "Ounce",
                        "Pound"
                };
                builder.setSingleChoiceItems(
                        weight2,
                        -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String selectedItem = Arrays.asList(weight2).get(i);
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
                final AlertDialog.Builder builder = new AlertDialog.Builder(weight_cal.this);
                builder.setTitle("Choose Unit");
                final String[] weight2 = new String[]{
                        "Kilogram",
                        "Quintal",
                        "Carat",
                        "Ounce",
                        "Pound"
                };
                builder.setSingleChoiceItems(
                        weight2,
                        -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String selectedItem = Arrays.asList(weight2).get(i);
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
                String weightInput = et_fromUnit.getText().toString();
                String weightInput2 = et_toUnitCheck.getText().toString();
                if (weightInput.equals("") || isnotNumeric3(weightInput) || weightInput2.equals("") || isnotNumeric3(weightInput2)) {
                    if (weightInput.equals("")) {
                        et_fromUnit.setError("Please enter some value");
                    } else if (weightInput2.equals("")) {
                        et_toUnitCheck.setError("Please enter some value");
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (tv_fromUnit.getText().toString().equals(values[0])) {
                        if (tv_toUnitCheck.getText().toString().equals(values[0])) {
                            kilogramToKilogramCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[1])) {
                            kilogramToQuintalCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[2])) {
                            kilogramToCaratCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[3])) {
                            kilogramToOunceCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[4])) {
                            kilogramToPoundCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[1])) {
                        if (tv_toUnitCheck.getText().toString().equals(values[0])) {
                            quintalToKilogramCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[1])) {
                            quintalToQuintalCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[2])) {
                            quintalToCaratCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[3])) {
                            quintalToOunceCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[4])) {
                            quintalToPoundCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[2])) {
                        if (tv_toUnitCheck.getText().toString().equals(values[0])) {
                            caratToKilogramCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[1])) {
                            caratToQuintalCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[2])) {
                            caratToCaratCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[3])) {
                            caratToOunceCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[4])) {
                            caratToPoundCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[3])) {
                        if (tv_toUnitCheck.getText().toString().equals(values[0])) {
                            ounceToKilogramCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[1])) {
                            ounceToQuintalCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[2])) {
                            ounceToCaratCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[3])) {
                            ounceToOunceCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[4])) {
                            ounceToPoundCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[4])) {
                        if (tv_toUnitCheck.getText().toString().equals(values[0])) {
                            poundToKilogramCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[1])) {
                            poundToQuintalCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[2])) {
                            poundToCaratCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[3])) {
                            poundToOunceCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[4])) {
                            poundToPoundCheck(Double.parseDouble(weightInput), Double.parseDouble(weightInput2));
                        }
                    }

                }
            }

            //kilogram check
            private void kilogramToKilogramCheck(double kilogram, double kilogram2) {
                if (String.format("%.3f", kilogram).equals(String.format("%.3f", kilogram2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", kilogram));
                    vibe.vibrate(80);
                }
            }

            private void kilogramToQuintalCheck(double kilogram, double quintal2) {
                double quintal = kilogram * 100;
                if (String.format("%.3f", quintal).equals(String.format("%.3f", quintal2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", quintal));
                    vibe.vibrate(80);
                }
            }

            private void kilogramToCaratCheck(double kilogram, double carat2) {
                double carat = kilogram * 5000;
                if (String.format("%.3f", carat).equals(String.format("%.3f", carat2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", carat));
                    vibe.vibrate(80);
                }
            }

            private void kilogramToOunceCheck(double kilogram, double ounce2) {
                double ounce = kilogram * 35.2739619;
                if (String.format("%.3f", ounce).equals(String.format("%.3f", ounce2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", ounce));
                    vibe.vibrate(80);
                }
            }

            private void kilogramToPoundCheck(double kilogram, double pound2) {
                double pound = kilogram * 2.20462262185;
                if (String.format("%.3f", pound).equals(String.format("%.3f", pound2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", pound));
                    vibe.vibrate(80);
                }
            }

            //quintal check
            private void quintalToKilogramCheck(double quintal, double kilogram2) {
                double kilogram = quintal / 100.0;
                if (String.format("%.3f", kilogram).equals(String.format("%.3f", kilogram2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", kilogram));
                    vibe.vibrate(80);
                }
            }

            private void quintalToQuintalCheck(double quintal, double quintal2) {
                if (String.format("%.3f", quintal).equals(String.format("%.3f", quintal2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", quintal));
                    vibe.vibrate(80);
                }
            }

            private void quintalToCaratCheck(double quintal, double carat2) {
                double carat = quintal / 50000.0;
                if (String.format("%.3f", carat).equals(String.format("%.3f", carat2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", carat));
                    vibe.vibrate(80);
                }
            }

            private void quintalToOunceCheck(double quintal, double ounce2) {
                double ounce = quintal * 3527.3961694;
                if (String.format("%.3f", ounce).equals(String.format("%.3f", ounce2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    //mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", ounce));
                    vibe.vibrate(80);
                }
            }

            private void quintalToPoundCheck(double quintal, double pound2) {
                double pound = quintal * 220.46;
                if (String.format("%.3f", pound).equals(String.format("%.3f", pound2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", pound));
                    vibe.vibrate(80);
                }
            }

            //Carat check
            private void caratToKilogramCheck(double carat, double kilogram2) {
                double kilogram = carat / 5000.0;
                if (String.format("%.3f", kilogram).equals(String.format("%.3f", kilogram2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", kilogram));
                    vibe.vibrate(80);
                }
            }

            private void caratToQuintalCheck(double carat, double quintal2) {
                double quintal = carat / 50000.0;
                if (String.format("%.3f", quintal).equals(String.format("%.3f", quintal2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", quintal));
                    vibe.vibrate(80);
                }
            }

            private void caratToCaratCheck(double carat, double carat2) {
                if (String.format("%.3f", carat).equals(String.format("%.3f", carat2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", carat));
                    vibe.vibrate(80);
                }
            }

            private void caratToOunceCheck(double carat, double ounce2) {
                double ounce = carat * 0.007055;
                if (String.format("%.3f", ounce).equals(String.format("%.3f", ounce2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", ounce));
                    vibe.vibrate(80);
                }
            }

            private void caratToPoundCheck(double carat, double pound2) {
                double pound = carat * 0.000441;
                if (String.format("%.3f", pound).equals(String.format("%.3f", pound2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", pound));
                    vibe.vibrate(80);
                }
            }

            //Ounce check
            private void ounceToKilogramCheck(double ounce, double kilogram2) {
                double kilogram = ounce / 2.20462262185;
                if (String.format("%.3f", kilogram).equals(String.format("%.3f", kilogram2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", kilogram));
                    vibe.vibrate(80);
                }
            }

            private void ounceToQuintalCheck(double ounce, double quintal2) {
                double quintal = ounce / 3527.3961694;
                if (String.format("%.3f", quintal).equals(String.format("%.3f", quintal2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", quintal));
                    vibe.vibrate(80);
                }
            }

            private void ounceToCaratCheck(double ounce, double carat2) {
                double carat = ounce / 0.007055;
                if (String.format("%.3f", carat).equals(String.format("%.3f", carat2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", carat));
                    vibe.vibrate(80);
                }
            }

            private void ounceToOunceCheck(double ounce, double ounce2) {
                if (String.format("%.3f", ounce).equals(String.format("%.3f", ounce2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", ounce));
                    vibe.vibrate(80);
                }
            }

            private void ounceToPoundCheck(double ounce, double pound2) {
                double pound = ounce * 0.062500;
                if (String.format("%.3f", pound).equals(String.format("%.3f", pound2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", pound));
                    vibe.vibrate(80);
                }
            }

            //Pound
            private void poundToKilogramCheck(double pound, double kilogram2) {
                double kilogram = pound / 2.20462262185;
                if (String.format("%.3f", kilogram).equals(String.format("%.3f", kilogram2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", kilogram));
                    vibe.vibrate(80);
                }
            }

            private void poundToQuintalCheck(double pound, double quintal2) {
                double quintal = pound / 220.46;
                if (String.format("%.3f", quintal).equals(String.format("%.3f", quintal2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", quintal));
                    vibe.vibrate(80);
                }
            }

            private void poundToCaratCheck(double pound, double carat2) {
                double carat = pound / 0.000441;
                if (String.format("%.3f", carat).equals(String.format("%.3f", carat2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", carat));
                    vibe.vibrate(80);
                }
            }

            private void poundToOunceCheck(double pound, double ounce2) {
                double ounce = pound * 0.007055;
                if (String.format("%.3f", ounce).equals(String.format("%.3f", ounce2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", ounce));
                    vibe.vibrate(80);
                }
            }

            private void poundToPoundCheck(double pound, double pound2) {
                if (String.format("%.3f", pound).equals(String.format("%.3f", pound2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", pound));
                    vibe.vibrate(80);
                }
            }


        });


    }


    //kilogram
    private String kilogramToQuintal(double kilogram) {
        double quintal = kilogram * 100.0;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", quintal);
    }

    private String kilogramToCarat(double kilogram) {
        double carat = kilogram * 5000.0;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", carat);
    }

    private String kilogramToOunce(double kilogram) {
        double ounce = kilogram * 35.2739619;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", ounce);
    }

    private String kilogramToPound(double kilogram) {
        double pound = kilogram * 2.20462262185;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", pound);
    }

    //        quintal
    private String quintalToKilogram(double quintal) {
        double kilogram = quintal / 100.0;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", kilogram);
    }

    private String quintalToCarat(double quintal) {
        double carat = quintal / 50000.0;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", carat);
    }

    private String quintalToOunce(double quintal) {
        double ounce = quintal * 3527.3961694;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", ounce);
    }

    private String quintalToPound(double quintal) {
        double pound = quintal * 220.46;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", pound);
    }

    //Carat
    private String caratToKilogram(double carat) {
        double kilogram = carat / 5000.0;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", kilogram);
    }

    private String caratToQuintal(double carat) {
        double quintal = carat / 50000.0;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", quintal);
    }

    private String caratToOunce(double carat) {
        double ounce = carat * 0.007055;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", ounce);
    }

    private String caratToPound(double carat) {
        double pound = carat * 0.000441;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", pound);
    }

    //Ounce
    private String ounceToKilogram(double ounce) {
        double kilogram = ounce / 2.20462262185;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", kilogram);
    }

    private String ounceToQuintal(double ounce) {
        double quintal = ounce / 3527.3961694;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", quintal);
    }

    private String ounceToCarat(double ounce) {
        double carat = ounce / 0.007055;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", carat);
    }

    private String ounceToPound(double ounce) {
        double pound = ounce * 0.062500;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", pound);
    }

    //Pound
    private String poundToKilogram(double pound) {
        double kilogram = pound / 2.20462262185;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", kilogram);
    }

    private String poundToQuintal(double pound) {
        double quintal = pound / 220.46;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", quintal);
    }

    private String poundToCarat(double pound) {
        double carat = pound / 0.000441;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", carat);
    }

    private String poundToOunce(double pound) {
        double ounce = pound * 0.007055;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", ounce);
    }
}