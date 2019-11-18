package com.lamlt.my_day.ui.note;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.lamlt.my_day.R;
import com.lamlt.my_day.adapter.StaggeredRecycleViewNoteAdapter;
import com.lamlt.my_day.base.GridSpacingItemDecoration;
import com.lamlt.my_day.fragment.NoteCreationFragment;
import com.lamlt.my_day.model.Note;

import java.util.Collections;
import java.util.List;

import static com.lamlt.my_day.Constants.NUM_COLUMNS;

public class NoteFragment extends Fragment {

    private NoteViewModel noteViewModel;
    private RecyclerView recyclerView;
    private List<Note> mNotes;
    private StaggeredRecycleViewNoteAdapter staggeredRecycleViewNoteAdapter;
    private Button createNote;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        noteViewModel =
                ViewModelProviders.of(this).get(NoteViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_note, container, false);
        initViews(root);
        recyclerView.setHasFixedSize(true);
        staggeredRecycleViewNoteAdapter = new StaggeredRecycleViewNoteAdapter(mNotes, root.getContext());
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, 1);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        // Prevent the loss of items
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 0);

        final float scale = getResources().getDisplayMetrics().density;
        int spacing = (int) (1 * scale + 0.5f);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spacing));

        recyclerView.setAdapter(staggeredRecycleViewNoteAdapter);

        // Drag and drop
        ItemTouchHelper ith = new ItemTouchHelper(_ithCallback);
        ith.attachToRecyclerView(recyclerView);

        createNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                NoteCreationFragment noteCreationFragment = new NoteCreationFragment();
                fragmentTransaction.add(R.id.note_list, noteCreationFragment);
                fragmentTransaction.addToBackStack("Note");
                fragmentTransaction.commit();
            }
        });

        return root;
    }

    private void initViews(View v){
        recyclerView = v.findViewById(R.id.note_recycle_view);
        createNote = v.findViewById(R.id.create_new_note);
    }

    ItemTouchHelper.Callback _ithCallback = new ItemTouchHelper.Callback() {
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

            Collections.swap(mNotes, viewHolder.getAdapterPosition(), target.getAdapterPosition());
            staggeredRecycleViewNoteAdapter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
            return true;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            //TODO
        }

        // Defines the enabled move directions in each state (idle, swiping, dragging).
        @Override
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {

            return makeFlag(ItemTouchHelper.ACTION_STATE_DRAG,
                    ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.START | ItemTouchHelper.END);
        }
    };

}