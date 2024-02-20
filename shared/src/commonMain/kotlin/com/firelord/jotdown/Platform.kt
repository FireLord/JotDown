package com.firelord.jotdown

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform