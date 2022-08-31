package id.co.rsudkelet.textinputlayoutinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    // Initialize variable
    TextInputLayout tilName, tilEmail;
    EditText etName, etMobile, etEmail, etPassword;
    MaterialButton btClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign variable
        tilName = findViewById(R.id.til_name);
        tilEmail = findViewById(R.id.til_email);
        etName = findViewById(R.id.et_name);
        etMobile = findViewById(R.id.et_mobile);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btClear = findViewById(R.id.bt_clear);

        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                // Check condition
                if (!s.toString().isEmpty() && !s.toString().matches("[a-zA-Z]+")) {
                    // When value is not equal to empty and contain numeric value
                    // Show error
                    tilName.setError("Allow only character");
                } else {
                    // When value is equal to character only
                    // Hide error
                    tilName.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tilEmail.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear value
                etEmail.getText().clear();
            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear all input value
                etName.getText().clear();
                etMobile.getText().clear();
                etEmail.getText().clear();
                etPassword.getText().clear();

                // Clear focus
                etPassword.clearFocus();
            }
        });
    }
}