package com.firelord.jotdown.domain.note

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
            "RedOrangeHex",
            "RedPinkHex",
            "LightGreenHex",
            "BodyBlueHex",
            "VioletHex"
        )
        fun generateRandomColorHex() = colors.random()
    }
}
