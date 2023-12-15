package com.misul.movies.domain.navigator

import androidx.compose.runtime.Immutable

@Immutable
interface Navigator {
    fun pop(): Boolean
}