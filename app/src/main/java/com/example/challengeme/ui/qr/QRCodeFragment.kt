package com.example.challengeme.ui.qr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.challengeme.R

class QRCodeFragment : Fragment() {

    private lateinit var qrCodeViewModel: QRCodeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        qrCodeViewModel =
            ViewModelProviders.of(this).get(QRCodeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_qr_code, container, false)
        val qrView = root.findViewById<ImageView>(R.id.qrCode_imageView)
        val qrButton = root.findViewById<Button>(R.id.qrCode_Button)
        /*val textView: TextView = root.findViewById(R.id.text_dashboard)
        qrCodeViewModel.text.observe(this, Observer {
            textView.text = it
        })*/


        qrCodeViewModel.qrCodeString.observe(this, Observer {
            val registrationState = it ?: return@Observer

            // рисуем куАр код

        })



        qrButton.setOnClickListener {
            // Тут запускаем генерацию куАрКода

            /*loading.visibility = View.VISIBLE

            qrCodeViewModel.методГенерацииКуар*/
        }

        return root

    }




    // По нажатию на кнопку - изменяем поле во ВьюМодел
    // В активити подписываемся на изменение значения этого поля
    // При изменении этого значения рисуем картинку куАр

}