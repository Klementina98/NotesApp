package com.example.notesapp.repository

import com.example.notesapp.data.NoteDatabaseDao
import com.example.notesapp.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepository  @Inject constructor(
    private val noteDatabaseDao: NoteDatabaseDao
){
    suspend fun addNote(note: Note) = noteDatabaseDao.insert(note)
    suspend fun removeNote(note: Note) = noteDatabaseDao.deleteNote(note)
    suspend fun updateNote(note: Note) = noteDatabaseDao.update(note)
    suspend fun deleteAllNotes() = noteDatabaseDao.deleteAll()
    fun getAllNotes() : Flow<List<Note>> =
        noteDatabaseDao.getNotes().flowOn(Dispatchers.IO)
}