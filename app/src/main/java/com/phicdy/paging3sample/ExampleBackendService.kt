package com.phicdy.paging3sample

class ExampleBackendService {
    fun searchUsers(query: String, nextPageNumber: Int): UserSearchResult {
        val list = mutableListOf<User>()
        for (i in 1..50) {
            val id = i + 50 * (nextPageNumber - 1)
            list.add(User(id, "user${id}"))
        }
        return UserSearchResult(
            list,
            nextPageNumber + 1
        )
    }
}