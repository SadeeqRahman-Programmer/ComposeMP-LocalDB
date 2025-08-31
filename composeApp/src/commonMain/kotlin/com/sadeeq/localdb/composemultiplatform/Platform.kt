package com.sadeeq.localdb.composemultiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform