package com.aklal.briquedagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = DaggerMainComponent.create().presenter()

        bttDisplayNewDate.setOnClickListener{
            displayDate(
                presenter.getDateSince(),
                presenter.getDateUntil()
            )
        }
    }

    fun displayDate(since: String, until: String) {
        tvSince.text = since
        tvUntil.text = until
    }
}
