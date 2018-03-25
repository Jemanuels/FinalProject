package za.co.samtakie.myjokeui;

/***
 * Created by Jurgen Emanuels, this Activity is responsible for showing the
 * joke.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeUIActivity extends AppCompatActivity {

    private TextView myJokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_ui);
        myJokeTextView = (TextView) findViewById(R.id.joke_txt);

        // get the Intent data from the activity sending the data
        Bundle jokeExtras = getIntent().getExtras();

        // if jokeExtras is not empty get the joke data which is a String
        if (jokeExtras != null) {
            String getJoke = jokeExtras.getString("joke");
            // Set the string to the myJokeTextView
            myJokeTextView.setText(getJoke);
        }

    }
}