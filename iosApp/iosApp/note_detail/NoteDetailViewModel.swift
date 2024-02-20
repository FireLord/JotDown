//
//  NoteDetailViewModel.swift
//  JotDown
//
//  Created by Aman Kumar on 21/02/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

extension NoteDetailScreen {
    @MainActor class NoteDetailViewModel: ObservableObject {
        private var noteDataSource: NoteDataSource?
        
        private var noteId: Int64? = nil
        @Published var noteTitle = ""
        @Published var noteContent = ""
        @Published private(set) var noteColor = Note.Companion().generateRandomColorHex()
        
        init(noteDataSource: NoteDataSource? = nil) {
            self.noteDataSource = noteDataSource
        }
        
        func loadNoteIfExists(id: Int64?) {
            if (id != nil) {
                self.noteId = id
                noteDataSource?.getNoteById(id: id!, completionHandler: { note,  error in
                    self.noteTitle = note?.title ?? ""
                    self.noteContent = note?.content ?? ""
                    self.noteColor = note?.colorHex ?? Note.Companion().generateRandomColorHex()
                })
            }
        }
        
        func saveNote(onSaved: @escaping () -> Void) {
            noteDataSource?.insertNote(
                note: Note(
                    id: noteId == nil ? nil : KotlinLong(value: noteId!),
                    title: self.noteTitle,
                    content: self.noteContent,
                    colorHex: self.noteColor,
                    created: DateTimeUtil().now()),
                completionHandler: { error in
                    onSaved()
                })
        }
        
        func setParamsAndLoadNote(noteDataSource: NoteDataSource, noteId: Int64?) {
            self.noteDataSource = noteDataSource
            loadNoteIfExists(id: noteId)
        }
    }
}
