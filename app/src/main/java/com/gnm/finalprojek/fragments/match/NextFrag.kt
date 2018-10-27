package com.gnm.finalprojek.fragments.match

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import android.widget.Spinner
import com.gnm.finalprojek.R
import com.gnm.finalprojek.R.array.league
import com.gnm.finalprojek.activities.DetailMatch
import com.gnm.finalprojek.api.ApiRequest
import com.gnm.finalprojek.data.EventAdapter
import com.gnm.finalprojek.data.models.Event
import com.gnm.finalprojek.presenters.match.NextMatchPres
import com.gnm.finalprojek.views.match.NextMatchFragView
import com.google.gson.Gson
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.onRefresh

class NextFrag : Fragment(), NextMatchFragView {

    var data: MutableList<Event> = mutableListOf()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: EventAdapter
    lateinit var presenter: NextMatchPres
    lateinit var spinner: Spinner
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var pgBar: ProgressBar
    private lateinit var leagueName: String
    lateinit var idLeague: String
    lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.nextmatch_frag, container, false)
        init()
        return rootView
    }

    override fun Loading() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun FinishLoad() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun showData(data: List<Event>) {
        this.data.clear()
        this.data.addAll(data)
        this.adapter.notifyDataSetChanged()
    }

    companion object {
        @JvmStatic
        fun newInstance(): NextFrag {
            val nextFrag = NextFrag()
            val args = Bundle()
            nextFrag.arguments = args
            return nextFrag
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = false
    }

    fun init() {
        swipeRefreshLayout = rootView.findViewById(R.id.swiping)

        val gson = Gson()
        val request = ApiRequest()
        pgBar = rootView.findViewById(R.id.pgBars)
        recyclerView = rootView.findViewById(R.id.recNext)
        spinner = rootView.findViewById(R.id.spinnerLiga)

        presenter = NextMatchPres(this, request, gson)

        val spinnerItems = resources.getStringArray(league)
        val spinnerAdapter = ArrayAdapter<String>(ctx, R.layout.spinner_item, spinnerItems);
        spinner.adapter = spinnerAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                loadData()
            }
        }
        swipeRefreshLayout.onRefresh {
            loadData()
        }
        adapter = EventAdapter(this.context!!, data) {
            DetailMatch.caller = "match"
            val intent = Intent(this.context, DetailMatch::class.java)
            intent.putExtra("idMatch", it)
            startActivity(intent)
        }
        loadData()
    }

    fun loadData() {
        recyclerView.layoutManager = LinearLayoutManager(ctx)
        recyclerView.adapter = adapter
        presenter = NextMatchPres(this, ApiRequest(), Gson())
        leagueName = spinner.selectedItem.toString()
        getIdLeague(leagueName)
        presenter.getData(idLeague)
    }

    fun getIdLeague(leagueName: String) {
        when {
            leagueName.equals(getString(R.string.english_premier_league)) -> idLeague = "4328"
            leagueName.equals(getString(R.string.english_league_championship)) -> idLeague = "4329"
            leagueName.equals(getString(R.string.german_bundesliga)) -> idLeague = "4331"
            leagueName.equals(getString(R.string.italian_serie_a)) -> idLeague = "4332"
            leagueName.equals(getString(R.string.french_ligue_1)) -> idLeague = "4334"
            leagueName.equals(getString(R.string.spanish_la_liga)) -> idLeague = "4335"
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retainInstance = true
        init()
    }
}