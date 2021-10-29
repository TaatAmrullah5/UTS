package id.Amrullah.Taat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.submit)
        btn.setOnClickListener{simulasi()}
    }

    private fun currencyConvert(num: Double): String {
        return NumberFormat.getCurrencyInstance().format(num)
    }

    private fun simulasi(){

        // Get All result layout element
        val biaya_layout: LinearLayout = findViewById(R.id.layanan)
        val bunga_layout: LinearLayout = findViewById(R.id.sukubunga)
        val pencairan_layout: LinearLayout = findViewById(R.id.pencairan)
        val totalpinjaman_layout: LinearLayout = findViewById(R.id.totalpinjaman)

        // Get Input Value
        val inputpinjaman: TextInputEditText = findViewById(R.id.pinjamanedit)
        val bulan: TextInputEditText = findViewById(R.id.bulanedit)
        var pinjaman = inputpinjaman.text.toString().toDoubleOrNull()
        var bulanvalue = bulan.text.toString().toDoubleOrNull()

        // Calculate Loan Simulation
        var layanan = pinjaman?.times(0.05)
        var bunga = pinjaman?.times(0.0375)
        var pencairan= pinjaman?.minus(layanan!!)
        var totalpinjaman = bulanvalue?.let { bunga?.times(it)?.let { pinjaman?.plus(it) } }

        // Get Result Element
        val biaya_res: TextView = findViewById(R.id.biayalayanan1)
        val bunga_res: TextView = findViewById(R.id.sukubunga2)
        val pencairan_res: TextView = findViewById(R.id.pencairan2)
        val totalpinjaman_res: TextView = findViewById(R.id.totalpinjaman2)

        // put to text
        biaya_res.text = currencyConvert(layanan!!)
        bunga_res.text = currencyConvert(bunga!!)
        pencairan_res.text = currencyConvert(pencairan!!)
        totalpinjaman_res.text = currencyConvert(totalpinjaman!!)

        // Make is Visible
        biaya_layout.visibility = View.VISIBLE
        bunga_layout.visibility = View.VISIBLE
        pencairan_layout.visibility = View.VISIBLE
        totalpinjaman_layout.visibility = View.VISIBLE
    }
}
