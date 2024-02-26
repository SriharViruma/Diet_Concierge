package std.srihar.dietpreparer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        TextView loginTextView = findViewById(R.id.dont_have_account);
        SpannableString spannableString = new SpannableString("Already Registered\nLog in here");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                // Handle click event, navigate to the MainActivity
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
                // Finish the current activity to prevent going back to SignUpActivity when pressing back button from MainActivity
                finish();
            }
        };
        spannableString.setSpan(clickableSpan, 19, spannableString.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        loginTextView.setText(spannableString);
        loginTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
