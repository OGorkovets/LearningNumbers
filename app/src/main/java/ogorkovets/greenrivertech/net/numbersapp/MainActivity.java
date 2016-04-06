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

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int rand1 = 0;
    private int rand2 = 0;
    private int correct = 0;
    private int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //generate random numbers and store them
        rand1 = randNum();
        rand2 = randNum();
        //set buttons to display our numbers
        setButton();
    }

    public void setButton(){
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setText(rand1 + "");

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setText(rand2 + "");

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
            result = compareNum(rand1, rand2);
        } else {
            result = compareNum(rand2, rand1);
        }
        if (result == true) {
            answer = "Good job!";
            correct++;

        } else {
            answer = "Try more!";
        }
        total++;
        Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_SHORT).show();
        dispayMessages();
        //set new values
        rand1 = randNum();
        rand2 = randNum();
        //set buttons to display our numbers
        setButton();
    }

    public void dispayMessages(){
        TextView displayTotal = (TextView) findViewById(R.id.displayTotal);
        displayTotal.setText("Total number of tries : " + total);

        TextView displayCorrect = (TextView) findViewById(R.id.displayCorrect);
        displayCorrect.setText("Correct number of tries : " + correct);
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



    public boolean compareNum(int rand1, int rand2){
        //boolean result = false;
        if(rand1 > rand2){
            return true;
        }
        else{
            return false;
        }
        //return result;
    }

    public int randNum(){
        Random random = new Random();
        return random.nextInt(100) + 1;
    }
}
