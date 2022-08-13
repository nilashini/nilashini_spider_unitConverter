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

public class length_cal extends AppCompatActivity {

    final String[] values = new String[]{"Meter", "Mile", "Yard", "Inch", "Foot"};
    CardView cv_fromUnit, cv_toUnit, cv_convert, cv_check;
    RelativeLayout mCLayout;
    String fromUnit = "Meter";
    String toUnit = "Mile";
    String toUnitCheck = "Mile";
    TextView tv_fromUnit, tv_toUnit, tv_toUnitCheck;
    EditText et_fromUnit, et_toUnit, et_toUnitCheck;

    public static boolean isnotNumeric2(String lengthInput) {
        if (lengthInput == null) {
            return true;
        }
        try {
            double d = Double.parseDouble(lengthInput);
        } catch (NumberFormatException
                nfe) {
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_cal);
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        cv_fromUnit = findViewById(R.id.fromUnit);
        cv_toUnit = findViewById(R.id.toUnit);
        cv_convert = findViewById(R.id.cv_convert);
        cv_check = findViewById(R.id.cv_check);

        mCLayout = findViewById(R.id.length_relativeLayout);

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
                String lengthInput = et_fromUnit.getText().toString();
                if (lengthInput.equals("") || isnotNumeric2(lengthInput)) {
                    if (lengthInput == null || lengthInput.equals("")) {
                        et_fromUnit.setError("Please enter some value");
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (tv_fromUnit.getText().toString().equals(values[0])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(lengthInput);
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(meterToMile(Double.parseDouble(lengthInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(meterToYard(Double.parseDouble(lengthInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(meterToInch(Double.parseDouble(lengthInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(meterToFoot(Double.parseDouble(lengthInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[1])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(mileToMeter(Double.parseDouble(lengthInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(lengthInput);
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(mileToYard(Double.parseDouble(lengthInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(mileToInch(Double.parseDouble(lengthInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(mileToFoot(Double.parseDouble(lengthInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[2])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(yardToMeter(Double.parseDouble(lengthInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(yardToMile(Double.parseDouble(lengthInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(lengthInput);
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(yardToInch(Double.parseDouble(lengthInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(yardToFoot(Double.parseDouble(lengthInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[3])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(inchToMeter(Double.parseDouble(lengthInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(inchToMile(Double.parseDouble(lengthInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(inchToYard(Double.parseDouble(lengthInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(lengthInput);
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(inchToFoot(Double.parseDouble(lengthInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[4])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(footToMeter(Double.parseDouble(lengthInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(footToMile(Double.parseDouble(lengthInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(footToYard(Double.parseDouble(lengthInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(footToInch(Double.parseDouble(lengthInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(lengthInput);
                        }
                    }
                }
            }
        });
        cv_toUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(length_cal.this);
                builder.setTitle("Choose Unit");
                final String[] length2 = new String[]{
                        "Meter",
                        "Mile",
                        "Yard",
                        "Inch",
                        "Foot"
                };
                builder.setSingleChoiceItems(
                        length2,
                        -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String selectedItem = Arrays.asList(length2).get(i);
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
                final AlertDialog.Builder builder = new AlertDialog.Builder(length_cal.this);
                builder.setTitle("Choose Unit");
                final String[] length2 = new String[]{
                        "Meter",
                        "Mile",
                        "Yard",
                        "Inch",
                        "Foot"
                };
                builder.setSingleChoiceItems(
                        length2,
                        -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String selectedItem = Arrays.asList(length2).get(i);
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
                String lengthInput = et_fromUnit.getText().toString();
                String lengthInput2 = et_toUnitCheck.getText().toString();
                if (lengthInput.equals("") || isnotNumeric2(lengthInput) || lengthInput2.equals("") || isnotNumeric2(lengthInput2)) {
                    if (lengthInput.equals("")) {
                        et_fromUnit.setError("Please enter some value");
                    } else if (lengthInput2.equals("")) {
                        et_toUnitCheck.setError("Please enter some value");
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (tv_fromUnit.getText().toString().equals(values[0])) {
                        if (tv_toUnitCheck.getText().toString().equals(values[0])) {
                            meterToMeterCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[1])) {
                            meterToMileCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[2])) {
                            meterToYardCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[3])) {
                            meterToInchCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[4])) {
                            meterToFootCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[1])) {
                        if (tv_toUnitCheck.getText().toString().equals(values[0])) {
                            mileToMeterCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[1])) {
                            mileToMileCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[2])) {
                            mileToYardCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[3])) {
                            mileToInchCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[4])) {
                            mileToFootCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[2])) {
                        if (tv_toUnitCheck.getText().toString().equals(values[0])) {
                            yardToMeterCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[1])) {
                            yardToMileCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[2])) {
                            yardToYardCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[3])) {
                            yardToInchCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[4])) {
                            yardToFootCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[3])) {
                        if (tv_toUnitCheck.getText().toString().equals(values[0])) {
                            inchToMeterCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[1])) {
                            inchToMileCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[2])) {
                            inchToYardCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[3])) {
                            inchToInchCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[4])) {
                            inchToFootCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[4])) {
                        if (tv_toUnitCheck.getText().toString().equals(values[0])) {
                            footToMeterCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[1])) {
                            footToMileCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[2])) {
                            footToYardCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[3])) {
                            footToInchCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[4])) {
                            footToFootCheck(Double.parseDouble(lengthInput), Double.parseDouble(lengthInput2));
                        }
                    }

                }
            }

            //meter check
            private void meterToMeterCheck(double meter, double meter2) {
                if (String.format("%.3f", meter).equals(String.format("%.3f", meter2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", meter));
                    vibe.vibrate(80);
                }
            }

            private void meterToMileCheck(double meter, double mile2) {
                double mile = meter / 1609.34400;
                if (String.format("%.3f", mile).equals(String.format("%.3f", mile2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", mile));
                    vibe.vibrate(80);
                }
            }

            private void meterToYardCheck(double meter, double yard2) {
                double yard = meter * 1.90361;
                if (String.format("%.3f", yard).equals(String.format("%.3f", yard2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", yard));
                    vibe.vibrate(80);
                }
            }

            private void meterToInchCheck(double meter, double inch2) {
                double inch = meter * 39.37007;
                if (String.format("%.3f", inch).equals(String.format("%.3f", inch2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", inch));
                    vibe.vibrate(80);
                }
            }

            private void meterToFootCheck(double meter, double foot2) {
                double foot = meter * 3.28084;
                if (String.format("%.3f", foot).equals(String.format("%.3f", foot2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", foot));
                    vibe.vibrate(80);
                }
            }

            //mile check
            private void mileToMeterCheck(double mile, double meter2) {
                double meter = mile * 1609.34400;
                if (String.format("%.3f", meter).equals(String.format("%.3f", meter2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", meter));
                    vibe.vibrate(80);
                }
            }

            private void mileToMileCheck(double mile, double mile2) {
                if (String.format("%.3f", mile).equals(String.format("%.3f", mile2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", mile));
                    vibe.vibrate(80);
                }
            }

            private void mileToYardCheck(double mile, double yard2) {
                double yard = mile * 1760.00000;
                if (String.format("%.3f", yard).equals(String.format("%.3f", yard2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", yard));
                    vibe.vibrate(80);
                }
            }

            private void mileToInchCheck(double mile, double inch2) {
                double inch = mile * 63360.00000;
                if (String.format("%.3f", inch).equals(String.format("%.3f", inch2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    //mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", inch));
                    vibe.vibrate(80);
                }
            }

            private void mileToFootCheck(double mile, double foot2) {
                double foot = mile * 5280.00000;
                if (String.format("%.3f", foot).equals(String.format("%.3f", foot2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", foot));
                    vibe.vibrate(80);
                }
            }

            //Yard check
            private void yardToMeterCheck(double yard, double meter2) {
                double meter = yard / 1.09361;
                if (String.format("%.3f", meter).equals(String.format("%.3f", meter2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", meter));
                    vibe.vibrate(80);
                }
            }

            private void yardToMileCheck(double yard, double mile2) {
                double mile = yard / 1760.00000;
                if (String.format("%.3f", mile).equals(String.format("%.3f", mile2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", mile));
                    vibe.vibrate(80);
                }
            }

            private void yardToYardCheck(double yard, double yard2) {
                if (String.format("%.3f", yard).equals(String.format("%.3f", yard2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", yard));
                    vibe.vibrate(80);
                }
            }

            private void yardToInchCheck(double yard, double inch2) {
                double inch = yard * 36.00000;
                if (String.format("%.3f", inch).equals(String.format("%.3f", inch2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", inch));
                    vibe.vibrate(80);
                }
            }

            private void yardToFootCheck(double yard, double foot2) {
                double foot = yard * 3.00000;
                if (String.format("%.3f", foot).equals(String.format("%.3f", foot2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", foot));
                    vibe.vibrate(80);
                }
            }

            //Inch check
            private void inchToMeterCheck(double inch, double meter2) {
                double meter = inch / 39.37007;
                if (String.format("%.3f", meter).equals(String.format("%.3f", meter2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", meter));
                    vibe.vibrate(80);
                }
            }

            private void inchToMileCheck(double inch, double mile2) {
                double mile = inch / 63360.00000;
                if (String.format("%.3f", mile).equals(String.format("%.3f", mile2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", mile));
                    vibe.vibrate(80);
                }
            }

            private void inchToYardCheck(double inch, double yard2) {
                double yard = inch / 36.00000;
                if (String.format("%.3f", yard).equals(String.format("%.3f", yard2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", yard));
                    vibe.vibrate(80);
                }
            }

            private void inchToInchCheck(double inch, double inch2) {
                if (String.format("%.3f", inch).equals(String.format("%.3f", inch2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", inch));
                    vibe.vibrate(80);
                }
            }

            private void inchToFootCheck(double inch, double foot2) {
                double foot = inch / 12.00000;
                if (String.format("%.3f", foot).equals(String.format("%.3f", foot2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", foot));
                    vibe.vibrate(80);
                }
            }

            //Foot
            private void footToMeterCheck(double foot, double meter2) {
                double meter = foot / 3.28084;
                if (String.format("%.3f", meter).equals(String.format("%.3f", meter2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", meter));
                    vibe.vibrate(80);
                }
            }

            private void footToMileCheck(double foot, double mile2) {
                double mile = foot / 5280.00000;
                if (String.format("%.3f", mile).equals(String.format("%.3f", mile2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", mile));
                    vibe.vibrate(80);
                }
            }

            private void footToYardCheck(double foot, double yard2) {
                double yard = foot / 3.00000;
                if (String.format("%.3f", yard).equals(String.format("%.3f", yard2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", yard));
                    vibe.vibrate(80);
                }
            }

            private void footToInchCheck(double foot, double inch2) {
                double inch = foot * 12.0000;
                if (String.format("%.3f", inch).equals(String.format("%.3f", inch2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", inch));
                    vibe.vibrate(80);
                }
            }

            private void footToFootCheck(double foot, double foot2) {
                if (String.format("%.3f", foot).equals(String.format("%.3f", foot2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", foot));
                    vibe.vibrate(80);
                }
            }


        });


    }


    //meter
    private String meterToMile(double meter) {
        double mile = meter / 1609.34400;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", mile);
    }

    private String meterToYard(double meter) {
        double yard = meter * 1.90361;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", yard);
    }

    private String meterToInch(double meter) {
        double inch = meter * 39.37007;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", inch);
    }

    private String meterToFoot(double meter) {
        double foot = meter * 3.28084;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", foot);
    }

    //        mile
    private String mileToMeter(double mile) {
        double meter = mile * 1609.34400;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", meter);
    }

    private String mileToYard(double mile) {
        double yard = mile * 1760.00000;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", yard);
    }

    private String mileToInch(double mile) {
        double inch = mile * 63360.00000;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", inch);
    }

    private String mileToFoot(double mile) {
        double foot = mile * 5280.00000;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", foot);
    }

    //Yard
    private String yardToMeter(double yard) {
        double meter = yard / 1.09361;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", meter);
    }

    private String yardToMile(double yard) {
        double mile = yard / 1760.00000;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", mile);
    }

    private String yardToInch(double yard) {
        double inch = yard * 36.00000;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", inch);
    }

    private String yardToFoot(double yard) {
        double foot = yard * 3.00000;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", foot);
    }

    //Inch
    private String inchToMeter(double inch) {
        double meter = inch / 39.37007;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", meter);
    }

    private String inchToMile(double inch) {
        double mile = inch / 63360.00000;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", mile);
    }

    private String inchToYard(double inch) {
        double yard = inch / 36.00000;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", yard);
    }

    private String inchToFoot(double inch) {
        double foot = inch / 12.00000;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", foot);
    }

    //Foot
    private String footToMeter(double foot) {
        double meter = foot / 3.28084;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", meter);
    }

    private String footToMile(double foot) {
        double mile = foot / 5280.00000;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", mile);
    }

    private String footToYard(double foot) {
        double yard = foot / 3.00000;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", yard);
    }

    private String footToInch(double foot) {
        double inch = foot * 12.0000;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", inch);
    }
}
