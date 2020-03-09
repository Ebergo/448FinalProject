package com.csci448.ebergo.scavenger2.ui.ui.listing_list

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.csci448.ebergo.scavenger2.R
import com.csci448.ebergo.scavenger2.data.Listing
import java.util.*
private const val LogTag = "448.ListingListFrag"
class ListingListFragment: Fragment() {
    private lateinit var listinglistRecyclerView: RecyclerView
    private lateinit var adapter: ListingListAdapter
    private lateinit var listingListViewModel: ListingListViewModel
    private var callbacks:Callbacks? = null
    interface Callbacks {
        fun onListingListSelected(ListingID:UUID)
    }
    private fun updateUI(listings:List<Listing>){
        adapter = ListingListAdapter(listings) {
            listing : Listing -> Unit
            val action = ListingListFragmentDirections.actionNavListingsToDetailListingFragment()
            findNavController().navigate(action)
            //callbacks?.onListingListSelected(listing.id)
        }
        listinglistRecyclerView.adapter = adapter
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(LogTag,"onAttach Called")
        //callbacks = context as Callbacks?
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        Log.d(LogTag,"onCreate Called")
        val factory = ListingListViewModelFactory(requireContext())
        listingListViewModel = ViewModelProvider(this,factory).get(ListingListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(LogTag,"onCreateView Called")
        val view = inflater.inflate(R.layout.fragment_item_list_view,container,false)
        view.setBackgroundColor(Color.WHITE)
        listinglistRecyclerView = view.findViewById(R.id.item_list_view) as RecyclerView
        listinglistRecyclerView.layoutManager = LinearLayoutManager(context)
        updateUI(emptyList())
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(LogTag,"onViewCreated Called")
        updateUI(listingListViewModel.listings)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(LogTag,"onActivityCreated Called")
    }
    override fun onStart() {
        super.onStart()
        Log.d(LogTag,"onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LogTag,"onResume Called")
    }

    override fun onPause() {
        Log.d(LogTag,"onPause Called")
        super.onPause()
    }

    override fun onStop() {
        Log.d(LogTag,"onStop Called")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d(LogTag,"onDestroyView Called")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d(LogTag,"onDestroy Called")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d(LogTag,"onDetatch Called")
        super.onDetach()
        callbacks = null
    }
    companion object {
        fun newInstance(keyword:String):ListingListFragment{
            val args = Bundle().apply{
               // putSerializable(ARGS_LISTING_ID,id)
            }
            return ListingListFragment().apply{
                arguments = args
            }
        }
    }
}