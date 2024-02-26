package std.srihar.dietpreparer;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.text.Spanned;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.goal_options, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set up your spinner here

        // Set up "Don't have an account? Sign up" text
        TextView dontHaveAccountTextView = findViewById(R.id.dont_have_account);
        SpannableString spannableString = new SpannableString("Don't have an account? Sign up");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                // Handle click event, navigate to the SignUpActivity
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        };
        spannableString.setSpan(clickableSpan, 22, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        dontHaveAccountTextView.setText(spannableString);
        dontHaveAccountTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
