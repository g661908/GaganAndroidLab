package algonquin.cst2335;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText name, password, email, dob, phoneno;
    private TextView result;
    private Switch sw1, sw2, mySwitch;
    private RadioGroup genderGroup;
    private CheckBox android, java, angular, python;
    private ImageView myImageView;
    private Button btnChangeImage;
    private boolean isImage1 = true; // To keep track of the current image

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize all the UI elements
        name = (EditText) findViewById(R.id.txtName);
        password = (EditText) findViewById(R.id.txtPwd);
        email = (EditText) findViewById(R.id.txtEmai);
        dob = (EditText) findViewById(R.id.txtDate);
        phoneno = (EditText) findViewById(R.id.txtPhone);
        result = (TextView) findViewById(R.id.resultView);

        Button btnSubmit = (Button) findViewById(R.id.btnSend);
        Button btnGet = (Button) findViewById(R.id.getBtn);

        // Switches
        sw1 = (Switch) findViewById(R.id.switch1);
        sw2 = (Switch) findViewById(R.id.switch2);
        mySwitch = (Switch) findViewById(R.id.mySwitch);

        // CheckBoxes
        android = (CheckBox) findViewById(R.id.chkAndroid);
        angular = (CheckBox) findViewById(R.id.chkAngular);
        java = (CheckBox) findViewById(R.id.chkJava);
        python = (CheckBox) findViewById(R.id.chkPython);

        // Gender RadioGroup
        genderGroup = (RadioGroup) findViewById(R.id.genderGroup);
        Button btnSubmitGender = (Button) findViewById(R.id.btnSubmitGender);

        // Initialize ImageView and Button
        myImageView = (ImageView) findViewById(R.id.myImageView);
        btnChangeImage = (Button) findViewById(R.id.btnChangeImage);

        // Set initial image
        myImageView.setImageResource(R.drawable.torch_app); // Assuming image1 is the initial image

        // Button action for submitting details
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty() || password.getText().toString().isEmpty()
                        || email.getText().toString().isEmpty() || dob.getText().toString().isEmpty()
                        || phoneno.getText().toString().isEmpty()) {
                    result.setText("Please Fill All the Details");
                } else {
                    result.setText("Name -  " + name.getText().toString() + " \n" + "Password -  "
                            + password.getText().toString() + " \n" + "E-Mail -  "
                            + email.getText().toString() + " \n" + "DOB -  " + dob.getText().toString()
                            + " \n" + "Contact -  " + phoneno.getText().toString());
                }
            }
        });

        // Button action for getting the selected switches
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1, str2;
                if (sw1.isChecked())
                    str1 = sw1.getTextOn().toString();
                else
                    str1 = sw1.getTextOff().toString();

                if (sw2.isChecked())
                    str2 = sw2.getTextOn().toString();
                else
                    str2 = sw2.getTextOff().toString();

                Toast.makeText(getApplicationContext(), "Switch1 -  " + str1 + " \n" + "Switch2 - " + str2, Toast.LENGTH_SHORT).show();
            }
        });

        // Custom switch functionality
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "Custom Switch is ON", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Custom Switch is OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Checkboxes for selected courses
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "Selected Courses";
                if (android.isChecked()) {
                    result += "\nAndroid";
                }
                if (angular.isChecked()) {
                    result += "\nAngularJS";
                }
                if (java.isChecked()) {
                    result += "\nJava";
                }
                if (python.isChecked()) {
                    result += "\nPython";
                }
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            }
        });

        // RadioButton for gender selection
        btnSubmitGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = genderGroup.getCheckedRadioButtonId();

                if (selectedId != -1) {
                    RadioButton selectedRadioButton = (RadioButton) findViewById(selectedId);
                    String selectedGender = selectedRadioButton.getText().toString();

                    Toast.makeText(getApplicationContext(), "Selected Gender: " + selectedGender, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Please select a gender", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Button action to change the image
        btnChangeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isImage1) {
                    myImageView.setImageResource(R.drawable.ic_launcher_background); // Switch to image2
                } else {
                    myImageView.setImageResource(R.drawable.
                            ic_launcher_foreground); // Switch back to image1
                }
                isImage1 = !isImage1; // Toggle the image flag
            }

        });
    }
}