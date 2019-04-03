package com.singh.ms.architecture.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.singh.ms.architecture.model.Note;
import com.singh.ms.architecture.repo.NoteRepository;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {

    private NoteRepository repository;
    private LiveData<List<Note>> allNotes;

    public NotesViewModel(@NonNull Application application) {
        super(application);
        //methods which will be called from NoteRepository
        repository = new NoteRepository(application);
        allNotes = repository.getAllNotes();
    }

    //methods which will be called by UI
    public void insert(Note note) {
        repository.insert(note);
    }

    public void update(Note note) {
        repository.update(note);
    }

    public void delete(Note note) {
        repository.delete(note);
    }

    public void deleteAllNotes() {
        repository.deleteAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }
}
