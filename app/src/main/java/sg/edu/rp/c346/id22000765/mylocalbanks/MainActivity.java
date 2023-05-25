package sg.edu.rp.c346.id22000765.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");

        if(v==tvDBS){
            wordClicked = "DBS";
        }
        else if(v==tvOCBC){
            wordClicked="OCBC";
        }
        else{
            wordClicked="UOB";
        }

    }

    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 1) { // Check whether the selected menu item ID is 0
            // Code for action
            if (wordClicked.equalsIgnoreCase("dbs")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 1800111111"));
                startActivity(intentCall);
                return true;
            } else if (wordClicked.equalsIgnoreCase("ocbc")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 18003633333"));
                startActivity(intentCall);
                return true;
            } else if (wordClicked.equalsIgnoreCase("uob")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18002222121"));
                startActivity(intentCall);
                return true;
            }
        }

        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

}