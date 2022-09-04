package dev.refox.trackapp.charts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import dev.refox.trackapp.R
import dev.refox.trackapp.databinding.ActivityCclineChartBinding
import java.security.KeyStore

class CCLineChartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCclineChartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCclineChartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setLineChartData()
    }

    fun setLineChartData() {


        val lineentry = ArrayList<Entry>();
        lineentry.add(Entry(1f, 969F))
        lineentry.add(Entry(1.2f, 1000F))
        lineentry.add(Entry(1.4f, 1500F))
        lineentry.add(Entry(1.6f, 2000F))
        lineentry.add(Entry(1.8f, 3000F))
        lineentry.add(Entry(2f, 3913F))

        val linedataset = LineDataSet(lineentry, "First")
        linedataset.color = resources.getColor(R.color.red)


        val data = LineData(linedataset)
        binding.ccChart.data = data
    }
}