package com.csci448.ebergo.scavenger2.ui.ui.search_settings.location

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.csci448.ebergo.scavenger2.R
import com.csci448.ebergo.scavenger2.data.AggKeywordListing
import com.csci448.ebergo.scavenger2.ui.ui.keyword_list.*


class LocationFragment: Fragment() {

    private lateinit var locationViewModel: LocationViewModel
    private  val LogTag = "448.LocationFragment"
    private fun updateUI(keywords:List<AggKeywordListing>){

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(LogTag,"onAttach Called")
        //callbacks = context as Callbacks?
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LogTag,"onCreate Called")
        //setHasOptionsMenu(true)
        val factory = KeywordListViewModelFactory(requireContext())
        locationViewModel = ViewModelProvider(this,factory).get(LocationViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(LogTag,"onCreateView Called")
        val view = inflater.inflate(R.layout.location_settings_view,container,false)
        updateUI(emptyList())
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(LogTag,"onViewCreated Called")
        updateUI(emptyList())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(LogTag,"onActivityCreated Called")
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        Log.d(LogTag,"onCreateOptionsMenu Called")
        //inflater.inflate(R.menu.main_options_bar,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d(LogTag,"onOptionsItemSelected() called")
        return when(item.itemId){
            R.id.action_search -> {
                Toast.makeText(context,"search to be implemented", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
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

    }
    companion object{
        fun newInstance(): KeywordListFragment {
            val args = Bundle().apply{}
            return KeywordListFragment().apply{
                arguments = args
            }
        }
    }
}