package com.example.notesapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//top level class that one project can hold, extends whole exo android sustem
//dependency container
@HiltAndroidApp
class NoteApplication : Application() {

}