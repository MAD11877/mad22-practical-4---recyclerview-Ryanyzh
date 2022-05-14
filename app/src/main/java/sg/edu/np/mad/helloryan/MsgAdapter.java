package sg.edu.np.mad.helloryan;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgViewHolder> {

    List<User> data;
    public MsgAdapter(List<User> data){
        this.data = data;
    }

    @NonNull
    @Override
    public MsgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_rec, parent, false);
        return new MsgViewHolder(item);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull MsgViewHolder holder, int position) {
        User sS = data.get(position);
        String phrase = sS.name + "-" + sS.id;
        holder.nameID.setText(phrase);
        holder.description.setText(sS.description);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
