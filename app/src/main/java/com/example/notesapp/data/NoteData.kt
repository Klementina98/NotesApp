package com.example.notesapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.notesapp.model.Note

class NotesDataSource {
    @RequiresApi(Build.VERSION_CODES.O)
    fun loadNotes(): List<Note> {
        return listOf(
            Note(
                title = "Garden Plans",
                description = "Decided to plant a vegetable garden this year. Going to start with tomatoes, peppers, lettuce, and herbs. Need to buy seeds and start seedlings indoors."
            ),

            Note(
                title = "Grocery List",
                description = "Need to pick up milk, bread, eggs, and apples at the store."
            ),
            Note(
                title = "Meeting Notes",
                description = "Discussed project updates with the team. Action items: 1) Follow up on task assignments, 2) Review budget proposal, 3) Schedule next meeting."
            ),
            Note(
                title = "To-Do List",
                description = "1) Respond to emails, 2) Finish report, 3) Call client, 4) Attend yoga class at 6 PM."
            ),
            Note(
                title = "Travel Plans",
                description = "Booked flights and hotel for vacation in Hawaii. Need to rent a car and make restaurant reservations."
            ),
            Note(
                title = "Birthday Gifts",
                description = "Possible gift ideas for John's birthday: 1) Book on his favorite author, 2) Gift card to his favorite restaurant, 3) Tickets to a concert or sporting event."
            ),
            Note(
                title = "Recipe Ideas",
                description = "Looking for new recipes to try out. So far, considering making a quiche, a curry dish, and a soup with seasonal vegetables."
            ),
        )
    }
}