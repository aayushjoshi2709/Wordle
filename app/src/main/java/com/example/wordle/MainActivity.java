package com.example.wordle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
public class MainActivity extends AppCompatActivity {
    ArrayList<String> arr = new ArrayList<String>(Arrays.asList("About","Alert","Argue","Beach","Above","Alike","Arise","Began","Abuse","Alive","Array","Begin","Actor","Allow","Aside","Begun","Acute","Alone","Asset","Being","Admit","Along","Audio","Below","Adopt","Alter","Audit","Bench","Adult","Among","Avoid","Billy","After","Anger","Award","Birth","Again","Angle","Aware","Black","Agent","Angry","Badly","Blame","Agree","Apart","Baker","Blind","Ahead","Apple","Bases","Block","Alarm","Apply","Basic","Blood","Album","Arena","Basis","Board","Boost","Buyer","China","Cover","Booth","Cable","Chose","Craft","Bound","Calif","Civil","Crash","Brain","Carry","Claim","Cream","Brand","Catch","Class","Crime","Bread","Cause","Clean","Cross","Break","Chain","Clear","Crowd","Breed","Chair","Click","Crown","Brief","Chart","Clock","Curve","Bring","Chase","Close","Cycle","Broad","Cheap","Coach","Daily","Broke","Check","Coast","Dance","Brown","Chest","Could","Dated","Build","Chief","Count","Dealt","Built","Child","Court","Death","Debut","Entry","Forth","Group","Delay","Equal","Forty","Grown","Depth","Error","Forum","Guard","Doing","Event","Found","Guess","Doubt","Every","Frame","Guest","Dozen","Exact","Frank","Guide","Draft","Exist","Fraud","Happy","Drama","Extra","Fresh","Harry","Drawn","Faith","Front","Heart","Dream","False","Fruit","Heavy","Dress","Fault","Fully","Hence","Drill","Fiber","Funny","Henry","Drink","Field","Giant","Horse","Drive","Fifth","Given","Hotel","Drove","Fifty","Glass","House","Dying","Fight","Globe","Human","Eager","Final","Going","Ideal","Early","First","Grace","Image","Earth","Fixed","Grade","Index","Eight","Flash","Grand","Inner","Elite","Fleet","Grant","Input","Empty","Floor","Grass","Issue","Enemy","Fluid","Great","Irony","Enjoy","Focus","Green","Juice","Enter","Force","Gross","Joint","Jones","Links","Media","Newly","Judge","Lives","Metal","Night","Known","Local","Might","Noise","Label","Logic","Minor","North","Large","Loose","Minus","Noted","Laser","Lower","Mixed","Novel","Later","Lucky","Model","Nurse","Laugh","Lunch","Money","Occur","Layer","Lying","Month","Ocean","Learn","Magic","Moral","Offer","Lease","Major","Motor","Often","Least","Maker","Mount","Order","Leave","March","Mouse","Other","Legal","Maria","Mouth","Ought","Level","Match","Movie","Paint","Lewis","Maybe","Music","Panel","Light","Mayor","Needs","Paper","Limit","Meant","Never","Party","Peace","Power","Radio","Round","Peter","Press","Raise","Route","Phase","Price","Range","Royal","Phone","Pride","Rapid","Rural","Photo","Prime","Ratio","Scale","Piece","Print","Reach","Scene","Pilot","Prior","Ready","Scope","Pitch","Prize","Refer","Score","Place","Proof","Right","Sense","Plain","Proud","Rival","Serve","Plane","Prove","River","Seven","Plant","Queen","Robin","Shall","Plate","Quick","Roger","Shape","Point","Quiet","Roman","Share","Pound","Quite","Rough","Sharp","Sheet","Spare","Style","Times","Shelf","Speak","Sugar","Tired","Shell","Speed","Suite","Title","Shift","Spend","Super","Today","Shirt","Spent","Sweet","Topic","Shock","Split","Table","Total","Shoot","Spoke","Taken","Touch","Short","Sport","Taste","Tough","Shown","Staff","Taxes","Tower","Sight","Stage","Teach","Track","Since","Stake","Teeth","Trade","Sixth","Stand","Terry","Train","Sixty","Start"," ","Texas","Treat","Sized","State","Thank","Trend","Skill","Steam","Theft","Trial","Sleep","Steel","Their","Tried","Slide","Stick","Theme","Tries","Small","Still","There","Truck","Smart","Stock","These","Truly","Smile","Stone","Thick","Trust","Smith","Stood","Thing","Truth","Smoke","Store","Think","Twice","Solid","Storm","Third","Under","Solve","Story","Those"));
    private final char[][] container = new char[5][5];
    private int randomNumber = (int)Math.floor(Math.random()*(arr.size()-0+1)+0);
    private String currentWord = arr.get(randomNumber).toUpperCase();
    private int counteri = 0;
    private int counterj = 0;
    private int score = 0;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder = new AlertDialog.Builder(this);
        for(int i = 0; i < 5;i++) {
            for (int j = 0; j < 5; j++) {
                int number = (i * 5 + j) + 1;
                TextView tv = findViewById(getResources().getIdentifier("textView" + number, "id", getPackageName()));
                tv.setText(container[i][j] + "");
                tv.setCompoundDrawables(ContextCompat.getDrawable(getApplicationContext(),R.drawable.rounded_corner2),null,null,null);
                tv.setTextColor(Color.WHITE);

            }
        }
        clearData();
    }
    protected void printToGrid(int i, int j){
        int number = (i * 5 + j) + 1;
        TextView tv = findViewById(getResources().getIdentifier("textView" + number, "id", getPackageName()));
        tv.setText(container[counteri][j] + "");
    }
    private void clearData(){
        counteri = 0;
        counterj = 0;
        randomNumber = (int)Math.floor(Math.random()*(arr.size()-0+1)+0);
        currentWord = arr.get(randomNumber).toUpperCase();
        Button submitButton = findViewById(R.id.submit);
        submitButton.setEnabled(false);
        for(int i = 0; i < 5;i++){
            for(int j = 0; j < 5;j++){
                container[i][j] = ' ';
            }
        }
        for(int i = 0; i < 5;i++) {
            for (int j = 0; j < 5; j++) {
                int number = (i * 5 + j) + 1;
                TextView tv = findViewById(getResources().getIdentifier("textView" + number, "id", getPackageName()));
                tv.setText(container[i][j] + "");
                Drawable tvBackground = tv.getBackground();
                tvBackground = DrawableCompat.wrap(tvBackground);
                DrawableCompat.setTint(tvBackground, Color.parseColor("#ffcccc"));
                tv.setBackground(tvBackground);
            }
        }
    }
    public void backspace(View view){
        Button submitButton = findViewById(R.id.submit);
        if(counterj != 0){
            counterj--;
            container[counteri][counterj] = ' ';
            printToGrid(counteri, counterj);
        }
        submitButton.setEnabled(false);
    }
    public void skip(View view){
        clearData();
    }
    public void buttonPress(View view){
        Button submitButton = findViewById(R.id.submit);
        int id = view.getId();
        Button but = findViewById(id);
        char c = but.getText().toString().charAt(0);
        if(counterj < 5){
            container[counteri][counterj] = c;
            printToGrid(counteri, counterj);
            counterj++;
        }
        if(counterj == 5){
            submitButton.setEnabled(true);
        }
    }
    private void buildAlert(String msg1, String msg2){
        builder.setMessage(msg1).setTitle(msg2);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                clearData();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finishAffinity();
                System.exit(0);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void updateScore(){
        TextView score = findViewById(R.id.score);
        score.setText("Score: " + score);
    }

    public void submit(View view){
        Button submitButton = findViewById(R.id.submit);
        int count = 0;
        for(int j = 0; j < 5;j++) {
            int number = (counteri * 5 + j) + 1;
            TextView tv = findViewById(getResources().getIdentifier("textView" + number, "id", getPackageName()));
            Drawable tvBackground = tv.getBackground();
            tvBackground = DrawableCompat.wrap(tvBackground);
            char c = tv.getText().toString().charAt(0);
            if(currentWord.charAt(j) == c){
                DrawableCompat.setTint(tvBackground, Color.parseColor("#76FF03"));
                count++;
            }else{
                int i = 0;
                for(i = 0; i < 5;i++){
                    if(currentWord.charAt(i) == c){
                        DrawableCompat.setTint(tvBackground, Color.parseColor("#FFA000"));
                        break;
                    }
                }
                if(i == 5) {
                    DrawableCompat.setTint(tvBackground, Color.parseColor("#D1C4E9"));
                }
            }
            tv.setBackground(tvBackground);
        }
        if(count==5) {
            score++;
            buildAlert("Want to play again?", "You Win");
        }
        counteri++;
        if(counteri == 5)
            buildAlert("Want to play again?","You Lose");

        counterj = 0;
        submitButton.setEnabled(false);
    }
}