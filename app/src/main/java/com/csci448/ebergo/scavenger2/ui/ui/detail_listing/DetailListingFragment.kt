package com.csci448.ebergo.scavenger2.ui.ui.detail_listing

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.csci448.ebergo.scavenger2.R
import java.util.*

private const val LogTag = "448.DetailListingFrag"
class DetailListingFragment: Fragment() {
    private lateinit var detailListingViewModel: DetailListingViewModel
    private fun updateUI(){}
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(LogTag,"onAttach Called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LogTag,"onCreateCalled")
        val factory = DetailListingViewModelFactory(requireContext())
        detailListingViewModel = ViewModelProvider(this,factory).get(DetailListingViewModel::class.java)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        Log.d(LogTag,"onCreateOptionsMenu Called")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(LogTag,"onCreateView Called")
        val view = inflater.inflate(R.layout.listing_detail_view,container,false)
        view.setBackgroundColor(Color.WHITE)
        //TODO hookup parts in layout
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(LogTag,"onViewCreated Called")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(LogTag,"onActivityCreated Called")
    }
    override fun onStart(){
        super.onStart()
        Log.d(LogTag,"onStart Called")
    }
    companion object{
        fun newInstance(listingID: UUID):DetailListingFragment{
            val args = Bundle().apply{}
            return DetailListingFragment().apply{
                arguments = args
            }
        }
    }
    override fun onResume() {
        super.onResume()
        Log.d(LogTag,"onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LogTag,"onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LogTag,"onStop Called")
        //crimeDetailViewModel.saveCrime(crime)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LogTag,"onDestroy Called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(LogTag,"onDestroyView Called")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(LogTag,"onDetatch Called")
    }

}