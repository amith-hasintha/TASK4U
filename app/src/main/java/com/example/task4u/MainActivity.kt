package com.example.task4u
//vgvgvgvgjjknbj
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task4u.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db:NoteDatabaseHelper
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDatabaseHelper(this)
        noteAdapter = NoteAdapter(db.getAllNotes(), this)

        binding.notesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.notesRecyclerView.adapter = noteAdapter

        binding.addButton.setOnClickListener{
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume(){
        super.onResume()
        noteAdapter.refreshData(db.getAllNotes())
    }
}