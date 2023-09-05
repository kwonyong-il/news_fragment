import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news_fragment.Adapter
import com.example.news_fragment.DetailFragment
import com.example.news_fragment.NewsItem
import com.example.news_fragment.R
import com.example.news_fragment.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    private lateinit var binding: FragmentTitleBinding
    private lateinit var datalist: MutableList<NewsItem>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTitleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        datalist = mutableListOf(
            NewsItem(
                R.drawable.news_1,
                "KAIST 차세대소형위성2호 관측영상 공개",
                "KAIST(총장 이광형)는 지난 5월 나로우주센터에서 발사된 누리호 3차 주탑재 위성인 차세대소형위성 2호에 대한 초기 운영을 완수했다고 5일 밝혔다."
            ),
            NewsItem(
                R.drawable.sample_2,
                "Second news",
                "second new article second new article second new article second new article second new article second new article second new article"
            ),
            NewsItem(
                R.drawable.sample_3,
                "Third news",
                "Third new article Third new article Third new article Third new article Third new article Third new article Third new article"
            ),
            NewsItem(
                R.drawable.sample_4,
                "fourth news",
                "fourth new article fourth new article fourth new article fourth new article  fourth new article fourth new article fourth new article"
            ),
            NewsItem(
                R.drawable.sample_5,
                "fifth news",
                "fifth new article fifth new article fifth new article fifth new article fifth new article fifth new article fifth new article fifth new article"
            ),
            NewsItem(
                R.drawable.sample_7,
                "seventh news",
                "seventh new article seventh new article seventh new article seventh new article seventh new article seventh new article seventh new article"
            ),
            NewsItem(
                R.drawable.sample_8,
                "eighth news",
                "eighth new article eighth new article eighth new article eighth new article eighth new article eighth new article eighth new article eighth new article"
            ),
            NewsItem(
                R.drawable.sample_9,
                "ninth news",
                "ninth new article ninth new article ninth new article ninth new article ninth new article ninth new article ninth new article ninth new article"
            ),
            NewsItem(
                R.drawable.sample_10,
                "tenth news",
                "tenth new article tenth new article tenth new article tenth new article tenth new article tenth new article tenth new article tenth new article"
            )
        )


        val adapter = Adapter(datalist)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        adapter.itemClick = object : Adapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val newsItem = datalist[position]

                val detailFragment = DetailFragment()
                val bundle = Bundle()
                bundle.putParcelable("newsItem", newsItem)
                detailFragment.arguments = bundle

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment, detailFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}





