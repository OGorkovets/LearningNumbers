package ogorkovets.greenrivertech.net.numbersapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

/**
 * @author  Oleksandr Gorkovets
 * @version 2.0
 * @date 4/11/2016
 */

public class MainActivity extends AppCompatActivity {
    private LearningGameModel game = new LearningGameModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //set buttons to display our numbers
        setButton();
    }

    public void setButton(){
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setText(game.getLeftNumber() + "");

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setText(game.getRightNumber() + "");

        button1.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
               compareOnclick(view);
            }
        });
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                compareOnclick(view);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void compareOnclick(View view){
        int clicked = view.getId();
        boolean result;
        String answer = "";
        if (clicked == R.id.button1) {
            result = game.play(game.getLeftNumber(), game.getRightNumber());
        } else {
            result = game.play(game.getRightNumber(), game.getLeftNumber());
        }
        if (result == true) {
            answer = "Good job!";
        } else {
            answer = "Try more!";
        }
        Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_SHORT).show();
        dispayMessages();
        //set new values
        game.generateNumbers();
        //set buttons to display our numbers
        setButton();
    }

    public void dispayMessages(){
        TextView displayTotal = (TextView) findViewById(R.id.displayTotal);
        displayTotal.setText("Total number of tries : " + game.getGamesPlayed());

        TextView displayCorrect = (TextView) findViewById(R.id.displayCorrect);
        displayCorrect.setText("Correct number of tries : " + game.getGamesWon());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
