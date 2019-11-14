package com.example.challengeme.Hobby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.challengeme.Interfaces.Hobby.HobbyControllerInterface
import com.example.challengeme.Interfaces.Hobby.HobbyObjectInterface
import com.example.challengeme.Interfaces.Hobby.HobbyObserverInterface
import com.example.challengeme.Interfaces.Markers.MapMarkerObjectInterface
import com.example.challengeme.Markers.MapMarker
import com.example.challengeme.R
import com.example.challengeme.SplashScreenActivity

var markers : ArrayList<MapMarker> = ArrayList()

class MainActivity : AppCompatActivity(), HobbyObserverInterface {


    private lateinit var model: HobbyObjectInterface
    private lateinit var controller: HobbyControllerInterface
    private var fragmentManager: FragmentManager = supportFragmentManager

    private lateinit var dateTextView: TextView
    private lateinit var dayCouterTextView: TextView
    private lateinit var nameTextView: TextView
    private lateinit var categoryTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var guideTextView: TextView
    private lateinit var exerciseTextView: TextView

    private lateinit var difficultBar: RatingBar
    private lateinit var image_pager: ViewPager

    private lateinit var mapButton: Button
    private lateinit var companyButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model = SplashScreenActivity.instance
        //this.model = intent.getParcelableExtra(R.string.modelIntent.toString())!!
        controller = HobbyController(model)
        findViewElements()
        setViewElements()

    }

    // сопоставляем view с элементами Layout'a
    private fun findViewElements() {
        nameTextView = findViewById(R.id.hobby_name_tv)
        categoryTextView = findViewById(R.id.category_tv)
        difficultBar = findViewById(R.id.difficulty_rb)
        descriptionTextView = findViewById(R.id.description_tv)
        image_pager = findViewById(R.id.image_vp)
        guideTextView = findViewById(R.id.guide_tv)
        mapButton = findViewById(R.id.open_map_button)
        companyButton = findViewById(R.id.find_people_button)

        mapButton.setOnClickListener{
            // думаю надо сделать загрузку мапМаркеров именно тут а не в сплэше
            // что-то мне подсказывает, что загрузка не должна осуществляться во view
            // но я согласна, что в сплэшэ она еще не нужна

           // controller.onMapButtonClick(this)
        }
        companyButton.setOnClickListener {

        }

    }
    // заполняем view
    private fun setViewElements() {
        nameTextView.text = model.getName()
        categoryTextView.text = model.getCategory()
        difficultBar.rating = model.getDifficulty().toFloat()
        descriptionTextView.text = model.getDescription()
        image_pager.adapter = PagerAdapter(fragmentManager)
        guideTextView.text = model.getGuide()

    }

    override fun update() {
        setViewElements()

    }

    inner class PagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            val image = model.getImages(position)
            val bundle = Bundle()
            bundle.putString("image", image)
            val imageFragment = ImageFragment().createFragment()
            imageFragment.arguments = bundle
            return imageFragment
        }

        override fun getCount(): Int {
            return model.getImageSize()
        }

    }

}
