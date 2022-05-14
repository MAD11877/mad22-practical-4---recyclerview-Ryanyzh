package sg.edu.np.mad.helloryan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        List<User> userObjects = new LinkedList<>();


        for (int u = 0; u < 20; u++)
        {
            Random random = new Random();
            boolean userFollowed;
            String userName = "Name";
            int userId = (int)random.nextInt(999999999);
            String userDescription = "Description " + Double.toString(random.nextInt(999999999));
            int followInt = random.nextInt(2);
            if (followInt == 1)
            {
                userFollowed = true;
            }
            else
            {
                userFollowed = false;
            }
            User newUser = new User (userName, userDescription, userId, userFollowed);
        }

        RecyclerView rv = findViewById(R.id.rv_id);
        MsgAdapter adapter = new MsgAdapter(userObjects);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        rv.setLayoutManager(layout);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);

        /*
        ImageView clickThis = findViewById(R.id.userPicture);
        clickThis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);

                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setCancelable(true);
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        //<action>
                    }
                });
                builder.setNegativeButton("View", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Intent i = new Intent(ListActivity.this, MainActivity.class);
                        int x = (int)Math.floor(Math.random()*(1000001)+0);
                        i.putExtra("number" , x);
                        startActivity(i);
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();



            }
        });

         */
    }
}