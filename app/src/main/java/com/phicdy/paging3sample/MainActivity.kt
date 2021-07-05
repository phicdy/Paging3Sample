package com.phicdy.paging3sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pagingAdapter = UserAdapter(UserComparator)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.adapter = pagingAdapter

        val flow = Pager(
            // Configure how data is loaded by passing additional properties to
            // PagingConfig, such as prefetchDistance.
            PagingConfig(pageSize = 20)
        ) {
            ExamplePagingSource(ExampleBackendService(), "query")
        }.flow
            .cachedIn(lifecycleScope)


// Activities can use lifecycleScope directly, but Fragments should instead use
// viewLifecycleOwner.lifecycleScope.
        lifecycleScope.launch {
            flow.collectLatest { pagingData ->
                pagingAdapter.submitData(pagingData)
            }
        }

    }
}