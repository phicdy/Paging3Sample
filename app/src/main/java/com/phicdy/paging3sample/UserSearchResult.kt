package com.phicdy.paging3sample

data class UserSearchResult(
    val users: List<User>,
    val nextPageNumber: Int
)