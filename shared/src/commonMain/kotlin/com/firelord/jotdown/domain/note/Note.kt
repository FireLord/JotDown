package com.firelord.jotdown.domain.note

import com.firelord.jotdown.presentation.BabyBlueHex
import com.firelord.jotdown.presentation.LightGreenHex
import com.firelord.jotdown.presentation.RedOrangeHex
import com.firelord.jotdown.presentation.RedPinkHex
import com.firelord.jotdown.presentation.VioletHex
import kotlinx.datetime.LocalDateTime

data class Note(
    val id: Long?,
    val title: String,
    val content: String,
    val colorHex: Long,
    val created: LocalDateTime
) {
    companion object {
        private val colors = listOf(
            RedOrangeHex,
            RedPinkHex,
            LightGreenHex,
            BabyBlueHex,
            VioletHex
        )
        fun generateRandomColorHex() = colors.random()
    }
}
