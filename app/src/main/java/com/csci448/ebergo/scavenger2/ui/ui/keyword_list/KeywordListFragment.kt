package com.csci448.ebergo.scavenger2.ui.ui.keyword_list

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.work.*
import com.csci448.ebergo.scavenger2.MainActivity

import com.csci448.ebergo.scavenger2.R
import com.csci448.ebergo.scavenger2.data.AggKeywordListing
import com.csci448.ebergo.scavenger2.data.SearchWorker
import java.util.concurrent.TimeUnit

private const val PERIODIC_POLL_NAME = "poll_name"

private const val LogTag = "448.KeywordListFragment"
class KeywordListFragment: Fragment() {
    private lateinit var keywordRecyclerView: RecyclerView
    private lateinit var adapter:KeywordListAdapter
    private lateinit var keywordListViewModel: KeywordListViewModel
    private lateinit var workManager: WorkManager
    private var callbacks:Callbacks? = null
    interface Callbacks{
        fun onAggKeywordSelected(keyword:String)
    }
    private fun updateUI(keywords:List<AggKeywordListing>){
        adapter = KeywordListAdapter(keywords){ keyword->Unit
            val action = KeywordListFragmentDirections.actionNavHomeToNavListings2()
            findNavController().navigate(action)
        }
        keywordRecyclerView.adapter = adapter
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
        keywordListViewModel = ViewModelProvider(this,factory).get(KeywordListViewModel::class.java)

        workManager = WorkManager.getInstance(requireContext())

/*
        val notificationManager = NotificationManagerCompat.from(requireContext())
        val channelID = requireContext().resources.getString(R.string.notification_channel_id)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // version is Oreo or higher
            // version is API 26 or higher
            // version is Android 8.0 or higher
            val channel = NotificationChannel(channelID,
                R.string.notification_channel_name.toString(),
                NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = R.string.notification_channel_desc.toString()
            }
            notificationManager.createNotificationChannel(channel)
        }
        val intent = Intent(requireContext(), MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(requireContext(), 0, intent, 0)
        val notification = NotificationCompat.Builder(requireContext(), channelID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(requireContext().getString(R.string.notification_title))
            .setContentText("Found 15 laptops in your area")
            .setAutoCancel(false)
            .setContentIntent(pendingIntent)
            .build()
        notificationManager.notify(0, notification)
        */

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(LogTag,"onCreateView Called")
        val view = inflater.inflate(R.layout.fragment_keyword_list,container,false)
        keywordRecyclerView = view.findViewById(R.id.keyword_recycler_view) as RecyclerView
        keywordRecyclerView.layoutManager = LinearLayoutManager(context)
        updateUI(emptyList())
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(LogTag,"onViewCreated Called")
        updateUI(keywordListViewModel.dummyAggListings)

        val workRequest =
            OneTimeWorkRequestBuilder<SearchWorker>()
                .build()

        workManager.enqueue(workRequest)
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
        callbacks = null
    }
    companion object{
        fun newInstance():KeywordListFragment{
            val args = Bundle().apply{}
            return KeywordListFragment().apply{
                arguments = args
            }
        }
    }
}