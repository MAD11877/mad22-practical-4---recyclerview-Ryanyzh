package sg.edu.np.mad.helloryan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    User user = new User("Ryan", "Is clueless??", 10, false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = (TextView) findViewById(R.id.title_text);
        username.setText(user.name);

        TextView description = (TextView) findViewById(R.id.para_text);
        description.setText(user.description);

        Button follow = (Button) findViewById(R.id.follow_btn);
        follow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //event handler
                user.followed = !(user.followed);

                if (!user.followed){
                    follow.setText("Follow");
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_LONG).show();
                }
                else{
                    follow.setText("Unfollow");
                }

            }
        });
        Intent receive = getIntent();
        Integer messageTxt = receive.getIntExtra("number", 0);
        username.setText("MAD " + messageTxt);

        Button message = (Button) findViewById(R.id.message_btn);
        message.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent in = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(in);
            }
        });
    }
}