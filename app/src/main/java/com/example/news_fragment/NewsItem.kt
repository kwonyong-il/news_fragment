package com.example.news_fragment

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsItem(val img: Int,val title: String,val article: String) : Parcelable

