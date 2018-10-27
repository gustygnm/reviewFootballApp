package com.gnm.finalprojek.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.gnm.finalprojek.R
import com.gnm.finalprojek.activities.SearchActivity
import com.gnm.finalprojek.fragments.match.NextFrag
import com.gnm.finalprojek.fragments.match.PastFrag
import com.gnm.finalprojek.views.MatchFragmentView
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.ctx

class MatchFrag : Fragment(), MatchFragmentView {

    lateinit var rootView: View
    lateinit var spinnerMatch: Spinner
    lateinit var frameDeploy: FrameLayout
    lateinit var button: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.match_frag, container, false)
        init()
        return rootView
    }

    override fun changeFragment(fragment: Fragment) {
        val trans = this.fragmentManager!!.beginTransaction()
        trans.replace(R.id.frameMatch, fragment)
        trans.addToBackStack(null)
        trans.commit()
    }

    override fun Loading() {

    }

    override fun finishLoading() {

    }

    override fun init() {
        spinnerMatch = rootView.findViewById(R.id.spinnerMatch)
        button = rootView.findViewById(R.id.search)
        button.onClick {
            SearchActivity.caller = "match"
            val intent = Intent(context, SearchActivity::class.java)
            startActivity(intent)
        }
        val spinnerItem = resources.getStringArray(R.array.match)
        val spinnerAdapter = ArrayAdapter(ctx, android.R.layout.simple_spinner_dropdown_item, spinnerItem)
        spinnerMatch.adapter = spinnerAdapter
        spinnerMatch.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selected: String = spinnerMatch.selectedItem.toString()
                if (selected.equals("Past Match")) {
                    changeFragment(PastFrag.newInstance())
                    Log.d("change Frag", "frag now $selected")
                } else if (selected.equals("Next Match")) {
                    changeFragment(NextFrag.newInstance())
                    Log.d("change Frag", "frag now $selected")
                }
            }

        }
        frameDeploy = rootView.findViewById(R.id.frameMatch)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retainInstance = true
        init()
    }

}