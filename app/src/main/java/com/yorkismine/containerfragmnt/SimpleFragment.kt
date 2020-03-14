package com.yorkismine.containerfragmnt

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent

/**
 * A simple [Fragment] subclass.
 */
class SimpleFragment : Fragment() {

    var state: String = "none"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_simple, container, false)

        view.findViewById<TextView>(R.id.title).text = tag

        return view
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    override fun onStop() {
        super.onStop()
        state = "isStopped"

        Log.d("TESTING", state)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        state = "isCreated"
        Log.d("TESTING", state)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun onDestroy() {
        super.onDestroy()

        state = "isDestroyed"
        Log.d("TESTING", state)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    override fun onPause() {
        super.onPause()

        state = "isPaused"
        Log.d("TESTING", state)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    override fun onStart() {
        super.onStart()

        state = "isStarted"
        Log.d("TESTING", state)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    override fun onResume() {
        super.onResume()

        state = "isResumed"
        Log.d("TESTING", state)
    }

}
