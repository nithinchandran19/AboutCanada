package com.nctech.aboutcanada

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.nctech.aboutcanada.adapter.FeedAdapter
import com.nctech.aboutcanada.network.model.responsemodel.Feed
import com.nctech.aboutcanada.network.model.responsemodel.FeedDetails
import com.nctech.aboutcanada.viewmodel.FeedDataViewModel
import kotlinx.android.synthetic.main.about_fragment_layout.*

/**
 * About Canada Fragment
 */
class AboutCanadaFragment : Fragment() {

    private lateinit var adapter: FeedAdapter
    private lateinit var viewModel:FeedDataViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.about_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val listData = ArrayList<FeedDetails>()

        adapter = FeedAdapter(listData)
        viewModel = ViewModelProvider(this).get(FeedDataViewModel::class.java)
        list_view.layoutManager = LinearLayoutManager(this.context)
        val dividerItemDecoration = DividerItemDecoration(
            list_view.context,
            (list_view.layoutManager as LinearLayoutManager).orientation
        )
        list_view.addItemDecoration(dividerItemDecoration)
        list_view.setHasFixedSize(true)
        list_view.adapter = adapter
        viewModel.getLatestData()

        viewModel.feedData.observe(viewLifecycleOwner, Observer(fun(it: Feed?) {
            if (it != null) {
                listData.addAll(it.rows)
                adapter.notifyDataSetChanged()
            }
        }))
        swipe_refresh.setOnRefreshListener { update() }
    }

    private fun update() {
        viewModel.getLatestData()
        swipe_refresh.isRefreshing = false // Disables the refresh icon
    }
}