package com.firelord.jotdown.android.note_list

import com.firelord.jotdown.domain.note.Note

data class NoteListState (
    val notes: List<Note> = emptyList(),
    val searchText: String = "",
    val isSearchActive: Boolean = false
)