//
//  NoteDetailScreen.swift
//  JotDown
//
//  Created by Aman Kumar on 21/02/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct NoteDetailScreen: View {
    private var noteDataSource: NoteDataSource?
    private var noteId: Int64? = nil
    
    init(noteDataSource: NoteDataSource? = nil, noteId: Int64? = nil) {
        self.noteDataSource = noteDataSource
        self.noteId = noteId
    }
    
    var body: some View {
        Text(/*@START_MENU_TOKEN@*/"Hello, World!"/*@END_MENU_TOKEN@*/)
    }
}

#Preview {
    NoteDetailScreen()
}
