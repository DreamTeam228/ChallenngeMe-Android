package com.example.challengeme.ui.qrimport android.os.Bundleimport android.view.LayoutInflaterimport android.view.Viewimport android.view.ViewGroupimport android.widget.Buttonimport android.widget.ImageViewimport androidx.fragment.app.Fragmentimport androidx.lifecycle.Observerimport androidx.lifecycle.ViewModelProvidersimport com.example.challengeme.Rclass QRCodeFragment : Fragment() {    private lateinit var qrCodeViewModel: QRCodeViewModel    override fun onCreateView(        inflater: LayoutInflater,        container: ViewGroup?,        savedInstanceState: Bundle?    ): View? {        qrCodeViewModel =            ViewModelProviders.of(this).get(QRCodeViewModel::class.java)        val root = inflater.inflate(R.layout.fragment_qr_code, container, false)        val qrView = root.findViewById<ImageView>(R.id.qrCode_imageView)        val qrButton = root.findViewById<Button>(R.id.qrCode_Button)        qrCodeViewModel.qrCode.observe(this, Observer {            val qr = it ?: return@Observer            qrView.setImageBitmap(qr)            // ������ ���� ���        })        qrButton.setOnClickListener {            // ��� ��������� ��������� ��������            /*loading.visibility = View.VISIBLE            qrCodeViewModel.������������������*/            qrCodeViewModel.generateQR()        }        return root    }    // �� ������� �� ������ - �������� ���� �� ��������    // � �������� ������������� �� ��������� �������� ����� ����    // ��� ��������� ����� �������� ������ �������� ����}