package com.example.umar.passwordless;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.Account;
import com.facebook.accountkit.PhoneNumber;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;


public class Success extends AppCompatActivity {

    Button btnLogout;
    TextView tvPhone;

    EditText etUserId, etUserPhone, etUserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        btnLogout = findViewById(R.id.btnLogout);


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccountKit.logOut();
                finish();
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
            @Override
            public void onSuccess(Account account) {

               /* tvPhone=findViewById(R.id.tvPhone);
                etUserEmail=findViewById(R.id.etUserEmail);
                etUserEmail.setText(String.format("Email Id %s",account.getEmail()));


                tvPhone.setText(String.format("Phone %s",account.getPhoneNumber() == null ? "": account.getPhoneNumber().toString()));


                etUserId=findViewById(R.id.etUserId);
                etUserId.setText(String.format("User Id %s",account.getId()));

                etUserPhone=findViewById(R.id.etUserPhone);
                //etUserPhone.setText(String.format("Phone %s",account.getPhoneNumber() == null ?
                        //"": account.getPhoneNumber().toString()));


*/
            }

            @Override
            public void onError(AccountKitError accountKitError) {

            }
        });
    }
}
