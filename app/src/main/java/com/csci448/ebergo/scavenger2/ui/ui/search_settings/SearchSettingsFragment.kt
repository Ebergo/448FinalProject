package com.csci448.ebergo.scavenger2.ui.ui.search_settings

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.csci448.ebergo.scavenger2.LocationActivity
import com.csci448.ebergo.scavenger2.R
import com.csci448.ebergo.scavenger2.data.Keyword
import com.csci448.ebergo.scavenger2.ui.ui.search_settings.keyword_toggle.KeywordToggleAdapter
import com.csci448.ebergo.scavenger2.ui.ui.search_settings.keyword_toggle.KeywordToggleViewModel
import com.csci448.ebergo.scavenger2.ui.ui.search_settings.keyword_toggle.KeywordToggleViewModelFactory

private const val LogTag = "448.SearchSettingsFrag"
class SearchSettingsFragment: Fragment() {
    private lateinit var keywordToggleRecyclerView: RecyclerView
    private lateinit var adapter: KeywordToggleAdapter
    private lateinit var keywordToggleViewModel: KeywordToggleViewModel
    private lateinit var locationButton:ImageButton
    private fun updateUI(keywords:List<Keyword>){
        adapter = KeywordToggleAdapter(keywordToggleViewModel.keywords)
        keywordToggleRecyclerView.adapter = adapter
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(LogTag,"onAttach Called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LogTag,"onCreate Called")
        val factory = KeywordToggleViewModelFactory(requireContext())
        keywordToggleViewModel = ViewModelProvider(this,factory).get(KeywordToggleViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(LogTag,"onCreateView Called")
        val view = inflater.inflate(R.layout.fragment_settings,container,false)
        locationButton = view.findViewById(R.id.location_button)
        locationButton.setOnClickListener{
            val action = SearchSettingsFragmentDirections.actionNavSearchSettingsToLocationFragment()
            findNavController().navigate(action)
        }
        keywordToggleRecyclerView = view.findViewById(R.id.keyword_settings_list) as RecyclerView
        keywordToggleRecyclerView.layoutManager = LinearLayoutManager(context)
        updateUI(emptyList())
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

    override fun onDestroy() {
        Log.d(LogTag,"onDestroy Called")
        super.onDestroy()
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