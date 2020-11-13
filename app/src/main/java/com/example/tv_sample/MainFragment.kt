package com.example.tv_sample

import android.os.Bundle
import android.view.View
import androidx.leanback.app.RowsSupportFragment
import androidx.leanback.widget.*

class MainFragment : RowsSupportFragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rowsAdapter = ArrayObjectAdapter(ClassPresenterSelector().apply {
            addClassPresenter(
                ListRow::class.java,
                ListRowPresenter(FocusHighlight.ZOOM_FACTOR_MEDIUM)
            )
        })
        adapter = rowsAdapter

        rowsAdapter.addAll(0, listOf(createItems(), createItems(), createItems()))
    }

    private fun createItems(): ListRow {
        return ListRow(
            HeaderItem("Horis Practice"),
            ArrayObjectAdapter(HorisPresenter()).apply {
                addAll(0, listOf("あいうえお", "かきくけこ", "さしすせそ", "たちつてと", "なにぬねの"))
            }
        )
    }
}
