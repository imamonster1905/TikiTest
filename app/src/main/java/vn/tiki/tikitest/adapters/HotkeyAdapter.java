package vn.tiki.tikitest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vn.tiki.tikitest.R;
import vn.tiki.tikitest.utilities.StringRefactor;
import vn.tiki.tikitest.ui.ItemGenerator;

public class HotkeyAdapter extends RecyclerView.Adapter<HotkeyAdapter.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;

    public HotkeyAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_hotkey, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String hotKey = mData.get(position);

        hotKey = StringRefactor.handleString(hotKey);

        holder.myTextView.setText(hotKey);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.item_hotkey_text);

            ItemGenerator.randomItemView(itemView);

        }
    }
}
