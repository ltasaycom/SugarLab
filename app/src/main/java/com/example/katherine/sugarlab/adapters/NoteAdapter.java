package com.example.katherine.sugarlab.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.katherine.sugarlab.R;
import com.example.katherine.sugarlab.models.Note;
import com.github.curioustechizen.ago.RelativeTimeTextView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private List<Note>notes;

    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }

    public void setNotas(List<Note> notes) {
        this.notes = notes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView text_mytitle_;
        RelativeTimeTextView date_text_;
        TextView text_content_;
        CheckBox check_favorite_;

        public ViewHolder(View itemView){
            super(itemView);
            text_mytitle_ = (TextView)itemView.findViewById(R.id.text_mytitle);
            date_text_ = (RelativeTimeTextView)itemView.findViewById(R.id.date_text);
            text_content_ = (TextView)itemView.findViewById(R.id.text_content);
            check_favorite_ = (CheckBox)itemView.findViewById(R.id.check_favorite);
        }
    }

    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notes, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NoteAdapter.ViewHolder viewHolder, int position) {
        Note notes = this.notes.get(position);
        viewHolder.text_mytitle_.setText(notes.getTitle());
        viewHolder.date_text_.setReferenceTime(notes.getDate().getTime());
        viewHolder.text_content_.setText(notes.getContent());
        viewHolder.check_favorite_.setChecked(notes.getFavorite());
    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }
}
