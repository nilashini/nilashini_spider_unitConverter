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

public class speed_cal extends AppCompatActivity {

    final String[] values = new String[]{"MeterPerSecond", "KilometerPerHour", "MilePerHour","InchPerSecond","KilometerPerSecond" };
    CardView cv_fromUnit, cv_toUnit, cv_convert, cv_check;
    RelativeLayout mCLayout;
    String fromUnit = "MeterPerSecond";
    String toUnit = "KilometerPerHour";
    String toUnitCheck = "KilometerPerHour";
    TextView tv_fromUnit, tv_toUnit, tv_toUnitCheck;
    EditText et_fromUnit, et_toUnit, et_toUnitCheck;

    public static boolean isnotNumeric4(String speedInput) {
        if (speedInput == null) {
            return true;
        }
        try {
            double d = Double.parseDouble(speedInput);
        } catch (NumberFormatException
                nfe) {
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_cal);
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        cv_fromUnit = findViewById(R.id.fromUnit);
        cv_toUnit = findViewById(R.id.toUnit);
        cv_convert = findViewById(R.id.cv_convert);
        cv_check = findViewById(R.id.cv_check);

        mCLayout = findViewById(R.id.speed_relativeLayout);

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
                String speedInput = et_fromUnit.getText().toString();
                if (speedInput.equals("") || isnotNumeric4(speedInput)) {
                    if (speedInput == null || speedInput.equals("")) {
                        et_fromUnit.setError("Please enter some value");
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (tv_fromUnit.getText().toString().equals(values[0])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(speedInput);
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(meterPerSecondToKilometerPerHour(Double.parseDouble(speedInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(meterPerSecondToMilePerHour(Double.parseDouble(speedInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(meterPerSecondToInchPerSecond(Double.parseDouble(speedInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(meterPerSecondToKilometerPerSecond(Double.parseDouble(speedInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[1])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(kilometerPerHourToMeterPerSecond(Double.parseDouble(speedInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(speedInput);
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(kilometerPerHourToMilePerHour(Double.parseDouble(speedInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(kilometerPerHourToInchPerSecond(Double.parseDouble(speedInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(kilometerPerHourToKilometerPerSecond(Double.parseDouble(speedInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[2])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(milePerHourToMeterPerSecond(Double.parseDouble(speedInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(milePerHourToKilometerPerHour(Double.parseDouble(speedInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(speedInput);
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(milePerHourToInchPerSecond(Double.parseDouble(speedInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(milePerHourToKilometerPerSecond(Double.parseDouble(speedInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[3])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(inchPerSecondToMeterPerSecond(Double.parseDouble(speedInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(inchPerSecondToKilometerPerHour(Double.parseDouble(speedInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(inchPerSecondToMilePerHour(Double.parseDouble(speedInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(speedInput);
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(inchPerSecondToKilometerPerSecond(Double.parseDouble(speedInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[4])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(kilometerPerSecondToMeterPerSecond(Double.parseDouble(speedInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(kilometerPerSecondToKilometerPerHour(Double.parseDouble(speedInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(kilometerPerSecondToMilePerHour(Double.parseDouble(speedInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(kilometerPerSecondToInchPerSecond(Double.parseDouble(speedInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(speedInput);
                        }
                    }
                }
            }
        });
        cv_toUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(speed_cal.this);
                builder.setTitle("Choose Unit");
                final String[] speed2 = new String[]{
                        "MeterPerSecond",
                        "KilometerPerHour",
                        "MilePerHour",
                        "InchPerSecond",
                        "KilometerPerSecond"
                };
                builder.setSingleChoiceItems(
                        speed2,
                        -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String selectedItem = Arrays.asList(speed2).get(i);
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
                final AlertDialog.Builder builder = new AlertDialog.Builder(speed_cal.this);
                builder.setTitle("Choose Unit");
                final String[] speed2 = new String[]{
                        "MeterPerSecond",
                        "KilometerPerHour",
                        "MilePerHour",
                        "InchPerSecond",
                        "KilometerPerSecond"
                };
                builder.setSingleChoiceItems(
                        speed2,
                        -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String selectedItem = Arrays.asList(speed2).get(i);
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
                String speedInput = et_fromUnit.getText().toString();
                String speedInput2 = et_toUnitCheck.getText().toString();
                if (speedInput.equals("") || isnotNumeric4(speedInput) || speedInput2.equals("") || isnotNumeric4(speedInput2)) {
                    if (speedInput.equals("")) {
                        et_fromUnit.setError("Please enter some value");
                    } else if (speedInput2.equals("")) {
                        et_toUnitCheck.setError("Please enter some value");
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (tv_fromUnit.getText().toString().equals(values[0])) {
                        if (tv_toUnitCheck.getText().toString().equals(values[0])) {
                            meterPerSecondToMeterPerSecondCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[1])) {
                            meterPerSecondToKilometerPerHourCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[2])) {
                            meterPerSecondToMilePerHourCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[3])) {
                            meterPerSecondToInchPerSecondCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[4])) {
                            meterPerSecondToKilometerPerSecondCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[1])) {
                        if (tv_toUnitCheck.getText().toString().equals(values[0])) {
                            kilometerPerHourToMeterPerSecondCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[1])) {
                            kilometerPerHourToKilometerPerHourCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[2])) {
                            kilometerPerHourToMilePerHourCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[3])) {
                            kilometerPerHourToInchPerSecondCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[4])) {
                            kilometerPerHourToKilometerPerSecondCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[2])) {
                        if (tv_toUnitCheck.getText().toString().equals(values[0])) {
                            milePerHourToMeterPerSecondCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[1])) {
                            milePerHourToKilometerPerHourCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[2])) {
                            milePerHourToMilePerHourCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[3])) {
                            milePerHourToInchPerSecondCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[4])) {
                            milePerHourToKilometerPerSecondCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[3])) {
                        if (tv_toUnitCheck.getText().toString().equals(values[0])) {
                            inchPerSecondToMeterPerSecondCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[1])) {
                            inchPerSecondToKilometerPerHourCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[2])) {
                            inchPerSecondToMilePerHourCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[3])) {
                            inchPerSecondToInchPerSecondCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[4])) {
                            inchPerSecondToKilometerPerSecondCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[4])) {
                        if (tv_toUnitCheck.getText().toString().equals(values[0])) {
                            kilometerPerSecondToMeterPerSecondCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[1])) {
                            kilometerPerSecondToKilometerPerHourCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[2])) {
                            kilometerPerSecondToMilePerHourCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[3])) {
                            kilometerPerSecondToInchPerSecondCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        } else if (tv_toUnitCheck.getText().toString().equals(values[4])) {
                            kilometerPerSecondToKilometerPerSecondCheck(Double.parseDouble(speedInput), Double.parseDouble(speedInput2));
                        }
                    }

                }
            }

            //meterPerSecond check
            private void meterPerSecondToMeterPerSecondCheck(double meterPerSecond, double meterPerSecond2) {
                if (String.format("%.3f", meterPerSecond).equals(String.format("%.3f", meterPerSecond2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", meterPerSecond));
                    vibe.vibrate(80);
                }
            }

            private void meterPerSecondToKilometerPerHourCheck(double meterPerSecond, double kilometerPerHour2) {
                double kilometerPerHour = meterPerSecond * 3.60000;
                if (String.format("%.3f", kilometerPerHour).equals(String.format("%.3f", kilometerPerHour2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", kilometerPerHour));
                    vibe.vibrate(80);
                }
            }

            private void meterPerSecondToMilePerHourCheck(double meterPerSecond, double milePerHour2) {
                double milePerHour = meterPerSecond * 2.236936;
                if (String.format("%.3f", milePerHour).equals(String.format("%.3f", milePerHour2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", milePerHour));
                    vibe.vibrate(80);
                }
            }

            private void meterPerSecondToInchPerSecondCheck(double meterPerSecond, double inchPerSecond2) {
                double inchPerSecond = meterPerSecond * 39.37000;
                if (String.format("%.3f", inchPerSecond).equals(String.format("%.3f", inchPerSecond2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", inchPerSecond));
                    vibe.vibrate(80);
                }
            }

            private void meterPerSecondToKilometerPerSecondCheck(double meterPerSecond, double kilometerPerSecond2) {
                double kilometerPerSecond = meterPerSecond / 1000.00000;
                if (String.format("%.3f", kilometerPerSecond).equals(String.format("%.3f", kilometerPerSecond2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", kilometerPerSecond));
                    vibe.vibrate(80);
                }
            }

            //kilometerPerHour check
            private void kilometerPerHourToMeterPerSecondCheck(double kilometerPerHour, double meterPerSecond2) {
                double meterPerSecond = kilometerPerHour / 3.60000;
                if (String.format("%.3f", meterPerSecond).equals(String.format("%.3f", meterPerSecond2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", meterPerSecond));
                    vibe.vibrate(80);
                }
            }

            private void kilometerPerHourToKilometerPerHourCheck(double kilometerPerHour, double kilometerPerHour2) {
                if (String.format("%.3f", kilometerPerHour).equals(String.format("%.3f", kilometerPerHour2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", kilometerPerHour));
                    vibe.vibrate(80);
                }
            }

            private void kilometerPerHourToMilePerHourCheck(double kilometerPerHour, double milePerHour2) {
                double milePerHour = kilometerPerHour * 0.6213711;
                if (String.format("%.3f", milePerHour).equals(String.format("%.3f", milePerHour2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", milePerHour));
                    vibe.vibrate(80);
                }
            }

            private void kilometerPerHourToInchPerSecondCheck(double kilometerPerHour, double inchPerSecond2) {
                double inchPerSecond = kilometerPerHour * 10.936132;
                if (String.format("%.3f", inchPerSecond).equals(String.format("%.3f", inchPerSecond2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    //mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", inchPerSecond));
                    vibe.vibrate(80);
                }
            }

            private void kilometerPerHourToKilometerPerSecondCheck(double kilometerPerHour, double kilometerPerSecond2) {
                double kilometerPerSecond = kilometerPerHour / 3600.00000;
                if (String.format("%.3f", kilometerPerSecond).equals(String.format("%.3f", kilometerPerSecond2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", kilometerPerSecond));
                    vibe.vibrate(80);
                }
            }

            //MilePerHour check
            private void milePerHourToMeterPerSecondCheck(double milePerHour, double meterPerSecond2) {
                double meterPerSecond = milePerHour / 2.236936;
                if (String.format("%.3f", meterPerSecond).equals(String.format("%.3f", meterPerSecond2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", meterPerSecond));
                    vibe.vibrate(80);
                }
            }

            private void milePerHourToKilometerPerHourCheck(double milePerHour, double kilometerPerHour2) {
                double kilometerPerHour = milePerHour / 0.6213711;
                if (String.format("%.3f", kilometerPerHour).equals(String.format("%.3f", kilometerPerHour2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", kilometerPerHour));
                    vibe.vibrate(80);
                }
            }

            private void milePerHourToMilePerHourCheck(double milePerHour, double milePerHour2) {
                if (String.format("%.3f", milePerHour).equals(String.format("%.3f", milePerHour2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", milePerHour));
                    vibe.vibrate(80);
                }
            }

            private void milePerHourToInchPerSecondCheck(double milePerHour, double inchPerSecond2) {
                double inchPerSecond = milePerHour * 17.60000;
                if (String.format("%.3f", inchPerSecond).equals(String.format("%.3f", inchPerSecond2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", inchPerSecond));
                    vibe.vibrate(80);
                }
            }

            private void milePerHourToKilometerPerSecondCheck(double milePerHour, double kilometerPerSecond2) {
                double kilometerPerSecond = milePerHour * 0.000447;
                if (String.format("%.3f", kilometerPerSecond).equals(String.format("%.3f", kilometerPerSecond2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", kilometerPerSecond));
                    vibe.vibrate(80);
                }
            }

            //InchPerSecond check
            private void inchPerSecondToMeterPerSecondCheck(double inchPerSecond, double meterPerSecond2) {
                double meterPerSecond = inchPerSecond / 39.37;
                if (String.format("%.3f", meterPerSecond).equals(String.format("%.3f", meterPerSecond2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", meterPerSecond));
                    vibe.vibrate(80);
                }
            }

            private void inchPerSecondToKilometerPerHourCheck(double inchPerSecond, double kilometerPerHour2) {
                double kilometerPerHour = inchPerSecond / 10.936132;
                if (String.format("%.3f", kilometerPerHour).equals(String.format("%.3f", kilometerPerHour2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", kilometerPerHour));
                    vibe.vibrate(80);
                }
            }

            private void inchPerSecondToMilePerHourCheck(double inchPerSecond, double milePerHour2) {
                double milePerHour = inchPerSecond / 17.60000;
                if (String.format("%.3f", milePerHour).equals(String.format("%.3f", milePerHour2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", milePerHour));
                    vibe.vibrate(80);
                }
            }

            private void inchPerSecondToInchPerSecondCheck(double inchPerSecond, double inchPerSecond2) {
                if (String.format("%.3f", inchPerSecond).equals(String.format("%.3f", inchPerSecond2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", inchPerSecond));
                    vibe.vibrate(80);
                }
            }

            private void inchPerSecondToKilometerPerSecondCheck(double inchPerSecond, double kilometerPerSecond2) {
                double kilometerPerSecond = inchPerSecond * 0.0000254;
                if (String.format("%.3f", kilometerPerSecond).equals(String.format("%.3f", kilometerPerSecond2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", kilometerPerSecond));
                    vibe.vibrate(80);
                }
            }

            //KilometerPerSecond
            private void kilometerPerSecondToMeterPerSecondCheck(double kilometerPerSecond, double meterPerSecond2) {
                double meterPerSecond = kilometerPerSecond * 1000.000;
                if (String.format("%.3f", meterPerSecond).equals(String.format("%.3f", meterPerSecond2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", meterPerSecond));
                    vibe.vibrate(80);
                }
            }

            private void kilometerPerSecondToKilometerPerHourCheck(double kilometerPerSecond, double kilometerPerHour2) {
                double kilometerPerHour = kilometerPerSecond * 3600.00000;
                if (String.format("%.3f", kilometerPerHour).equals(String.format("%.3f", kilometerPerHour2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", kilometerPerHour));
                    vibe.vibrate(80);
                }
            }

            private void kilometerPerSecondToMilePerHourCheck(double kilometerPerSecond, double milePerHour2) {
                double milePerHour = kilometerPerSecond / 0.000447;
                if (String.format("%.3f", milePerHour).equals(String.format("%.3f", milePerHour2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", milePerHour));
                    vibe.vibrate(80);
                }
            }

            private void kilometerPerSecondToInchPerSecondCheck(double kilometerPerSecond, double inchPerSecond2) {
                double inchPerSecond = kilometerPerSecond / 0.0000254;
                if (String.format("%.3f", inchPerSecond).equals(String.format("%.3f", inchPerSecond2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", inchPerSecond));
                    vibe.vibrate(80);
                }
            }

            private void kilometerPerSecondToKilometerPerSecondCheck(double kilometerPerSecond, double kilometerPerSecond2) {
                if (String.format("%.3f", kilometerPerSecond).equals(String.format("%.3f", kilometerPerSecond2))) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.GREEN);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    mCLayout.setBackgroundColor(Color.RED);
                    et_toUnit.setText(String.format("%.3f", kilometerPerSecond));
                    vibe.vibrate(80);
                }
            }


        });


    }


    //meterPerSecond
    private String meterPerSecondToKilometerPerHour(double meterPerSecond) {
        double kilometerPerHour = meterPerSecond * 3.6;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", kilometerPerHour);
    }

    private String meterPerSecondToMilePerHour(double meterPerSecond) {
        double milePerHour = meterPerSecond * 2.236936;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", milePerHour);
    }

    private String meterPerSecondToInchPerSecond(double meterPerSecond) {
        double inchPerSecond = meterPerSecond * 39.37;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", inchPerSecond);
    }

    private String meterPerSecondToKilometerPerSecond(double meterPerSecond) {
        double kilometerPerSecond = meterPerSecond / 1000.00000;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", kilometerPerSecond);
    }

    //        kilometerPerHour
    private String kilometerPerHourToMeterPerSecond(double kilometerPerHour) {
        double meterPerSecond = kilometerPerHour / 3.60000;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", meterPerSecond);
    }

    private String kilometerPerHourToMilePerHour(double kilometerPerHour) {
        double milePerHour = kilometerPerHour * 0.6213711;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", milePerHour);
    }

    private String kilometerPerHourToInchPerSecond(double kilometerPerHour) {
        double inchPerSecond = kilometerPerHour * 10.936132;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", inchPerSecond);
    }

    private String kilometerPerHourToKilometerPerSecond(double kilometerPerHour) {
        double kilometerPerSecond = kilometerPerHour / 3600.00000;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", kilometerPerSecond);
    }

    //MilePerHour
    private String milePerHourToMeterPerSecond(double milePerHour) {
        double meterPerSecond = milePerHour / 2.236936;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", meterPerSecond);
    }

    private String milePerHourToKilometerPerHour(double milePerHour) {
        double kilometerPerHour = milePerHour / 0.6213711;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", kilometerPerHour);
    }

    private String milePerHourToInchPerSecond(double milePerHour) {
        double inchPerSecond = milePerHour * 17.60000;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", inchPerSecond);
    }

    private String milePerHourToKilometerPerSecond(double milePerHour) {
        double kilometerPerSecond = milePerHour * 0.000447;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", kilometerPerSecond);
    }

    //InchPerSecond
    private String inchPerSecondToMeterPerSecond(double inchPerSecond) {
        double meterPerSecond = inchPerSecond / 39.37;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", meterPerSecond);
    }

    private String inchPerSecondToKilometerPerHour(double inchPerSecond) {
        double kilometerPerHour = inchPerSecond / 10.936132;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", kilometerPerHour);
    }

    private String inchPerSecondToMilePerHour(double inchPerSecond) {
        double milePerHour = inchPerSecond / 17.60000;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", milePerHour);
    }

    private String inchPerSecondToKilometerPerSecond(double inchPerSecond) {
        double kilometerPerSecond = inchPerSecond * 0.0000254;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", kilometerPerSecond);
    }

    //KilometerPerSecond
    private String kilometerPerSecondToMeterPerSecond(double kilometerPerSecond) {
        double meterPerSecond = kilometerPerSecond * 1000.000;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", meterPerSecond);
    }

    private String kilometerPerSecondToKilometerPerHour(double kilometerPerSecond) {
        double kilometerPerHour = kilometerPerSecond * 3600.00000;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", kilometerPerHour);
    }

    private String kilometerPerSecondToMilePerHour(double kilometerPerSecond) {
        double milePerHour = kilometerPerSecond / 0.000447;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", milePerHour);
    }

    private String kilometerPerSecondToInchPerSecond(double kilometerPerSecond) {
        double inchPerSecond = kilometerPerSecond / 0.0000254;
        Toast.makeText(getApplicationContext(), "Conversion Successful", Toast.LENGTH_SHORT).show();
        return String.format("%.5f", inchPerSecond);
    }
}
