package com.example.notesapp.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.model.Note
import com.example.notesapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    //var noteList = mutableStateListOf<Note>()
    private val _noteListState = MutableStateFlow<List<Note>>(emptyList())
    val noteListState = _noteListState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged()
                .collect { listOfNotes ->
                    if (listOfNotes.isEmpty()) {
                        Log.d("Empty", "Empty List: ")
                    } else {
                        _noteListState.value = listOfNotes
                    }

                }
        }
//        noteList.addAll(NotesDataSource().loadNotes())
    }

    fun addNote(note: Note) {
        viewModelScope.launch {
            repository.addNote(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            repository.updateNote(note)
        }
    }

    fun removeNote(note: Note) {
        viewModelScope.launch {
            repository.removeNote(note)
        }
    }

    fun getAllNotes() {
        viewModelScope.launch {
            repository.getAllNotes()
        }
    }
}